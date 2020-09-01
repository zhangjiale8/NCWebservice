package nc.itf.Impl.entity;

import nc.bs.dao.BaseDAO;
import nc.bs.dao.DAOException;
import nc.jdbc.framework.SQLParameter;
import nc.jdbc.framework.processor.ColumnProcessor;

import com.gbase.jdbc.Blob;

/**
 * 人员信息
 * @author zhangjiale
 *
 */
public class BdPsndoc{

    private String addr;

    private String birthdate;

    private String code;

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

    private Long dr;

    private String email;

    private Long enablestate;

    private String homephone;

    private String id;

    private String idtype;

    private String isshopassist;

    private String joinworkdate;

    private String mnecode;

    private String mobile;

    private String modifiedtime;

    private String modifier;

    private String name;

    private String name2;

    private String name3;

    private String name4;

    private String name5;

    private String name6;

    private String officephone;

    private String pkGroup;

    private String pkOrg;
    //主键
    private String pkPsndoc;

    private Long sex;

    private String ts;

    private String usedname;

    private String bloodtype;

    private String censusaddr;

    private String characterrpr;

    private String country;

    private String dieDate;

    private String dieRemark;

    private String edu;

    private String fax;

    private String fileaddress;

    private String health;

    private String ishiskeypsn;

    private String joinpolitydate;

    private String marital;

    private String marriagedate;

    private String nationality;

    private String nativeplace;

    private String penelauth;

    private String permanreside;

    private Blob photo;

    private String pkDegree;

    private String pkHrorg;

    private String polity;

    private String postalcode;

    private Blob previewphoto;

    private String prof;

    private String retiredate;

    private String secretEmail;

    private String shortname;

    private String titletechpost;

    private String firstname;

    private String lastname;

    private String iscadre;

    private String ishisleader;

    private String age;

    private String workage;

    private String glbdef1;

    private String glbdef2;

    private String glbdef3;

    private String glbdef4;

    private String glbdef5;

    private String glbdef6;

    private String glbdef7;

    private String glbdef8;

    private String glbdef9;

    private String glbdef10;

    private String glbdef11;

    private String glbdef12;

    private String glbdef13;

    private String glbdef14;

    private String glbdef15;

    private String glbdef16;

    private String glbdef17;

    private String glbdef18;

    private String glbdef19;

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

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

	public Long getDr() {
		return dr;
	}

	public void setDr(Long dr) {
		this.dr = dr;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getEnablestate() {
		return enablestate;
	}

	public void setEnablestate(Long enablestate) {
		this.enablestate = enablestate;
	}

	public String getHomephone() {
		return homephone;
	}

	public void setHomephone(String homephone) {
		this.homephone = homephone;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIdtype() {
		return idtype;
	}

	public void setIdtype(String idtype) {
		this.idtype = idtype;
	}

	public String getIsshopassist() {
		return isshopassist;
	}

	public void setIsshopassist(String isshopassist) {
		this.isshopassist = isshopassist;
	}

	public String getJoinworkdate() {
		return joinworkdate;
	}

	public void setJoinworkdate(String joinworkdate) {
		this.joinworkdate = joinworkdate;
	}

	public String getMnecode() {
		return mnecode;
	}

	public void setMnecode(String mnecode) {
		this.mnecode = mnecode;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
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

	public String getOfficephone() {
		return officephone;
	}

	public void setOfficephone(String officephone) {
		this.officephone = officephone;
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

	public String getPkPsndoc() {
		return pkPsndoc;
	}

	public void setPkPsndoc(String pkPsndoc) {
		this.pkPsndoc = pkPsndoc;
	}

	public Long getSex() {
		return sex;
	}

	public void setSex(Long sex) {
		this.sex = sex;
	}

	public String getTs() {
		return ts;
	}

	public void setTs(String ts) {
		this.ts = ts;
	}

	public String getUsedname() {
		return usedname;
	}

	public void setUsedname(String usedname) {
		this.usedname = usedname;
	}

	public String getBloodtype() {
		return bloodtype;
	}

	public void setBloodtype(String bloodtype) {
		this.bloodtype = bloodtype;
	}

	public String getCensusaddr() {
		return censusaddr;
	}

	public void setCensusaddr(String censusaddr) {
		this.censusaddr = censusaddr;
	}

	public String getCharacterrpr() {
		return characterrpr;
	}

	public void setCharacterrpr(String characterrpr) {
		this.characterrpr = characterrpr;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getDieDate() {
		return dieDate;
	}

	public void setDieDate(String dieDate) {
		this.dieDate = dieDate;
	}

	public String getDieRemark() {
		return dieRemark;
	}

	public void setDieRemark(String dieRemark) {
		this.dieRemark = dieRemark;
	}

	public String getEdu() {
		return edu;
	}

	public void setEdu(String edu) {
		this.edu = edu;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getFileaddress() {
		return fileaddress;
	}

	public void setFileaddress(String fileaddress) {
		this.fileaddress = fileaddress;
	}

	public String getHealth() {
		return health;
	}

	public void setHealth(String health) {
		this.health = health;
	}

	public String getIshiskeypsn() {
		return ishiskeypsn;
	}

	public void setIshiskeypsn(String ishiskeypsn) {
		this.ishiskeypsn = ishiskeypsn;
	}

	public String getJoinpolitydate() {
		return joinpolitydate;
	}

	public void setJoinpolitydate(String joinpolitydate) {
		this.joinpolitydate = joinpolitydate;
	}

	public String getMarital() {
		return marital;
	}

	public void setMarital(String marital) {
		this.marital = marital;
	}

	public String getMarriagedate() {
		return marriagedate;
	}

	public void setMarriagedate(String marriagedate) {
		this.marriagedate = marriagedate;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getNativeplace() {
		return nativeplace;
	}

	public void setNativeplace(String nativeplace) {
		this.nativeplace = nativeplace;
	}

	public String getPenelauth() {
		return penelauth;
	}

	public void setPenelauth(String penelauth) {
		this.penelauth = penelauth;
	}

	public String getPermanreside() {
		return permanreside;
	}

	public void setPermanreside(String permanreside) {
		this.permanreside = permanreside;
	}

	public Blob getPhoto() {
		return photo;
	}

	public void setPhoto(Blob photo) {
		this.photo = photo;
	}

	public String getPkDegree() {
		return pkDegree;
	}

	public void setPkDegree(String pkDegree) {
		this.pkDegree = pkDegree;
	}

	public String getPkHrorg() {
		return pkHrorg;
	}

	public void setPkHrorg(String pkHrorg) {
		this.pkHrorg = pkHrorg;
	}

	public String getPolity() {
		return polity;
	}

	public void setPolity(String polity) {
		this.polity = polity;
	}

	public String getPostalcode() {
		return postalcode;
	}

	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}

	public Blob getPreviewphoto() {
		return previewphoto;
	}

	public void setPreviewphoto(Blob previewphoto) {
		this.previewphoto = previewphoto;
	}

	public String getProf() {
		return prof;
	}

	public void setProf(String prof) {
		this.prof = prof;
	}

	public String getRetiredate() {
		return retiredate;
	}

	public void setRetiredate(String retiredate) {
		this.retiredate = retiredate;
	}

	public String getSecretEmail() {
		return secretEmail;
	}

	public void setSecretEmail(String secretEmail) {
		this.secretEmail = secretEmail;
	}

	public String getShortname() {
		return shortname;
	}

	public void setShortname(String shortname) {
		this.shortname = shortname;
	}

	public String getTitletechpost() {
		return titletechpost;
	}

	public void setTitletechpost(String titletechpost) {
		this.titletechpost = titletechpost;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getIscadre() {
		return iscadre;
	}

	public void setIscadre(String iscadre) {
		this.iscadre = iscadre;
	}

	public String getIshisleader() {
		return ishisleader;
	}

	public void setIshisleader(String ishisleader) {
		this.ishisleader = ishisleader;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getWorkage() {
		return workage;
	}

	public void setWorkage(String workage) {
		this.workage = workage;
	}

	public String getGlbdef1() {
		return glbdef1;
	}

	public void setGlbdef1(String glbdef1) {
		this.glbdef1 = glbdef1;
	}

	public String getGlbdef2() {
		return glbdef2;
	}

	public void setGlbdef2(String glbdef2) {
		this.glbdef2 = glbdef2;
	}

	public String getGlbdef3() {
		return glbdef3;
	}

	public void setGlbdef3(String glbdef3) {
		this.glbdef3 = glbdef3;
	}

	public String getGlbdef4() {
		return glbdef4;
	}

	public void setGlbdef4(String glbdef4) {
		this.glbdef4 = glbdef4;
	}

	public String getGlbdef5() {
		return glbdef5;
	}

	public void setGlbdef5(String glbdef5) {
		this.glbdef5 = glbdef5;
	}

	public String getGlbdef6() {
		return glbdef6;
	}

	public void setGlbdef6(String glbdef6) {
		this.glbdef6 = glbdef6;
	}

	public String getGlbdef7() {
		return glbdef7;
	}

	public void setGlbdef7(String glbdef7) {
		this.glbdef7 = glbdef7;
	}

	public String getGlbdef8() {
		return glbdef8;
	}

	public void setGlbdef8(String glbdef8) {
		this.glbdef8 = glbdef8;
	}

	public String getGlbdef9() {
		return glbdef9;
	}

	public void setGlbdef9(String glbdef9) {
		this.glbdef9 = glbdef9;
	}

	public String getGlbdef10() {
		return glbdef10;
	}

	public void setGlbdef10(String glbdef10) {
		this.glbdef10 = glbdef10;
	}

	public String getGlbdef11() {
		return glbdef11;
	}

	public void setGlbdef11(String glbdef11) {
		this.glbdef11 = glbdef11;
	}

	public String getGlbdef12() {
		return glbdef12;
	}

	public void setGlbdef12(String glbdef12) {
		this.glbdef12 = glbdef12;
	}

	public String getGlbdef13() {
		return glbdef13;
	}

	public void setGlbdef13(String glbdef13) {
		this.glbdef13 = glbdef13;
	}

	public String getGlbdef14() {
		return glbdef14;
	}

	public void setGlbdef14(String glbdef14) {
		this.glbdef14 = glbdef14;
	}

	public String getGlbdef15() {
		return glbdef15;
	}

	public void setGlbdef15(String glbdef15) {
		this.glbdef15 = glbdef15;
	}

	public String getGlbdef16() {
		return glbdef16;
	}

	public void setGlbdef16(String glbdef16) {
		this.glbdef16 = glbdef16;
	}

	public String getGlbdef17() {
		return glbdef17;
	}

	public void setGlbdef17(String glbdef17) {
		this.glbdef17 = glbdef17;
	}

	public String getGlbdef18() {
		return glbdef18;
	}

	public void setGlbdef18(String glbdef18) {
		this.glbdef18 = glbdef18;
	}

	public String getGlbdef19() {
		return glbdef19;
	}

	public void setGlbdef19(String glbdef19) {
		this.glbdef19 = glbdef19;
	}

	public void initByCode(BaseDAO dao, String code) throws DAOException {
		String getSql = "select A.PK_PSNDOC from BD_PSNDOC A where A.DR = 0 and A.CODE = ?";
		SQLParameter parameter = new SQLParameter();
		parameter.addParam(code);
		this.code = code;
		this.pkPsndoc = (String) dao.executeQuery(getSql, parameter , new ColumnProcessor());
		
	}

    
}
