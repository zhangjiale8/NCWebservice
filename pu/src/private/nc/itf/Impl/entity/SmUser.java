package nc.itf.Impl.entity;

import nc.bs.dao.BaseDAO;
import nc.bs.dao.DAOException;
import nc.jdbc.framework.SQLParameter;
import nc.jdbc.framework.processor.ColumnProcessor;

public class SmUser {


    private String abledate;

    private Long baseDocType;

    private String contentlang;

    private String creationtime;

    private String creator;
    //Ö÷¼ü
    private String cuserid;

    private Long dataoriginflag;

    private String disabledate;

    private Long dr;

    private Long enablestate;

    private String format;

    private String identityverifycode;

    private String isca;

    private String islocked;

    private String modifiedtime;

    private String modifier;

    private String pkBaseDoc;

    private String pkCustomer;

    private String pkGroup;

    private String pkOrg;

    private String pkPsndoc;

    private String pkSupplier;

    private String pkUsergroupforcreate;

    private String pwdlevelcode;

    private String pwdparam;

    private String ts;
    //ÓÃ»§±àºÅ
    private String userCode;

    private String userCodeQ;

    private String userName;

    private String userName2;

    private String userName3;

    private String userName4;

    private String userName5;

    private String userName6;

    private String userNote;

    private String userPassword;

    private Long userType;

	public String getAbledate() {
		return abledate;
	}

	public void setAbledate(String abledate) {
		this.abledate = abledate;
	}

	public Long getBaseDocType() {
		return baseDocType;
	}

	public void setBaseDocType(Long baseDocType) {
		this.baseDocType = baseDocType;
	}

	public String getContentlang() {
		return contentlang;
	}

	public void setContentlang(String contentlang) {
		this.contentlang = contentlang;
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

	public String getCuserid() {
		return cuserid;
	}

	public void setCuserid(String cuserid) {
		this.cuserid = cuserid;
	}

	public Long getDataoriginflag() {
		return dataoriginflag;
	}

	public void setDataoriginflag(Long dataoriginflag) {
		this.dataoriginflag = dataoriginflag;
	}

	public String getDisabledate() {
		return disabledate;
	}

	public void setDisabledate(String disabledate) {
		this.disabledate = disabledate;
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

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public String getIdentityverifycode() {
		return identityverifycode;
	}

	public void setIdentityverifycode(String identityverifycode) {
		this.identityverifycode = identityverifycode;
	}

	public String getIsca() {
		return isca;
	}

	public void setIsca(String isca) {
		this.isca = isca;
	}

	public String getIslocked() {
		return islocked;
	}

	public void setIslocked(String islocked) {
		this.islocked = islocked;
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

	public String getPkBaseDoc() {
		return pkBaseDoc;
	}

	public void setPkBaseDoc(String pkBaseDoc) {
		this.pkBaseDoc = pkBaseDoc;
	}

	public String getPkCustomer() {
		return pkCustomer;
	}

	public void setPkCustomer(String pkCustomer) {
		this.pkCustomer = pkCustomer;
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

	public String getPkSupplier() {
		return pkSupplier;
	}

	public void setPkSupplier(String pkSupplier) {
		this.pkSupplier = pkSupplier;
	}

	public String getPkUsergroupforcreate() {
		return pkUsergroupforcreate;
	}

	public void setPkUsergroupforcreate(String pkUsergroupforcreate) {
		this.pkUsergroupforcreate = pkUsergroupforcreate;
	}

	public String getPwdlevelcode() {
		return pwdlevelcode;
	}

	public void setPwdlevelcode(String pwdlevelcode) {
		this.pwdlevelcode = pwdlevelcode;
	}

	public String getPwdparam() {
		return pwdparam;
	}

	public void setPwdparam(String pwdparam) {
		this.pwdparam = pwdparam;
	}

	public String getTs() {
		return ts;
	}

	public void setTs(String ts) {
		this.ts = ts;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getUserCodeQ() {
		return userCodeQ;
	}

	public void setUserCodeQ(String userCodeQ) {
		this.userCodeQ = userCodeQ;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserName2() {
		return userName2;
	}

	public void setUserName2(String userName2) {
		this.userName2 = userName2;
	}

	public String getUserName3() {
		return userName3;
	}

	public void setUserName3(String userName3) {
		this.userName3 = userName3;
	}

	public String getUserName4() {
		return userName4;
	}

	public void setUserName4(String userName4) {
		this.userName4 = userName4;
	}

	public String getUserName5() {
		return userName5;
	}

	public void setUserName5(String userName5) {
		this.userName5 = userName5;
	}

	public String getUserName6() {
		return userName6;
	}

	public void setUserName6(String userName6) {
		this.userName6 = userName6;
	}

	public String getUserNote() {
		return userNote;
	}

	public void setUserNote(String userNote) {
		this.userNote = userNote;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public Long getUserType() {
		return userType;
	}

	public void setUserType(Long userType) {
		this.userType = userType;
	}

	public void initByCode(BaseDAO dao, String saleUserId) throws DAOException {
		String getSql = "select A.CUSERID from SM_USER A where A.USER_CODE = ?";
		SQLParameter parameter = new SQLParameter();
		parameter.addParam(saleUserId);
		this.userCode = saleUserId;
		this.cuserid = (String) dao.executeQuery(getSql, parameter , new ColumnProcessor());
	}
        

}
