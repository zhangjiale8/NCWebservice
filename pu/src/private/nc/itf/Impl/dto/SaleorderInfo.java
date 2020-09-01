package nc.itf.Impl.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import nc.itf.Impl.entity.BdBilltype;
import nc.itf.Impl.entity.BdBusitype;
import nc.itf.Impl.entity.BdCurrtype;
import nc.itf.Impl.entity.BdCustomer;
import nc.itf.Impl.entity.BdPsndoc;
import nc.itf.Impl.entity.OrgDept;
import nc.itf.Impl.entity.OrgGroup;
import nc.itf.Impl.entity.OrgSalesorg;
import nc.itf.Impl.entity.SmUser;
import nc.itf.Impl.entity.SoSaleorder;

public class SaleorderInfo {
	//销售订单编号
	private String saleOrderNo;
	//NC销售订单
	private SoSaleorder soSaleorder;
	//单据类型
	private BdBilltype bdBilltype;
	//业务流程
	private BdBusitype serviceFlowInfo;
	//单据日期
	private Date saleOrderDtm;
	//单据状态
	private String validSta;
	//备注
	private String remarkDsc;
	//业务员
	private BdPsndoc saleUser;
	//手机
	private String phoneVal;
	//集团
	private OrgGroup groupInfo;
	//销售组织
	private OrgSalesorg saleOrgInfo;
	//部门
	private OrgDept deptInfo;
	//客户
	private BdCustomer customerInfo;
	//站点
	private BdCustomer stationInfo;
	//地址
	private String areaVal;
	//币种
	private BdCurrtype currencyInfo;
	//总数量
	private Double countSumVal;
	//总金额
	private Double amountsumval;
	//创建时间
	private Date createDtm;
	//最后修改时间
	private Date updatedtm;
	//创建人
	private SmUser createUserInfo;
	//最后更新人
	private SmUser updateUserInfo;
	
	//销售订单物料明细
	private List<SaleOrderProdlin> orderProdlins = new ArrayList<SaleOrderProdlin>();
	//收发货信息
	private SaleOrderLogisticlin saleOrderLogisticlin;
	
	public String getSaleOrderNo() {
		return saleOrderNo;
	}


	public void setSaleOrderNo(String saleOrderNo) {
		this.saleOrderNo = saleOrderNo;
	}


	public SoSaleorder getSoSaleorder() {
		return soSaleorder;
	}


	public void setSoSaleorder(SoSaleorder soSaleorder) {
		this.soSaleorder = soSaleorder;
	}


	public BdBilltype getBdBilltype() {
		return bdBilltype;
	}


	public void setBdBilltype(BdBilltype bdBilltype) {
		this.bdBilltype = bdBilltype;
	}

	public Date getSaleOrderDtm() {
		return saleOrderDtm;
	}


	public void setSaleOrderDtm(Date saleOrderDtm) {
		this.saleOrderDtm = saleOrderDtm;
	}


	public String getValidSta() {
		return validSta;
	}


	public void setValidSta(String validSta) {
		this.validSta = validSta;
	}


	public String getRemarkDsc() {
		return remarkDsc;
	}


	public void setRemarkDsc(String remarkDsc) {
		this.remarkDsc = remarkDsc;
	}


	public BdPsndoc getSaleUser() {
		return saleUser;
	}


	public void setSaleUser(BdPsndoc saleUser) {
		this.saleUser = saleUser;
	}


	public String getPhoneVal() {
		return phoneVal;
	}


	public void setPhoneVal(String phoneVal) {
		this.phoneVal = phoneVal;
	}


	public OrgGroup getGroupInfo() {
		return groupInfo;
	}


	public void setGroupInfo(OrgGroup groupInfo) {
		this.groupInfo = groupInfo;
	}


	public OrgSalesorg getSaleOrgInfo() {
		return saleOrgInfo;
	}


	public void setSaleOrgInfo(OrgSalesorg saleOrgInfo) {
		this.saleOrgInfo = saleOrgInfo;
	}


	public OrgDept getDeptInfo() {
		return deptInfo;
	}


	public void setDeptInfo(OrgDept deptInfo) {
		this.deptInfo = deptInfo;
	}


	public BdCustomer getCustomerInfo() {
		return customerInfo;
	}


	public void setCustomerInfo(BdCustomer customerInfo) {
		this.customerInfo = customerInfo;
	}


	public BdCustomer getStationInfo() {
		return stationInfo;
	}


	public void setStationInfo(BdCustomer stationInfo) {
		this.stationInfo = stationInfo;
	}


	public String getAreaVal() {
		return areaVal;
	}


	public void setAreaVal(String areaVal) {
		this.areaVal = areaVal;
	}


	public BdCurrtype getCurrencyInfo() {
		return currencyInfo;
	}


	public void setCurrencyInfo(BdCurrtype currencyInfo) {
		this.currencyInfo = currencyInfo;
	}


	public Double getCountSumVal() {
		return countSumVal;
	}


	public void setCountSumVal(Double countSumVal) {
		this.countSumVal = countSumVal;
	}


	public Double getAmountsumval() {
		return amountsumval;
	}


	public void setAmountsumval(Double amountsumval) {
		this.amountsumval = amountsumval;
	}


	public Date getCreateDtm() {
		return createDtm;
	}


	public void setCreateDtm(Date createDtm) {
		this.createDtm = createDtm;
	}


	public Date getUpdatedtm() {
		return updatedtm;
	}


	public void setUpdatedtm(Date updatedtm) {
		this.updatedtm = updatedtm;
	}


	public SmUser getCreateUserInfo() {
		return createUserInfo;
	}


	public void setCreateUserInfo(SmUser createUserInfo) {
		this.createUserInfo = createUserInfo;
	}


	public SmUser getUpdateUserInfo() {
		return updateUserInfo;
	}


	public void setUpdateUserInfo(SmUser updateUserInfo) {
		this.updateUserInfo = updateUserInfo;
	}


	public List<SaleOrderProdlin> getOrderProdlins() {
		return orderProdlins;
	}


	public void setOrderProdlins(List<SaleOrderProdlin> orderProdlins) {
		this.orderProdlins = orderProdlins;
	}


	public SaleOrderLogisticlin getSaleOrderLogisticlin() {
		return saleOrderLogisticlin;
	}


	public void setSaleOrderLogisticlin(SaleOrderLogisticlin saleOrderLogisticlin) {
		this.saleOrderLogisticlin = saleOrderLogisticlin;
	}
	

	public BdBusitype getServiceFlowInfo() {
		return serviceFlowInfo;
	}


	public void setServiceFlowInfo(BdBusitype serviceFlowInfo) {
		this.serviceFlowInfo = serviceFlowInfo;
	}


	public SaleorderInfo(String saleOrderNo, SoSaleorder soSaleorder,
			BdBilltype bdBilltype,BdBusitype serviceFlowInfo, Date saleOrderDtm,
			String validSta, String remarkDsc, BdPsndoc saleUser,
			String phoneVal, OrgGroup groupInfo, OrgSalesorg saleOrgInfo,
			OrgDept deptInfo, BdCustomer customerInfo, BdCustomer stationInfo,
			String areaVal, BdCurrtype currencyInfo, Double countSumVal,
			Double amountsumval, List<SaleOrderProdlin> orderProdlins,
			SaleOrderLogisticlin saleOrderLogisticlin) {
		super();
		this.saleOrderNo = saleOrderNo;
		this.soSaleorder = soSaleorder;
		this.bdBilltype = bdBilltype;
		this.serviceFlowInfo = serviceFlowInfo;
		this.saleOrderDtm = saleOrderDtm;
		this.validSta = validSta;
		this.remarkDsc = remarkDsc;
		this.saleUser = saleUser;
		this.phoneVal = phoneVal;
		this.groupInfo = groupInfo;
		this.saleOrgInfo = saleOrgInfo;
		this.deptInfo = deptInfo;
		this.customerInfo = customerInfo;
		this.stationInfo = stationInfo;
		this.areaVal = areaVal;
		this.currencyInfo = currencyInfo;
		this.countSumVal = countSumVal;
		this.amountsumval = amountsumval;
		this.orderProdlins = orderProdlins;
		this.saleOrderLogisticlin = saleOrderLogisticlin;
	}


	public SaleorderInfo() {
		super();
	}
	
	
	
}
