package nc.itf.Impl.dto;

import java.util.Date;

import nc.itf.Impl.entity.BdCustomer;

/**
 * <p>
 * 关联收发货信息
 * </p>
 *
 * @author zhangjiale
 * @since 2020-05-14
 */

public class SaleOrderLogisticlin {

	//主键
    private Long orderLogisticinNo;
    //主表主键
    private Long saleOrderNo;
    //计划发货日期
    private Date planSendDtm;
    //市
    private Long takeCityNo;
    //区
    private Long takeDistrictNo;
    //省
    private Long takeProvinceNo;
    //收货地址
    private String takeAreaVal;
    //要求收货日期
    private Date demandTakeDtm;
    //收货客户
    private BdCustomer customerInfo;
    //收货人
    private String recieveUserId;
    //联系方式
    private String phoneVal;
    //实际发货日期
    private Date actulSendDtm;
    //实际收货日期
    private Date actulTakeDtm;
    //备注
    private String remarkDsc;
    //市
    private Long actulCityNo;
    //区
    private Long actulDistrictNo;
    //省
    private Long actulProvinceNo;
    //实际收货地址
    private String actulAreaVal;
    
	public Long getOrderLogisticinNo() {
		return orderLogisticinNo;
	}
	public void setOrderLogisticinNo(Long orderLogisticinNo) {
		this.orderLogisticinNo = orderLogisticinNo;
	}
	public Long getSaleOrderNo() {
		return saleOrderNo;
	}
	public void setSaleOrderNo(Long saleOrderNo) {
		this.saleOrderNo = saleOrderNo;
	}
	public Date getPlanSendDtm() {
		return planSendDtm;
	}
	public void setPlanSendDtm(Date planSendDtm) {
		this.planSendDtm = planSendDtm;
	}
	public Long getTakeCityNo() {
		return takeCityNo;
	}
	public void setTakeCityNo(Long takeCityNo) {
		this.takeCityNo = takeCityNo;
	}
	public Long getTakeDistrictNo() {
		return takeDistrictNo;
	}
	public void setTakeDistrictNo(Long takeDistrictNo) {
		this.takeDistrictNo = takeDistrictNo;
	}
	public Long getTakeProvinceNo() {
		return takeProvinceNo;
	}
	public void setTakeProvinceNo(Long takeProvinceNo) {
		this.takeProvinceNo = takeProvinceNo;
	}
	public String getTakeAreaVal() {
		return takeAreaVal;
	}
	public void setTakeAreaVal(String takeAreaVal) {
		this.takeAreaVal = takeAreaVal;
	}
	public Date getDemandTakeDtm() {
		return demandTakeDtm;
	}
	public void setDemandTakeDtm(Date demandTakeDtm) {
		this.demandTakeDtm = demandTakeDtm;
	}
	
	public String getRecieveUserId() {
		return recieveUserId;
	}
	public void setRecieveUserId(String recieveUserId) {
		this.recieveUserId = recieveUserId;
	}
	public String getPhoneVal() {
		return phoneVal;
	}
	public void setPhoneVal(String phoneVal) {
		this.phoneVal = phoneVal;
	}
	public Date getActulSendDtm() {
		return actulSendDtm;
	}
	public void setActulSendDtm(Date actulSendDtm) {
		this.actulSendDtm = actulSendDtm;
	}
	public Date getActulTakeDtm() {
		return actulTakeDtm;
	}
	public void setActulTakeDtm(Date actulTakeDtm) {
		this.actulTakeDtm = actulTakeDtm;
	}
	public String getRemarkDsc() {
		return remarkDsc;
	}
	public void setRemarkDsc(String remarkDsc) {
		this.remarkDsc = remarkDsc;
	}
	public Long getActulCityNo() {
		return actulCityNo;
	}
	public void setActulCityNo(Long actulCityNo) {
		this.actulCityNo = actulCityNo;
	}
	public Long getActulDistrictNo() {
		return actulDistrictNo;
	}
	public void setActulDistrictNo(Long actulDistrictNo) {
		this.actulDistrictNo = actulDistrictNo;
	}
	public Long getActulProvinceNo() {
		return actulProvinceNo;
	}
	public void setActulProvinceNo(Long actulProvinceNo) {
		this.actulProvinceNo = actulProvinceNo;
	}
	public String getActulAreaVal() {
		return actulAreaVal;
	}
	public void setActulAreaVal(String actulAreaVal) {
		this.actulAreaVal = actulAreaVal;
	}
	
	public BdCustomer getCustomerInfo() {
		return customerInfo;
	}
	public void setCustomerInfo(BdCustomer customerInfo) {
		this.customerInfo = customerInfo;
	}
	public SaleOrderLogisticlin() {
		super();
	}
	public SaleOrderLogisticlin(Date planSendDtm, String takeAreaVal,
			Date demandTakeDtm, BdCustomer customerInfo,
			String recieveUserId, String phoneVal,
			Date actulSendDtm, Date actulTakeDtm, String remarkDsc,
			String actulAreaVal) {
		super();
		this.planSendDtm = planSendDtm;
		this.takeAreaVal = takeAreaVal;
		this.demandTakeDtm = demandTakeDtm;
		this.customerInfo = customerInfo;
		this.recieveUserId = recieveUserId;
		this.phoneVal = phoneVal;
		this.actulSendDtm = actulSendDtm;
		this.actulTakeDtm = actulTakeDtm;
		this.remarkDsc = remarkDsc;
		this.actulAreaVal = actulAreaVal;
	}	
	
    
}
