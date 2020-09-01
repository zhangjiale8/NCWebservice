package nc.itf.Impl.entity;

import java.math.BigDecimal;

import nc.bs.dao.BaseDAO;
import nc.bs.dao.DAOException;
import nc.jdbc.framework.SQLParameter;
import nc.jdbc.framework.processor.ColumnProcessor;

/**
 * 计量单位
 * @author zhangjiale
 *
 */
public class BdMeasdoc{


    private String basecodeflag;

    private Long bitnumber;

    private String code;

    private String creationtime;

    private String creator;

    private Long dataoriginflag;

    private Long dr;

    private String modifiedtime;

    private String modifier;

    private String name;

    private String name2;

    private String name3;

    private String name4;

    private String name5;

    private String name6;

    private String oppdimen;

    private String pkGroup;
    //主键
    private String pkMeasdoc;

    private String pkOrg;

    private BigDecimal scalefactor;

    private String ts;

    private String ename;

	public String getBasecodeflag() {
		return basecodeflag;
	}

	public void setBasecodeflag(String basecodeflag) {
		this.basecodeflag = basecodeflag;
	}

	public Long getBitnumber() {
		return bitnumber;
	}

	public void setBitnumber(Long bitnumber) {
		this.bitnumber = bitnumber;
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

	public Long getDr() {
		return dr;
	}

	public void setDr(Long dr) {
		this.dr = dr;
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

	public String getOppdimen() {
		return oppdimen;
	}

	public void setOppdimen(String oppdimen) {
		this.oppdimen = oppdimen;
	}

	public String getPkGroup() {
		return pkGroup;
	}

	public void setPkGroup(String pkGroup) {
		this.pkGroup = pkGroup;
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

	public BigDecimal getScalefactor() {
		return scalefactor;
	}

	public void setScalefactor(BigDecimal scalefactor) {
		this.scalefactor = scalefactor;
	}

	public String getTs() {
		return ts;
	}

	public void setTs(String ts) {
		this.ts = ts;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public void initByCode(BaseDAO dao, String unitId) throws DAOException {
		String getSql = "select A.PK_MEASDOC from BD_MEASDOC A where A.CODE = ?";
		SQLParameter parameter = new SQLParameter();
		parameter.clearParams();
		parameter.addParam(unitId);
		this.code = unitId;
		this.pkMeasdoc = (String) dao.executeQuery(getSql, parameter , new ColumnProcessor());
		
	}

    
}
