package nc.itf.Impl.entity;

import java.math.BigDecimal;

import nc.bs.dao.BaseDAO;
import nc.bs.dao.DAOException;
import nc.jdbc.framework.SQLParameter;
import nc.jdbc.framework.processor.ColumnProcessor;

/**
 * 组织_业务单元_公司
 * @author zhangjiale
 *
 */
public class OrgCorp{

    private String begindate;

    private String briefintro;

    private String chargedeptcode;

    private String chargedeptname;

    private String code;

    private String corptype;

    private String createdate;

    private String creationtime;

    private String creator;

    private Long dataoriginflag;

    private String def1;

    private String def10;

    private String def11;

    private String def12;

    private String def13;

    private String def14;

    private String def15;

    private String def16;

    private String def17;

    private String def18;

    private String def19;

    private String def2;

    private String def20;

    private String def3;

    private String def4;

    private String def5;

    private String def6;

    private String def7;

    private String def8;

    private String def9;

    private Long disorder;

    private Long dr;

    private String ecotype;

    private String email1;

    private String email2;

    private String email3;

    private Long enablestate;

    private String enddate;

    private String fax1;

    private String fax2;

    private String idnumber;

    private String industry;

    private String innercode;

    private String isgroupcorp;

    private String islastversion;

    private String legalbodycode;

    private String linkman1;

    private String linkman2;

    private String linkman3;

    private String maxinnercode;

    private String mnecode;

    private String modifiedtime;

    private String modifier;

    private String name;

    private String name2;

    private String name3;

    private String name4;

    private String name5;

    private String name6;

    private BigDecimal ownersharerate;

    private String phone1;

    private String phone2;

    private String phone3;
    //主键
    private String pkCorp;

    private String pkCorpkind;

    private String pkFatherorg;

    private String pkGroup;

    private String pkOrg;

    private String pkVid;

    private String postaddr;

    private BigDecimal regcapital;

    private String region;

    private String shortname;

    private String shortname2;

    private String shortname3;

    private String shortname4;

    private String shortname5;

    private String shortname6;

    private Long taxpayertype;

    private String ts;

    private String unitdistinction;

    private String url;

    private String venddate;

    private String vname;

    private String vno;

    private String vstartdate;

    private String zipcode;

	public String getBegindate() {
		return begindate;
	}

	public void setBegindate(String begindate) {
		this.begindate = begindate;
	}

	public String getBriefintro() {
		return briefintro;
	}

	public void setBriefintro(String briefintro) {
		this.briefintro = briefintro;
	}

	public String getChargedeptcode() {
		return chargedeptcode;
	}

	public void setChargedeptcode(String chargedeptcode) {
		this.chargedeptcode = chargedeptcode;
	}

	public String getChargedeptname() {
		return chargedeptname;
	}

	public void setChargedeptname(String chargedeptname) {
		this.chargedeptname = chargedeptname;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCorptype() {
		return corptype;
	}

	public void setCorptype(String corptype) {
		this.corptype = corptype;
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

	public String getDef1() {
		return def1;
	}

	public void setDef1(String def1) {
		this.def1 = def1;
	}

	public String getDef10() {
		return def10;
	}

	public void setDef10(String def10) {
		this.def10 = def10;
	}

	public String getDef11() {
		return def11;
	}

	public void setDef11(String def11) {
		this.def11 = def11;
	}

	public String getDef12() {
		return def12;
	}

	public void setDef12(String def12) {
		this.def12 = def12;
	}

	public String getDef13() {
		return def13;
	}

	public void setDef13(String def13) {
		this.def13 = def13;
	}

	public String getDef14() {
		return def14;
	}

	public void setDef14(String def14) {
		this.def14 = def14;
	}

	public String getDef15() {
		return def15;
	}

	public void setDef15(String def15) {
		this.def15 = def15;
	}

	public String getDef16() {
		return def16;
	}

	public void setDef16(String def16) {
		this.def16 = def16;
	}

	public String getDef17() {
		return def17;
	}

	public void setDef17(String def17) {
		this.def17 = def17;
	}

	public String getDef18() {
		return def18;
	}

	public void setDef18(String def18) {
		this.def18 = def18;
	}

	public String getDef19() {
		return def19;
	}

	public void setDef19(String def19) {
		this.def19 = def19;
	}

	public String getDef2() {
		return def2;
	}

	public void setDef2(String def2) {
		this.def2 = def2;
	}

	public String getDef20() {
		return def20;
	}

	public void setDef20(String def20) {
		this.def20 = def20;
	}

	public String getDef3() {
		return def3;
	}

	public void setDef3(String def3) {
		this.def3 = def3;
	}

	public String getDef4() {
		return def4;
	}

	public void setDef4(String def4) {
		this.def4 = def4;
	}

	public String getDef5() {
		return def5;
	}

	public void setDef5(String def5) {
		this.def5 = def5;
	}

	public String getDef6() {
		return def6;
	}

	public void setDef6(String def6) {
		this.def6 = def6;
	}

	public String getDef7() {
		return def7;
	}

	public void setDef7(String def7) {
		this.def7 = def7;
	}

	public String getDef8() {
		return def8;
	}

	public void setDef8(String def8) {
		this.def8 = def8;
	}

	public String getDef9() {
		return def9;
	}

	public void setDef9(String def9) {
		this.def9 = def9;
	}

	public Long getDisorder() {
		return disorder;
	}

	public void setDisorder(Long disorder) {
		this.disorder = disorder;
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

	public String getEmail1() {
		return email1;
	}

	public void setEmail1(String email1) {
		this.email1 = email1;
	}

	public String getEmail2() {
		return email2;
	}

	public void setEmail2(String email2) {
		this.email2 = email2;
	}

	public String getEmail3() {
		return email3;
	}

	public void setEmail3(String email3) {
		this.email3 = email3;
	}

	public Long getEnablestate() {
		return enablestate;
	}

	public void setEnablestate(Long enablestate) {
		this.enablestate = enablestate;
	}

	public String getEnddate() {
		return enddate;
	}

	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}

	public String getFax1() {
		return fax1;
	}

	public void setFax1(String fax1) {
		this.fax1 = fax1;
	}

	public String getFax2() {
		return fax2;
	}

	public void setFax2(String fax2) {
		this.fax2 = fax2;
	}

	public String getIdnumber() {
		return idnumber;
	}

	public void setIdnumber(String idnumber) {
		this.idnumber = idnumber;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public String getInnercode() {
		return innercode;
	}

	public void setInnercode(String innercode) {
		this.innercode = innercode;
	}

	public String getIsgroupcorp() {
		return isgroupcorp;
	}

	public void setIsgroupcorp(String isgroupcorp) {
		this.isgroupcorp = isgroupcorp;
	}

	public String getIslastversion() {
		return islastversion;
	}

	public void setIslastversion(String islastversion) {
		this.islastversion = islastversion;
	}

	public String getLegalbodycode() {
		return legalbodycode;
	}

	public void setLegalbodycode(String legalbodycode) {
		this.legalbodycode = legalbodycode;
	}

	public String getLinkman1() {
		return linkman1;
	}

	public void setLinkman1(String linkman1) {
		this.linkman1 = linkman1;
	}

	public String getLinkman2() {
		return linkman2;
	}

	public void setLinkman2(String linkman2) {
		this.linkman2 = linkman2;
	}

	public String getLinkman3() {
		return linkman3;
	}

	public void setLinkman3(String linkman3) {
		this.linkman3 = linkman3;
	}

	public String getMaxinnercode() {
		return maxinnercode;
	}

	public void setMaxinnercode(String maxinnercode) {
		this.maxinnercode = maxinnercode;
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

	public BigDecimal getOwnersharerate() {
		return ownersharerate;
	}

	public void setOwnersharerate(BigDecimal ownersharerate) {
		this.ownersharerate = ownersharerate;
	}

	public String getPhone1() {
		return phone1;
	}

	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	public String getPhone2() {
		return phone2;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	public String getPhone3() {
		return phone3;
	}

	public void setPhone3(String phone3) {
		this.phone3 = phone3;
	}

	public String getPkCorp() {
		return pkCorp;
	}

	public void setPkCorp(String pkCorp) {
		this.pkCorp = pkCorp;
	}

	public String getPkCorpkind() {
		return pkCorpkind;
	}

	public void setPkCorpkind(String pkCorpkind) {
		this.pkCorpkind = pkCorpkind;
	}

	public String getPkFatherorg() {
		return pkFatherorg;
	}

	public void setPkFatherorg(String pkFatherorg) {
		this.pkFatherorg = pkFatherorg;
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

	public String getPkVid() {
		return pkVid;
	}

	public void setPkVid(String pkVid) {
		this.pkVid = pkVid;
	}

	public String getPostaddr() {
		return postaddr;
	}

	public void setPostaddr(String postaddr) {
		this.postaddr = postaddr;
	}

	public BigDecimal getRegcapital() {
		return regcapital;
	}

	public void setRegcapital(BigDecimal regcapital) {
		this.regcapital = regcapital;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
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

	public Long getTaxpayertype() {
		return taxpayertype;
	}

	public void setTaxpayertype(Long taxpayertype) {
		this.taxpayertype = taxpayertype;
	}

	public String getTs() {
		return ts;
	}

	public void setTs(String ts) {
		this.ts = ts;
	}

	public String getUnitdistinction() {
		return unitdistinction;
	}

	public void setUnitdistinction(String unitdistinction) {
		this.unitdistinction = unitdistinction;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getVenddate() {
		return venddate;
	}

	public void setVenddate(String venddate) {
		this.venddate = venddate;
	}

	public String getVname() {
		return vname;
	}

	public void setVname(String vname) {
		this.vname = vname;
	}

	public String getVno() {
		return vno;
	}

	public void setVno(String vno) {
		this.vno = vno;
	}

	public String getVstartdate() {
		return vstartdate;
	}

	public void setVstartdate(String vstartdate) {
		this.vstartdate = vstartdate;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public void initByNo(BaseDAO dao, String pkCorp) throws DAOException {
		String getSql = "select PK_VID from ORG_CORP A where A.DR = 0 and A.PK_CORP = ?";
		SQLParameter parameter = new SQLParameter();
		parameter.clearParams();
		parameter.addParam(pkCorp);
		this.pkCorp = pkCorp;
		this.pkVid = (String) dao.executeQuery(getSql, parameter , new ColumnProcessor());
		
	}


}
