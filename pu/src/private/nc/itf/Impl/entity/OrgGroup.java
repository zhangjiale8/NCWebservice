package nc.itf.Impl.entity;


import nc.bs.dao.BaseDAO;
import nc.bs.dao.DAOException;
import nc.jdbc.framework.SQLParameter;
import nc.jdbc.framework.processor.ColumnProcessor;

/**
 * 组织_集团
 * @author zhangjiale
 *
 */
public class OrgGroup{

    private String code;

    private String countryarea;

    private String countryzone;

    private String createdate;

    private String creationtime;

    private String creator;

    private Long dataoriginflag;

    private Long dr;

    private String ecotype;

    private Long enablestate;

    private String fax;

    private String groupno;

    private String headaddress;

    private String industry;

    private String initflag;

    private String innercode;

    private String introduction;

    private String memo;

    private String mnecode;

    private String modifiedtime;

    private String modifier;

    private String name;

    private String name2;

    private String name3;

    private String name4;

    private String name5;

    private String name6;

    private String ncindustry;

    private String pkAccperiodscheme;

    private String pkCurrtype;

    private String pkExratescheme;

    private String pkFathergroup;
    //主键
    private String pkGroup;

    private String service;

    private String shortname;

    private String shortname2;

    private String shortname3;

    private String shortname4;

    private String shortname5;

    private String shortname6;

    private String tel;

    private String ts;

    private String workcalendar;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCountryarea() {
		return countryarea;
	}

	public void setCountryarea(String countryarea) {
		this.countryarea = countryarea;
	}

	public String getCountryzone() {
		return countryzone;
	}

	public void setCountryzone(String countryzone) {
		this.countryzone = countryzone;
	}

	public String getCreatedate() {
		return createdate;
	}

	public void setCreatedate(String createdate) {
		this.createdate = createdate;
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

	public Long getDr() {
		return dr;
	}

	public void setDr(Long dr) {
		this.dr = dr;
	}

	public String getEcotype() {
		return ecotype;
	}

	public void setEcotype(String ecotype) {
		this.ecotype = ecotype;
	}

	public Long getEnablestate() {
		return enablestate;
	}

	public void setEnablestate(Long enablestate) {
		this.enablestate = enablestate;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getGroupno() {
		return groupno;
	}

	public void setGroupno(String groupno) {
		this.groupno = groupno;
	}

	public String getHeadaddress() {
		return headaddress;
	}

	public void setHeadaddress(String headaddress) {
		this.headaddress = headaddress;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public String getInitflag() {
		return initflag;
	}

	public void setInitflag(String initflag) {
		this.initflag = initflag;
	}

	public String getInnercode() {
		return innercode;
	}

	public void setInnercode(String innercode) {
		this.innercode = innercode;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getMnecode() {
		return mnecode;
	}

	public void setMnecode(String mnecode) {
		this.mnecode = mnecode;
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

	public String getNcindustry() {
		return ncindustry;
	}

	public void setNcindustry(String ncindustry) {
		this.ncindustry = ncindustry;
	}

	public String getPkAccperiodscheme() {
		return pkAccperiodscheme;
	}

	public void setPkAccperiodscheme(String pkAccperiodscheme) {
		this.pkAccperiodscheme = pkAccperiodscheme;
	}

	public String getPkCurrtype() {
		return pkCurrtype;
	}

	public void setPkCurrtype(String pkCurrtype) {
		this.pkCurrtype = pkCurrtype;
	}

	public String getPkExratescheme() {
		return pkExratescheme;
	}

	public void setPkExratescheme(String pkExratescheme) {
		this.pkExratescheme = pkExratescheme;
	}

	public String getPkFathergroup() {
		return pkFathergroup;
	}

	public void setPkFathergroup(String pkFathergroup) {
		this.pkFathergroup = pkFathergroup;
	}

	public String getPkGroup() {
		return pkGroup;
	}

	public void setPkGroup(String pkGroup) {
		this.pkGroup = pkGroup;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getShortname() {
		return shortname;
	}

	public void setShortname(String shortname) {
		this.shortname = shortname;
	}

	public String getShortname2() {
		return shortname2;
	}

	public void setShortname2(String shortname2) {
		this.shortname2 = shortname2;
	}

	public String getShortname3() {
		return shortname3;
	}

	public void setShortname3(String shortname3) {
		this.shortname3 = shortname3;
	}

	public String getShortname4() {
		return shortname4;
	}

	public void setShortname4(String shortname4) {
		this.shortname4 = shortname4;
	}

	public String getShortname5() {
		return shortname5;
	}

	public void setShortname5(String shortname5) {
		this.shortname5 = shortname5;
	}

	public String getShortname6() {
		return shortname6;
	}

	public void setShortname6(String shortname6) {
		this.shortname6 = shortname6;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getTs() {
		return ts;
	}

	public void setTs(String ts) {
		this.ts = ts;
	}

	public String getWorkcalendar() {
		return workcalendar;
	}

	public void setWorkcalendar(String workcalendar) {
		this.workcalendar = workcalendar;
	}

	public void initByCode(BaseDAO dao, String code) throws DAOException {
		String getSql = "select A.PK_GROUP from ORG_GROUP A where A.CODE =? and A.DR=0";
		SQLParameter parameter = new SQLParameter();
		parameter.addParam(code);
		this.code = code;
		this.dr = 0L;
		this.pkGroup = (String) dao.executeQuery(getSql, parameter , new ColumnProcessor());
	}


}
