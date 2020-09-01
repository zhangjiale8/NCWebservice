package nc.itf.Impl.entity;


import nc.bs.dao.BaseDAO;
import nc.bs.dao.DAOException;
import nc.jdbc.framework.SQLParameter;
import nc.jdbc.framework.processor.ColumnProcessor;

/**
 * 销售订单
 * @author zhangjiale
 *
 */
public class SoSaleorder{

    private String approver;

    private String badvfeeflag;

    private String barsettleflag;

    private String bcooptopoflag;

    private String bcostsettleflag;

    private String bfreecustflag;

    private String billmaker;

    private String binvoicendflag;

    private String boffsetflag;

    private String boutendflag;

    private String bpocooptomeflag;

    private String bpreceiveflag;

    private String bsendendflag;

    private String cbalancetypeid;

    private String cbiztypeid;

    private String cchanneltypeid;

    private String ccustbankaccid;

    private String ccustbankid;

    private String ccustomerid;

    private String cdeptid;

    private String cdeptvid;

    private String cemployeeid;

    private String cfreecustid;

    private String cinvoicecustid;

    private String corigcurrencyid;

    private String cpaytermid;

    private String creationtime;

    private String creator;

    private String creviserid;
    //主键
    private String csaleorderid;

    private String ctradewordid;

    private String ctransporttypeid;

    private String ctrantypeid;

    private String dbilldate;

    private String dmakedate;

    private Long dr;

    private Long fpfstatusflag;

    private Long fstatusflag;

    private Long iprintcount;

    private Long iversion;

    private String modifiedtime;

    private String modifier;

    private Double ndiscountrate;

    private Double npreceivemny;

    private Double npreceivequota;

    private Double npreceiverate;

    private Double nreceivedmny;

    private Double ntotalnum;

    private Double ntotalorigmny;

    private Double ntotalorigsubmny;

    private Double ntotalpiece;

    private Double ntotalvolume;

    private Double ntotalweight;

    private String pkGroup;

    private String pkOrg;

    private String pkOrgV;

    private String taudittime;

    private String trevisetime;

    private String ts;

    private String vbillcode;

    private String vcooppohcode;

    private String vcreditnum;

    private String vdef1;

    private String vdef10;

    private String vdef11;

    private String vdef12;

    private String vdef13;

    private String vdef14;

    private String vdef15;

    private String vdef16;

    private String vdef17;

    private String vdef18;

    private String vdef19;

    private String vdef2;

    private String vdef20;

    private String vdef3;

    private String vdef4;

    private String vdef5;

    private String vdef6;

    private String vdef7;

    private String vdef8;

    private String vdef9;

    private String vnote;

    private String vrevisereason;

    private String vtrantypecode;

    private String cbillsrcid;

    private String vbillsrctype;

	public String getApprover() {
		return approver;
	}

	public void setApprover(String approver) {
		this.approver = approver;
	}

	public String getBadvfeeflag() {
		return badvfeeflag;
	}

	public void setBadvfeeflag(String badvfeeflag) {
		this.badvfeeflag = badvfeeflag;
	}

	public String getBarsettleflag() {
		return barsettleflag;
	}

	public void setBarsettleflag(String barsettleflag) {
		this.barsettleflag = barsettleflag;
	}

	public String getBcooptopoflag() {
		return bcooptopoflag;
	}

	public void setBcooptopoflag(String bcooptopoflag) {
		this.bcooptopoflag = bcooptopoflag;
	}

	public String getBcostsettleflag() {
		return bcostsettleflag;
	}

	public void setBcostsettleflag(String bcostsettleflag) {
		this.bcostsettleflag = bcostsettleflag;
	}

	public String getBfreecustflag() {
		return bfreecustflag;
	}

	public void setBfreecustflag(String bfreecustflag) {
		this.bfreecustflag = bfreecustflag;
	}

	public String getBillmaker() {
		return billmaker;
	}

	public void setBillmaker(String billmaker) {
		this.billmaker = billmaker;
	}

	public String getBinvoicendflag() {
		return binvoicendflag;
	}

	public void setBinvoicendflag(String binvoicendflag) {
		this.binvoicendflag = binvoicendflag;
	}

	public String getBoffsetflag() {
		return boffsetflag;
	}

	public void setBoffsetflag(String boffsetflag) {
		this.boffsetflag = boffsetflag;
	}

	public String getBoutendflag() {
		return boutendflag;
	}

	public void setBoutendflag(String boutendflag) {
		this.boutendflag = boutendflag;
	}

	public String getBpocooptomeflag() {
		return bpocooptomeflag;
	}

	public void setBpocooptomeflag(String bpocooptomeflag) {
		this.bpocooptomeflag = bpocooptomeflag;
	}

	public String getBpreceiveflag() {
		return bpreceiveflag;
	}

	public void setBpreceiveflag(String bpreceiveflag) {
		this.bpreceiveflag = bpreceiveflag;
	}

	public String getBsendendflag() {
		return bsendendflag;
	}

	public void setBsendendflag(String bsendendflag) {
		this.bsendendflag = bsendendflag;
	}

	public String getCbalancetypeid() {
		return cbalancetypeid;
	}

	public void setCbalancetypeid(String cbalancetypeid) {
		this.cbalancetypeid = cbalancetypeid;
	}

	public String getCbiztypeid() {
		return cbiztypeid;
	}

	public void setCbiztypeid(String cbiztypeid) {
		this.cbiztypeid = cbiztypeid;
	}

	public String getCchanneltypeid() {
		return cchanneltypeid;
	}

	public void setCchanneltypeid(String cchanneltypeid) {
		this.cchanneltypeid = cchanneltypeid;
	}

	public String getCcustbankaccid() {
		return ccustbankaccid;
	}

	public void setCcustbankaccid(String ccustbankaccid) {
		this.ccustbankaccid = ccustbankaccid;
	}

	public String getCcustbankid() {
		return ccustbankid;
	}

	public void setCcustbankid(String ccustbankid) {
		this.ccustbankid = ccustbankid;
	}

	public String getCcustomerid() {
		return ccustomerid;
	}

	public void setCcustomerid(String ccustomerid) {
		this.ccustomerid = ccustomerid;
	}

	public String getCdeptid() {
		return cdeptid;
	}

	public void setCdeptid(String cdeptid) {
		this.cdeptid = cdeptid;
	}

	public String getCdeptvid() {
		return cdeptvid;
	}

	public void setCdeptvid(String cdeptvid) {
		this.cdeptvid = cdeptvid;
	}

	public String getCemployeeid() {
		return cemployeeid;
	}

	public void setCemployeeid(String cemployeeid) {
		this.cemployeeid = cemployeeid;
	}

	public String getCfreecustid() {
		return cfreecustid;
	}

	public void setCfreecustid(String cfreecustid) {
		this.cfreecustid = cfreecustid;
	}

	public String getCinvoicecustid() {
		return cinvoicecustid;
	}

	public void setCinvoicecustid(String cinvoicecustid) {
		this.cinvoicecustid = cinvoicecustid;
	}

	public String getCorigcurrencyid() {
		return corigcurrencyid;
	}

	public void setCorigcurrencyid(String corigcurrencyid) {
		this.corigcurrencyid = corigcurrencyid;
	}

	public String getCpaytermid() {
		return cpaytermid;
	}

	public void setCpaytermid(String cpaytermid) {
		this.cpaytermid = cpaytermid;
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

	public String getCreviserid() {
		return creviserid;
	}

	public void setCreviserid(String creviserid) {
		this.creviserid = creviserid;
	}

	public String getCsaleorderid() {
		return csaleorderid;
	}

	public void setCsaleorderid(String csaleorderid) {
		this.csaleorderid = csaleorderid;
	}

	public String getCtradewordid() {
		return ctradewordid;
	}

	public void setCtradewordid(String ctradewordid) {
		this.ctradewordid = ctradewordid;
	}

	public String getCtransporttypeid() {
		return ctransporttypeid;
	}

	public void setCtransporttypeid(String ctransporttypeid) {
		this.ctransporttypeid = ctransporttypeid;
	}

	public String getCtrantypeid() {
		return ctrantypeid;
	}

	public void setCtrantypeid(String ctrantypeid) {
		this.ctrantypeid = ctrantypeid;
	}

	public String getDbilldate() {
		return dbilldate;
	}

	public void setDbilldate(String dbilldate) {
		this.dbilldate = dbilldate;
	}

	public String getDmakedate() {
		return dmakedate;
	}

	public void setDmakedate(String dmakedate) {
		this.dmakedate = dmakedate;
	}

	public Long getDr() {
		return dr;
	}

	public void setDr(Long dr) {
		this.dr = dr;
	}

	public Long getFpfstatusflag() {
		return fpfstatusflag;
	}

	public void setFpfstatusflag(Long fpfstatusflag) {
		this.fpfstatusflag = fpfstatusflag;
	}

	public Long getFstatusflag() {
		return fstatusflag;
	}

	public void setFstatusflag(Long fstatusflag) {
		this.fstatusflag = fstatusflag;
	}

	public Long getIprintcount() {
		return iprintcount;
	}

	public void setIprintcount(Long iprintcount) {
		this.iprintcount = iprintcount;
	}

	public Long getIversion() {
		return iversion;
	}

	public void setIversion(Long iversion) {
		this.iversion = iversion;
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

	public Double getNdiscountrate() {
		return ndiscountrate;
	}

	public void setNdiscountrate(Double ndiscountrate) {
		this.ndiscountrate = ndiscountrate;
	}

	public Double getNpreceivemny() {
		return npreceivemny;
	}

	public void setNpreceivemny(Double npreceivemny) {
		this.npreceivemny = npreceivemny;
	}

	public Double getNpreceivequota() {
		return npreceivequota;
	}

	public void setNpreceivequota(Double npreceivequota) {
		this.npreceivequota = npreceivequota;
	}

	public Double getNpreceiverate() {
		return npreceiverate;
	}

	public void setNpreceiverate(Double npreceiverate) {
		this.npreceiverate = npreceiverate;
	}

	public Double getNreceivedmny() {
		return nreceivedmny;
	}

	public void setNreceivedmny(Double nreceivedmny) {
		this.nreceivedmny = nreceivedmny;
	}

	public Double getNtotalnum() {
		return ntotalnum;
	}

	public void setNtotalnum(Double ntotalnum) {
		this.ntotalnum = ntotalnum;
	}

	public Double getNtotalorigmny() {
		return ntotalorigmny;
	}

	public void setNtotalorigmny(Double ntotalorigmny) {
		this.ntotalorigmny = ntotalorigmny;
	}

	public Double getNtotalorigsubmny() {
		return ntotalorigsubmny;
	}

	public void setNtotalorigsubmny(Double ntotalorigsubmny) {
		this.ntotalorigsubmny = ntotalorigsubmny;
	}

	public Double getNtotalpiece() {
		return ntotalpiece;
	}

	public void setNtotalpiece(Double ntotalpiece) {
		this.ntotalpiece = ntotalpiece;
	}

	public Double getNtotalvolume() {
		return ntotalvolume;
	}

	public void setNtotalvolume(Double ntotalvolume) {
		this.ntotalvolume = ntotalvolume;
	}

	public Double getNtotalweight() {
		return ntotalweight;
	}

	public void setNtotalweight(Double ntotalweight) {
		this.ntotalweight = ntotalweight;
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

	public String getPkOrgV() {
		return pkOrgV;
	}

	public void setPkOrgV(String pkOrgV) {
		this.pkOrgV = pkOrgV;
	}

	public String getTaudittime() {
		return taudittime;
	}

	public void setTaudittime(String taudittime) {
		this.taudittime = taudittime;
	}

	public String getTrevisetime() {
		return trevisetime;
	}

	public void setTrevisetime(String trevisetime) {
		this.trevisetime = trevisetime;
	}

	public String getTs() {
		return ts;
	}

	public void setTs(String ts) {
		this.ts = ts;
	}

	public String getVbillcode() {
		return vbillcode;
	}

	public void setVbillcode(String vbillcode) {
		this.vbillcode = vbillcode;
	}

	public String getVcooppohcode() {
		return vcooppohcode;
	}

	public void setVcooppohcode(String vcooppohcode) {
		this.vcooppohcode = vcooppohcode;
	}

	public String getVcreditnum() {
		return vcreditnum;
	}

	public void setVcreditnum(String vcreditnum) {
		this.vcreditnum = vcreditnum;
	}

	public String getVdef1() {
		return vdef1;
	}

	public void setVdef1(String vdef1) {
		this.vdef1 = vdef1;
	}

	public String getVdef10() {
		return vdef10;
	}

	public void setVdef10(String vdef10) {
		this.vdef10 = vdef10;
	}

	public String getVdef11() {
		return vdef11;
	}

	public void setVdef11(String vdef11) {
		this.vdef11 = vdef11;
	}

	public String getVdef12() {
		return vdef12;
	}

	public void setVdef12(String vdef12) {
		this.vdef12 = vdef12;
	}

	public String getVdef13() {
		return vdef13;
	}

	public void setVdef13(String vdef13) {
		this.vdef13 = vdef13;
	}

	public String getVdef14() {
		return vdef14;
	}

	public void setVdef14(String vdef14) {
		this.vdef14 = vdef14;
	}

	public String getVdef15() {
		return vdef15;
	}

	public void setVdef15(String vdef15) {
		this.vdef15 = vdef15;
	}

	public String getVdef16() {
		return vdef16;
	}

	public void setVdef16(String vdef16) {
		this.vdef16 = vdef16;
	}

	public String getVdef17() {
		return vdef17;
	}

	public void setVdef17(String vdef17) {
		this.vdef17 = vdef17;
	}

	public String getVdef18() {
		return vdef18;
	}

	public void setVdef18(String vdef18) {
		this.vdef18 = vdef18;
	}

	public String getVdef19() {
		return vdef19;
	}

	public void setVdef19(String vdef19) {
		this.vdef19 = vdef19;
	}

	public String getVdef2() {
		return vdef2;
	}

	public void setVdef2(String vdef2) {
		this.vdef2 = vdef2;
	}

	public String getVdef20() {
		return vdef20;
	}

	public void setVdef20(String vdef20) {
		this.vdef20 = vdef20;
	}

	public String getVdef3() {
		return vdef3;
	}

	public void setVdef3(String vdef3) {
		this.vdef3 = vdef3;
	}

	public String getVdef4() {
		return vdef4;
	}

	public void setVdef4(String vdef4) {
		this.vdef4 = vdef4;
	}

	public String getVdef5() {
		return vdef5;
	}

	public void setVdef5(String vdef5) {
		this.vdef5 = vdef5;
	}

	public String getVdef6() {
		return vdef6;
	}

	public void setVdef6(String vdef6) {
		this.vdef6 = vdef6;
	}

	public String getVdef7() {
		return vdef7;
	}

	public void setVdef7(String vdef7) {
		this.vdef7 = vdef7;
	}

	public String getVdef8() {
		return vdef8;
	}

	public void setVdef8(String vdef8) {
		this.vdef8 = vdef8;
	}

	public String getVdef9() {
		return vdef9;
	}

	public void setVdef9(String vdef9) {
		this.vdef9 = vdef9;
	}

	public String getVnote() {
		return vnote;
	}

	public void setVnote(String vnote) {
		this.vnote = vnote;
	}

	public String getVrevisereason() {
		return vrevisereason;
	}

	public void setVrevisereason(String vrevisereason) {
		this.vrevisereason = vrevisereason;
	}

	public String getVtrantypecode() {
		return vtrantypecode;
	}

	public void setVtrantypecode(String vtrantypecode) {
		this.vtrantypecode = vtrantypecode;
	}

	public String getCbillsrcid() {
		return cbillsrcid;
	}

	public void setCbillsrcid(String cbillsrcid) {
		this.cbillsrcid = cbillsrcid;
	}

	public String getVbillsrctype() {
		return vbillsrctype;
	}

	public void setVbillsrctype(String vbillsrctype) {
		this.vbillsrctype = vbillsrctype;
	}

	public void initByCode(BaseDAO dao, String saleOrderId) throws DAOException {
		String getSql = "select A.CSALEORDERID from SO_SALEORDER A where A.VBILLCODE = ?";
		SQLParameter parameter = new SQLParameter();
		parameter.addParam(saleOrderId);
		this.vbillcode = saleOrderId;
		this.csaleorderid = (String) dao.executeQuery(getSql, parameter , new ColumnProcessor());
		
	}

	public SoSaleorder() {
		super();
	}

	

}
