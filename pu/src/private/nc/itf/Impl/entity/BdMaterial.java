package nc.itf.Impl.entity;

import java.math.BigDecimal;

import nc.bs.dao.BaseDAO;
import nc.bs.dao.DAOException;
import nc.jdbc.framework.SQLParameter;
import nc.jdbc.framework.processor.ColumnProcessor;

/**
 * 物料信息
 * @author zhangjiale
 *
 */
public class BdMaterial{


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

    private Long deletestate;

    private String delperson;

    private String deltime;

    private String discountflag;

    private Long dr;

    private String electronicsale;

    private Long enablestate;

    private String fee;

    private String graphid;

    private BigDecimal intolerance;

    private String iselectrans;

    private String latest;

    private String materialbarcode;

    private Long materialmgt;

    private String materialmnecode;

    private String materialshortname;

    private String materialspec;

    private String materialtype;

    private String memo;

    private String modifiedtime;

    private String modifier;

    private String name;

    private String name2;

    private String name3;

    private String name4;

    private String name5;

    private String name6;

    private BigDecimal outcloselowerlimit;

    private BigDecimal outtolerance;

    private String pkBrand;

    private String pkGoodscode;

    private String pkGroup;

    private String pkMarasstframe;

    private String pkMarbasclass;
    //主键
    private String pkMaterial;

    private String pkMaterialPf;

    private String pkMattaxes;

    private String pkMeasdoc;

    private String pkOrg;

    private String pkProdline;

    private String pkSource;

    private String pkTaxitems;

    private String prodarea;

    private String productfamily;

    private Long prolifeperiod;

    private String retail;

    private String setpartsflag;

    private BigDecimal storeunitnum;

    private String ts;

    private String unitheight;

    private String unitlength;

    private BigDecimal unitvolume;

    private BigDecimal unitweight;

    private String unitwidth;

    private Long version;

    private String ematerialspec;

    private String ename;

    private String goodsprtname;

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

	public String getDiscountflag() {
		return discountflag;
	}

	public void setDiscountflag(String discountflag) {
		this.discountflag = discountflag;
	}

	public Long getDr() {
		return dr;
	}

	public void setDr(Long dr) {
		this.dr = dr;
	}

	public String getElectronicsale() {
		return electronicsale;
	}

	public void setElectronicsale(String electronicsale) {
		this.electronicsale = electronicsale;
	}

	public Long getEnablestate() {
		return enablestate;
	}

	public void setEnablestate(Long enablestate) {
		this.enablestate = enablestate;
	}

	public String getFee() {
		return fee;
	}

	public void setFee(String fee) {
		this.fee = fee;
	}

	public String getGraphid() {
		return graphid;
	}

	public void setGraphid(String graphid) {
		this.graphid = graphid;
	}

	public BigDecimal getIntolerance() {
		return intolerance;
	}

	public void setIntolerance(BigDecimal intolerance) {
		this.intolerance = intolerance;
	}

	public String getIselectrans() {
		return iselectrans;
	}

	public void setIselectrans(String iselectrans) {
		this.iselectrans = iselectrans;
	}

	public String getLatest() {
		return latest;
	}

	public void setLatest(String latest) {
		this.latest = latest;
	}

	public String getMaterialbarcode() {
		return materialbarcode;
	}

	public void setMaterialbarcode(String materialbarcode) {
		this.materialbarcode = materialbarcode;
	}

	public Long getMaterialmgt() {
		return materialmgt;
	}

	public void setMaterialmgt(Long materialmgt) {
		this.materialmgt = materialmgt;
	}

	public String getMaterialmnecode() {
		return materialmnecode;
	}

	public void setMaterialmnecode(String materialmnecode) {
		this.materialmnecode = materialmnecode;
	}

	public String getMaterialshortname() {
		return materialshortname;
	}

	public void setMaterialshortname(String materialshortname) {
		this.materialshortname = materialshortname;
	}

	public String getMaterialspec() {
		return materialspec;
	}

	public void setMaterialspec(String materialspec) {
		this.materialspec = materialspec;
	}

	public String getMaterialtype() {
		return materialtype;
	}

	public void setMaterialtype(String materialtype) {
		this.materialtype = materialtype;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
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

	public BigDecimal getOutcloselowerlimit() {
		return outcloselowerlimit;
	}

	public void setOutcloselowerlimit(BigDecimal outcloselowerlimit) {
		this.outcloselowerlimit = outcloselowerlimit;
	}

	public BigDecimal getOuttolerance() {
		return outtolerance;
	}

	public void setOuttolerance(BigDecimal outtolerance) {
		this.outtolerance = outtolerance;
	}

	public String getPkBrand() {
		return pkBrand;
	}

	public void setPkBrand(String pkBrand) {
		this.pkBrand = pkBrand;
	}

	public String getPkGoodscode() {
		return pkGoodscode;
	}

	public void setPkGoodscode(String pkGoodscode) {
		this.pkGoodscode = pkGoodscode;
	}

	public String getPkGroup() {
		return pkGroup;
	}

	public void setPkGroup(String pkGroup) {
		this.pkGroup = pkGroup;
	}

	public String getPkMarasstframe() {
		return pkMarasstframe;
	}

	public void setPkMarasstframe(String pkMarasstframe) {
		this.pkMarasstframe = pkMarasstframe;
	}

	public String getPkMarbasclass() {
		return pkMarbasclass;
	}

	public void setPkMarbasclass(String pkMarbasclass) {
		this.pkMarbasclass = pkMarbasclass;
	}

	public String getPkMaterial() {
		return pkMaterial;
	}

	public void setPkMaterial(String pkMaterial) {
		this.pkMaterial = pkMaterial;
	}

	public String getPkMaterialPf() {
		return pkMaterialPf;
	}

	public void setPkMaterialPf(String pkMaterialPf) {
		this.pkMaterialPf = pkMaterialPf;
	}

	public String getPkMattaxes() {
		return pkMattaxes;
	}

	public void setPkMattaxes(String pkMattaxes) {
		this.pkMattaxes = pkMattaxes;
	}

	public String getPkMeasdoc() {
		return pkMeasdoc;
	}

	public void setPkMeasdoc(String pkMeasdoc) {
		this.pkMeasdoc = pkMeasdoc;
	}

	public String getPkOrg() {
		return pkOrg;
	}

	public void setPkOrg(String pkOrg) {
		this.pkOrg = pkOrg;
	}

	public String getPkProdline() {
		return pkProdline;
	}

	public void setPkProdline(String pkProdline) {
		this.pkProdline = pkProdline;
	}

	public String getPkSource() {
		return pkSource;
	}

	public void setPkSource(String pkSource) {
		this.pkSource = pkSource;
	}

	public String getPkTaxitems() {
		return pkTaxitems;
	}

	public void setPkTaxitems(String pkTaxitems) {
		this.pkTaxitems = pkTaxitems;
	}

	public String getProdarea() {
		return prodarea;
	}

	public void setProdarea(String prodarea) {
		this.prodarea = prodarea;
	}

	public String getProductfamily() {
		return productfamily;
	}

	public void setProductfamily(String productfamily) {
		this.productfamily = productfamily;
	}

	public Long getProlifeperiod() {
		return prolifeperiod;
	}

	public void setProlifeperiod(Long prolifeperiod) {
		this.prolifeperiod = prolifeperiod;
	}

	public String getRetail() {
		return retail;
	}

	public void setRetail(String retail) {
		this.retail = retail;
	}

	public String getSetpartsflag() {
		return setpartsflag;
	}

	public void setSetpartsflag(String setpartsflag) {
		this.setpartsflag = setpartsflag;
	}

	public BigDecimal getStoreunitnum() {
		return storeunitnum;
	}

	public void setStoreunitnum(BigDecimal storeunitnum) {
		this.storeunitnum = storeunitnum;
	}

	public String getTs() {
		return ts;
	}

	public void setTs(String ts) {
		this.ts = ts;
	}

	public String getUnitheight() {
		return unitheight;
	}

	public void setUnitheight(String unitheight) {
		this.unitheight = unitheight;
	}

	public String getUnitlength() {
		return unitlength;
	}

	public void setUnitlength(String unitlength) {
		this.unitlength = unitlength;
	}

	public BigDecimal getUnitvolume() {
		return unitvolume;
	}

	public void setUnitvolume(BigDecimal unitvolume) {
		this.unitvolume = unitvolume;
	}

	public BigDecimal getUnitweight() {
		return unitweight;
	}

	public void setUnitweight(BigDecimal unitweight) {
		this.unitweight = unitweight;
	}

	public String getUnitwidth() {
		return unitwidth;
	}

	public void setUnitwidth(String unitwidth) {
		this.unitwidth = unitwidth;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public String getEmaterialspec() {
		return ematerialspec;
	}

	public void setEmaterialspec(String ematerialspec) {
		this.ematerialspec = ematerialspec;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getGoodsprtname() {
		return goodsprtname;
	}

	public void setGoodsprtname(String goodsprtname) {
		this.goodsprtname = goodsprtname;
	}

	public void initByCode(BaseDAO dao, String prodId) throws DAOException {
		String getSql = "select A.PK_MATERIAL from BD_MATERIAL A where A.CODE = ?";
		SQLParameter parameter = new SQLParameter();
		parameter.clearParams();
		parameter.addParam(prodId);
		this.code = prodId;
		this.pkMaterial = (String) dao.executeQuery(getSql, parameter , new ColumnProcessor());
		
	}

    
}
