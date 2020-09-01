package nc.itf.Impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;

import nc.bs.dao.BaseDAO;
import nc.bs.framework.common.InvocationInfoProxy;
import nc.bs.framework.common.NCLocator;
import nc.bs.logging.Logger;
import nc.itf.Impl.dto.SaleOrderLogisticlin;
import nc.itf.Impl.dto.SaleOrderProdlin;
import nc.itf.Impl.dto.SaleorderInfo;
import nc.itf.Impl.entity.BdCountryzone;
import nc.itf.Impl.entity.OrgCorp;
import nc.itf.Impl.entity.OrgStockorg;
import nc.itf.Impl.entity.SmUser;
import nc.itf.Impl.entity.SoSaleorderExe;
import nc.itf.Impl.utils.TimeTools;
import nc.itf.Impl.utils.WebServicesUtils;
import nc.itf.uap.pf.IPFBusiAction;
import nc.ui.itf.ISaleOrderSync;
import nc.vo.pub.BusinessException;
import nc.vo.pub.lang.UFBoolean;
import nc.vo.pub.lang.UFDate;
import nc.vo.pub.lang.UFDateTime;
import nc.vo.pub.lang.UFDouble;
import nc.vo.so.m30.entity.SaleOrderBVO;
import nc.vo.so.m30.entity.SaleOrderHVO;
import nc.vo.so.m30.entity.SaleOrderVO;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


public class SaleOrderSyncImpl implements ISaleOrderSync{

	@Override
	public String ncSaleOrderSync(String paramsStr) {
		
		JSONObject retVal = WebServicesUtils.getCommonReturnJson();
		try{
			if(StringUtils.isNotEmpty(paramsStr)){
				/***************************参数校验 start**************************************/
				String [] paramFields = {"saleOrderId","saleOrderTypId","countSumVal","amountSumVal"};
				String [] paramNames = {"订单编号","订单类型","总数量","总金额"};
				boolean flg = WebServicesUtils.ParamsCheckNull(retVal,paramFields,paramNames,paramsStr);
				if(flg){
					JSONObject params = WebServicesUtils.String2Json(paramsStr);
					JSONArray datas = params.getJSONArray("datas");
					for(int i=0;i<datas.size();i++){
						JSONObject saleOrderInfo = (JSONObject) datas.get(i);
						JSONArray prodlinArray = saleOrderInfo.getJSONArray("orderProdlins");
						if(null != prodlinArray && prodlinArray.size() > 0){
							for(int j=0;j<prodlinArray.size();j++){
								JSONObject prodlin = (JSONObject) prodlinArray.get(j);
								if(null != prodlin){
									String [] paramLinFields = {"prodId","unitId"};
									String [] paramLinNames = {"物料编号","计量单位编号"};
									JSONObject checkRetVal = WebServicesUtils.CheckNull(paramLinFields,paramLinNames,prodlin);
									boolean retFlg = checkRetVal.getBoolean("flag");
									if(!retFlg){
										retVal.put("result", "fail");
										retVal.put("code", "0000");
										retVal.put("message", checkRetVal.get("message"));
										break;
									}
								}
								
							}
						}
					}
					
					/***************************参数校验 end**************************************/
					
					//数据库操作
					BaseDAO dao = WebServicesUtils.getBaseDao();
					List<SaleorderInfo> saleorderInfos = SaleOrderUtils.initList(dao,params);
					if(!CollectionUtils.isEmpty(saleorderInfos)){
						//操作人
						SmUser operator = new SmUser();
						String operatorId = params.getString("operatorId");
						operator.initByCode(dao, operatorId);
						String operatorNo = operator.getCuserid();
						
						if(StringUtils.isEmpty(operatorNo)){
							retVal.put("message","当前操作人在NC中不存在，请及时同步人员数据到NC!");
							return retVal.toString();
						}
						for(SaleorderInfo saleorderInfo : saleorderInfos){
							/********************校验参数是否合法，在NC中是否存在*****************************/
							if(StringUtils.isEmpty(saleorderInfo.getBdBilltype().getPkBilltypeid())){
								retVal.put("message","当前单据类型在NC中不存在，请及时同步单据类型数据到NC!");
								return retVal.toString();
							}
							if(StringUtils.isEmpty(saleorderInfo.getSaleUser().getPkPsndoc())){
								retVal.put("message","当前业务员在NC中不存在，请及时同步业务员数据到NC!");
								return retVal.toString();
							}
							if(StringUtils.isEmpty(saleorderInfo.getSaleOrgInfo().getPkSalesorg())){
								retVal.put("message","当前销售组织在NC中不存在，请及时同步销售组织数据到NC!");
								return retVal.toString();
							}
							if(StringUtils.isEmpty(saleorderInfo.getDeptInfo().getPkDept())){
								retVal.put("message","当前部门在NC中不存在，请及时同步部门数据到NC!");
								return retVal.toString();
							}
							if(StringUtils.isEmpty(saleorderInfo.getCustomerInfo().getPkCustomer())){
								retVal.put("message","当前客户在NC中不存在，请及时同步客户数据到NC!");
								return retVal.toString();
							}
							if(StringUtils.isEmpty(saleorderInfo.getStationInfo().getPkCustomer())){
								retVal.put("message","当前站点在NC中不存在，请及时同步站点数据到NC!");
								return retVal.toString();
							}
							if(StringUtils.isEmpty(saleorderInfo.getCurrencyInfo().getPkCurrtype())){
								retVal.put("message","当前币种在NC中不存在，请及时同步币种数据到NC!");
								return retVal.toString();
							}
							retVal = operateSaleOrders(retVal,dao,saleorderInfo,operatorNo);
							String result = retVal.getString("result");
							if("fail".equals(result)){
								return retVal.toString();
							}
							
						}
					}
					
					
				}
				
				
			}
			
		}catch(Exception e){
			e.printStackTrace();
			Logger.error("Exception",e);
			retVal.put("message",e.getMessage());
			
		}
		
		return retVal.toString();
	}

	private JSONObject operateSaleOrders(JSONObject retVal, BaseDAO dao,
			SaleorderInfo saleorderInfo, String operatorNo) throws BusinessException, SQLException {
		if(StringUtils.isEmpty(saleorderInfo.getSoSaleorder().getCsaleorderid())){
			retVal = addSaleOrder(retVal,dao,saleorderInfo,operatorNo);
		}else{
			retVal = updateSaleOrder(retVal,dao,saleorderInfo,operatorNo);
		}
		
		return retVal;
		
	}
	
	private JSONObject addSaleOrder(JSONObject retVal, BaseDAO dao,
			SaleorderInfo saleorderInfo, String operatorNo) throws BusinessException, SQLException {
		SaleOrderHVO ordermst = new SaleOrderHVO();
		//销售组织
		String saleOrgNo = saleorderInfo.getSaleOrgInfo().getPkSalesorg();
		String saleOrgVId = saleorderInfo.getSaleOrgInfo().getPkVid();
		ordermst.setPk_org(saleOrgNo);
		ordermst.setPk_org_v(saleOrgVId);
		
		//部门
		ordermst.setCdeptid(saleorderInfo.getDeptInfo().getPkDept());
		ordermst.setCdeptvid(saleorderInfo.getDeptInfo().getPkVid());
		
		//集团
		String pkGroup = saleorderInfo.getGroupInfo().getPkGroup();
		ordermst.setPk_group(pkGroup);
		
		//订单类型
		ordermst.setCtrantypeid(saleorderInfo.getBdBilltype().getPkBilltypeid());
		ordermst.setVtrantypecode(saleorderInfo.getBdBilltype().getPkBilltypecode());
		
		//订单编号
		ordermst.setVbillcode(saleorderInfo.getSoSaleorder().getVbillcode());
		
		//单据日期
		String saleOrderDtm = TimeTools.DateStr(saleorderInfo.getSaleOrderDtm(), TimeTools.Y_M_D_H_M_S);
		ordermst.setDbilldate(new UFDate(saleOrderDtm));
		
		//客户
		String pkCustomer = saleorderInfo.getCustomerInfo().getPkCustomer();
		String isfreecust = saleorderInfo.getCustomerInfo().getIsfreecust();
		ordermst.setCcustomerid(pkCustomer);
		//是否散户
		ordermst.setBfreecustflag(new UFBoolean(isfreecust));
		
		//开票客户
		ordermst.setCinvoicecustid(pkCustomer);
		
		//站点
		String pkStation = saleorderInfo.getStationInfo().getPkCustomer();
		ordermst.setVdef2(pkStation);
		
		//地址
		ordermst.setVdef3(saleorderInfo.getAreaVal());
		
		//业务员
		ordermst.setCemployeeid(saleorderInfo.getSaleUser().getPkPsndoc());
		
		//币种
		String pkCurrtype = saleorderInfo.getCurrencyInfo().getPkCurrtype();
		ordermst.setCorigcurrencyid(pkCurrtype);
		
		//贸易术语-物流
		ordermst.setCtradewordid(saleOrgNo);
		ordermst.setCtradewordid(saleOrgVId);
		
		//单据状态 1=自由，2=审批通过，3=冻结，4=关闭，7=审批中，8=审批不通过，5=失效
		ordermst.setFstatusflag(1);
		
		//备注
		ordermst.setVnote(saleorderInfo.getRemarkDsc());
		
		//业务流水--数字富仁的销售订单号
		ordermst.setVdef20(saleorderInfo.getSaleOrderNo());
		
		//手机
		ordermst.setVdef7(saleorderInfo.getPhoneVal());
		
		//创建人
		ordermst.setCreator(operatorNo);
		//创建时间
		ordermst.setCreationtime(new UFDateTime());
		
		//制单人
		ordermst.setBillmaker(operatorNo);
		//制单日期
		ordermst.setDmakedate(new UFDate());
		
		//业务流程
		String pkBusitype = saleorderInfo.getServiceFlowInfo().getPkBusitype();
		ordermst.setCbiztypeid(pkBusitype);
		
		//总数量
		ordermst.setNtotalnum(new UFDouble(saleorderInfo.getCountSumVal()));
		//冲抵前金额--总金额
		ordermst.setNtotalmny(new UFDouble(saleorderInfo.getAmountsumval()));
		//总金额-价税合计
		ordermst.setNtotalorigmny(new UFDouble(saleorderInfo.getAmountsumval()));
		
		ordermst.setDr(new Integer(0));
		ordermst.setTs(new UFDateTime());
		
		ordermst.setApprover("~");
		//代垫运费 
		ordermst.setBadvfeeflag(new UFBoolean("N"));
		
		//收入结算关闭
		ordermst.setBarsettleflag(new UFBoolean("N"));
		//已协同生成采购订单
		ordermst.setBcooptopoflag(new UFBoolean("N"));
		//成本结算关闭
		ordermst.setBcostsettleflag(new UFBoolean("N"));
		//开票关闭
		ordermst.setBinvoicendflag(new UFBoolean("N"));
		//是否冲抵
		ordermst.setBoffsetflag(new UFBoolean("N"));
		//出库关闭
		ordermst.setBoutendflag(new UFBoolean("N"));
		//由采购订单协同生成
		ordermst.setBpocooptomeflag(new UFBoolean("N"));
		//收款限额控制预收
		ordermst.setBpreceiveflag(new UFBoolean("N"));
		//发货关闭
		ordermst.setBsendendflag(new UFBoolean("N"));
		ordermst.setCbalancetypeid("~");
		ordermst.setCchanneltypeid("~");
		ordermst.setCcustbankaccid("~");
		ordermst.setCcustbankid("~");
		ordermst.setCfreecustid("~");
		ordermst.setCpaytermid("~");
		ordermst.setCreviserid("~");
		ordermst.setCtransporttypeid("~");
		//审批流状态
		ordermst.setFpfstatusflag(new Integer(-1));
		//修订版本号
		ordermst.setIversion(new Integer(0));
		//整单折扣
		ordermst.setNdiscountrate(new UFDouble(100));
		//费用冲抵金额
		ordermst.setNtotalorigsubmny(new UFDouble(0));
		//总件数
		ordermst.setNtotalpiece(new UFDouble(0));
		//合计体积
		ordermst.setNtotalvolume(new UFDouble(0));
		//合计重量
		ordermst.setNtotalweight(new UFDouble(0));
		ordermst.setVcreditnum("~");
		ordermst.setVdef1("~");
		ordermst.setVdef10("~");
		ordermst.setVdef11("~");
		ordermst.setVdef12("~");
		ordermst.setVdef13("~");
		ordermst.setVdef14("~");
		ordermst.setVdef15("~");
		ordermst.setVdef16("~");
		ordermst.setVdef17("~");
		ordermst.setVdef18("~");
		ordermst.setVdef19("~");
		ordermst.setVdef4("~");
		ordermst.setVdef5("~");
		ordermst.setVdef6("~");
		ordermst.setVdef7("~");
		ordermst.setVdef8("~");
		ordermst.setVdef9("~");
		ordermst.setCbillsrcid("~");
		ordermst.setVbillsrctype("~");
		
		//财务组织
		OrgStockorg orgStockorg = new OrgStockorg();
		orgStockorg.initByNo(dao,saleOrgNo);
		String pkFinanceOrg = orgStockorg.getPkFinanceorg();
		
		//财务组织版本
		OrgCorp orgCorp = new OrgCorp();
		orgCorp.initByNo(dao,pkFinanceOrg);
		String financeOrgVId = orgCorp.getPkVid();
		
		//国家
		BdCountryzone country = new BdCountryzone();
		country.initDefalut(dao);
		String pkCountry = country.getPkCountry();
		
		List<SaleOrderProdlin> orderProdlins = saleorderInfo.getOrderProdlins();
		//临时存储
		List<SaleOrderBVO> prodlins = new ArrayList<SaleOrderBVO>();
		if(!CollectionUtils.isEmpty(orderProdlins)){
			//下标号
			int countrow = 0;
			for(SaleOrderProdlin saleOrderProdlin : orderProdlins){
				if(null != saleOrderProdlin){
					if(StringUtils.isEmpty(saleOrderProdlin.getProdInfo().getCode())){
						retVal.put("message","物料编码不能为空!");
						return retVal;
					}
					
					if(StringUtils.isEmpty(saleOrderProdlin.getUnitInfo().getCode())){
						retVal.put("message","计量单位编码不能为空!");
						return retVal;
					}
					
					if(StringUtils.isEmpty(saleOrderProdlin.getTaxRateInfo().getCode())){
						retVal.put("message","税率编码不能为空!");
						return retVal;
					}
					
					if(null == saleOrderProdlin.getCountVal()){
						retVal.put("message","数量不能为空!");
						return retVal;
					}
					if(null == saleOrderProdlin.getNotaxPriceVal()){
						retVal.put("message","无税单价不能为空!");
						return retVal;
					}
					//物料主键
					String pkMaterial = saleOrderProdlin.getProdInfo().getPkMaterial();
					if(StringUtils.isEmpty(pkMaterial)){
						retVal.put("message","当前物料在NC中不存在，请及时同步物料数据到NC!");
						return retVal;
					}
					//计量单位主键
					String pkMeasdoc = saleOrderProdlin.getUnitInfo().getPkMeasdoc();
					if(StringUtils.isEmpty(pkMeasdoc)){
						retVal.put("message","当前计量单位在NC中不存在，请及时同步计量单位数据到NC!");
						return retVal;
					}
					//税率主键
					String pkTaxcode = saleOrderProdlin.getTaxRateInfo().getPkTaxcode();
					if(StringUtils.isEmpty(pkTaxcode)){
						retVal.put("message","当前增值税率在NC中不存在，请及时同步增值税率数据到NC!");
						return retVal;
					}
					SaleOrderBVO prodlin = new SaleOrderBVO();
					countrow += 10;
					//行号
					prodlin.setCrowno(String.valueOf(countrow));
					//物料
					prodlin.setCmaterialid(pkMaterial);
					//物料（多版本）
					prodlin.setCmaterialvid(pkMaterial);
					//税率
					prodlin.setNtaxrate(new UFDouble(saleOrderProdlin.getTaxRateVal()));
					//税码
					prodlin.setCtaxcodeid(pkTaxcode);
					
					//计量单位
					prodlin.setCunitid(pkMeasdoc);
					
					//辅助单位
					prodlin.setCastunitid(saleOrderProdlin.getConvertInfo().getPkMeasdoc());
					//转换比率
					String convertVal = saleOrderProdlin.getConvertInfo().getMeasrate();
					prodlin.setVchangerate(convertVal);
					
					//行备注
					prodlin.setVrownote(saleOrderProdlin.getRemarkDsc());
					
					//本位币
					prodlin.setCcurrencyid(saleorderInfo.getCurrencyInfo().getPkCurrtype());
					
					//主数量
					UFDouble nnum = new UFDouble(saleOrderProdlin.getCountVal());
					prodlin.setNnum(nnum);
					
					String[] str = new String[2];
					str = convertVal.split("/");
					//数量
					UFDouble nastnum = new UFDouble(nnum).multiply(
							new UFDouble(str[1])).div(new UFDouble(str[0]));
					prodlin.setNastnum(nastnum);
					
					//无税单价
					UFDouble nqtorigprice = new UFDouble(saleOrderProdlin.getNotaxPriceVal());
					prodlin.setNqtorigprice(nqtorigprice);
					//无税金额
					UFDouble norigmny = new UFDouble(saleOrderProdlin.getNotaxAmountVal());
					prodlin.setNorigmny(norigmny);
					//含税单价
					UFDouble nqtorigtaxprice = new UFDouble(saleOrderProdlin.getPriceVal());
					prodlin.setNqtorigtaxprice(nqtorigtaxprice);
					//价税合计
					UFDouble norigtaxmny = new UFDouble(saleOrderProdlin.getAmountVal());
					prodlin.setNorigtaxmny(norigtaxmny);
					
					//计税金额
					prodlin.setNcaltaxmny(norigmny);
					//本币无税金额
					prodlin.setNmny(norigmny);
					//主本币无税净价
					prodlin.setNnetprice(nqtorigprice);
					//主无税净价
					prodlin.setNorignetprice(nqtorigprice);
					//主无税单价
					prodlin.setNorigprice(nqtorigprice);
					//主含税净价
					prodlin.setNorigtaxnetprice(nqtorigtaxprice);
					//主含税单价
					prodlin.setNorigtaxprice(nqtorigtaxprice);
					//主本币无税单价
					prodlin.setNprice(nqtorigprice);
					//本币无税净价
					prodlin.setNqtnetprice(nqtorigprice);
					
					
					
					//折本汇率
					prodlin.setNexchangerate(new UFDouble(saleOrderProdlin.getCostRateVal()));
					/******************此处数量、金额计算不明***********************/
					SaleOrderLogisticlin saleOrderLogisticlin = saleorderInfo.getSaleOrderLogisticlin();
				
					if(null != saleOrderLogisticlin){
						//发货日期
						UFDate dsendDate = new UFDate();
						if(null != saleOrderLogisticlin.getPlanSendDtm()){
							String planSendDtm = TimeTools.DateStr(saleOrderLogisticlin.getPlanSendDtm(), TimeTools.Y_M_D_H_M_S);
							dsendDate = new UFDate(planSendDtm);
						}
						prodlin.setDsenddate(dsendDate);
						//到货日期
						UFDate dreceiveDate = new UFDate();
						if(null != saleOrderLogisticlin.getDemandTakeDtm()){
							String demandTakeDtm = TimeTools.DateStr(saleOrderLogisticlin.getDemandTakeDtm(), TimeTools.Y_M_D_H_M_S);
							dreceiveDate = new UFDate(demandTakeDtm);
						}
						prodlin.setDreceivedate(dreceiveDate);
						//收货客户
						prodlin.setCreceivecustid(saleOrderLogisticlin.getCustomerInfo().getPkCustomer());
						
					}
					//发货库存组织
					prodlin.setCsendstockorgvid(saleOrgNo);
					//利润中心最新版本
					prodlin.setCprofitcenterid(saleOrgNo);
					//利润中心版本
					prodlin.setCprofitcentervid(saleOrgVId);
					//财务中心
					prodlin.setCarorgid(pkFinanceOrg);
					//财务组织版本
					prodlin.setCsettleorgvid(financeOrgVId);
					//财务组织版本
					prodlin.setCarorgvid(financeOrgVId);
					//销售组织
					prodlin.setPk_org(saleOrgNo);
					//集团
					prodlin.setPk_group(pkGroup);
					
					prodlin.setDr(new Integer(0));
					prodlin.setTs(new UFDateTime());
					
					
					//报价单位
					prodlin.setCqtunitid(pkMeasdoc);
					//收货国家/地区
					prodlin.setCrececountryid(pkCountry);
					//发货国家/地区
					prodlin.setCsendcountryid(pkCountry);
					prodlin.setCtrafficorgid(pkCountry);
					//库存组织
					prodlin.setCsendstockorgid(saleOrgNo);
					//库存组织版本
					prodlin.setCsendstockorgvid(saleOrgVId);
					prodlin.setCtrafficorgvid(saleOrgVId);
					//财务组织
					prodlin.setCsettleorgid(pkFinanceOrg);
					//财务组织版本
					prodlin.setCtaxcountryid(pkCountry);
					//单据日期--是否要跟销售订单主表同步
					prodlin.setDbilldate(new UFDate());
					//购销类型 1=国内销售，2=国内采购，3=出口，4=进口，5=不区分
					prodlin.setFbuysellflag(new Integer(1));
					//赠品价格分摊方式 1=未分摊，2=被分摊物料，3=分摊赠品
					prodlin.setFlargesstypeflag(new Integer(1));
					prodlin.setFretexchange(new Integer(0));
					prodlin.setFrowstatus(new Integer(1));

					//扣税类别 1=应税外加，0=应税内含
					prodlin.setFtaxtypeflag(new Integer(1));

					//本币折扣额
					prodlin.setNdiscount(new UFDouble(0));
					//单品折扣
					prodlin.setNitemdiscountrate(new UFDouble(100));
					//折扣额
					prodlin.setNorigdiscount(new UFDouble(0));
					
					//含税净价
					prodlin.setNqtorigtaxnetprc(nqtorigtaxprice);
					//本币无税单价
					prodlin.setNqtprice(nqtorigprice);
					//本币含税净价 
					prodlin.setNqttaxnetprice(nqtorigtaxprice);
					//无税单价
					prodlin.setNqtorigprice(nqtorigprice);
					//本币含税单价
					prodlin.setNqttaxprice(nqtorigtaxprice);
					//报价单位数量
					prodlin.setNqtunitnum(new UFDouble(nnum));
					//税额
					UFDouble ntax = new UFDouble(norigtaxmny).sub(new UFDouble(
							norigmny));
					prodlin.setNtax(ntax);
					//本币价税合计
					prodlin.setNtaxmny(norigtaxmny);
					//主本币含税净价
					prodlin.setNtaxnetprice(nqtorigtaxprice);
					//主本币含税单价
					prodlin.setNtaxprice(nqtorigtaxprice);
					//体积
					prodlin.setNvolume(new UFDouble(0));
					//重量
					prodlin.setNweight(new UFDouble(0));
					//报价换算率
					prodlin.setVqtunitrate("1.00/1.00");
					//冲抵前金额
					prodlin.setNbforigsubmny(norigmny);
					//无税净价
					prodlin.setNqtorignetprice(nqtorigprice);
					//整单折扣
					prodlin.setNdiscountrate(new UFDouble(100));
					
					//是否货源安排完毕
					prodlin.setBarrangedflag(new UFBoolean("N"));
					//收入结算关闭 
					prodlin.setBbarsettleflag(new UFBoolean("N"));
					//成本结算关闭
					prodlin.setBbcostsettleflag(new UFBoolean("N"));
					//捆绑存货
					prodlin.setBbindflag(new UFBoolean("N"));
					//开票关闭
					prodlin.setBbinvoicendflag(new UFBoolean("N"));
					//出库关闭
					prodlin.setBboutendflag(new UFBoolean("N"));
					//发货关闭
					prodlin.setBbsendendflag(new UFBoolean("N"));
					//折扣类
					prodlin.setBdiscountflag(new UFBoolean("N"));
					//借出转销售
					prodlin.setBjczxsflag(new UFBoolean("N"));
					//服务类
					prodlin.setBlaborflag(new UFBoolean("N"));
					//赠品
					prodlin.setBlargessflag(new UFBoolean("N"));
					//三角贸易
					prodlin.setBtriatradeflag(new UFBoolean("N"));
					prodlin.setPk_batchcode("~");
					prodlin.setCarrangepersonid("~");
                    prodlin.setCbindsrcid("~");
                    prodlin.setCctmanagebid("~");
                    prodlin.setCctmanageid("~");
                    prodlin.setCcustmaterialid("~");
                    prodlin.setCexchangesrcretid("~");
                    prodlin.setCfactoryid("~");
                    prodlin.setCfirstbid("~");
                    prodlin.setCfirstid("~");
                    prodlin.setClargesssrcid("~");
                    prodlin.setCorigareaid("~");
                    prodlin.setCorigcountryid("~");
                    prodlin.setCpriceformid("~");
                    prodlin.setCpriceitemid("~");
                    prodlin.setCpriceitemtableid("~");
                    prodlin.setCpricepolicyid("~");
                    prodlin.setCprodlineid("~");
                    prodlin.setCproductorid("~");
                    prodlin.setCprojectid("~");
                    prodlin.setCqualitylevelid("~");
                    prodlin.setCreceiveadddocid("~");
                    prodlin.setCreceiveaddrid("~");
                    prodlin.setCreceiveareaid("~");
                    prodlin.setCretpolicyid("~");
                    prodlin.setCretreasonid("~");
                    prodlin.setCsendstordocid("~");
                    prodlin.setCsrcbid("~");
                    prodlin.setCsrcid("~");
                    prodlin.setCvendorid("~");
                    prodlin.setVbdef1("~");
                    prodlin.setVbdef11("~");
                    prodlin.setVbdef12("~");
                    prodlin.setVbdef13("~");
                    prodlin.setVbdef14("~");
                    prodlin.setVbdef15("~");
                    prodlin.setVbdef16("~");
                    prodlin.setVbdef17("~");
                    prodlin.setVbdef18("~");
                    prodlin.setVbdef19("~");
                    prodlin.setVbdef2("~");
                    prodlin.setVbdef20("~");
                    prodlin.setVbdef3("~");
                    prodlin.setVbdef4("~");
                    prodlin.setVbdef5("~");
                    prodlin.setVbdef6("~");
                    prodlin.setVbdef7("~");
                    prodlin.setVbdef8("~");
                    prodlin.setVbdef9("~");
                    prodlin.setVfirstcode("~");
                    prodlin.setVfirsttrantype("~");
                    prodlin.setVfirsttype("~");
                    prodlin.setVfree1("~");
                    prodlin.setVfree10("~");
                    prodlin.setVfree2("~");
                    prodlin.setVfree3("~");
                    prodlin.setVfree4("~");
                    prodlin.setVfree5("~");
                    prodlin.setVfree6("~");
                    prodlin.setVfree7("~");
                    prodlin.setVfree8("~");
                    prodlin.setVfree9("~");
                    prodlin.setVsrcrowno("~");
                    prodlin.setVsrctrantype("~");
                    prodlin.setVsrctype("~");
                    prodlin.setCbuypromottypeid("~");
                    prodlin.setCprcpromottypeid("~");
                    prodlin.setCbuylargessactid("~");
                    prodlin.setCbuylargessid("~");
                    prodlin.setCpricepromtactid("~");

					
					prodlins.add(prodlin);
				}
			}
			/*String saleOrderNo = WebServicesUtils.generatePkValue(dao,pkGroup,20);
			ordermst.setCsaleorderid(saleOrderNo);
			Logger.error("ordermst:"+ordermst.toString());
			dao.insertVOWithPK(ordermst);
			if(!CollectionUtils.isEmpty(prodlins)){
				for(SaleOrderBVO saleOrderBVO : prodlins){
					saleOrderBVO.setCsaleorderid(saleOrderNo);
					String orderProdlinNo = WebServicesUtils.generatePkValue(dao,pkGroup,20);
					saleOrderBVO.setCsaleorderbid(orderProdlinNo);
					Logger.error("saleOrderBVO:"+saleOrderBVO.toString());
					dao.insertVOWithPK(saleOrderBVO);
					
					SoSaleorderExe soSaleorderExe = new SoSaleorderExe();
					soSaleorderExe.setCsaleorderbid(saleOrderBVO.getCsaleorderbid());
					soSaleorderExe.setDr(0L);
					if(null != saleOrderBVO.getNarrangemonum()){
						soSaleorderExe.setNarrangemonum(saleOrderBVO.getNarrangemonum().toBigDecimal());
					}
					if(null != saleOrderBVO.getNarrangepoappnum()){
						
						soSaleorderExe.setNarrangepoappnum(saleOrderBVO.getNarrangepoappnum().toBigDecimal());
					}
					if(null != saleOrderBVO.getNarrangeponum()){
						
						soSaleorderExe.setNarrangeponum(saleOrderBVO.getNarrangeponum().toBigDecimal());
					}
					if(null != saleOrderBVO.getNarrangescornum()){
						
						soSaleorderExe.setNarrangescornum(saleOrderBVO.getNarrangescornum().toBigDecimal());
					}
					if(null != saleOrderBVO.getNarrangetoappnum()){
						
						soSaleorderExe.setNarrangetoappnum(saleOrderBVO.getNarrangetoappnum().toBigDecimal());
					}
					if(null != saleOrderBVO.getNarrangetoornum()){
						
						soSaleorderExe.setNarrangetoornum(saleOrderBVO.getNarrangetoornum().toBigDecimal());
					}
					if(null != saleOrderBVO.getNorigsubmny()){
						
						soSaleorderExe.setNorigsubmny(saleOrderBVO.getNorigsubmny().toBigDecimal());
					}
					if(null != saleOrderBVO.getNreqrsnum()){
						
						soSaleorderExe.setNreqrsnum(saleOrderBVO.getNreqrsnum().toBigDecimal());
					}
					if(null != saleOrderBVO.getNtotalarmny()){
						
						soSaleorderExe.setNtotalarmny(saleOrderBVO.getNtotalarmny().toBigDecimal());
					}
					if(null != saleOrderBVO.getNtotalarnum()){
						
						soSaleorderExe.setNtotalarnum(saleOrderBVO.getNtotalarnum().toBigDecimal());
					}
					if(null != saleOrderBVO.getNtotalcostnum()){
						
						soSaleorderExe.setNtotalcostnum(saleOrderBVO.getNtotalcostnum().toBigDecimal());
					}
					if(null != saleOrderBVO.getNtotalestarmny()){
						
						soSaleorderExe.setNtotalestarmny(saleOrderBVO.getNtotalestarmny().toBigDecimal());
					}
					if(null != saleOrderBVO.getNtotalestarnum()){
						
						soSaleorderExe.setNtotalestarnum(saleOrderBVO.getNtotalestarnum().toBigDecimal());
					}
					if(null != saleOrderBVO.getNtotalinvoicenum()){
						
						soSaleorderExe.setNtotalinvoicenum(saleOrderBVO.getNtotalinvoicenum().toBigDecimal());
					}
					if(null != saleOrderBVO.getNtotalnotoutnum()){
						
						soSaleorderExe.setNtotaloutnum(saleOrderBVO.getNtotalnotoutnum().toBigDecimal());
					}
					if(null != saleOrderBVO.getNtotalpaymny()){
						
						soSaleorderExe.setNtotalpaymny(saleOrderBVO.getNtotalpaymny().toBigDecimal());
					}
					if(null != saleOrderBVO.getNtotalplonum()){
						
						soSaleorderExe.setNtotalplonum(saleOrderBVO.getNtotalplonum().toBigDecimal());
					}
					if(null != saleOrderBVO.getNtotalreturnnum()){
						
						soSaleorderExe.setNtotalreturnnum(saleOrderBVO.getNtotalreturnnum().toBigDecimal());
					}
					if(null != saleOrderBVO.getNtotalrushnum()){
						
						soSaleorderExe.setNtotalrushnum(saleOrderBVO.getNtotalrushnum().toBigDecimal());
					}
					if(null != saleOrderBVO.getNtotalsendnum()){
						
						soSaleorderExe.setNtotalsendnum(saleOrderBVO.getNtotalsendnum().toBigDecimal());
					}
					if(null != saleOrderBVO.getNtotalsignnum()){
						
						soSaleorderExe.setNtotalsignnum(saleOrderBVO.getNtotalsignnum().toBigDecimal());
					}
					if(null != saleOrderBVO.getNtotaltradenum()){
						
						soSaleorderExe.setNtotaltradenum(saleOrderBVO.getNtotaltradenum().toBigDecimal());
					}
					if(null != saleOrderBVO.getNtranslossnum()){
						
						soSaleorderExe.setNtranslossnum(saleOrderBVO.getNtranslossnum().toBigDecimal());
					}
					if(null != saleOrderBVO.getTs()){
						soSaleorderExe.setTs(saleOrderBVO.getTs().toStdString());
					}
					//dao.insertVOWithPK(soSaleorderExe);
					SaleOrderUtils.insertSoSaleorderExe(soSaleorderExe);
				}
			}*/
			
			SaleOrderBVO [] prodlinArray = null;
			if(!CollectionUtils.isEmpty(prodlins)){
				prodlinArray = new SaleOrderBVO [prodlins.size()];
				for(int i=0;i<prodlins.size();i++){
					prodlinArray[i] = prodlins.get(i);
				}
			}
			
			
			SaleOrderVO avo = new SaleOrderVO();
			avo.setParentVO(ordermst);
			avo.setChildrenVO(prodlinArray);
			InvocationInfoProxy.getInstance().setGroupId(ordermst.getPk_group());
			InvocationInfoProxy.getInstance().setUserId(ordermst.getCreator());
			HashMap<String, Object> eParams = new HashMap<String, Object>();
			eParams.put("notechecked", "notechecked");
			eParams.put("nc.bs.scmpub.pf.ORIGIN_VO_PARAMETER",
					new SaleOrderVO[] { avo });
			IPFBusiAction pfaction = (IPFBusiAction) NCLocator.getInstance()
					.lookup(IPFBusiAction.class.getName());
			pfaction.processAction("WRITE", "N_30_WRITE", null, avo, null,
					eParams);
		}
		retVal.put("result", "success");
		retVal.put("message","同步成功!");
		return retVal;
	}

	private JSONObject updateSaleOrder(JSONObject retVal, BaseDAO dao,
			SaleorderInfo saleorderInfo, String operatorNo) {
		
		return retVal;
	}

	

}
