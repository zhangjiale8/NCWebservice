package nc.itf.Impl.entity;

import nc.bs.dao.BaseDAO;
import nc.bs.dao.DAOException;
import nc.jdbc.framework.SQLParameter;
import nc.jdbc.framework.processor.ColumnProcessor;

/**
 * 组织_业务单元_库存组织
 * @author zhangjiale
 *
 */
public class OrgStockorg{

    private String addressbook;

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

    private Long enablestate;

    private String islastversion;

    private String mnecode;

    private String modifiedtime;

    private String modifier;

    private String name;

    private String name2;

    private String name3;

    private String name4;

    private String name5;

    private String name6;

    private String pkAddress;

    private String pkAreacl;

    private String pkFinanceorg;

    private String pkGroup;

    private String pkOrg;
    //主键
    private String pkStockorg;

    private String pkVid;

    private String shortname;

    private String shortname2;

    private String shortname3;

    private String shortname4;

    private String shortname5;

    private String shortname6;

    private String ts;

    private String venddate;

    private String vname;

    private String vname2;

    private String vname3;

    private String vname4;

    private String vname5;

    private String vname6;

    private String vno;

    private String vstartdate;

	public String getAddressbook() {
		return addressbook;
	}

	public void setAddressbook(String addressbook) {
		this.addressbook = addressbook;
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

	public Long getEnablestate() {
		return enablestate;
	}

	public void setEnablestate(Long enablestate) {
		this.enablestate = enablestate;
	}

	public String getIslastversion() {
		return islastversion;
	}

	public void setIslastversion(String islastversion) {
		this.islastversion = islastversion;
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

	public String getPkAddress() {
		return pkAddress;
	}

	public void setPkAddress(String pkAddress) {
		this.pkAddress = pkAddress;
	}

	public String getPkAreacl() {
		return pkAreacl;
	}

	public void setPkAreacl(String pkAreacl) {
		this.pkAreacl = pkAreacl;
	}

	public String getPkFinanceorg() {
		return pkFinanceorg;
	}

	public void setPkFinanceorg(String pkFinanceorg) {
		this.pkFinanceorg = pkFinanceorg;
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

	public String getPkStockorg() {
		return pkStockorg;
	}

	public void setPkStockorg(String pkStockorg) {
		this.pkStockorg = pkStockorg;
	}

	public String getPkVid() {
		return pkVid;
	}

	public void setPkVid(String pkVid) {
		this.pkVid = pkVid;
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

	public String getTs() {
		return ts;
	}

	public void setTs(String ts) {
		this.ts = ts;
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

	public String getVname2() {
		return vname2;
	}

	public void setVname2(String vname2) {
		this.vname2 = vname2;
	}

	public String getVname3() {
		return vname3;
	}

	public void setVname3(String vname3) {
		this.vname3 = vname3;
	}

	public String getVname4() {
		return vname4;
	}

	public void setVname4(String vname4) {
		this.vname4 = vname4;
	}

	public String getVname5() {
		return vname5;
	}

	public void setVname5(String vname5) {
		this.vname5 = vname5;
	}

	public String getVname6() {
		return vname6;
	}

	public void setVname6(String vname6) {
		this.vname6 = vname6;
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

	public void initByNo(BaseDAO dao, String pkStockorg) throws DAOException {
		String getSql = "select A.PK_FINANCEORG from  ORG_STOCKORG A where A.DR = 0 and A.PK_STOCKORG = ?";
		SQLParameter parameter = new SQLParameter();
		parameter.clearParams();
		parameter.addParam(pkStockorg);
		this.pkStockorg = pkStockorg;
		this.pkFinanceorg = (String) dao.executeQuery(getSql, parameter , new ColumnProcessor());
		
	}

    
}
