package nc.itf.Impl.entity;


import nc.bs.dao.BaseDAO;
import nc.bs.dao.DAOException;
import nc.jdbc.framework.SQLParameter;
import nc.jdbc.framework.processor.ColumnProcessor;

/**
 * 业务流程
 * @author zhangjiale
 *
 */
public class BdBusitype {


    private String busicode;

    private String businame;

    private String businame2;

    private String businame3;

    private String businame4;

    private String businame5;

    private String businame6;

    private Long busiprop;

    private Long defaultgather;

    private String defstr2;

    private String defstr3;

    private String defstr4;

    private String defstr5;

    private Long dr;

    private String fktype;

    private String isdapclassified;

    private String jumpflag;

    private String mnecode;

    private Long orgcount;

    private String owetype;
    //主键
    private String pkBusitype;

    private String pkCorp;

    private String pkGroup;

    private String pkOrg;

    private String primarybilltype;

    private Long priority;

    private String receipttype;

    private String sktype;

    private String ts;

    private Long validity;

    private String version;

    private String ystype;

	public String getBusicode() {
		return busicode;
	}

	public void setBusicode(String busicode) {
		this.busicode = busicode;
	}

	public String getBusiname() {
		return businame;
	}

	public void setBusiname(String businame) {
		this.businame = businame;
	}

	public String getBusiname2() {
		return businame2;
	}

	public void setBusiname2(String businame2) {
		this.businame2 = businame2;
	}

	public String getBusiname3() {
		return businame3;
	}

	public void setBusiname3(String businame3) {
		this.businame3 = businame3;
	}

	public String getBusiname4() {
		return businame4;
	}

	public void setBusiname4(String businame4) {
		this.businame4 = businame4;
	}

	public String getBusiname5() {
		return businame5;
	}

	public void setBusiname5(String businame5) {
		this.businame5 = businame5;
	}

	public String getBusiname6() {
		return businame6;
	}

	public void setBusiname6(String businame6) {
		this.businame6 = businame6;
	}

	public Long getBusiprop() {
		return busiprop;
	}

	public void setBusiprop(Long busiprop) {
		this.busiprop = busiprop;
	}

	public Long getDefaultgather() {
		return defaultgather;
	}

	public void setDefaultgather(Long defaultgather) {
		this.defaultgather = defaultgather;
	}

	public String getDefstr2() {
		return defstr2;
	}

	public void setDefstr2(String defstr2) {
		this.defstr2 = defstr2;
	}

	public String getDefstr3() {
		return defstr3;
	}

	public void setDefstr3(String defstr3) {
		this.defstr3 = defstr3;
	}

	public String getDefstr4() {
		return defstr4;
	}

	public void setDefstr4(String defstr4) {
		this.defstr4 = defstr4;
	}

	public String getDefstr5() {
		return defstr5;
	}

	public void setDefstr5(String defstr5) {
		this.defstr5 = defstr5;
	}

	public Long getDr() {
		return dr;
	}

	public void setDr(Long dr) {
		this.dr = dr;
	}

	public String getFktype() {
		return fktype;
	}

	public void setFktype(String fktype) {
		this.fktype = fktype;
	}

	public String getIsdapclassified() {
		return isdapclassified;
	}

	public void setIsdapclassified(String isdapclassified) {
		this.isdapclassified = isdapclassified;
	}

	public String getJumpflag() {
		return jumpflag;
	}

	public void setJumpflag(String jumpflag) {
		this.jumpflag = jumpflag;
	}

	public String getMnecode() {
		return mnecode;
	}

	public void setMnecode(String mnecode) {
		this.mnecode = mnecode;
	}

	public Long getOrgcount() {
		return orgcount;
	}

	public void setOrgcount(Long orgcount) {
		this.orgcount = orgcount;
	}

	public String getOwetype() {
		return owetype;
	}

	public void setOwetype(String owetype) {
		this.owetype = owetype;
	}

	public String getPkBusitype() {
		return pkBusitype;
	}

	public void setPkBusitype(String pkBusitype) {
		this.pkBusitype = pkBusitype;
	}

	public String getPkCorp() {
		return pkCorp;
	}

	public void setPkCorp(String pkCorp) {
		this.pkCorp = pkCorp;
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

	public String getPrimarybilltype() {
		return primarybilltype;
	}

	public void setPrimarybilltype(String primarybilltype) {
		this.primarybilltype = primarybilltype;
	}

	public Long getPriority() {
		return priority;
	}

	public void setPriority(Long priority) {
		this.priority = priority;
	}

	public String getReceipttype() {
		return receipttype;
	}

	public void setReceipttype(String receipttype) {
		this.receipttype = receipttype;
	}

	public String getSktype() {
		return sktype;
	}

	public void setSktype(String sktype) {
		this.sktype = sktype;
	}

	public String getTs() {
		return ts;
	}

	public void setTs(String ts) {
		this.ts = ts;
	}

	public Long getValidity() {
		return validity;
	}

	public void setValidity(Long validity) {
		this.validity = validity;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getYstype() {
		return ystype;
	}

	public void setYstype(String ystype) {
		this.ystype = ystype;
	}

	public void initInfo(BaseDAO dao, String pkGroup, String saleOrderTypId) throws DAOException {
		String 	getSql = "select PK_BUSITYPE from BD_BUSITYPE where PRIMARYBILLTYPE =? and PK_GROUP = ? and VALIDITY = 1 and DR = 0";
		SQLParameter parameter = new SQLParameter();
		parameter.addParam(saleOrderTypId);
		parameter.addParam(pkGroup);
		this.pkGroup = pkGroup;
		this.primarybilltype = saleOrderTypId;
		this.validity = 1L;
		this.dr = 0L;
		this.pkBusitype = (String) dao.executeQuery(getSql, parameter , new ColumnProcessor());
	}

    
}
