package nc.itf.Impl.utils;

import java.util.Date;

import org.apache.commons.lang.StringUtils;

import config.SystemConfig;
import nc.bs.dao.BaseDAO;
import nc.bs.dao.DAOException;
import nc.bs.framework.common.InvocationInfoProxy;
import nc.jdbc.framework.SQLParameter;
import nc.jdbc.framework.processor.ColumnProcessor;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class WebServicesUtils {

	/**
	 * 获取通用的WebService返回信息
	 * @return
	 */
	public static JSONObject getCommonReturnJson() {
		JSONObject retVal = new JSONObject();	
		retVal.put("result", "fail");
		retVal.put("code", "0000");
		retVal.put("message", "调用接口失败，请检查参数!");
		return retVal;
	}
	
	/**
	 * Json字符串转化成Json对象
	 * @param paramsStr
	 * @return
	 */
	public static JSONObject String2Json(String paramsStr) {
		if(StringUtils.isNotEmpty(paramsStr)){
			try{
				JSONObject retVal = JSONObject.fromObject(paramsStr);
				
				return retVal;
				
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return null;
	}
	/**
	 * 接口多参数费控校验
	 * @param retVal
	 * @param paramFields
	 * @param paramNames
	 * @param paramsStr 
	 * @return
	 */
	public static boolean ParamsCheckNull(JSONObject retVal,
			String[] paramFields, String[] paramNames, String paramsStr) {
		boolean retFlg = false;
		if(null != retVal && null != paramFields && null != paramNames && StringUtils.isNotEmpty(paramsStr)){
			JSONObject params = WebServicesUtils.String2Json(paramsStr);
			if(null != params){
				JSONArray josnArray = params.getJSONArray("datas");
				if(null != josnArray && josnArray.size() > 0){
					for(int i=0;i<josnArray.size();i++){
						JSONObject info = (JSONObject) josnArray.get(i);
						JSONObject checkRetVal = CheckNull(paramFields,paramNames,info);
						retFlg = checkRetVal.getBoolean("flag");
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
		return retFlg;
	}
	
	/**
	 * 参数校验
	 * @param paramFields
	 * @param paramNames
	 * @param params
	 * @return
	 */
	public static JSONObject CheckNull(String[] paramFields, String[] paramNames,JSONObject params) {
		JSONObject retVal = new JSONObject();
		retVal.put("flag", false);
		retVal.put("message", "请检查必填参数!");
		if (null != params && null != paramFields && null != paramNames) {
			if (paramFields.length == paramNames.length) {
				for (int i = 0; i < paramFields.length; i++) {
					boolean checkFlag = false;
					Object value = params.get(paramFields[i]);
					if (value instanceof Integer) {
						if (null != value) {
							checkFlag = true;
						}
					} else if (value instanceof String) {
						if (StringUtils.isNotEmpty((String) value)) {
							checkFlag = true;
						}
					} else if (value instanceof Double) {
						if (null != value) {
							checkFlag = true;
						}
					} else if (value instanceof Float) {
						if (null != value) {
							checkFlag = true;
						}
					} else if (value instanceof Long) {
						if (null != value) {
							checkFlag = true;
						}
					} else if (value instanceof Date) {
						if (null != value) {
							checkFlag = true;
						}
					}
					retVal.put("flag", checkFlag);
					if(!checkFlag){
						retVal.put("message", "必填字段"+paramFields[i]+"为空!");
						break;
					}
				}
			} else {
				retVal.put("message", "待检测参数数目与参数名数目不一致!");

			}
		}

		return retVal;
	}
	
	/**
	 * 生成主键
	 * @param dao
	 * @param pkgroup
	 * @param nums
	 * @return
	 * @throws DAOException
	 */
	public static String generatePkValue(BaseDAO dao,String pkgroup, int nums) throws DAOException {
        String pkvalue = "";
        String groupNo = "";
        if(StringUtils.isNotEmpty(pkgroup)){
        	String getSql = "";
			SQLParameter parameter = new SQLParameter();
			//查询集团
			getSql = "select A.GROUPNO from ORG_GROUP A where A.CODE ='01' and A.DR=0";
			parameter.clearParams();
			groupNo = (String) dao.executeQuery(getSql, parameter , new ColumnProcessor());
        }
        if(StringUtils.isEmpty(groupNo)){
        	groupNo = "1001";
        }
        pkvalue +=groupNo;
        String dbsourceoid = "A1";
        pkvalue +=dbsourceoid;
        int randomlength = nums - pkvalue.length();
        pkvalue += RandomUtils.getRandomString(randomlength);

        return pkvalue;
    }
	
	/**
	 * 获取数据库连接
	 * @return
	 */
	@SuppressWarnings("unused")
	public static BaseDAO getBaseDao() {
		// 获取数据源
		BaseDAO dao=new BaseDAO();
		if(null == dao){
			String oldDataSourceName = InvocationInfoProxy.getInstance().getUserDataSource();
			dao=new BaseDAO(oldDataSourceName);
			if(null == dao){
				dao = new BaseDAO(SystemConfig.getInstance().getDatasource());
			}
		}

		return dao;
	}

}
