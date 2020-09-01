package nc.itf.Impl.entity;

import nc.bs.dao.BaseDAO;
import nc.bs.dao.DAOException;
import nc.jdbc.framework.processor.ColumnProcessor;

/**
 * 国家地区
 * @author zhangjiale
 *
 */
public class BdCountryzone{

    private static final long serialVersionUID=1L;

    private String bbanrule;

    private String code;

    private String codeth;

    private String creationtime;

    private String creator;

    private Long dataoriginflag;

    private String description;

    private Long dr;

    private Long ibanlength;

    private String ibanrule;

    private String iseucountry;

    private String modifiedtime;

    private String modifier;

    private String name;

    private String name2;

    private String name3;

    private String name4;

    private String name5;

    private String name6;

    private String phonecode;
    //主键
    private String pkCountry;

    private String pkCurrtype;

    private String pkFormat;

    private String pkLang;

    private String pkOrg;

    private String pkTimezone;

    private String ts;

    private String wholename;

    private String wholename2;

    private String wholename3;

    private String wholename4;

    private String wholename5;

    private String wholename6;

    private String ename;

	public String getBbanrule() {
		return bbanrule;
	}

	public void setBbanrule(String bbanrule) {
		this.bbanrule = bbanrule;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCodeth() {
		return codeth;
	}

	public void setCodeth(String codeth) {
		this.codeth = codeth;
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

	public Long getDr() {
		return dr;
	}

	public void setDr(Long dr) {
		this.dr = dr;
	}

	public Long getIbanlength() {
		return ibanlength;
	}

	public void setIbanlength(Long ibanlength) {
		this.ibanlength = ibanlength;
	}

	public String getIbanrule() {
		return ibanrule;
	}

	public void setIbanrule(String ibanrule) {
		this.ibanrule = ibanrule;
	}

	public String getIseucountry() {
		return iseucountry;
	}

	public void setIseucountry(String iseucountry) {
		this.iseucountry = iseucountry;
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

	public String getPhonecode() {
		return phonecode;
	}

	public void setPhonecode(String phonecode) {
		this.phonecode = phonecode;
	}

	public String getPkCountry() {
		return pkCountry;
	}

	public void setPkCountry(String pkCountry) {
		this.pkCountry = pkCountry;
	}

	public String getPkCurrtype() {
		return pkCurrtype;
	}

	public void setPkCurrtype(String pkCurrtype) {
		this.pkCurrtype = pkCurrtype;
	}

	public String getPkFormat() {
		return pkFormat;
	}

	public void setPkFormat(String pkFormat) {
		this.pkFormat = pkFormat;
	}

	public String getPkLang() {
		return pkLang;
	}

	public void setPkLang(String pkLang) {
		this.pkLang = pkLang;
	}

	public String getPkOrg() {
		return pkOrg;
	}

	public void setPkOrg(String pkOrg) {
		this.pkOrg = pkOrg;
	}

	public String getPkTimezone() {
		return pkTimezone;
	}

	public void setPkTimezone(String pkTimezone) {
		this.pkTimezone = pkTimezone;
	}

	public String getTs() {
		return ts;
	}

	public void setTs(String ts) {
		this.ts = ts;
	}

	public String getWholename() {
		return wholename;
	}

	public void setWholename(String wholename) {
		this.wholename = wholename;
	}

	public String getWholename2() {
		return wholename2;
	}

	public void setWholename2(String wholename2) {
		this.wholename2 = wholename2;
	}

	public String getWholename3() {
		return wholename3;
	}

	public void setWholename3(String wholename3) {
		this.wholename3 = wholename3;
	}

	public String getWholename4() {
		return wholename4;
	}

	public void setWholename4(String wholename4) {
		this.wholename4 = wholename4;
	}

	public String getWholename5() {
		return wholename5;
	}

	public void setWholename5(String wholename5) {
		this.wholename5 = wholename5;
	}

	public String getWholename6() {
		return wholename6;
	}

	public void setWholename6(String wholename6) {
		this.wholename6 = wholename6;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void initDefalut(BaseDAO dao) throws DAOException {
		String getSql = "select PK_COUNTRY from BD_COUNTRYZONE A where  A.CODE ='CN' and A.DR = 0";
		this.code = "CN";
		this.dr = 0L;
		this.pkCountry = (String) dao.executeQuery(getSql,new ColumnProcessor());
		
	}
    
    
}
