package nc.itf.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import nc.bs.dao.BaseDAO;
import nc.bs.dao.DAOException;
import nc.impl.pubapp.pattern.database.DBTool;
import nc.itf.Impl.dto.SaleOrderLogisticlin;
import nc.itf.Impl.dto.SaleOrderProdlin;
import nc.itf.Impl.dto.SaleorderInfo;
import nc.itf.Impl.entity.BdBilltype;
import nc.itf.Impl.entity.BdBusitype;
import nc.itf.Impl.entity.BdCurrtype;
import nc.itf.Impl.entity.BdCustomer;
import nc.itf.Impl.entity.BdMaterial;
import nc.itf.Impl.entity.BdMaterialconvert;
import nc.itf.Impl.entity.BdMeasdoc;
import nc.itf.Impl.entity.BdPsndoc;
import nc.itf.Impl.entity.BdTaxcode;
import nc.itf.Impl.entity.OrgDept;
import nc.itf.Impl.entity.OrgGroup;
import nc.itf.Impl.entity.OrgSalesorg;
import nc.itf.Impl.entity.SoSaleorder;
import nc.itf.Impl.entity.SoSaleorderExe;
import nc.itf.Impl.utils.JDBCUtils;
import nc.itf.Impl.utils.TimeTools;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class SaleOrderUtils {

	public static List<SaleorderInfo> initList(BaseDAO dao, JSONObject params) throws DAOException {
		List<SaleorderInfo> saleorderInfos = new ArrayList<SaleorderInfo>();
		if(null != params){
			JSONArray josnArray = params.getJSONArray("datas");
			if(null != josnArray && josnArray.size() > 0){
				OrgGroup groupInfo = new OrgGroup();
				groupInfo.initByCode(dao,"01");
				
				for(int i=0;i<josnArray.size();i++){
					JSONObject info = (JSONObject) josnArray.get(i);
					if(null != info){
					
						//销售订单编号
						String saleOrderNo = info.getString("saleOrderNo");
						String saleOrderId =  info.getString("saleOrderId");
						SoSaleorder soSaleorder = new SoSaleorder();
						soSaleorder.initByCode(dao,saleOrderId);
						//单据类型
						String saleOrderTypId =  info.getString("saleOrderTypId");
						BdBilltype bdBilltype = new BdBilltype();
						bdBilltype.initByCode(dao,saleOrderTypId);
						//业务流主键
						BdBusitype serviceFlowInfo = new BdBusitype();
						serviceFlowInfo.initInfo(dao,groupInfo.getPkGroup(),saleOrderTypId);
						//单据日期
						Date saleOrderDtm = null;
						String saleOrderDtmStr =  info.getString("saleOrderDtm");
						if(StringUtils.isNotEmpty(saleOrderDtmStr)){
							saleOrderDtm = TimeTools.DateFormate(saleOrderDtmStr, TimeTools.Y_M_D_H_M_S);
						}
						//单据状态
						String validSta =  info.getString("validSta");
						//备注
						String remarkDsc =  info.getString("remarkDsc");
						//业务员
						String saleUserId =  info.getString("saleUserId");
						BdPsndoc saleUser = new BdPsndoc();
						saleUser.initByCode(dao,saleUserId);
						//手机
						String phoneVal =  info.getString("phoneVal");
						//销售组织编号
						String saleOrgId =  info.getString("saleOrgId");
						OrgSalesorg saleOrgInfo = new OrgSalesorg();
						saleOrgInfo.initByCode(dao,saleOrgId);
						//部门编号
						String deptId =  info.getString("deptId");
						OrgDept deptInfo = new OrgDept();
						deptInfo.initByCode(dao,deptId);
						//客户编号
						String customerId =  info.getString("customerId");
						BdCustomer customerInfo = new BdCustomer();
						customerInfo.initByCode(dao,customerId);
						//站点编号
						String stationId =  info.getString("stationId");
						BdCustomer stationInfo = new BdCustomer();
						stationInfo.initByCode(dao,stationId);
						//地址
						String areaVal =  info.getString("areaVal");
						//币种编号
						String currencyTypId =  info.getString("currencyTypId");
						BdCurrtype currencyInfo = new BdCurrtype();
						currencyInfo.initByCode(dao,currencyTypId);
						//总数量
						Double countSumVal =  info.getDouble("countSumVal");
						//总金额
						Double amountsumval =  info.getDouble("amountSumVal");
						
						List<SaleOrderProdlin> orderProdlins = new ArrayList<SaleOrderProdlin>();
						JSONArray prodlinArray = info.getJSONArray("orderProdlins");
						if(null != prodlinArray && prodlinArray.size() > 0){
							for(int j=0;j<prodlinArray.size();j++){
								JSONObject prodlin = (JSONObject) prodlinArray.get(j);
								if(null != prodlin){
									//物料编号
									String prodId =  prodlin.getString("prodId");
									BdMaterial prodInfo = new BdMaterial();
									prodInfo.initByCode(dao,prodId);
									//计量单位编号
									String unitId =  prodlin.getString("unitId");
									BdMeasdoc unitInfo = new BdMeasdoc();
									unitInfo.initByCode(dao,unitId);
									//辅助单位
									BdMaterialconvert convertInfo = new BdMaterialconvert();
									convertInfo.initByCode(dao,prodInfo.getPkMaterial());
									//税率（%）
								    String taxRateId= prodlin.getString("taxRateId");
								    BdTaxcode taxRateInfo = new BdTaxcode();
								    taxRateInfo.initByCode(dao,taxRateId);
								    Double taxRateVal = prodlin.getDouble("taxRateVal");
								    //物料数量
								    Double countVal = prodlin.getDouble("countVal");
								    //含税单价
								    Double priceVal = prodlin.getDouble("priceVal");
								    //价税合计
								    Double amountVal = prodlin.getDouble("amountVal");
								    //无税单价
								    Double notaxPriceVal = prodlin.getDouble("notaxPriceVal");
								    //无税金额
								    Double notaxAmountVal = prodlin.getDouble("notaxAmountVal");
								    //折本汇率
								    Double costRateVal = prodlin.getDouble("costRateVal");
								    //备注
								    String remarkLinDsc = prodlin.getString("remarkDsc");
								    
									SaleOrderProdlin saleOrderProdlin = new SaleOrderProdlin(prodInfo,unitInfo,
											convertInfo,countVal,priceVal,amountVal,notaxPriceVal,notaxAmountVal,costRateVal,
											taxRateInfo,taxRateVal,remarkLinDsc);
									
									orderProdlins.add(saleOrderProdlin);
								}
								
							}
						}
						//收发货信息
						SaleOrderLogisticlin saleOrderLogisticlin = null;
						JSONArray logisticLinArray = info.getJSONArray("orderLogisticlins");
						if(null != logisticLinArray && logisticLinArray.size() > 0){
							JSONObject logisticlin = (JSONObject) logisticLinArray.get(0);
							if(null != logisticlin){
								//计划发货日期
								Date planSendDtm = null;
								String planSendDtmStr =  logisticlin.getString("planSendDtm");
								if(StringUtils.isNotEmpty(planSendDtmStr)){
									planSendDtm = TimeTools.DateFormate(planSendDtmStr, TimeTools.Y_M_D_H_M_S);
								}
								//要求收货日期
								Date demandTakeDtm = null;
								String demandTakeDtmStr =  logisticlin.getString("demandTakeDtm");
								if(StringUtils.isNotEmpty(demandTakeDtmStr)){
									demandTakeDtm = TimeTools.DateFormate(demandTakeDtmStr, TimeTools.Y_M_D_H_M_S);
								}
								//收货地址
								String takeAreaVal =  logisticlin.getString("takeAreaVal");
								//收货客户
								String linCustomerId =  logisticlin.getString("customerId");
								BdCustomer takeCustomerInfo = new BdCustomer();
								takeCustomerInfo.initByCode(dao,linCustomerId);
								//收货人
								String recieveUserId =  logisticlin.getString("recieveUserId");
								//联系方式
								String linPhoneVal =  logisticlin.getString("phoneVal");
								//计划发货日期
								Date actulSendDtm = null;
								String actulSendDtmStr =  logisticlin.getString("actulSendDtm");
								if(StringUtils.isNotEmpty(actulSendDtmStr)){
									actulSendDtm = TimeTools.DateFormate(actulSendDtmStr, TimeTools.Y_M_D_H_M_S);
								}
								//要求收货日期
								Date actulTakeDtm = null;
								String actulTakeDtmStr =  logisticlin.getString("actulTakeDtm");
								if(StringUtils.isNotEmpty(actulTakeDtmStr)){
									actulTakeDtm = TimeTools.DateFormate(actulTakeDtmStr, TimeTools.Y_M_D_H_M_S);
								}
								//收货地址
								String actulAreaVal =  logisticlin.getString("actulAreaVal");
								//备注
								String linRemarkDsc =  logisticlin.getString("remarkDsc");
								
								saleOrderLogisticlin = new SaleOrderLogisticlin(planSendDtm,takeAreaVal,
										demandTakeDtm,takeCustomerInfo,
										recieveUserId,linPhoneVal,
										actulSendDtm,actulTakeDtm,linRemarkDsc,actulAreaVal);
							}
						}
						
						SaleorderInfo saleorderInfo = new SaleorderInfo(saleOrderNo,soSaleorder,
								bdBilltype,serviceFlowInfo,saleOrderDtm,
								validSta,remarkDsc,saleUser,
								phoneVal,groupInfo,saleOrgInfo,
								deptInfo,customerInfo,stationInfo,
								areaVal,currencyInfo,countSumVal,
								amountsumval,orderProdlins,saleOrderLogisticlin);
						
						saleorderInfos.add(saleorderInfo);
					}
					
					
				}
			}
		}
		return saleorderInfos;
	}
	/**
	 * 插入销售订单物料明细扩展表
	 * @param soSaleorderExeVo
	 * @throws SQLException 
	 */
	public static int insertSoSaleorderExe(SoSaleorderExe soSaleorderExe) throws SQLException {
		int retVal = 0;
		if(null != soSaleorderExe){
			DBTool db=new DBTool();
			Connection conn = null;
		    PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				//首先需要获取实例,然后获取连接
				conn = db.getConnection();
				//创建语句
				StringBuffer insertSql = new StringBuffer();
				insertSql.append(" insert into SO_SALEORDER_EXE (CSALEORDERBID, DR, NARRANGEMONUM, NARRANGEPOAPPNUM, ");
				insertSql.append(" NARRANGEPONUM, NARRANGESCORNUM, NARRANGETOAPPNUM, NARRANGETOORNUM, NORIGSUBMNY,  ");
				insertSql.append(" NREQRSNUM, NTOTALARMNY, NTOTALARNUM, NTOTALCOSTNUM, NTOTALESTARMNY, NTOTALESTARNUM,  ");
				insertSql.append(" NTOTALINVOICENUM, NTOTALNOTOUTNUM, NTOTALOUTNUM, NTOTALPAYMNY, NTOTALPLONUM, NTOTALRETURNNUM, ");
				insertSql.append(" NTOTALRUSHNUM, NTOTALSENDNUM, NTOTALSIGNNUM, NTOTALTRADENUM, NTRANSLOSSNUM, TS) ");
				insertSql.append(" values ( ");
				insertSql.append(" ?,?,?,?, ");
				insertSql.append(" ?,?,?,?,?, ");
				insertSql.append(" ?,?,?,?,?,?, ");
				insertSql.append(" ?,?,?,?,?,?, ");
				insertSql.append(" ?,?,?,?,?,? ");
				insertSql.append(" ) ");
		        pstmt = (PreparedStatement) conn.prepareStatement(insertSql.toString());
		        pstmt.setString(1, soSaleorderExe.getCsaleorderbid());
		        pstmt.setLong(2, soSaleorderExe.getDr());
		        pstmt.setBigDecimal(3, soSaleorderExe.getNarrangemonum());
		        pstmt.setBigDecimal(4, soSaleorderExe.getNarrangepoappnum());
		        pstmt.setBigDecimal(5, soSaleorderExe.getNarrangeponum());
		        pstmt.setBigDecimal(6, soSaleorderExe.getNarrangescornum());
		        pstmt.setBigDecimal(7, soSaleorderExe.getNarrangetoappnum());
		        pstmt.setBigDecimal(8, soSaleorderExe.getNarrangetoornum());
		        pstmt.setBigDecimal(9, soSaleorderExe.getNorigsubmny());
		        pstmt.setBigDecimal(10, soSaleorderExe.getNreqrsnum());
		        pstmt.setBigDecimal(11, soSaleorderExe.getNtotalarmny());
		        pstmt.setBigDecimal(12, soSaleorderExe.getNtotalarnum());
		        pstmt.setBigDecimal(13, soSaleorderExe.getNtotalcostnum());
		        pstmt.setBigDecimal(14, soSaleorderExe.getNtotalestarmny());
		        pstmt.setBigDecimal(15, soSaleorderExe.getNtotalestarnum());
		        pstmt.setBigDecimal(16, soSaleorderExe.getNtotalinvoicenum());
		        pstmt.setBigDecimal(17, soSaleorderExe.getNtotalnotoutnum());
		        pstmt.setBigDecimal(18, soSaleorderExe.getNtotaloutnum());
		        pstmt.setBigDecimal(19, soSaleorderExe.getNtotalpaymny());
		        pstmt.setBigDecimal(20, soSaleorderExe.getNtotalplonum());
		        pstmt.setBigDecimal(21, soSaleorderExe.getNtotalreturnnum());
		        pstmt.setBigDecimal(22, soSaleorderExe.getNtotalrushnum());
		        pstmt.setBigDecimal(23,	soSaleorderExe.getNtotalsendnum() );
		        pstmt.setBigDecimal(24,	soSaleorderExe.getNtotalsignnum() );
		        pstmt.setBigDecimal(25, soSaleorderExe.getNtotaltradenum());
		        pstmt.setBigDecimal(26, soSaleorderExe.getNtranslossnum());
		        pstmt.setString(27, soSaleorderExe.getTs());
				//处理结果集
				retVal = pstmt.executeUpdate();
			} finally {
				JDBCUtils.free(conn, pstmt, rs);
			}
			
		}
		return retVal;
		
	}
	


}
