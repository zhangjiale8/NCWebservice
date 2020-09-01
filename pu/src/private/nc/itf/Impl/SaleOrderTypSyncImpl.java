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
				/***************************����У�� start**************************************/
				String [] paramFields = {"saleOrderTypId","saleOrderTypId","countSumVal","amountSumVal"};
				String [] paramNames = {"�������","��������","������","�ܽ��"};
				boolean flg = WebServicesUtils.ParamsCheckNull(retVal,paramFields,paramNames,paramsStr);
				if(flg){
					BaseDAO dao = new BaseDAO(SystemConfig.getInstance().getDatasource());
					JSONObject params = WebServicesUtils.String2Json(paramsStr);
					String getSql = "";
					SQLParameter parameter = new SQLParameter();
					//������
					String operatorNo = null;
					String operatorId = params.getString("operatorId");
					if(StringUtils.isNotEmpty(operatorId)){
						getSql = "select A.CUSERID from SM_USER A where A.USER_CODE = ?";
						parameter.clearParams();
						parameter.addParam(operatorId);
						operatorNo = (String) dao.executeQuery(getSql, parameter , new ColumnProcessor());
					}
					//��ѯ����
					getSql = "select A.PK_GROUP from ORG_GROUP A where A.CODE ='01' and A.DR=0";
					parameter.clearParams();
					String groupNo = (String) dao.executeQuery(getSql, parameter , new ColumnProcessor());
					
					JSONArray datas = params.getJSONArray("datas");
					for(int i=0;i<datas.size();i++){
						JSONObject info = datas.getJSONObject(i);
						//����
						String saleOrderTypNo = WebServicesUtils.generatePkValue(dao,groupNo,20);
						//�������ͱ��
					    String saleOrderTypId = info.getString("saleOrderTypId");
					    //������������
					    String saleOrderTypNam = info.getString("saleOrderTypNam");
					    //��Ч״̬
					    String validSta = info.getString("validSta");
					    //��ע
					    String remarkDsc = info.getString("remarkDsc");
					    
						BilltypeVO orderTypInfo = new BilltypeVO();
						orderTypInfo.setPk_billtypeid(saleOrderTypNo);
						orderTypInfo.setPk_billtypecode(saleOrderTypId);
						orderTypInfo.setBilltypename(saleOrderTypNam);
						orderTypInfo.setWebNodecode("~");
						orderTypInfo.setSystemcode("SO");
						
					}
					
					/***************************����У�� end**************************************/
					
					//���ݿ����
					
					
					
				}
				
				
			}
			
		}catch(Exception e){
			e.printStackTrace();
			retVal.put("message",e.getMessage());
		}
		
		return retVal.toString();
	}

	
	

}
