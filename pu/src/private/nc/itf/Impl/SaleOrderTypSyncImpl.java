package nc.itf.Impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;

import config.SystemConfig;
import nc.bs.dao.BaseDAO;
import nc.itf.Impl.dto.SaleorderInfo;
import nc.itf.Impl.utils.WebServicesUtils;
import nc.jdbc.framework.SQLParameter;
import nc.jdbc.framework.processor.ColumnProcessor;
import nc.ui.itf.ISaleOrderTypSync;
import nc.vo.pub.billtype.BilltypeVO;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


public class SaleOrderTypSyncImpl implements ISaleOrderTypSync{

	@Override
	public String ncSaleOrderTypSync(String paramsStr) {
		JSONObject retVal = WebServicesUtils.getCommonReturnJson();
		try{
			if(StringUtils.isNotEmpty(paramsStr)){
				/***************************参数校验 start**************************************/
				String [] paramFields = {"saleOrderTypId","saleOrderTypId","countSumVal","amountSumVal"};
				String [] paramNames = {"订单编号","订单类型","总数量","总金额"};
				boolean flg = WebServicesUtils.ParamsCheckNull(retVal,paramFields,paramNames,paramsStr);
				if(flg){
					BaseDAO dao = new BaseDAO(SystemConfig.getInstance().getDatasource());
					JSONObject params = WebServicesUtils.String2Json(paramsStr);
					String getSql = "";
					SQLParameter parameter = new SQLParameter();
					//操作人
					String operatorNo = null;
					String operatorId = params.getString("operatorId");
					if(StringUtils.isNotEmpty(operatorId)){
						getSql = "select A.CUSERID from SM_USER A where A.USER_CODE = ?";
						parameter.clearParams();
						parameter.addParam(operatorId);
						operatorNo = (String) dao.executeQuery(getSql, parameter , new ColumnProcessor());
					}
					//查询集团
					getSql = "select A.PK_GROUP from ORG_GROUP A where A.CODE ='01' and A.DR=0";
					parameter.clearParams();
					String groupNo = (String) dao.executeQuery(getSql, parameter , new ColumnProcessor());
					
					JSONArray datas = params.getJSONArray("datas");
					for(int i=0;i<datas.size();i++){
						JSONObject info = datas.getJSONObject(i);
						//主键
						String saleOrderTypNo = WebServicesUtils.generatePkValue(dao,groupNo,20);
						//订单类型编号
					    String saleOrderTypId = info.getString("saleOrderTypId");
					    //订单类型名称
					    String saleOrderTypNam = info.getString("saleOrderTypNam");
					    //有效状态
					    String validSta = info.getString("validSta");
					    //备注
					    String remarkDsc = info.getString("remarkDsc");
					    
						BilltypeVO orderTypInfo = new BilltypeVO();
						orderTypInfo.setPk_billtypeid(saleOrderTypNo);
						orderTypInfo.setPk_billtypecode(saleOrderTypId);
						orderTypInfo.setBilltypename(saleOrderTypNam);
						orderTypInfo.setWebNodecode("~");
						orderTypInfo.setSystemcode("SO");
						
					}
					
					/***************************参数校验 end**************************************/
					
					//数据库操作
					
					
					
				}
				
				
			}
			
		}catch(Exception e){
			e.printStackTrace();
			retVal.put("message",e.getMessage());
		}
		
		return retVal.toString();
	}

	
	

}
