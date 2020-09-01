package nc.ui.itf;

public abstract interface ISaleOrderSync {
	/**
	 * 销售订单同步接口
	 * @param params
	 * @return
	 */
	public abstract String ncSaleOrderSync(String paramsStr);
}
