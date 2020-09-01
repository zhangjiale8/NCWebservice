package nc.itf.Impl.dto;

import java.util.Date;

import nc.itf.Impl.entity.BdCustomer;

/**
 * <p>
 * �����շ�����Ϣ
 * </p>
 *
 * @author zhangjiale
 * @since 2020-05-14
 */

public class SaleOrderLogisticlin {

	//����
    private Long orderLogisticinNo;
    //��������
    private Long saleOrderNo;
    //�ƻ���������
    private Date planSendDtm;
    //��
    private Long takeCityNo;
    //��
    private Long takeDistrictNo;
    //ʡ
    private Long takeProvinceNo;
    //�ջ���ַ
    private String takeAreaVal;
    //Ҫ���ջ�����
    private Date demandTakeDtm;
    //�ջ��ͻ�
    private BdCustomer customerInfo;
    //�ջ���
    private String recieveUserId;
    //��ϵ��ʽ
    private String phoneVal;
    //ʵ�ʷ�������
    private Date actulSendDtm;
    //ʵ���ջ�����
    private Date actulTakeDtm;
    //��ע
    private String remarkDsc;
    //��
    private Long actulCityNo;
    //��
    private Long actulDistrictNo;
    //ʡ
    private Long actulProvinceNo;
    //ʵ���ջ���ַ
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
