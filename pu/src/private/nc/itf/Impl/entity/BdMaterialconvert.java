package nc.itf.Impl.entity;

import java.util.ArrayList;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;

import nc.bs.dao.BaseDAO;
import nc.bs.dao.DAOException;
import nc.jdbc.framework.SQLParameter;
import nc.jdbc.framework.processor.MapListProcessor;

/**
 * 物料转换
 * @author zhangjiale
 *
 */
public class BdMaterialconvert{

    private Long dataoriginflag;

    private Long dr;

    private String fixedflag;

    private String ispiecemangage;

    private String isprodmeasdoc;

    private String ispumeasdoc;

    private String isretailmeasdoc;

    private String issalemeasdoc;

    private String isstockmeasdoc;

    private String isstorebalance;
    //转化比率
    private String measrate;

    private String pkApartmeasdoc;

    private String pkMaterial;
    //主键
    private String pkMaterialconvert;

    private String pkMeasdoc;

    private Long showorder;

    private String ts;

	public Long getDataoriginflag() {
		return dataoriginflag;
	}

	public void setDataoriginflag(Long dataoriginflag) {
		this.dataoriginflag = dataoriginflag;
	}

	public Long getDr() {
		return dr;
	}

	public void setDr(Long dr) {
		this.dr = dr;
	}

	public String getFixedflag() {
		return fixedflag;
	}

	public void setFixedflag(String fixedflag) {
		this.fixedflag = fixedflag;
	}

	public String getIspiecemangage() {
		return ispiecemangage;
	}

	public void setIspiecemangage(String ispiecemangage) {
		this.ispiecemangage = ispiecemangage;
	}

	public String getIsprodmeasdoc() {
		return isprodmeasdoc;
	}

	public void setIsprodmeasdoc(String isprodmeasdoc) {
		this.isprodmeasdoc = isprodmeasdoc;
	}

	public String getIspumeasdoc() {
		return ispumeasdoc;
	}

	public void setIspumeasdoc(String ispumeasdoc) {
		this.ispumeasdoc = ispumeasdoc;
	}

	public String getIsretailmeasdoc() {
		return isretailmeasdoc;
	}

	public void setIsretailmeasdoc(String isretailmeasdoc) {
		this.isretailmeasdoc = isretailmeasdoc;
	}

	public String getIssalemeasdoc() {
		return issalemeasdoc;
	}

	public void setIssalemeasdoc(String issalemeasdoc) {
		this.issalemeasdoc = issalemeasdoc;
	}

	public String getIsstockmeasdoc() {
		return isstockmeasdoc;
	}

	public void setIsstockmeasdoc(String isstockmeasdoc) {
		this.isstockmeasdoc = isstockmeasdoc;
	}

	public String getIsstorebalance() {
		return isstorebalance;
	}

	public void setIsstorebalance(String isstorebalance) {
		this.isstorebalance = isstorebalance;
	}

	public String getMeasrate() {
		return measrate;
	}

	public void setMeasrate(String measrate) {
		this.measrate = measrate;
	}

	public String getPkApartmeasdoc() {
		return pkApartmeasdoc;
	}

	public void setPkApartmeasdoc(String pkApartmeasdoc) {
		this.pkApartmeasdoc = pkApartmeasdoc;
	}

	public String getPkMaterial() {
		return pkMaterial;
	}

	public void setPkMaterial(String pkMaterial) {
		this.pkMaterial = pkMaterial;
	}

	public String getPkMaterialconvert() {
		return pkMaterialconvert;
	}

	public void setPkMaterialconvert(String pkMaterialconvert) {
		this.pkMaterialconvert = pkMaterialconvert;
	}

	public String getPkMeasdoc() {
		return pkMeasdoc;
	}

	public void setPkMeasdoc(String pkMeasdoc) {
		this.pkMeasdoc = pkMeasdoc;
	}

	public Long getShoworder() {
		return showorder;
	}

	public void setShoworder(Long showorder) {
		this.showorder = showorder;
	}

	public String getTs() {
		return ts;
	}

	public void setTs(String ts) {
		this.ts = ts;
	}

	@SuppressWarnings("unchecked")
	public void initByCode(BaseDAO dao, String pkMaterial) throws DAOException {
		String getSql = "select A.MEASRATE,A.PK_MEASDOC from BD_MATERIALCONVERT A where A.PK_MATERIAL = ?";
		SQLParameter parameter = new SQLParameter();
		parameter.clearParams();
		parameter.addParam(pkMaterial);
		this.pkMaterial = pkMaterial;
		ArrayList<Map<String,Object>> tempInfos = (ArrayList<Map<String, Object>>) dao.executeQuery(getSql, parameter , new MapListProcessor());
		if(!CollectionUtils.isEmpty(tempInfos)){
			Map<String,Object> infoMap = tempInfos.get(0);
			if(null != infoMap){
				this.pkMeasdoc = (String) infoMap.get("pk_measdoc");
				this.measrate = (String) infoMap.get("measrate");
			}
		}
		
	}

    
}
