package nc.itf.Impl.entity;


import nc.bs.dao.BaseDAO;
import nc.bs.dao.DAOException;
import nc.jdbc.framework.SQLParameter;
import nc.jdbc.framework.processor.ColumnProcessor;

/**
 * 单据类型
 * @author zhangjiale
 *
 */
public class BdBilltype{


    private String accountclass;

    private String billcoderule;

    private Long billstyle;

    private String billtypename;

    private String billtypename2;

    private String billtypename3;

    private String billtypename4;

    private String billtypename5;

    private String billtypename6;

    private String canextendtransaction;

    private String checkclassname;

    private String classname;

    private String component;

    private String datafinderclz;

    private String def1;

    private String def2;

    private String def3;

    private Long dr;

    private String emendenumclass;

    private String forwardbilltype;

    private String isaccount;

    private String isapprovebill;

    private String isbizflowbill;

    private String iseditableproperty;

    private String isenablebutton;

    private String islock;

    private String isroot;

    private String istransaction;

    private String ncbrcode;

    private String nodecode;

    private String parentbilltype;

    private String pkBilltypecode;
    //主键
    private String pkBilltypeid;

    private String pkGroup;

    private String pkOrg;

    private String referclassname;

    private String systemcode;

    private String transtypeClass;

    private String ts;

    private String webnodecode;

    private String wherestring;

	public String getAccountclass() {
		return accountclass;
	}

	public void setAccountclass(String accountclass) {
		this.accountclass = accountclass;
	}

	public String getBillcoderule() {
		return billcoderule;
	}

	public void setBillcoderule(String billcoderule) {
		this.billcoderule = billcoderule;
	}

	public Long getBillstyle() {
		return billstyle;
	}

	public void setBillstyle(Long billstyle) {
		this.billstyle = billstyle;
	}

	public String getBilltypename() {
		return billtypename;
	}

	public void setBilltypename(String billtypename) {
		this.billtypename = billtypename;
	}

	public String getBilltypename2() {
		return billtypename2;
	}

	public void setBilltypename2(String billtypename2) {
		this.billtypename2 = billtypename2;
	}

	public String getBilltypename3() {
		return billtypename3;
	}

	public void setBilltypename3(String billtypename3) {
		this.billtypename3 = billtypename3;
	}

	public String getBilltypename4() {
		return billtypename4;
	}

	public void setBilltypename4(String billtypename4) {
		this.billtypename4 = billtypename4;
	}

	public String getBilltypename5() {
		return billtypename5;
	}

	public void setBilltypename5(String billtypename5) {
		this.billtypename5 = billtypename5;
	}

	public String getBilltypename6() {
		return billtypename6;
	}

	public void setBilltypename6(String billtypename6) {
		this.billtypename6 = billtypename6;
	}

	public String getCanextendtransaction() {
		return canextendtransaction;
	}

	public void setCanextendtransaction(String canextendtransaction) {
		this.canextendtransaction = canextendtransaction;
	}

	public String getCheckclassname() {
		return checkclassname;
	}

	public void setCheckclassname(String checkclassname) {
		this.checkclassname = checkclassname;
	}

	public String getClassname() {
		return classname;
	}

	public void setClassname(String classname) {
		this.classname = classname;
	}

	public String getComponent() {
		return component;
	}

	public void setComponent(String component) {
		this.component = component;
	}

	public String getDatafinderclz() {
		return datafinderclz;
	}

	public void setDatafinderclz(String datafinderclz) {
		this.datafinderclz = datafinderclz;
	}

	public String getDef1() {
		return def1;
	}

	public void setDef1(String def1) {
		this.def1 = def1;
	}

	public String getDef2() {
		return def2;
	}

	public void setDef2(String def2) {
		this.def2 = def2;
	}

	public String getDef3() {
		return def3;
	}

	public void setDef3(String def3) {
		this.def3 = def3;
	}

	public Long getDr() {
		return dr;
	}

	public void setDr(Long dr) {
		this.dr = dr;
	}

	public String getEmendenumclass() {
		return emendenumclass;
	}

	public void setEmendenumclass(String emendenumclass) {
		this.emendenumclass = emendenumclass;
	}

	public String getForwardbilltype() {
		return forwardbilltype;
	}

	public void setForwardbilltype(String forwardbilltype) {
		this.forwardbilltype = forwardbilltype;
	}

	public String getIsaccount() {
		return isaccount;
	}

	public void setIsaccount(String isaccount) {
		this.isaccount = isaccount;
	}

	public String getIsapprovebill() {
		return isapprovebill;
	}

	public void setIsapprovebill(String isapprovebill) {
		this.isapprovebill = isapprovebill;
	}

	public String getIsbizflowbill() {
		return isbizflowbill;
	}

	public void setIsbizflowbill(String isbizflowbill) {
		this.isbizflowbill = isbizflowbill;
	}

	public String getIseditableproperty() {
		return iseditableproperty;
	}

	public void setIseditableproperty(String iseditableproperty) {
		this.iseditableproperty = iseditableproperty;
	}

	public String getIsenablebutton() {
		return isenablebutton;
	}

	public void setIsenablebutton(String isenablebutton) {
		this.isenablebutton = isenablebutton;
	}

	public String getIslock() {
		return islock;
	}

	public void setIslock(String islock) {
		this.islock = islock;
	}

	public String getIsroot() {
		return isroot;
	}

	public void setIsroot(String isroot) {
		this.isroot = isroot;
	}

	public String getIstransaction() {
		return istransaction;
	}

	public void setIstransaction(String istransaction) {
		this.istransaction = istransaction;
	}

	public String getNcbrcode() {
		return ncbrcode;
	}

	public void setNcbrcode(String ncbrcode) {
		this.ncbrcode = ncbrcode;
	}

	public String getNodecode() {
		return nodecode;
	}

	public void setNodecode(String nodecode) {
		this.nodecode = nodecode;
	}

	public String getParentbilltype() {
		return parentbilltype;
	}

	public void setParentbilltype(String parentbilltype) {
		this.parentbilltype = parentbilltype;
	}

	public String getPkBilltypecode() {
		return pkBilltypecode;
	}

	public void setPkBilltypecode(String pkBilltypecode) {
		this.pkBilltypecode = pkBilltypecode;
	}

	public String getPkBilltypeid() {
		return pkBilltypeid;
	}

	public void setPkBilltypeid(String pkBilltypeid) {
		this.pkBilltypeid = pkBilltypeid;
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

	public String getReferclassname() {
		return referclassname;
	}

	public void setReferclassname(String referclassname) {
		this.referclassname = referclassname;
	}

	public String getSystemcode() {
		return systemcode;
	}

	public void setSystemcode(String systemcode) {
		this.systemcode = systemcode;
	}

	public String getTranstypeClass() {
		return transtypeClass;
	}

	public void setTranstypeClass(String transtypeClass) {
		this.transtypeClass = transtypeClass;
	}

	public String getTs() {
		return ts;
	}

	public void setTs(String ts) {
		this.ts = ts;
	}

	public String getWebnodecode() {
		return webnodecode;
	}

	public void setWebnodecode(String webnodecode) {
		this.webnodecode = webnodecode;
	}

	public String getWherestring() {
		return wherestring;
	}

	public void setWherestring(String wherestring) {
		this.wherestring = wherestring;
	}

	public void initByCode(BaseDAO dao, String pkBilltypecode) throws DAOException {
		String getSql = "select A.PK_BILLTYPEID from BD_BILLTYPE A where A.SYSTEMCODE = 'SO' and A.PK_BILLTYPECODE = ?";
		SQLParameter parameter = new SQLParameter();
		parameter.addParam(pkBilltypecode);
		this.pkBilltypecode = pkBilltypecode;
		this.systemcode = "SO";
		this.pkBilltypeid = (String) dao.executeQuery(getSql, parameter , new ColumnProcessor());
		
	}

    
}
