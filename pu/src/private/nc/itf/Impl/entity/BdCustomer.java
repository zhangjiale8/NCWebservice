package nc.itf.Impl.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;

import nc.bs.dao.BaseDAO;
import nc.bs.dao.DAOException;
import nc.jdbc.framework.SQLParameter;
import nc.jdbc.framework.processor.MapListProcessor;

/**
 * ¿Í»§
 * @author zhangjiale
 *
 */
public class BdCustomer{


    private String code;

    private String corpaddress;

    private String creationtime;

    private String creator;

    private Long custprop;

    private Long custstate;

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

    private String def21;

    private String def22;

    private String def23;

    private String def24;

    private String def25;

    private String def26;

    private String def27;

    private String def28;

    private String def29;

    private String def3;

    private String def30;

    private String def4;

    private String def5;

    private String def6;

    private String def7;

    private String def8;

    private String def9;

    private Long deletestate;

    private String delperson;

    private String deltime;

    private Long dr;

    private String ecotypesincevfive;

    private String email;

    private Long enablestate;

    private String fax1;

    private String fax2;

    private String frozenflag;

    private String isfreecust;

    private String isretailstore;

    private String issupplier;

    private String isvat;

    private String legalbody;

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

    private String pkAreacl;

    private String pkBilltypecode;

    private String pkCountry;

    private String pkCustclass;
    //Ö÷¼ü
    private String pkCustomer;

    private String pkCustomerMain;

    private String pkCustomerpf;

    private String pkCusttaxes;

    private String pkFinanceorg;

    private String pkFormat;

    private String pkGroup;

    private String pkOrg;

    private String pkSupplier;

    private String pkTimezone;

    private BigDecimal registerfund;

    private String shortname;

    private String taxpayerid;

    private String tel1;

    private String tel2;

    private String tel3;

    private String trade;

    private String ts;

    private String url;

    private String vatcode;

    private String ename;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCorpaddress() {
		return corpaddress;
	}

	public void setCorpaddress(String corpaddress) {
		this.corpaddress = corpaddress;
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

	public Long getCustprop() {
		return custprop;
	}

	public void setCustprop(Long custprop) {
		this.custprop = custprop;
	}

	public Long getCuststate() {
		return custstate;
	}

	public void setCuststate(Long custstate) {
		this.custstate = custstate;
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

	public String getDef21() {
		return def21;
	}

	public void setDef21(String def21) {
		this.def21 = def21;
	}

	public String getDef22() {
		return def22;
	}

	public void setDef22(String def22) {
		this.def22 = def22;
	}

	public String getDef23() {
		return def23;
	}

	public void setDef23(String def23) {
		this.def23 = def23;
	}

	public String getDef24() {
		return def24;
	}

	public void setDef24(String def24) {
		this.def24 = def24;
	}

	public String getDef25() {
		return def25;
	}

	public void setDef25(String def25) {
		this.def25 = def25;
	}

	public String getDef26() {
		return def26;
	}

	public void setDef26(String def26) {
		this.def26 = def26;
	}

	public String getDef27() {
		return def27;
	}

	public void setDef27(String def27) {
		this.def27 = def27;
	}

	public String getDef28() {
		return def28;
	}

	public void setDef28(String def28) {
		this.def28 = def28;
	}

	public String getDef29() {
		return def29;
	}

	public void setDef29(String def29) {
		this.def29 = def29;
	}

	public String getDef3() {
		return def3;
	}

	public void setDef3(String def3) {
		this.def3 = def3;
	}

	public String getDef30() {
		return def30;
	}

	public void setDef30(String def30) {
		this.def30 = def30;
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

	public Long getDeletestate() {
		return deletestate;
	}

	public void setDeletestate(Long deletestate) {
		this.deletestate = deletestate;
	}

	public String getDelperson() {
		return delperson;
	}

	public void setDelperson(String delperson) {
		this.delperson = delperson;
	}

	public String getDeltime() {
		return deltime;
	}

	public void setDeltime(String deltime) {
		this.deltime = deltime;
	}

	public Long getDr() {
		return dr;
	}

	public void setDr(Long dr) {
		this.dr = dr;
	}

	public String getEcotypesincevfive() {
		return ecotypesincevfive;
	}

	public void setEcotypesincevfive(String ecotypesincevfive) {
		this.ecotypesincevfive = ecotypesincevfive;
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

	public String getFrozenflag() {
		return frozenflag;
	}

	public void setFrozenflag(String frozenflag) {
		this.frozenflag = frozenflag;
	}

	public String getIsfreecust() {
		return isfreecust;
	}

	public void setIsfreecust(String isfreecust) {
		this.isfreecust = isfreecust;
	}

	public String getIsretailstore() {
		return isretailstore;
	}

	public void setIsretailstore(String isretailstore) {
		this.isretailstore = isretailstore;
	}

	public String getIssupplier() {
		return issupplier;
	}

	public void setIssupplier(String issupplier) {
		this.issupplier = issupplier;
	}

	public String getIsvat() {
		return isvat;
	}

	public void setIsvat(String isvat) {
		this.isvat = isvat;
	}

	public String getLegalbody() {
		return legalbody;
	}

	public void setLegalbody(String legalbody) {
		this.legalbody = legalbody;
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

	public String getPkAreacl() {
		return pkAreacl;
	}

	public void setPkAreacl(String pkAreacl) {
		this.pkAreacl = pkAreacl;
	}

	public String getPkBilltypecode() {
		return pkBilltypecode;
	}

	public void setPkBilltypecode(String pkBilltypecode) {
		this.pkBilltypecode = pkBilltypecode;
	}

	public String getPkCountry() {
		return pkCountry;
	}

	public void setPkCountry(String pkCountry) {
		this.pkCountry = pkCountry;
	}

	public String getPkCustclass() {
		return pkCustclass;
	}

	public void setPkCustclass(String pkCustclass) {
		this.pkCustclass = pkCustclass;
	}

	public String getPkCustomer() {
		return pkCustomer;
	}

	public void setPkCustomer(String pkCustomer) {
		this.pkCustomer = pkCustomer;
	}

	public String getPkCustomerMain() {
		return pkCustomerMain;
	}

	public void setPkCustomerMain(String pkCustomerMain) {
		this.pkCustomerMain = pkCustomerMain;
	}

	public String getPkCustomerpf() {
		return pkCustomerpf;
	}

	public void setPkCustomerpf(String pkCustomerpf) {
		this.pkCustomerpf = pkCustomerpf;
	}

	public String getPkCusttaxes() {
		return pkCusttaxes;
	}

	public void setPkCusttaxes(String pkCusttaxes) {
		this.pkCusttaxes = pkCusttaxes;
	}

	public String getPkFinanceorg() {
		return pkFinanceorg;
	}

	public void setPkFinanceorg(String pkFinanceorg) {
		this.pkFinanceorg = pkFinanceorg;
	}

	public String getPkFormat() {
		return pkFormat;
	}

	public void setPkFormat(String pkFormat) {
		this.pkFormat = pkFormat;
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

	public String getPkSupplier() {
		return pkSupplier;
	}

	public void setPkSupplier(String pkSupplier) {
		this.pkSupplier = pkSupplier;
	}

	public String getPkTimezone() {
		return pkTimezone;
	}

	public void setPkTimezone(String pkTimezone) {
		this.pkTimezone = pkTimezone;
	}

	public BigDecimal getRegisterfund() {
		return registerfund;
	}

	public void setRegisterfund(BigDecimal registerfund) {
		this.registerfund = registerfund;
	}

	public String getShortname() {
		return shortname;
	}

	public void setShortname(String shortname) {
		this.shortname = shortname;
	}

	public String getTaxpayerid() {
		return taxpayerid;
	}

	public void setTaxpayerid(String taxpayerid) {
		this.taxpayerid = taxpayerid;
	}

	public String getTel1() {
		return tel1;
	}

	public void setTel1(String tel1) {
		this.tel1 = tel1;
	}

	public String getTel2() {
		return tel2;
	}

	public void setTel2(String tel2) {
		this.tel2 = tel2;
	}

	public String getTel3() {
		return tel3;
	}

	public void setTel3(String tel3) {
		this.tel3 = tel3;
	}

	public String getTrade() {
		return trade;
	}

	public void setTrade(String trade) {
		this.trade = trade;
	}

	public String getTs() {
		return ts;
	}

	public void setTs(String ts) {
		this.ts = ts;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getVatcode() {
		return vatcode;
	}

	public void setVatcode(String vatcode) {
		this.vatcode = vatcode;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	@SuppressWarnings("unchecked")
	public void initByCode(BaseDAO dao, String customerId) throws DAOException {
		String getSql = "select A.PK_CUSTOMER,A.ISFREECUST from BD_CUSTOMER A where A.CODE = ?";
		SQLParameter parameter = new SQLParameter();
		parameter.clearParams();
		parameter.addParam(customerId);
		this.code = customerId;
		ArrayList<Map<String,Object>> tempInfos = (ArrayList<Map<String, Object>>) dao.executeQuery(getSql, parameter , new MapListProcessor());
		if(!CollectionUtils.isEmpty(tempInfos)){
			Map<String,Object> infoMap = tempInfos.get(0);
			if(null != infoMap){
				this.pkCustomer = (String) infoMap.get("pk_customer");
				this.isfreecust = (String) infoMap.get("isfreecust");
			}
		}
		
	}
    
}
