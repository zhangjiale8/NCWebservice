package nc.itf.Impl.dto;

import nc.itf.Impl.entity.BdMaterial;
import nc.itf.Impl.entity.BdMaterialconvert;
import nc.itf.Impl.entity.BdMeasdoc;
import nc.itf.Impl.entity.BdTaxcode;

public class SaleOrderProdlin {
	//销售订单物料主键
	private String orderProdlinNo;
	//销售订单主键
	private String saleOrderNo;
	//物料
    private BdMaterial prodInfo;
    //计量单位
    private BdMeasdoc unitInfo;
    //辅助单位
    private BdMaterialconvert convertInfo;
    //物料数量
    private Double countVal;
    //含税单价
    private Double priceVal;
    //价税合计
    private Double amountVal;
    //无税单价
    private Double notaxPriceVal;
    //无税金额
    private Double notaxAmountVal;
    //折本汇率
    private Double costRateVal;
    //备注
    private String remarkDsc;
    //税率（%）
    private BdTaxcode taxRateInfo;
    private Double taxRateVal;
	public String getOrderProdlinNo() {
		return orderProdlinNo;
	}
	public void setOrderProdlinNo(String orderProdlinNo) {
		this.orderProdlinNo = orderProdlinNo;
	}
	public String getSaleOrderNo() {
		return saleOrderNo;
	}
	public void setSaleOrderNo(String saleOrderNo) {
		this.saleOrderNo = saleOrderNo;
	}
	
	public Double getCountVal() {
		return countVal;
	}
	public void setCountVal(Double countVal) {
		this.countVal = countVal;
	}
	public Double getPriceVal() {
		return priceVal;
	}
	public void setPriceVal(Double priceVal) {
		this.priceVal = priceVal;
	}
	public Double getAmountVal() {
		return amountVal;
	}
	public void setAmountVal(Double amountVal) {
		this.amountVal = amountVal;
	}
	public Double getNotaxPriceVal() {
		return notaxPriceVal;
	}
	public void setNotaxPriceVal(Double notaxPriceVal) {
		this.notaxPriceVal = notaxPriceVal;
	}
	public Double getNotaxAmountVal() {
		return notaxAmountVal;
	}
	public void setNotaxAmountVal(Double notaxAmountVal) {
		this.notaxAmountVal = notaxAmountVal;
	}
	public Double getCostRateVal() {
		return costRateVal;
	}
	public void setCostRateVal(Double costRateVal) {
		this.costRateVal = costRateVal;
	}
	public String getRemarkDsc() {
		return remarkDsc;
	}
	public void setRemarkDsc(String remarkDsc) {
		this.remarkDsc = remarkDsc;
	}

	public Double getTaxRateVal() {
		return taxRateVal;
	}
	public void setTaxRateVal(Double taxRateVal) {
		this.taxRateVal = taxRateVal;
	}
	
	public BdMaterial getProdInfo() {
		return prodInfo;
	}
	public void setProdInfo(BdMaterial prodInfo) {
		this.prodInfo = prodInfo;
	}
	public BdMeasdoc getUnitInfo() {
		return unitInfo;
	}
	public void setUnitInfo(BdMeasdoc unitInfo) {
		this.unitInfo = unitInfo;
	}
	
	public BdTaxcode getTaxRateInfo() {
		return taxRateInfo;
	}
	public void setTaxRateInfo(BdTaxcode taxRateInfo) {
		this.taxRateInfo = taxRateInfo;
	}
	
	public BdMaterialconvert getConvertInfo() {
		return convertInfo;
	}
	public void setConvertInfo(BdMaterialconvert convertInfo) {
		this.convertInfo = convertInfo;
	}
	public SaleOrderProdlin(BdMaterial prodInfo, BdMeasdoc unitInfo,BdMaterialconvert convertInfo,Double countVal, Double priceVal, Double amountVal,
			Double notaxPriceVal, Double notaxAmountVal, Double costRateVal,
			BdTaxcode taxRateInfo, Double taxRateVal,String remarkDsc) {
		super();
		this.prodInfo = prodInfo;
		this.unitInfo = unitInfo;
		this.convertInfo = convertInfo;
		this.countVal = countVal;
		this.priceVal = priceVal;
		this.amountVal = amountVal;
		this.notaxPriceVal = notaxPriceVal;
		this.notaxAmountVal = notaxAmountVal;
		this.costRateVal = costRateVal;
		this.remarkDsc = remarkDsc;
		this.taxRateInfo = taxRateInfo;
		this.taxRateVal = taxRateVal;
		
	}
	
	public SaleOrderProdlin() {
		super();
	}
	
	
    
}
