package nc.itf.Impl.entity;

import nc.bs.dao.BaseDAO;
import nc.bs.dao.DAOException;
import nc.jdbc.framework.SQLParameter;
import nc.jdbc.framework.processor.ColumnProcessor;

/**
 * ±ÒÖÖ
 * @author zhangjiale
 *
 */
public class BdCurrtype{

    private String code;

    private String creationtime;

    private String creator;

    private Long currdigit;

    private String currtypesign;

    private Long dataoriginflag;

    private Long dr;

    private String isdefault;

    private String modifiedtime;

    private String modifier;

    private String name;

    private String name2;

    private String name3;

    private String name4;

    private String name5;

    private String name6;
    //Ö÷¼ü
    private String pkCurrtype;

    private String pkGroup;

    private String pkOrg;

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

	public Long getCurrdigit() {
		return currdigit;
	}

	public void setCurrdigit(Long currdigit) {
		this.currdigit = currdigit;
	}

	public String getCurrtypesign() {
		return currtypesign;
	}

	public void setCurrtypesign(String currtypesign) {
		this.currtypesign = currtypesign;
	}

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

	public String getIsdefault() {
		return isdefault;
	}

	public void setIsdefault(String isdefault) {
		this.isdefault = isdefault;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName2() {
		return name2;
	}

	public void setName2(String name2) {
		this.name2 = name2;
	}

	public String getName3() {
		return name3;
	}

	public void setName3(String name3) {
		this.name3 = name3;
	}

	public String getName4() {
		return name4;
	}

	public void setName4(String name4) {
		this.name4 = name4;
	}

	public String getName5() {
		return name5;
	}

	public void setName5(String name5) {
		this.name5 = name5;
	}

	public String getName6() {
		return name6;
	}

	public void setName6(String name6) {
		this.name6 = name6;
	}

	public String getPkCurrtype() {
		return pkCurrtype;
	}

	public void setPkCurrtype(String pkCurrtype) {
		this.pkCurrtype = pkCurrtype;
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

	public String getTs() {
		return ts;
	}

	public void setTs(String ts) {
		this.ts = ts;
	}

	public void initByCode(BaseDAO dao, String currencyTypId) throws DAOException {
		String getSql = "select A.PK_CURRTYPE from BD_CURRTYPE A where A.CODE = ?";
		SQLParameter parameter = new SQLParameter();
		parameter.clearParams();
		parameter.addParam(currencyTypId);
		this.code = currencyTypId;
		this.pkCurrtype = (String) dao.executeQuery(getSql, parameter , new ColumnProcessor());
		
	}

    
}
