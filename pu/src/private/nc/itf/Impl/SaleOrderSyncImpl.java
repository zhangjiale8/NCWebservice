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
				/***************************����У�� start**************************************/
				String [] paramFields = {"saleOrderId","saleOrderTypId","countSumVal","amountSumVal"};
				String [] paramNames = {"�������","��������","������","�ܽ��"};
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
									String [] paramLinNames = {"���ϱ��","������λ���"};
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
					
					/***************************����У�� end**************************************/
					
					//���ݿ����
					BaseDAO dao = WebServicesUtils.getBaseDao();
					List<SaleorderInfo> saleorderInfos = SaleOrderUtils.initList(dao,params);
					if(!CollectionUtils.isEmpty(saleorderInfos)){
						//������
						SmUser operator = new SmUser();
						String operatorId = params.getString("operatorId");
						operator.initByCode(dao, operatorId);
						String operatorNo = operator.getCuserid();
						
						if(StringUtils.isEmpty(operatorNo)){
							retVal.put("message","��ǰ��������NC�в����ڣ��뼰ʱͬ����Ա���ݵ�NC!");
							return retVal.toString();
						}
						for(SaleorderInfo saleorderInfo : saleorderInfos){
							/********************У������Ƿ�Ϸ�����NC���Ƿ����*****************************/
							if(StringUtils.isEmpty(saleorderInfo.getBdBilltype().getPkBilltypeid())){
								retVal.put("message","��ǰ����������NC�в����ڣ��뼰ʱͬ�������������ݵ�NC!");
								return retVal.toString();
							}
							if(StringUtils.isEmpty(saleorderInfo.getSaleUser().getPkPsndoc())){
								retVal.put("message","��ǰҵ��Ա��NC�в����ڣ��뼰ʱͬ��ҵ��Ա���ݵ�NC!");
								return retVal.toString();
							}
							if(StringUtils.isEmpty(saleorderInfo.getSaleOrgInfo().getPkSalesorg())){
								retVal.put("message","��ǰ������֯��NC�в����ڣ��뼰ʱͬ��������֯���ݵ�NC!");
								return retVal.toString();
							}
							if(StringUtils.isEmpty(saleorderInfo.getDeptInfo().getPkDept())){
								retVal.put("message","��ǰ������NC�в����ڣ��뼰ʱͬ���������ݵ�NC!");
								return retVal.toString();
							}
							if(StringUtils.isEmpty(saleorderInfo.getCustomerInfo().getPkCustomer())){
								retVal.put("message","��ǰ�ͻ���NC�в����ڣ��뼰ʱͬ���ͻ����ݵ�NC!");
								return retVal.toString();
							}
							if(StringUtils.isEmpty(saleorderInfo.getStationInfo().getPkCustomer())){
								retVal.put("message","��ǰվ����NC�в����ڣ��뼰ʱͬ��վ�����ݵ�NC!");
								return retVal.toString();
							}
							if(StringUtils.isEmpty(saleorderInfo.getCurrencyInfo().getPkCurrtype())){
								retVal.put("message","��ǰ������NC�в����ڣ��뼰ʱͬ���������ݵ�NC!");
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
		//������֯
		String saleOrgNo = saleorderInfo.getSaleOrgInfo().getPkSalesorg();
		String saleOrgVId = saleorderInfo.getSaleOrgInfo().getPkVid();
		ordermst.setPk_org(saleOrgNo);
		ordermst.setPk_org_v(saleOrgVId);
		
		//����
		ordermst.setCdeptid(saleorderInfo.getDeptInfo().getPkDept());
		ordermst.setCdeptvid(saleorderInfo.getDeptInfo().getPkVid());
		
		//����
		String pkGroup = saleorderInfo.getGroupInfo().getPkGroup();
		ordermst.setPk_group(pkGroup);
		
		//��������
		ordermst.setCtrantypeid(saleorderInfo.getBdBilltype().getPkBilltypeid());
		ordermst.setVtrantypecode(saleorderInfo.getBdBilltype().getPkBilltypecode());
		
		//�������
		ordermst.setVbillcode(saleorderInfo.getSoSaleorder().getVbillcode());
		
		//��������
		String saleOrderDtm = TimeTools.DateStr(saleorderInfo.getSaleOrderDtm(), TimeTools.Y_M_D_H_M_S);
		ordermst.setDbilldate(new UFDate(saleOrderDtm));
		
		//�ͻ�
		String pkCustomer = saleorderInfo.getCustomerInfo().getPkCustomer();
		String isfreecust = saleorderInfo.getCustomerInfo().getIsfreecust();
		ordermst.setCcustomerid(pkCustomer);
		//�Ƿ�ɢ��
		ordermst.setBfreecustflag(new UFBoolean(isfreecust));
		
		//��Ʊ�ͻ�
		ordermst.setCinvoicecustid(pkCustomer);
		
		//վ��
		String pkStation = saleorderInfo.getStationInfo().getPkCustomer();
		ordermst.setVdef2(pkStation);
		
		//��ַ
		ordermst.setVdef3(saleorderInfo.getAreaVal());
		
		//ҵ��Ա
		ordermst.setCemployeeid(saleorderInfo.getSaleUser().getPkPsndoc());
		
		//����
		String pkCurrtype = saleorderInfo.getCurrencyInfo().getPkCurrtype();
		ordermst.setCorigcurrencyid(pkCurrtype);
		
		//ó������-����
		ordermst.setCtradewordid(saleOrgNo);
		ordermst.setCtradewordid(saleOrgVId);
		
		//����״̬ 1=���ɣ�2=����ͨ����3=���ᣬ4=�رգ�7=�����У�8=������ͨ����5=ʧЧ
		ordermst.setFstatusflag(1);
		
		//��ע
		ordermst.setVnote(saleorderInfo.getRemarkDsc());
		
		//ҵ����ˮ--���ָ��ʵ����۶�����
		ordermst.setVdef20(saleorderInfo.getSaleOrderNo());
		
		//�ֻ�
		ordermst.setVdef7(saleorderInfo.getPhoneVal());
		
		//������
		ordermst.setCreator(operatorNo);
		//����ʱ��
		ordermst.setCreationtime(new UFDateTime());
		
		//�Ƶ���
		ordermst.setBillmaker(operatorNo);
		//�Ƶ�����
		ordermst.setDmakedate(new UFDate());
		
		//ҵ������
		String pkBusitype = saleorderInfo.getServiceFlowInfo().getPkBusitype();
		ordermst.setCbiztypeid(pkBusitype);
		
		//������
		ordermst.setNtotalnum(new UFDouble(saleorderInfo.getCountSumVal()));
		//���ǰ���--�ܽ��
		ordermst.setNtotalmny(new UFDouble(saleorderInfo.getAmountsumval()));
		//�ܽ��-��˰�ϼ�
		ordermst.setNtotalorigmny(new UFDouble(saleorderInfo.getAmountsumval()));
		
		ordermst.setDr(new Integer(0));
		ordermst.setTs(new UFDateTime());
		
		ordermst.setApprover("~");
		//�����˷� 
		ordermst.setBadvfeeflag(new UFBoolean("N"));
		
		//�������ر�
		ordermst.setBarsettleflag(new UFBoolean("N"));
		//��Эͬ���ɲɹ�����
		ordermst.setBcooptopoflag(new UFBoolean("N"));
		//�ɱ�����ر�
		ordermst.setBcostsettleflag(new UFBoolean("N"));
		//��Ʊ�ر�
		ordermst.setBinvoicendflag(new UFBoolean("N"));
		//�Ƿ���
		ordermst.setBoffsetflag(new UFBoolean("N"));
		//����ر�
		ordermst.setBoutendflag(new UFBoolean("N"));
		//�ɲɹ�����Эͬ����
		ordermst.setBpocooptomeflag(new UFBoolean("N"));
		//�տ��޶����Ԥ��
		ordermst.setBpreceiveflag(new UFBoolean("N"));
		//�����ر�
		ordermst.setBsendendflag(new UFBoolean("N"));
		ordermst.setCbalancetypeid("~");
		ordermst.setCchanneltypeid("~");
		ordermst.setCcustbankaccid("~");
		ordermst.setCcustbankid("~");
		ordermst.setCfreecustid("~");
		ordermst.setCpaytermid("~");
		ordermst.setCreviserid("~");
		ordermst.setCtransporttypeid("~");
		//������״̬
		ordermst.setFpfstatusflag(new Integer(-1));
		//�޶��汾��
		ordermst.setIversion(new Integer(0));
		//�����ۿ�
		ordermst.setNdiscountrate(new UFDouble(100));
		//���ó�ֽ��
		ordermst.setNtotalorigsubmny(new UFDouble(0));
		//�ܼ���
		ordermst.setNtotalpiece(new UFDouble(0));
		//�ϼ����
		ordermst.setNtotalvolume(new UFDouble(0));
		//�ϼ�����
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
		
		//������֯
		OrgStockorg orgStockorg = new OrgStockorg();
		orgStockorg.initByNo(dao,saleOrgNo);
		String pkFinanceOrg = orgStockorg.getPkFinanceorg();
		
		//������֯�汾
		OrgCorp orgCorp = new OrgCorp();
		orgCorp.initByNo(dao,pkFinanceOrg);
		String financeOrgVId = orgCorp.getPkVid();
		
		//����
		BdCountryzone country = new BdCountryzone();
		country.initDefalut(dao);
		String pkCountry = country.getPkCountry();
		
		List<SaleOrderProdlin> orderProdlins = saleorderInfo.getOrderProdlins();
		//��ʱ�洢
		List<SaleOrderBVO> prodlins = new ArrayList<SaleOrderBVO>();
		if(!CollectionUtils.isEmpty(orderProdlins)){
			//�±��
			int countrow = 0;
			for(SaleOrderProdlin saleOrderProdlin : orderProdlins){
				if(null != saleOrderProdlin){
					if(StringUtils.isEmpty(saleOrderProdlin.getProdInfo().getCode())){
						retVal.put("message","���ϱ��벻��Ϊ��!");
						return retVal;
					}
					
					if(StringUtils.isEmpty(saleOrderProdlin.getUnitInfo().getCode())){
						retVal.put("message","������λ���벻��Ϊ��!");
						return retVal;
					}
					
					if(StringUtils.isEmpty(saleOrderProdlin.getTaxRateInfo().getCode())){
						retVal.put("message","˰�ʱ��벻��Ϊ��!");
						return retVal;
					}
					
					if(null == saleOrderProdlin.getCountVal()){
						retVal.put("message","��������Ϊ��!");
						return retVal;
					}
					if(null == saleOrderProdlin.getNotaxPriceVal()){
						retVal.put("message","��˰���۲���Ϊ��!");
						return retVal;
					}
					//��������
					String pkMaterial = saleOrderProdlin.getProdInfo().getPkMaterial();
					if(StringUtils.isEmpty(pkMaterial)){
						retVal.put("message","��ǰ������NC�в����ڣ��뼰ʱͬ���������ݵ�NC!");
						return retVal;
					}
					//������λ����
					String pkMeasdoc = saleOrderProdlin.getUnitInfo().getPkMeasdoc();
					if(StringUtils.isEmpty(pkMeasdoc)){
						retVal.put("message","��ǰ������λ��NC�в����ڣ��뼰ʱͬ��������λ���ݵ�NC!");
						return retVal;
					}
					//˰������
					String pkTaxcode = saleOrderProdlin.getTaxRateInfo().getPkTaxcode();
					if(StringUtils.isEmpty(pkTaxcode)){
						retVal.put("message","��ǰ��ֵ˰����NC�в����ڣ��뼰ʱͬ����ֵ˰�����ݵ�NC!");
						return retVal;
					}
					SaleOrderBVO prodlin = new SaleOrderBVO();
					countrow += 10;
					//�к�
					prodlin.setCrowno(String.valueOf(countrow));
					//����
					prodlin.setCmaterialid(pkMaterial);
					//���ϣ���汾��
					prodlin.setCmaterialvid(pkMaterial);
					//˰��
					prodlin.setNtaxrate(new UFDouble(saleOrderProdlin.getTaxRateVal()));
					//˰��
					prodlin.setCtaxcodeid(pkTaxcode);
					
					//������λ
					prodlin.setCunitid(pkMeasdoc);
					
					//������λ
					prodlin.setCastunitid(saleOrderProdlin.getConvertInfo().getPkMeasdoc());
					//ת������
					String convertVal = saleOrderProdlin.getConvertInfo().getMeasrate();
					prodlin.setVchangerate(convertVal);
					
					//�б�ע
					prodlin.setVrownote(saleOrderProdlin.getRemarkDsc());
					
					//��λ��
					prodlin.setCcurrencyid(saleorderInfo.getCurrencyInfo().getPkCurrtype());
					
					//������
					UFDouble nnum = new UFDouble(saleOrderProdlin.getCountVal());
					prodlin.setNnum(nnum);
					
					String[] str = new String[2];
					str = convertVal.split("/");
					//����
					UFDouble nastnum = new UFDouble(nnum).multiply(
							new UFDouble(str[1])).div(new UFDouble(str[0]));
					prodlin.setNastnum(nastnum);
					
					//��˰����
					UFDouble nqtorigprice = new UFDouble(saleOrderProdlin.getNotaxPriceVal());
					prodlin.setNqtorigprice(nqtorigprice);
					//��˰���
					UFDouble norigmny = new UFDouble(saleOrderProdlin.getNotaxAmountVal());
					prodlin.setNorigmny(norigmny);
					//��˰����
					UFDouble nqtorigtaxprice = new UFDouble(saleOrderProdlin.getPriceVal());
					prodlin.setNqtorigtaxprice(nqtorigtaxprice);
					//��˰�ϼ�
					UFDouble norigtaxmny = new UFDouble(saleOrderProdlin.getAmountVal());
					prodlin.setNorigtaxmny(norigtaxmny);
					
					//��˰���
					prodlin.setNcaltaxmny(norigmny);
					//������˰���
					prodlin.setNmny(norigmny);
					//��������˰����
					prodlin.setNnetprice(nqtorigprice);
					//����˰����
					prodlin.setNorignetprice(nqtorigprice);
					//����˰����
					prodlin.setNorigprice(nqtorigprice);
					//����˰����
					prodlin.setNorigtaxnetprice(nqtorigtaxprice);
					//����˰����
					prodlin.setNorigtaxprice(nqtorigtaxprice);
					//��������˰����
					prodlin.setNprice(nqtorigprice);
					//������˰����
					prodlin.setNqtnetprice(nqtorigprice);
					
					
					
					//�۱�����
					prodlin.setNexchangerate(new UFDouble(saleOrderProdlin.getCostRateVal()));
					/******************�˴������������㲻��***********************/
					SaleOrderLogisticlin saleOrderLogisticlin = saleorderInfo.getSaleOrderLogisticlin();
				
					if(null != saleOrderLogisticlin){
						//��������
						UFDate dsendDate = new UFDate();
						if(null != saleOrderLogisticlin.getPlanSendDtm()){
							String planSendDtm = TimeTools.DateStr(saleOrderLogisticlin.getPlanSendDtm(), TimeTools.Y_M_D_H_M_S);
							dsendDate = new UFDate(planSendDtm);
						}
						prodlin.setDsenddate(dsendDate);
						//��������
						UFDate dreceiveDate = new UFDate();
						if(null != saleOrderLogisticlin.getDemandTakeDtm()){
							String demandTakeDtm = TimeTools.DateStr(saleOrderLogisticlin.getDemandTakeDtm(), TimeTools.Y_M_D_H_M_S);
							dreceiveDate = new UFDate(demandTakeDtm);
						}
						prodlin.setDreceivedate(dreceiveDate);
						//�ջ��ͻ�
						prodlin.setCreceivecustid(saleOrderLogisticlin.getCustomerInfo().getPkCustomer());
						
					}
					//���������֯
					prodlin.setCsendstockorgvid(saleOrgNo);
					//�����������°汾
					prodlin.setCprofitcenterid(saleOrgNo);
					//�������İ汾
					prodlin.setCprofitcentervid(saleOrgVId);
					//��������
					prodlin.setCarorgid(pkFinanceOrg);
					//������֯�汾
					prodlin.setCsettleorgvid(financeOrgVId);
					//������֯�汾
					prodlin.setCarorgvid(financeOrgVId);
					//������֯
					prodlin.setPk_org(saleOrgNo);
					//����
					prodlin.setPk_group(pkGroup);
					
					prodlin.setDr(new Integer(0));
					prodlin.setTs(new UFDateTime());
					
					
					//���۵�λ
					prodlin.setCqtunitid(pkMeasdoc);
					//�ջ�����/����
					prodlin.setCrececountryid(pkCountry);
					//��������/����
					prodlin.setCsendcountryid(pkCountry);
					prodlin.setCtrafficorgid(pkCountry);
					//�����֯
					prodlin.setCsendstockorgid(saleOrgNo);
					//�����֯�汾
					prodlin.setCsendstockorgvid(saleOrgVId);
					prodlin.setCtrafficorgvid(saleOrgVId);
					//������֯
					prodlin.setCsettleorgid(pkFinanceOrg);
					//������֯�汾
					prodlin.setCtaxcountryid(pkCountry);
					//��������--�Ƿ�Ҫ�����۶�������ͬ��
					prodlin.setDbilldate(new UFDate());
					//�������� 1=�������ۣ�2=���ڲɹ���3=���ڣ�4=���ڣ�5=������
					prodlin.setFbuysellflag(new Integer(1));
					//��Ʒ�۸��̯��ʽ 1=δ��̯��2=����̯���ϣ�3=��̯��Ʒ
					prodlin.setFlargesstypeflag(new Integer(1));
					prodlin.setFretexchange(new Integer(0));
					prodlin.setFrowstatus(new Integer(1));

					//��˰��� 1=Ӧ˰��ӣ�0=Ӧ˰�ں�
					prodlin.setFtaxtypeflag(new Integer(1));

					//�����ۿ۶�
					prodlin.setNdiscount(new UFDouble(0));
					//��Ʒ�ۿ�
					prodlin.setNitemdiscountrate(new UFDouble(100));
					//�ۿ۶�
					prodlin.setNorigdiscount(new UFDouble(0));
					
					//��˰����
					prodlin.setNqtorigtaxnetprc(nqtorigtaxprice);
					//������˰����
					prodlin.setNqtprice(nqtorigprice);
					//���Һ�˰���� 
					prodlin.setNqttaxnetprice(nqtorigtaxprice);
					//��˰����
					prodlin.setNqtorigprice(nqtorigprice);
					//���Һ�˰����
					prodlin.setNqttaxprice(nqtorigtaxprice);
					//���۵�λ����
					prodlin.setNqtunitnum(new UFDouble(nnum));
					//˰��
					UFDouble ntax = new UFDouble(norigtaxmny).sub(new UFDouble(
							norigmny));
					prodlin.setNtax(ntax);
					//���Ҽ�˰�ϼ�
					prodlin.setNtaxmny(norigtaxmny);
					//�����Һ�˰����
					prodlin.setNtaxnetprice(nqtorigtaxprice);
					//�����Һ�˰����
					prodlin.setNtaxprice(nqtorigtaxprice);
					//���
					prodlin.setNvolume(new UFDouble(0));
					//����
					prodlin.setNweight(new UFDouble(0));
					//���ۻ�����
					prodlin.setVqtunitrate("1.00/1.00");
					//���ǰ���
					prodlin.setNbforigsubmny(norigmny);
					//��˰����
					prodlin.setNqtorignetprice(nqtorigprice);
					//�����ۿ�
					prodlin.setNdiscountrate(new UFDouble(100));
					
					//�Ƿ��Դ�������
					prodlin.setBarrangedflag(new UFBoolean("N"));
					//�������ر� 
					prodlin.setBbarsettleflag(new UFBoolean("N"));
					//�ɱ�����ر�
					prodlin.setBbcostsettleflag(new UFBoolean("N"));
					//������
					prodlin.setBbindflag(new UFBoolean("N"));
					//��Ʊ�ر�
					prodlin.setBbinvoicendflag(new UFBoolean("N"));
					//����ر�
					prodlin.setBboutendflag(new UFBoolean("N"));
					//�����ر�
					prodlin.setBbsendendflag(new UFBoolean("N"));
					//�ۿ���
					prodlin.setBdiscountflag(new UFBoolean("N"));
					//���ת����
					prodlin.setBjczxsflag(new UFBoolean("N"));
					//������
					prodlin.setBlaborflag(new UFBoolean("N"));
					//��Ʒ
					prodlin.setBlargessflag(new UFBoolean("N"));
					//����ó��
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
		retVal.put("message","ͬ���ɹ�!");
		return retVal;
	}

	private JSONObject updateSaleOrder(JSONObject retVal, BaseDAO dao,
			SaleorderInfo saleorderInfo, String operatorNo) {
		
		return retVal;
	}

	

}
