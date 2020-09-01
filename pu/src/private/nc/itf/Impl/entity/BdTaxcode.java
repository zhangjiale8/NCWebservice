package nc.itf.Impl.entity;

import nc.bs.dao.BaseDAO;
import nc.bs.dao.DAOException;
import nc.jdbc.framework.SQLParameter;
import nc.jdbc.framework.processor.ColumnProcessor;

/**
 * Ë°ÂÊ
 * @author zhangjiale
 *
 */
public class BdTaxcode{

    private String code;

    private String creationtime;

    private String creator;

    private String cuscountry;

    private String custaxes;

    private Long dataoriginflag;

    private String description;

    private String description2;

    private String description3;

    private String description4;

    private String description5;

    private String description6;

    private Long dr;

    private Long enablestate;

    private Long iscusvat;

    private Long istriangletrade;

    private String mattaxes;

    private String modifiedtime;

    private String modifier;

    private String pkGroup;

    private String pkOrg;
    //Ö÷¼ü
    private String pkTaxcode;

    private Long pursaletype;

    private String reptaxcountry;

    private String supcountry;

    private String suptaxes;

    private String ts;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCreationtime() {
		return creationtime;
	}

	public void setCreationtime(String creationtime) {
		this.creationtime = creationtime;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getCuscountry() {
		return cuscountry;
	}

	public void setCuscountry(String cuscountry) {
		this.cuscountry = cuscountry;
	}

	public String getCustaxes() {
		return custaxes;
	}

	public void setCustaxes(String custaxes) {
		this.custaxes = custaxes;
	}

	public Long getDataoriginflag() {
		return dataoriginflag;
	}

	public void setDataoriginflag(Long dataoriginflag) {
		this.dataoriginflag = dataoriginflag;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription2() {
		return description2;
	}

	public void setDescription2(String description2) {
		this.description2 = description2;
	}

	public String getDescription3() {
		return description3;
	}

	public void setDescription3(String description3) {
		this.description3 = description3;
	}

	public String getDescription4() {
		return description4;
	}

	public void setDescription4(String description4) {
		this.description4 = description4;
	}

	public String getDescription5() {
		return description5;
	}

	public void setDescription5(String description5) {
		this.description5 = description5;
	}

	public String getDescription6() {
		return description6;
	}

	public void setDescription6(String description6) {
		this.description6 = description6;
	}

	public Long getDr() {
		return dr;
	}

	public void setDr(Long dr) {
		this.dr = dr;
	}

	public Long getEnablestate() {
		return enablestate;
	}

	public void setEnablestate(Long enablestate) {
		this.enablestate = enablestate;
	}

	public Long getIscusvat() {
		return iscusvat;
	}

	public void setIscusvat(Long iscusvat) {
		this.iscusvat = iscusvat;
	}

	public Long getIstriangletrade() {
		return istriangletrade;
	}

	public void setIstriangletrade(Long istriangletrade) {
		this.istriangletrade = istriangletrade;
	}

	public String getMattaxes() {
		return mattaxes;
	}

	public void setMattaxes(String mattaxes) {
		this.mattaxes = mattaxes;
	}

	public String getModifiedtime() {
		return modifiedtime;
	}

	public void setModifiedtime(String modifiedtime) {
		this.modifiedtime = modifiedtime;
	}

	public String getModifier() {
		return modifier;
	}

	public void setModifier(String modifier) {
		this.modifier = modifier;
	}

	public String getPkGroup() {
		return pkGroup;
	}

	public void setPkGroup(String pkGroup) {
		this.pkGroup = pkGroup;
	}

	public String getPkOrg() {
		return pkOrg;
	}

	public void setPkOrg(String pkOrg) {
		this.pkOrg = pkOrg;
	}

	public String getPkTaxcode() {
		return pkTaxcode;
	}

	public void setPkTaxcode(String pkTaxcode) {
		this.pkTaxcode = pkTaxcode;
	}

	public Long getPursaletype() {
		return pursaletype;
	}

	public void setPursaletype(Long pursaletype) {
		this.pursaletype = pursaletype;
	}

	public String getReptaxcountry() {
		return reptaxcountry;
	}

	public void setReptaxcountry(String reptaxcountry) {
		this.reptaxcountry = reptaxcountry;
	}

	public String getSupcountry() {
		return supcountry;
	}

	public void setSupcountry(String supcountry) {
		this.supcountry = supcountry;
	}

	public String getSuptaxes() {
		return suptaxes;
	}

	public void setSuptaxes(String suptaxes) {
		this.suptaxes = suptaxes;
	}

	public String getTs() {
		return ts;
	}

	public void setTs(String ts) {
		this.ts = ts;
	}

	public void initByCode(BaseDAO dao, String taxRateId) throws DAOException {
		String getSql = "select A.PK_TAXCODE from BD_TAXCODE A where A.CODE = ?";
		SQLParameter parameter = new SQLParameter();
		parameter.clearParams();
		parameter.addParam(taxRateId);
		this.code = taxRateId;
		this.pkTaxcode = (String) dao.executeQuery(getSql, parameter , new ColumnProcessor());
		
	}

    
}
