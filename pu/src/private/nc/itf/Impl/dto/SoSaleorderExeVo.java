package nc.itf.Impl.dto;

import nc.vo.pub.IVOMeta;
import nc.vo.pub.SuperVO;
import nc.vo.pub.lang.UFDateTime;
import nc.vo.pub.lang.UFDouble;
import nc.vo.pubapp.pattern.model.meta.entity.vo.VOMetaFactory;

/**
 * 销售订单扩展表
 * @author zhangjiale
 *
 */
public class SoSaleorderExeVo extends SuperVO{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3501052117326942710L;
	
	public String getCsaleorderbid()
    {
        return (String)getAttributeValue("csaleorderbid");
    }
	
	 public void setCsaleorderbid(String csaleorderbid)
    {
        setAttributeValue("csaleorderbid", csaleorderbid);
    }

    public void setCcustmaterialid(String ccustmaterialid)
    {
        setAttributeValue("ccustmaterialid", ccustmaterialid);
    }
    
    public Integer getDr()
    {
        return (Integer)getAttributeValue("dr");
    }
    
    public void setDr(Integer dr)
    {
        setAttributeValue("dr", dr);
    }
    
    public UFDouble getNarrangemonum()
    {
        return (UFDouble)getAttributeValue("narrangemonum");
    }
    
    public void setNarrangemonum(UFDouble narrangemonum)
    {
        setAttributeValue("narrangemonum", narrangemonum);
    }
    
    public UFDouble getNarrangepoappnum()
    {
        return (UFDouble)getAttributeValue("narrangepoappnum");
    }
    
    public void setNarrangepoappnum(UFDouble narrangepoappnum)
    {
        setAttributeValue("narrangepoappnum", narrangepoappnum);
    }
    
    public UFDouble getNarrangeponum()
    {
        return (UFDouble)getAttributeValue("narrangeponum");
    }
    
    public void setNarrangeponum(UFDouble narrangeponum)
    {
        setAttributeValue("narrangeponum", narrangeponum);
    }
    
    public UFDouble getNarrangescornum()
    {
        return (UFDouble)getAttributeValue("narrangescornum");
    }
    
    public void setNarrangescornum(UFDouble narrangescornum)
    {
        setAttributeValue("narrangescornum", narrangescornum);
    }

    public UFDouble getNarrangetoappnum()
    {
        return (UFDouble)getAttributeValue("narrangetoappnum");
    }
    
    public void setNarrangetoappnum(UFDouble narrangetoappnum)
    {
        setAttributeValue("narrangetoappnum", narrangetoappnum);
    }

    public UFDouble getNarrangetoornum()
    {
        return (UFDouble)getAttributeValue("narrangetoornum");
    }

    public void setNarrangetoornum(UFDouble narrangetoornum)
    {
        setAttributeValue("narrangetoornum", narrangetoornum);
    }
    
    public UFDouble getNorigsubmny()
    {
        return (UFDouble)getAttributeValue("norigsubmny");
    }
    
    public void setNorigsubmny(UFDouble norigsubmny)
    {
        setAttributeValue("norigsubmny", norigsubmny);
    }
    
    public UFDouble getNreqrsnum()
    {
        return (UFDouble)getAttributeValue("nreqrsnum");
    }
    
    public void setNreqrsnum(UFDouble nreqrsnum)
    {
        setAttributeValue("nreqrsnum", nreqrsnum);
    }
    
    public UFDouble getNtotalarmny()
    {
        return (UFDouble)getAttributeValue("ntotalarmny");
    }
    
    public void setNtotalarmny(UFDouble ntotalarmny)
    {
        setAttributeValue("ntotalarmny", ntotalarmny);
    }
    
    public UFDouble getNtotalarnum()
    {
        return (UFDouble)getAttributeValue("ntotalarnum");
    }
    
    public void setNtotalarnum(UFDouble ntotalarnum)
    {
        setAttributeValue("ntotalarnum", ntotalarnum);
    }
    
    public UFDouble getNtotalcostnum()
    {
        return (UFDouble)getAttributeValue("ntotalcostnum");
    }
    
    public void setNtotalcostnum(UFDouble ntotalcostnum)
    {
        setAttributeValue("ntotalcostnum", ntotalcostnum);
    }
    
    public UFDouble getNtotalestarmny()
    {
        return (UFDouble)getAttributeValue("ntotalestarmny");
    }
    
    public void setNtotalestarmny(UFDouble ntotalestarmny)
    {
        setAttributeValue("ntotalestarmny", ntotalestarmny);
    }
    
    public UFDouble getNtotalestarnum()
    {
        return (UFDouble)getAttributeValue("ntotalestarnum");
    }
    
    public void setNtotalestarnum(UFDouble ntotalestarnum)
    {
        setAttributeValue("ntotalestarnum", ntotalestarnum);
    }
    
    public UFDouble getNtotalinvoicenum()
    {
        return (UFDouble)getAttributeValue("ntotalinvoicenum");
    }
    
    public void setNtotalinvoicenum(UFDouble ntotalinvoicenum)
    {
        setAttributeValue("ntotalinvoicenum", ntotalinvoicenum);
    }
    
    public UFDouble getNtotalnotoutnum()
    {
        return (UFDouble)getAttributeValue("ntotalnotoutnum");
    }
    
    public UFDouble getNtotaloutnum()
    {
        return (UFDouble)getAttributeValue("ntotaloutnum");
    }
    
    public void setNtotaloutnum(UFDouble ntotaloutnum)
    {
        setAttributeValue("ntotaloutnum", ntotaloutnum);
    }
    
    public UFDouble getNtotalpaymny()
    {
        return (UFDouble)getAttributeValue("ntotalpaymny");
    }
    
    public void setNtotalpaymny(UFDouble ntotalpaymny)
    {
        setAttributeValue("ntotalpaymny", ntotalpaymny);
    }
    
    public UFDouble getNtotalplonum()
    {
        return (UFDouble)getAttributeValue("ntotalplonum");
    }
    
    public void setNtotalplonum(UFDouble ntotalplonum)
    {
        setAttributeValue("ntotalplonum", ntotalplonum);
    }
    
    public UFDouble getNtotalreturnnum()
    {
        return (UFDouble)getAttributeValue("ntotalreturnnum");
    }
    
    public void setNtotalreturnnum(UFDouble ntotalreturnnum)
    {
        setAttributeValue("ntotalreturnnum", ntotalreturnnum);
    }
    
    public UFDouble getNtotalrushnum()
    {
        return (UFDouble)getAttributeValue("ntotalrushnum");
    }
    
    public void setNtotalrushnum(UFDouble ntotalrushnum)
    {
        setAttributeValue("ntotalrushnum", ntotalrushnum);
    }
    
    public UFDouble getNtotalsendnum()
    {
        return (UFDouble)getAttributeValue("ntotalsendnum");
    }
    
    public void setNtotalsendnum(UFDouble ntotalsendnum)
    {
        setAttributeValue("ntotalsendnum", ntotalsendnum);
    }
    
    public UFDouble getNtotalsignnum()
    {
        return (UFDouble)getAttributeValue("ntotalsignnum");
    }
    
    public void setNtotalsignnum(UFDouble ntotalsignnum)
    {
        setAttributeValue("ntotalsignnum", ntotalsignnum);
    }
    
    public UFDouble getNtotaltradenum()
    {
        return (UFDouble)getAttributeValue("ntotaltradenum");
    }
    
    public void setNtotaltradenum(UFDouble ntotaltradenum)
    {
        setAttributeValue("ntotaltradenum", ntotaltradenum);
    }
    
    public UFDouble getNtranslossnum()
    {
        return (UFDouble)getAttributeValue("ntranslossnum");
    }
    
    public void setNtranslossnum(UFDouble ntranslossnum)
    {
        setAttributeValue("ntranslossnum", ntranslossnum);
    }
    
    public UFDateTime getTs()
    {
        return (UFDateTime)getAttributeValue("ts");
    }
    
    public void setTs(UFDateTime ts)
    {
        setAttributeValue("ts", ts);
    }
    
    public IVOMeta getMetaData()
    {
        IVOMeta meta = VOMetaFactory.getInstance().getVOMeta("so.so_saleorder_exe");
        return meta;
    }
    
    public SoSaleorderExeVo()
    {
    }
    
    public static final String CSALEORDERBID = "csaleorderbid";
    public static final String DR = "dr";
    public static final String NARRANGEMONUM = "narrangemonum";
    public static final String NARRANGEPOAPPNUM = "narrangepoappnum";
    public static final String NARRANGEPONUM = "narrangeponum";
    public static final String NARRANGESCORNUM = "narrangescornum";
    public static final String NARRANGETOAPPNUM = "narrangetoappnum";
    public static final String NARRANGETOORNUM = "narrangetoornum";
    public static final String NORIGSUBMNY = "norigsubmny";
    public static final String NREQRSNUM = "nreqrsnum";
    public static final String NTOTALARMNY = "ntotalarmny";
    public static final String NTOTALARNUM = "ntotalarnum";
    public static final String NTOTALCOSTNUM = "ntotalcostnum";
    public static final String NTOTALESTARMNY = "ntotalestarmny";
    public static final String NTOTALESTARNUM = "ntotalestarnum";
    public static final String NTOTALINVOICENUM = "ntotalinvoicenum";
    public static final String NTOTALNOTOUTNUM = "ntotalnotoutnum";
    public static final String NTOTALOUTNUM = "ntotaloutnum";
    public static final String NTOTALPAYMNY = "ntotalpaymny";
    public static final String NTOTALPLONUM = "ntotalplonum";
    public static final String NTOTALRETURNNUM = "ntotalreturnnum";
    public static final String NTOTALRUSHNUM = "ntotalrushnum";
    public static final String NTOTALSENDNUM = "ntotalsendnum";
    public static final String NTOTALSIGNNUM = "ntotalsignnum";
    public static final String NTOTALTRADENUM = "ntotaltradenum";
    public static final String NTRANSLOSSNUM = "ntranslossnum";
    public static final String TS = "ts";
    public static final String METAPATH = "so_saleorder_exe.";
    

}
