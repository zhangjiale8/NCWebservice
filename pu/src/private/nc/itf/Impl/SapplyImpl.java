package nc.itf.Impl;

import config.SystemConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import nc.bs.dao.BaseDAO;
import nc.bs.dao.DAOException;
import nc.bs.framework.common.InvocationInfoProxy;
import nc.bs.framework.common.NCLocator;
import nc.bs.logging.Logger;
import nc.itf.scmpub.reference.uap.bd.vat.VATInfoVO;
import nc.itf.uap.pf.IPFBusiAction;
import nc.jdbc.framework.processor.ColumnProcessor;
import nc.jdbc.framework.processor.MapListProcessor;
import nc.pub.billcode.itf.IBillcodeManage;
import nc.ui.itf.SapplyItf;
import nc.vo.am.proxy.AMProxy;
import nc.vo.ic.m4d.entity.MaterialOutBodyVO;
import nc.vo.ic.m4d.entity.MaterialOutHeadVO;
import nc.vo.ic.m4d.entity.MaterialOutVO;
import nc.vo.pub.BusinessException;
import nc.vo.pub.lang.UFBoolean;
import nc.vo.pub.lang.UFDate;
import nc.vo.pub.lang.UFDateTime;
import nc.vo.pub.lang.UFDouble;
import nc.vo.pubapp.pattern.pub.PubAppTool;
import nc.vo.so.m30.entity.SaleOrderBVO;
import nc.vo.so.m30.entity.SaleOrderHVO;
import nc.vo.so.m30.entity.SaleOrderVO;
import nc.vo.so.pub.keyvalue.IKeyRela;
import nc.vo.so.pub.keyvalue.IKeyValue;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class SapplyImpl implements SapplyItf {
	public String Sapply(String json) {
		Logger.error("获得数据:" + json);
		String ret_message = "";
		JSONObject fromObject = JSONObject.fromObject(json);
		BaseDAO dao = new BaseDAO(SystemConfig.getInstance().getDatasource());
		JSONArray josnArray = fromObject.getJSONArray("headinfo");
		for (int i = 0; i < josnArray.size(); i++) {
			JSONObject hjo = (JSONObject) josnArray.get(i);

			String ctrantypeid_one = hjo.getString("ctrantypeid");
			if ("".equals(ctrantypeid_one)) {
				ret_message = "{\"result\":\"0\",\"message\":\"出入库类型为空。\"}";
				return ret_message;
			}
			String pk_billtypecode = "";
			String sql_pk_billtypecode = "select pk_billtypecode from bd_billtype where pk_billtypeid ='"
					+ ctrantypeid_one
					+ "' and (ISLOCK = 'N' OR ISLOCK is null ) ";
			try {
				pk_billtypecode = getString(dao.executeQuery(
						sql_pk_billtypecode, new ColumnProcessor()));
			} catch (DAOException e2) {
				e2.printStackTrace();
				return "{\"result\":\"0\",\"message\":\"" + e2.getMessage()
						+ "\"}";
			}

			if ("".equals(pk_billtypecode)) {
				ret_message = "{\"result\":\"0\",\"message\":\"订单类型在NC中不存在。\"}";
				return ret_message;
			}

			if (pk_billtypecode.substring(0, 2).equals("4D")) {
				ret_message = InsertDate4D(hjo);
				return ret_message;
			}

			if (pk_billtypecode.substring(0, 2).equals("30")) {
				ret_message = InsertDate30(hjo);
				return ret_message;
			}
		}

		return ret_message;
	}

	public String InsertDate4D(JSONObject hjo) {
		BaseDAO dao = new BaseDAO(SystemConfig.getInstance().getDatasource());
		String ret_message = "";

		String ordernumber = hjo.getString("ordernumber");
		if ("".equals(ordernumber)) {
			ret_message = "{\"result\":\"0\",\"message\":\"钉钉流水号为空。\"}";
			return ret_message;
		}
		String sql_ordernumber1 = " select cgeneralhid,vdef10 from ic_material_h where vdef10 = '"
				+ ordernumber + "' and dr=0 ";
		String sql_ordernumber2 = " select csaleorderid,vdef20 from so_saleorder where vdef20 = '"
				+ ordernumber + "' and dr=0 ";

		ArrayList list_sql_ordernumber1 = new ArrayList();
		ArrayList list_sql_ordernumber2 = new ArrayList();
		try {
			list_sql_ordernumber1 = (ArrayList) dao.executeQuery(
					sql_ordernumber1, new MapListProcessor());
			list_sql_ordernumber2 = (ArrayList) dao.executeQuery(
					sql_ordernumber2, new MapListProcessor());
			if ((list_sql_ordernumber1.size() != 0)
					|| (list_sql_ordernumber2.size() != 0)) {
			}
			return "{\"result\":\"0\",\"message\":\"钉钉流水号：" + ordernumber
					+ "已经在NC中发起流程,不可以发起出库申请。\"}";
		} catch (DAOException e) {
			e.printStackTrace();

			String coutstockorgid = hjo.getString("coutstockorgid");
			String coutstordocid = hjo.getString("coutstordocid");
			String ctrantypeid = hjo.getString("ctrantypeid");
			String cdeptid = hjo.getString("cdeptid");
			String vdef2 = hjo.getString("vdef2");
			String creator = hjo.getString("creator");
			String dbilldate = hjo.getString("dbilldate");
			String vnote = hjo.getString("vnote");

			ret_message = headinfoNull(coutstockorgid, coutstordocid,
					ctrantypeid, cdeptid, creator);
			if (!"".equals(ret_message)) {
				return ret_message;
			}

			String pk_stockorg = "";
			String pk_stockorg_v = "";
			String sql_org = "select pk_stockorg,pk_vid from org_stockorg where pk_stockorg ='"
					+ coutstockorgid + "' and dr=0";
			ArrayList list_sql_org = new ArrayList();
			try {
				list_sql_org = (ArrayList) dao.executeQuery(sql_org,
						new MapListProcessor());
				if (list_sql_org.size() != 0) {
					for (int k = 0; k < list_sql_org.size(); k++) {
						Map map_list_sql_org = (Map) list_sql_org.get(k);
						pk_stockorg = String.valueOf(map_list_sql_org
								.get("pk_stockorg"));
						pk_stockorg_v = String.valueOf(map_list_sql_org
								.get("pk_vid"));
					}
				}
			} catch (DAOException e2) {
				e2.printStackTrace();
			}

			String sql_st = "select pk_billtypeid from bd_billtype where (ISLOCK = 'N' OR ISLOCK is null ) AND PK_BILLTYPECODE LIKE '4D%' and pk_group='0001A1100000000012WE' and pk_billtypeid  ='"
					+ ctrantypeid + "' ";
			try {
				ctrantypeid = getString(dao.executeQuery(sql_st,
						new ColumnProcessor()));
				if (ctrantypeid.length() == 0) {
				}
				return "{\"result\":\"0\",\"message\":\"出入库类型ctrantypeid在erp系统中没有检索到.\"}";
			} catch (DAOException e2) {
				e2.printStackTrace();

				String sql_pk_stordoc = "select pk_stordoc from bd_stordoc where pk_stordoc ='"
						+ coutstordocid + "' and dr=0";
				try {
					coutstordocid = getString(dao.executeQuery(sql_pk_stordoc,
							new ColumnProcessor()));
					if (coutstordocid.length() == 0) {
					}
					return "{\"result\":\"0\",\"message\":\"仓库cwarehouseid在erp系统中没有检索到.\"}";
				} catch (DAOException e21) {
					e21.printStackTrace();

					String cdeptvid = "";
					String sql_stm = "select pk_vid from org_dept where pk_dept ='"
							+ cdeptid + "' and dr=0";
					String pk_group;
					String cuserid;
					try {
						cdeptvid = getString(dao.executeQuery(sql_stm,
								new ColumnProcessor()));
						if (cdeptvid.length() == 0) {
						}
						return "{\"result\":\"0\",\"message\":\"领料部门cdptvid在erp系统中没有检索到.\"}";
					} catch (DAOException e211) {
						e211.printStackTrace();

						pk_group = "";
						String sql_group = "select pk_group from org_group where code ='01' and dr=0";
						try {
							pk_group = getString(dao.executeQuery(sql_group,
									new ColumnProcessor()));
						} catch (DAOException e2111) {
							e2111.printStackTrace();
						}

						String sql_sm_user = "select cuserid from sm_user where user_code ='"
								+ creator + "' and enablestate = 2 ";
						ArrayList list_sql_sm_user = querySQL(sql_sm_user);
						cuserid = "";
						if (list_sql_sm_user.size() != 0) {
							for (int s = 0; s < list_sql_sm_user.size(); s++) {
								Map map_list_sql_sm_user = (Map) list_sql_sm_user
										.get(s);
								cuserid = String.valueOf(map_list_sql_sm_user
										.get("cuserid"));
							}

						} else {
							return "{\"result\":\"0\",\"message\":\"创建人在NC系统中没有检索到。\"}";
						}
					}

					String sql_ccustomerid = " select isfreecust,pk_customer from bd_customer where pk_customer = '"
							+ vdef2 + "' and enablestate = 2 ";
					ArrayList list_sql_ccustomerid = new ArrayList();
					String pk_customer = "";
					try {
						list_sql_ccustomerid = (ArrayList) dao.executeQuery(
								sql_ccustomerid, new MapListProcessor());
						if (list_sql_ccustomerid.size() != 0) {
							for (int w = 0; w < list_sql_ccustomerid.size(); w++) {
								Map map_list_sql_ccustomerid = (Map) list_sql_ccustomerid
										.get(w);
								pk_customer = String
										.valueOf(map_list_sql_ccustomerid
												.get("pk_customer"));
							}
						}
					} catch (DAOException e4) {
						e4.printStackTrace();
					}

					MaterialOutHeadVO hvos = new MaterialOutHeadVO();
					hvos.setVdef2(pk_customer);
					hvos.setVdef10(ordernumber);
					hvos.setPk_group(pk_group);
					hvos.setPk_org(pk_stockorg);
					hvos.setPk_org_v(pk_stockorg_v);
					hvos.setDbilldate(new UFDate(dbilldate));
					hvos.setVnote(vnote);
					hvos.setCtrantypeid(ctrantypeid);
					hvos.setCwarehouseid(coutstordocid);
					hvos.setCdptid(cdeptid);
					hvos.setCdptvid(cdeptvid);
					hvos.setCreator(cuserid);
					hvos.setCreationtime(new UFDateTime());
					hvos.setBillmaker(cuserid);
					hvos.setDmakedate(new UFDate());
					hvos.setTs(new UFDateTime());
					hvos.setCdrawcalbodyoid(pk_stockorg);
					hvos.setCdrawcalbodyvid(pk_stockorg_v);
					hvos.setCdrawwarehouseid(coutstordocid);

					String sql_org_cr_stockstore = "select * from org_cr_stockstore where pk_stockorg = '"
							+ pk_stockorg
							+ "' and pk_storage = '"
							+ coutstordocid + "'";
					ArrayList list_sql_org_cr_stockstore = new ArrayList();
					try {
						list_sql_org_cr_stockstore = (ArrayList) dao
								.executeQuery(sql_org_cr_stockstore,
										new MapListProcessor());
						if (list_sql_org_cr_stockstore.size() != 0) {
							for (int y = 0; y < list_sql_org_cr_stockstore
									.size(); y++) {
								Map map_list_sql_org_cr_stockstore = (Map) list_sql_org_cr_stockstore
										.get(y);
								String pk_costregion = String
										.valueOf(map_list_sql_org_cr_stockstore
												.get("pk_costregion"));
								hvos.setCcostdomainoid(pk_costregion);
							}
						}
					} catch (DAOException e3) {
						e3.printStackTrace();
					}

					String sqlorgd = "select pk_corp,pk_vid from org_corp where pk_corp in ( select pk_financeorg from org_stockorg where pk_stockorg='"
							+ pk_stockorg + "')";
					ArrayList list_corp = new ArrayList();
					String Corpoid = "";
					String Corpvid = "";
					try {
						list_corp = (ArrayList) dao.executeQuery(sqlorgd,
								new MapListProcessor());
					} catch (DAOException e111) {
						e111.printStackTrace();
					}
					if (list_corp.size() != 0) {
						for (int r = 0; r < list_corp.size(); r++) {
							Map map_corp = (Map) list_corp.get(r);
							Corpoid = String.valueOf(map_corp.get("pk_corp"));
							Corpvid = String.valueOf(map_corp.get("pk_vid"));
							hvos.setCorpoid(Corpoid);
							hvos.setCorpvid(Corpvid);
						}
					}

					String sql_pk_financeorg = "select pk_financeorg,pk_vid from org_financeorg where pk_financeorg =( select pk_financeorg from org_stockorg where pk_stockorg='"
							+ pk_stockorg + "')";
					ArrayList list_sql_pk_financeorg = new ArrayList();
					String pk_financeorg = "";
					String pk_financeorg_v = "";
					try {
						list_sql_pk_financeorg = (ArrayList) dao.executeQuery(
								sql_pk_financeorg, new MapListProcessor());
						if (list_sql_pk_financeorg.size() != 0) {
							for (int r = 0; r < list_sql_pk_financeorg.size(); r++) {
								Map map_list_sql_pk_financeorg = (Map) list_sql_pk_financeorg
										.get(r);
								pk_financeorg = String
										.valueOf(map_list_sql_pk_financeorg
												.get("pk_financeorg"));
								pk_financeorg_v = String
										.valueOf(map_list_sql_pk_financeorg
												.get("pk_vid"));
								hvos.setCorpoid(pk_financeorg);
								hvos.setCorpvid(pk_financeorg_v);
							}
						}
					} catch (DAOException e1) {
						e1.printStackTrace();
					}

					hvos.setFbillflag(new Integer(2));
					hvos.setIprintcount(new Integer(0));
					hvos.setNtotalnum(new UFDouble(0));
					hvos.setNtotalweight(new UFDouble(0));

					String vtrantypecode = "";
					String vtr = "select  pk_billtypecode from bd_billtype where pk_billtypeid ='"
							+ ctrantypeid
							+ "' and (ISLOCK = 'N' OR ISLOCK is null )";
					try {
						vtrantypecode = getString(dao.executeQuery(vtr,
								new ColumnProcessor()));
					} catch (DAOException e6) {
						e6.printStackTrace();
					}

					hvos.setVtrantypecode(vtrantypecode);

					int countrow = 0;
					UFDouble totalnnum = new UFDouble(0);
					JSONArray bjosnArray = hjo.getJSONArray("detail");
					MaterialOutBodyVO[] bvos = new MaterialOutBodyVO[bjosnArray
							.size()];
					for (int j = 0; j < bjosnArray.size(); j++) {
						JSONObject bjo = bjosnArray.getJSONObject(j);
						String pk_material = bjo.getString("cmaterialid");
						String vbnote = bjo.getString("vbnote");
						if (("".equals(pk_material.trim()))
								|| (pk_material.trim().equals("null"))
								|| (pk_material.trim().equals(null))) {
							return "{\"result\":\"0\",\"message\":\"物料编码cmaterialvid不能为空.\"}";
						}

						String sql_cin = "select pk_material from bd_material where pk_material='"
								+ pk_material + "' and dr = 0";
						try {
							pk_material = getString(dao.executeQuery(sql_cin,
									new ColumnProcessor()));
							if (pk_material.length() == 0) {
							}
							return "{\"result\":\"0\",\"message\":\"物料编码cmaterialvid在erp系统中没有检索到.\"}";
						} catch (DAOException e7) {
							e7.printStackTrace();

							String nnum = bjo.getString("nnum");
							if (("".equals(nnum.trim()))
									|| (nnum.trim().equals("null"))
									|| (nnum.trim().equals(null))) {
								return "{\"result\":\"0\",\"message\":\" 实发主数量nnum不能为空.\"}";
							}

							MaterialOutBodyVO bvo = new MaterialOutBodyVO();
							countrow += 10;
							bvo.setCrowno(String.valueOf(countrow));
							bvo.setCmaterialoid(pk_material);
							bvo.setCmaterialvid(pk_material);
							bvo.setVnotebody(vbnote);

							String sql_unitid = "select pk_measdoc from bd_material where pk_material = '"
									+ pk_material + "'";
							String unitid = "";
							try {
								unitid = getString(dao.executeQuery(sql_unitid,
										new ColumnProcessor()));
								bvo.setCunitid(unitid);
							} catch (DAOException e9) {
								e9.printStackTrace();
								return "{\"result\":\"0\",\"message\":\""
										+ e.toString() + "\"}";
							}

							String sql_castunitid = "select measrate,pk_measdoc from bd_materialconvert where pk_material = '"
									+ pk_material + "'";
							String measrate = "";
							ArrayList list_sql_castunitid = new ArrayList();
							try {
								list_sql_castunitid = (ArrayList) dao
										.executeQuery(sql_castunitid,
												new MapListProcessor());
								if (list_sql_castunitid.size() != 0) {
									for (int t = 0; t < list_sql_castunitid
											.size(); t++) {
										Map map_list_sql_castunitid = (Map) list_sql_castunitid
												.get(t);
										measrate = String
												.valueOf(map_list_sql_castunitid
														.get("measrate"));
										String castunitid = String
												.valueOf(map_list_sql_castunitid
														.get("pk_measdoc"));
										bvo.setCastunitid(castunitid);
									}
								}
							} catch (DAOException e10) {
								e10.printStackTrace();
								return "{\"result\":\"0\",\"message\":\""
										+ e.toString() + "\"}";
							}

							bvo.setVchangerate(measrate);
							String[] str = new String[2];
							str = measrate.split("/");
							bvo.setNnum(new UFDouble(nnum));
							bvo.setNshouldnum(new UFDouble(nnum));
							UFDouble nassistnum = new UFDouble(nnum).multiply(
									new UFDouble(str[1])).div(
									new UFDouble(str[0]));
							bvo.setNassistnum(nassistnum);
							bvo.setNshouldassistnum(nassistnum);
							totalnnum = totalnnum.add(nassistnum);

							bvo.setTs(new UFDateTime());
							bvo.setDbizdate(new UFDate());
							bvo.setPk_org(pk_stockorg);
							bvo.setPk_org_v(pk_stockorg_v);
							bvo.setPk_group(pk_group);
							bvo.setBassetcard(new UFBoolean("N"));
							bvo.setBbarcodeclose(new UFBoolean("N"));
							bvo.setBonroadflag(new UFBoolean("N"));
							bvo.setCbodytranstypecode(vtrantypecode);
							bvo.setCbodywarehouseid(coutstordocid);
							bvo.setCorpoid(Corpoid);
							bvo.setCorpvid(Corpvid);
							bvo.setDbizdate(new UFDate());
							bvo.setPseudoColumn(new Integer(0));

							bvo.setBcseal(new UFBoolean(false));

							bvos[j] = bvo;
						}
					}

					hvos.setNtotalnum(new UFDouble(totalnnum));

					MaterialOutVO vos3 = new MaterialOutVO();
					vos3.setParent(hvos);
					String vbillcode = "";
					try {
						vbillcode = getPreBillCode5("4D", pk_group,
								"00000000000000000000", vos3);
					} catch (BusinessException e1) {
						e1.printStackTrace();
						return "{\"result\":\"0\",\"message\":\""
								+ e1.toString() + "\"}";
					}

					hvos.setVbillcode(vbillcode);

					MaterialOutVO avo = new MaterialOutVO();
					avo.setParentVO(hvos);
					avo.setChildrenVO(bvos);
					InvocationInfoProxy.getInstance().setGroupId(
							hvos.getPk_group());
					InvocationInfoProxy.getInstance().setUserId(
							hvos.getCreator());
					HashMap eParam1_er = new HashMap();
					eParam1_er.put("notechecked", "notechecked");
					eParam1_er.put("nc.bs.scmpub.pf.ORIGIN_VO_PARAMETER",
							new MaterialOutVO[] { avo });
					IPFBusiAction pfaction_er = (IPFBusiAction) NCLocator
							.getInstance()
							.lookup(IPFBusiAction.class.getName());
					try {
						pfaction_er.processAction("WRITE", "N_4D_WRITE", null,
								avo, null, eParam1_er);

						return "{\"result\":\"1\",\"message\":\"" + vbillcode
								+ "\"}";
					} catch (Exception er) {
						er.printStackTrace();
						ret_message = "{\"result\":\"0\",\"message\":\""
								+ er.getMessage() + "\"}";
					}
				}
			}
		}
		return ret_message;
	}

	public String InsertDate30(JSONObject hjo) {
		BaseDAO dao = new BaseDAO(SystemConfig.getInstance().getDatasource());
		String ret_message = "";

		String ordernumber = hjo.getString("ordernumber");
		if ("".equals(ordernumber)) {
			ret_message = "{\"result\":\"0\",\"message\":\"钉钉流水号为空。\"}";
			return ret_message;
		}
		String sql_ordernumber1 = " select cgeneralhid,vdef10 from ic_material_h where vdef10 = '"
				+ ordernumber + "' and dr=0 ";
		String sql_ordernumber2 = " select csaleorderid,vdef20 from so_saleorder where vdef20 = '"
				+ ordernumber + "' and dr=0 ";

		ArrayList list_sql_ordernumber1 = new ArrayList();
		ArrayList list_sql_ordernumber2 = new ArrayList();
		String pk_salesorg;
		String ctrantypeid;
		String ccustomerid;
		String vdef2;
		String cemployeeid;
		String cdeptid;
		String creator;
		String vnote;
		String dbilldate;
		String vdef3;
		String isfreecust;
		try {
			list_sql_ordernumber1 = (ArrayList) dao.executeQuery(
					sql_ordernumber1, new MapListProcessor());
			list_sql_ordernumber2 = (ArrayList) dao.executeQuery(
					sql_ordernumber2, new MapListProcessor());
			if ((list_sql_ordernumber1.size() != 0)
					|| (list_sql_ordernumber2.size() != 0)) {
			}
			return "{\"result\":\"0\",\"message\":\"钉钉流水号：" + ordernumber
					+ "已经在NC中发起流程,不可以发起出库申请。\"}";
		} catch (DAOException e) {
			e.printStackTrace();

			pk_salesorg = hjo.getString("pk_salesorg");
			ctrantypeid = hjo.getString("ctrantypeid");
			ccustomerid = hjo.getString("ccustomerid");
			vdef2 = hjo.getString("vdef2");

			cemployeeid = hjo.getString("cemployeeid");
			cdeptid = hjo.getString("cdeptid");
			creator = hjo.getString("creator");
			vnote = hjo.getString("vnote");
			dbilldate = hjo.getString("dbilldate");

			vdef3 = hjo.getString("area");

			ret_message = headinfoNull30(pk_salesorg, ctrantypeid, ccustomerid,
					cemployeeid, cdeptid, creator);
			if (!"".equals(ret_message)) {
				return ret_message;
			}

			String sql_pk_salesorg = "select pk_salesorg from  org_salesorg where pk_salesorg='"
					+ pk_salesorg + "' and dr=0";
			ArrayList list_sql_pk_salesorg = querySQL(sql_pk_salesorg);
			if (list_sql_pk_salesorg.size() == 0) {
				return "{\"result\":\"0\",\"message\":\"销售组织在NC系统中没有检索到。\"}";
			}

			String sql_pk_billtypeid = "select pk_billtypeid from bd_billtype where pk_billtypeid ='"
					+ ctrantypeid + "' and (ISLOCK = 'N' OR ISLOCK is null )";
			ArrayList list_sql_pk_billtypeid = querySQL(sql_pk_billtypeid);
			if (list_sql_pk_billtypeid.size() == 0) {
				return "{\"result\":\"0\",\"message\":\"订单类型在NC系统中没有检索到。\"}";
			}

			String sql_pk_customer = "select isfreecust,pk_customer from bd_customer where pk_customer='"
					+ ccustomerid + "' and dr=0";
			ArrayList list_sql_pk_customer = querySQL(sql_pk_customer);
			isfreecust = "";
			if (list_sql_pk_customer.size() != 0) {
				for (int p = 0; p < list_sql_pk_customer.size(); p++) {
					Map map_list_sql_pk_customer = (Map) list_sql_pk_customer
							.get(p);
					isfreecust = String.valueOf(map_list_sql_pk_customer
							.get("isfreecust"));
				}

			} else {
				return "{\"result\":\"0\",\"message\":\"客户在NC系统中没有检索到。\"}";
			}
		}

		String corigcurrencyid = "";
		String sql_pk_currtype = "select pk_currtype from  bd_currtype where code='CNY' and dr=0";
		try {
			corigcurrencyid = getString(dao.executeQuery(sql_pk_currtype,
					new ColumnProcessor()));
		} catch (DAOException e2) {
			e2.printStackTrace();
		}

		String sql_pk_psndoc = "select pk_psndoc from bd_psndoc where pk_psndoc='"
				+ cemployeeid + "' and dr=0";
		ArrayList list_sql_pk_psndoc = querySQL(sql_pk_psndoc);
		if (list_sql_pk_psndoc.size() == 0) {
			ret_message = "{\"result\":\"0\",\"message\":\"业务员在NC系统中没有检索到。\"}";
			return ret_message;
		}

		String pk_group = "";
		String sql_group = "select pk_group from org_salesorg where pk_salesorg='"
				+ pk_salesorg + "' and dr=0";
		try {
			pk_group = getString(dao.executeQuery(sql_group,
					new ColumnProcessor()));
		} catch (DAOException e2) {
			e2.printStackTrace();
		}

		String pk_salesorg_v = "";
		String sql_pk_salesorg_v = "select pk_salesorg,pk_vid from org_salesorg where pk_salesorg ='"
				+ pk_salesorg + "' and dr=0";
		ArrayList list_sql_pk_salesorg_v = querySQL(sql_pk_salesorg_v);
		if (list_sql_pk_salesorg_v.size() != 0) {
			for (int u = 0; u < list_sql_pk_salesorg_v.size(); u++) {
				Map map_list_sql_pk_salesorg_v = (Map) list_sql_pk_salesorg_v
						.get(u);
				pk_salesorg = String.valueOf(map_list_sql_pk_salesorg_v
						.get("pk_salesorg"));
				pk_salesorg_v = String.valueOf(map_list_sql_pk_salesorg_v
						.get("pk_vid"));
			}
		} else {
			ret_message = "{\"result\":\"0\",\"message\":\"销售组织在NC系统中没有检索到。\"}";
			return ret_message;
		}

		String sql_sm_user = "select cuserid from sm_user where user_code ='"
				+ creator + "' and enablestate = 2 ";
		ArrayList list_sql_sm_user = querySQL(sql_sm_user);
		String cuserid = "";
		if (list_sql_sm_user.size() != 0) {
			for (int s = 0; s < list_sql_sm_user.size(); s++) {
				Map map_list_sql_sm_user = (Map) list_sql_sm_user.get(s);
				cuserid = String.valueOf(map_list_sql_sm_user.get("cuserid"));
			}
		} else {
			ret_message = "{\"result\":\"0\",\"message\":\"创建人在NC系统中没有检索到。\"}";
			return ret_message;
		}

		String sql_dept = "select pk_dept,pk_vid from org_dept where pk_dept='"
				+ cdeptid + "' and dr=0 and enablestate = 2";
		ArrayList list_sql_dept = querySQL(sql_dept);
		String pk_dept = "";
		String pk_dept_v = "";
		if (list_sql_dept.size() != 0) {
			for (int y = 0; y < list_sql_dept.size(); y++) {
				Map map_list_sql_dept = (Map) list_sql_dept.get(y);
				pk_dept = String.valueOf(map_list_sql_dept.get("pk_dept"));
				pk_dept_v = String.valueOf(map_list_sql_dept.get("pk_vid"));
			}
		} else {
			ret_message = "{\"result\":\"0\",\"message\":\"部门在NC系统中没有检索到。\"}";
			return ret_message;
		}

		SaleOrderHVO hvos = new SaleOrderHVO();
		hvos.setVnote(vnote);
		hvos.setVdef3(vdef3);
		hvos.setVdef20(ordernumber);
		hvos.setPk_org(pk_salesorg);
		hvos.setPk_org_v(pk_salesorg_v);

		String sql_org_trafficorg = " select pk_trafficorg,pk_vid from org_trafficorg where pk_trafficorg = '"
				+ pk_salesorg + "' and enablestate = 2 ";
		ArrayList list_sql_org_trafficorg = querySQL(sql_org_trafficorg);
		if (list_sql_org_trafficorg.size() > 0) {
			hvos.setCtradewordid(pk_salesorg);
			hvos.setCtradewordid(pk_salesorg_v);
		}

		hvos.setDbilldate(new UFDate(dbilldate));
		hvos.setCtrantypeid(ctrantypeid);
		hvos.setCcustomerid(ccustomerid);
		hvos.setVdef2(vdef2);
		hvos.setCemployeeid(cemployeeid);
		hvos.setCorigcurrencyid(corigcurrencyid);
		hvos.setFstatusflag(new Integer(1));
		hvos.setCreator(cuserid);
		hvos.setCreationtime(new UFDateTime());
		hvos.setCdeptid(pk_dept);
		hvos.setCdeptvid(pk_dept_v);
		hvos.setPk_group(pk_group);
		hvos.setBadvfeeflag(new UFBoolean("N"));
		hvos.setBarsettleflag(new UFBoolean("N"));
		hvos.setBcooptopoflag(new UFBoolean("N"));
		hvos.setBcostsettleflag(new UFBoolean("N"));
		hvos.setBfreecustflag(new UFBoolean(isfreecust));
		hvos.setBillmaker(cuserid);
		hvos.setDmakedate(new UFDate());
		hvos.setBinvoicendflag(new UFBoolean("N"));
		hvos.setBoffsetflag(new UFBoolean("N"));
		hvos.setBoutendflag(new UFBoolean("N"));
		hvos.setBpocooptomeflag(new UFBoolean("N"));
		hvos.setBpreceiveflag(new UFBoolean("N"));
		hvos.setBsendendflag(new UFBoolean("N"));
		hvos.setCinvoicecustid(ccustomerid);
		hvos.setFpfstatusflag(new Integer(-1));
		hvos.setIversion(new Integer(0));
		hvos.setNdiscountrate(new UFDouble(100));
		hvos.setNtotalorigsubmny(new UFDouble(0));
		hvos.setNtotalpiece(new UFDouble(0));
		hvos.setNtotalvolume(new UFDouble(0));
		hvos.setNtotalweight(new UFDouble(0));

		String vtrantypecode = "";
		String vtr = "select pk_billtypecode from bd_billtype where pk_billtypeid ='"
				+ ctrantypeid + "' and (ISLOCK = 'N' OR ISLOCK is null )";
		try {
			vtrantypecode = getString(dao.executeQuery(vtr,
					new ColumnProcessor()));
		} catch (DAOException e2) {
			e2.printStackTrace();
		}
		hvos.setVtrantypecode(vtrantypecode);

		String cbiztypeid = "";
		String sql_curid = "select pk_busitype from bd_busitype where primarybilltype='"
				+ vtrantypecode
				+ "' and pk_group='"
				+ pk_group
				+ "' and validity =1 and dr=0";
		try {
			cbiztypeid = getString(dao.executeQuery(sql_curid,
					new ColumnProcessor()));
		} catch (DAOException e2) {
			e2.printStackTrace();
		}

		hvos.setCbiztypeid(cbiztypeid);
		hvos.setDr(new Integer(0));
		hvos.setTs(new UFDateTime());

		int countrow = 0;
		UFDouble totalnum = new UFDouble(0);
		UFDouble summ = new UFDouble(0);
		JSONArray bjosnArray = hjo.getJSONArray("detail");
		SaleOrderBVO[] bvos = new SaleOrderBVO[bjosnArray.size()];
		for (int j = 0; j < bjosnArray.size(); j++) {
			JSONObject bjo = bjosnArray.getJSONObject(j);
			String cmaterialid = bjo.getString("cmaterialid");
			if (("".equals(cmaterialid.trim()))
					|| (cmaterialid.trim().equals("null"))
					|| (cmaterialid.trim().equals(null))) {
				ret_message = "{\"result\":\"0\",\"message\":\"物料编码cmaterialvid不能为空.\"}";
				return ret_message;
			}
			String sql_cin = "select pk_material from bd_material where  pk_material='"
					+ cmaterialid + "' and dr = 0";
			try {
				cmaterialid = getString(dao.executeQuery(sql_cin,
						new ColumnProcessor()));
				if (cmaterialid.length() == 0) {
					return "{\"result\":\"0\",\"message\":\"物料编码cmaterialvid在erp系统中没有检索到.\"}";
				}
			} catch (DAOException e2) {
				e2.printStackTrace();

				String nnum = bjo.getString("nnum");
				if (("".equals(nnum.trim())) || (nnum.trim().equals("null"))
						|| (nnum.trim().equals(null))) {
					return "{\"result\":\"0\",\"message\":\"主数量nnum不能为空.\"}";
				}

				String nqtorigprice = bjo.getString("nqtorigprice");
				if ((nqtorigprice.trim().equals(""))
						|| (nqtorigprice.trim().equals("null"))
						|| (nqtorigprice.trim().equals(null))) {
					return "{\"result\":\"0\",\"message\":\"无税单价nqtorigprice不能为空.\"}";
				}

				SaleOrderBVO bvo = new SaleOrderBVO();
				countrow += 10;
				bvo.setCrowno(String.valueOf(countrow));
				bvo.setCmaterialid(cmaterialid);
				bvo.setCmaterialvid(cmaterialid);
				String vbnote = bjo.getString("vbnote");
				bvo.setVrownote(vbnote);

				String cunitid = "";
				String sql_s = "select pk_measdoc from bd_material where pk_material ='"
						+ cmaterialid + "' and dr = 0";
				try {
					cunitid = getString(dao.executeQuery(sql_s,
							new ColumnProcessor()));
				} catch (DAOException e21) {
					e21.printStackTrace();
				}

				String sql_castunitid = "select pk_measdoc from bd_materialconvert where pk_material = '"
						+ cmaterialid + "'";
				String castunitid = "";
				try {
					castunitid = getString(dao.executeQuery(sql_castunitid,
							new ColumnProcessor()));
				} catch (DAOException e) {
					e.printStackTrace();
					return "{\"result\":\"0\",\"message\":\"" + e.toString()
							+ "\"}";
				}

				bvo.setCunitid(cunitid);
				bvo.setCastunitid(castunitid);
				String sql_measrate = " select measrate,pk_measdoc from bd_materialconvert where pk_material = '"
						+ cmaterialid + "' ";
				ArrayList list_measrate = querySQL(sql_measrate);
				String measrate = "";
				if (list_measrate.size() != 0) {
					for (int e = 0; e < list_measrate.size(); e++) {
						Map map_list_measrate = (Map) list_measrate.get(e);
						measrate = String.valueOf(map_list_measrate
								.get("measrate"));
						bvo.setVchangerate(measrate);
					}
				}
				bvo.setNexchangerate(new UFDouble(1));

				String ntaxrate = bjo.getString("ntaxrate");
				bvo.setNtaxrate(new UFDouble(ntaxrate));

				String sql_ctaxcodeid = "select code,pk_taxcode from bd_taxcode where mattaxes = (select pk_mattaxes from bd_material where pk_material = '"
						+ cmaterialid + "')";
				ArrayList list_sql_ctaxcodeid = querySQL(sql_ctaxcodeid);
				if (list_sql_ctaxcodeid.size() != 0) {
					for (int m = 0; m < list_sql_ctaxcodeid.size(); m++) {
						Map map_list_sql_ctaxcodeid = (Map) list_sql_ctaxcodeid
								.get(m);
						String pk_taxcode = String
								.valueOf(map_list_sql_ctaxcodeid
										.get("pk_taxcode"));
						bvo.setCtaxcodeid(pk_taxcode);
					}
				} else {
					bvo.setCtaxcodeid("");
				}

				bvo.setCcurrencyid(corigcurrencyid);
				bvo.setNnum(new UFDouble(nnum));
				String[] str = new String[2];
				str = measrate.split("/");
				UFDouble nastnum = new UFDouble(nnum).multiply(
						new UFDouble(str[1])).div(new UFDouble(str[0]));
				bvo.setNastnum(nastnum);
				totalnum = totalnum.add(nastnum);

				bvo.setNqtorigprice(new UFDouble(nqtorigprice));
				UFDouble norigmny = new UFDouble(nnum).multiply(new UFDouble(
						nqtorigprice));
				bvo.setNorigmny(norigmny);
				UFDouble nqtorigtaxprice = new UFDouble(nqtorigprice)
						.multiply(new UFDouble(new UFDouble(ntaxrate)).div(
								new UFDouble(100)).add(new UFDouble(1)));
				bvo.setNqtorigtaxprice(nqtorigtaxprice);
				UFDouble norigtaxmny = new UFDouble(norigmny)
						.multiply(new UFDouble(new UFDouble(ntaxrate)).div(
								new UFDouble(100)).add(new UFDouble(1)));
				bvo.setNorigtaxmny(norigtaxmny);
				UFDouble d = norigtaxmny;
				summ = summ.add(d);
				hvos.setNtotalorigmny(summ);

				bvo.setDsenddate(new UFDate());
				bvo.setDreceivedate(new UFDate());
				bvo.setCreceivecustid(ccustomerid);
				bvo.setCsendstockorgvid(pk_salesorg);
				bvo.setCprofitcenterid(pk_salesorg);
				bvo.setCprofitcentervid(pk_salesorg_v);

				String carorgid = null;
				String vid = "select pk_financeorg from  org_stockorg where  pk_stockorg ='"
						+ pk_salesorg + "' and dr=0";
				try {
					carorgid = getString(dao.executeQuery(vid,
							new ColumnProcessor()));
				} catch (DAOException e22) {
					e22.printStackTrace();
				}

				bvo.setCarorgid(carorgid);
				String csettleorgvid = null;
				String vids = "select pk_vid from org_corp   where pk_corp='"
						+ carorgid + "' and dr=0";
				try {
					csettleorgvid = getString(dao.executeQuery(vids,
							new ColumnProcessor()));
				} catch (DAOException e24) {
					e24.printStackTrace();
				}

				bvo.setCsettleorgvid(csettleorgvid);
				bvo.setCarorgvid(csettleorgvid);
				bvo.setPk_org(pk_salesorg);
				bvo.setPk_group(pk_group);
				bvo.setDr(new Integer(0));
				bvo.setTs(new UFDateTime());
				bvo.setBarrangedflag(new UFBoolean("N"));
				bvo.setBbarsettleflag(new UFBoolean("N"));
				bvo.setBbcostsettleflag(new UFBoolean("N"));
				bvo.setBbindflag(new UFBoolean("N"));
				bvo.setBbinvoicendflag(new UFBoolean("N"));
				bvo.setBboutendflag(new UFBoolean("N"));
				bvo.setBbsendendflag(new UFBoolean("N"));
				bvo.setBdiscountflag(new UFBoolean("N"));
				bvo.setBjczxsflag(new UFBoolean("N"));
				bvo.setBlaborflag(new UFBoolean("N"));
				bvo.setBlargessflag(new UFBoolean("N"));
				bvo.setBtriatradeflag(new UFBoolean("N"));

				bvo.setCqtunitid(cunitid);

				String crececountryid = null;
				String sql_count = "select pk_country from  bd_countryzone where  code ='CN' and dr = 0 ";
				try {
					crececountryid = getString(dao.executeQuery(sql_count,
							new ColumnProcessor()));
				} catch (DAOException e23) {
					e23.printStackTrace();
				}
				bvo.setCrececountryid(crececountryid);
				bvo.setCsendcountryid(crececountryid);
				bvo.setCsendstockorgid(pk_salesorg);
				bvo.setCsendstockorgvid(pk_salesorg_v);
				bvo.setCsettleorgid(carorgid);
				bvo.setCtaxcountryid(crececountryid);
				bvo.setDbilldate(new UFDate());
				bvo.setFbuysellflag(new Integer(1));
				bvo.setFlargesstypeflag(new Integer(1));
				bvo.setFtaxtypeflag(new Integer(1));
				bvo.setNdiscount(new UFDouble(0));
				bvo.setNitemdiscountrate(new UFDouble(100));
				bvo.setNorigdiscount(new UFDouble(0));
				bvo.setNcaltaxmny(norigmny);
				bvo.setNmny(norigmny);
				bvo.setNnetprice(new UFDouble(nqtorigprice));
				bvo.setNorignetprice(new UFDouble(nqtorigprice));
				bvo.setNorigprice(new UFDouble(nqtorigprice));
				bvo.setNorigtaxnetprice(nqtorigtaxprice);
				bvo.setNorigtaxprice(nqtorigtaxprice);
				bvo.setNprice(new UFDouble(nqtorigprice));
				bvo.setNqtnetprice(new UFDouble(nqtorigprice));
				bvo.setNqtorigprice(new UFDouble(nqtorigprice));
				bvo.setNqtorigtaxnetprc(nqtorigtaxprice);
				bvo.setNqtprice(new UFDouble(nqtorigprice));
				bvo.setNqttaxnetprice(nqtorigtaxprice);
				bvo.setNqttaxprice(nqtorigtaxprice);
				bvo.setNqtunitnum(new UFDouble(nnum));
				UFDouble ntax = new UFDouble(norigtaxmny).sub(new UFDouble(
						norigmny));
				bvo.setNtax(ntax);
				bvo.setNtaxmny(norigtaxmny);
				bvo.setNtaxnetprice(nqtorigtaxprice);
				bvo.setNtaxprice(nqtorigtaxprice);
				hvos.setNtotalmny(new UFDouble(norigmny));
				bvo.setNvolume(new UFDouble(0));
				bvo.setNweight(new UFDouble(0));
				bvo.setVqtunitrate("1.00/1.00");
				bvo.setNbforigsubmny(new UFDouble(norigmny));
				bvo.setNqtorignetprice(new UFDouble(nqtorigprice));
				bvo.setNdiscountrate(new UFDouble(100));
				bvos[j] = bvo;
			}
		}

		hvos.setNtotalnum(new UFDouble(totalnum));

		SaleOrderVO vos3 = new SaleOrderVO();
		vos3.setParent(hvos);
		String vbillcode = "";
		try {
			vbillcode = getPreBillCode6("30", pk_group, "00000000000000000000",
					vos3);
		} catch (BusinessException e1) {
			e1.printStackTrace();
			return "{\"result\":\"0\",\"message\":\"" + e1.toString() + "\"}";
		}

		hvos.setVbillcode(vbillcode);

		SaleOrderVO avo = new SaleOrderVO();
		avo.setParentVO(hvos);
		avo.setChildrenVO(bvos);
		InvocationInfoProxy.getInstance().setGroupId(hvos.getPk_group());
		InvocationInfoProxy.getInstance().setUserId(hvos.getCreator());
		HashMap eParam1_er = new HashMap();
		eParam1_er.put("notechecked", "notechecked");
		eParam1_er.put("nc.bs.scmpub.pf.ORIGIN_VO_PARAMETER",
				new SaleOrderVO[] { avo });
		IPFBusiAction pfaction_er = (IPFBusiAction) NCLocator.getInstance()
				.lookup(IPFBusiAction.class.getName());
		try {
			pfaction_er.processAction("WRITE", "N_30_WRITE", null, avo, null,
					eParam1_er);
			return "{\"result\":\"1\",\"message\":\"" + vbillcode + "\"}";
		} catch (Exception er) {
			er.printStackTrace();
			er.getMessage();
			ret_message = "{\"result\":\"0\",\"message\":\"" + er.getMessage()
					+ "\"}";
		}
		return ret_message;
	}

	private void setTaxInfo(VATInfoVO[] vatinfos, int[] rows, boolean isonlycode) {
		int i = 0;
		List listchgrow = new ArrayList();
		IKeyValue keyValue = null;
		IKeyRela keyRela = null;
		for (int row : rows) {
			String newtaxcode = null;
			Integer newtaxtype = null;
			UFDouble newtaxrate = null;
			if (vatinfos[i] != null) {
				newtaxcode = vatinfos[i].getCtaxcodeid();
				newtaxtype = vatinfos[i].getFtaxtypeflag();
				newtaxrate = vatinfos[i].getNtaxrate();
			}
			String oldtaxcode = keyValue.getBodyStringValue(row,
					keyRela.getCtaxcodeidKey());

			UFDouble oldtaxrate = keyValue.getBodyUFDoubleValue(row,
					keyRela.getNtaxrateKey());

			Integer oldtaxtype = keyValue.getBodyIntegerValue(row,
					keyRela.getFtaxtypeflagKey());

			if ((oldtaxrate == null)
					|| (!PubAppTool.isEqual(oldtaxcode, newtaxcode))) {
				keyValue.setBodyValue(row, keyRela.getCtaxcodeidKey(),
						newtaxcode);

				keyValue.setBodyValue(row, keyRela.getFtaxtypeflagKey(),
						newtaxtype);

				keyValue.setBodyValue(row, keyRela.getNtaxrateKey(), newtaxrate);

				listchgrow.add(Integer.valueOf(row));
			}
			i++;
		}
	}

	public ArrayList querySQL(String sql) {
		BaseDAO dao = new BaseDAO(SystemConfig.getInstance().getDatasource());
		ArrayList list = new ArrayList();
		try {
			list = (ArrayList) dao.executeQuery(sql, new MapListProcessor());
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return list;
	}

	public String headinfoNull30(String pk_salesorg, String ctrantypeid,
			String ccustomerid, String cemployeeid, String cdeptid,
			String creator) {
		String ret_error = "";
		if ((pk_salesorg == null) || ("".equals(pk_salesorg))) {
			ret_error = "{\"result\":\"0\",\"message\":\"销售组织为空。\"}";
		} else if ((ccustomerid == null) || ("".equals(ccustomerid))) {
			ret_error = "{\"result\":\"0\",\"message\":\"客户为空。\"}";
		} else if ((ctrantypeid == null) || ("".equals(ctrantypeid))) {
			ret_error = "{\"result\":\"0\",\"message\":\"订单类型为空。\"}";
		} else if ((cdeptid == null) || ("".equals(cdeptid))) {
			ret_error = "{\"result\":\"0\",\"message\":\"部门为空。\"}";
		} else if ((creator == null) || ("".equals(creator))) {
			ret_error = "{\"result\":\"0\",\"message\":\"创建人为空。\"}";
		} else if ((cemployeeid == null) || ("".equals(cemployeeid))) {
			ret_error = "{\"result\":\"0\",\"message\":\"币种为空。\"}";
		}
		return ret_error;
	}

	public String detailNull(String pk_purchaseorg, String pk_material,
			String nastnum, String dreqdate, String pk_reqdept) {
		String ret_error = "";
		if ((pk_purchaseorg == null) || (pk_purchaseorg.equals(""))) {
			ret_error = "{\"result\":\"0\",\"message\":\"采购组织为空。\"}";
		} else if ((pk_material == null) || ("".equals(pk_material))) {
			ret_error = "{\"result\":\"0\",\"message\":\"物料为空。\"}";
		} else if ((nastnum == null) || ("".equals(nastnum))) {
			ret_error = "{\"result\":\"0\",\"message\":\"数量为空。\"}";
		} else if ((dreqdate == null) || ("".equals(dreqdate))) {
			ret_error = "{\"result\":\"0\",\"message\":\"需求日期为空。\"}";
		} else if ((pk_reqdept == null) || ("".equals(pk_reqdept))) {
			ret_error = "{\"result\":\"0\",\"message\":\"需求部门为空。\"}";
		}
		return ret_error;
	}

	public String headinfoNull(String coutstockorgid, String coutstordocid,
			String ctrantypeid, String cdeptid, String creator) {
		String ret_error = "";
		if ((coutstockorgid == null) || ("".equals(coutstockorgid))) {
			ret_error = "{\"result\":\"0\",\"message\":\"库存组织为空。\"}";
		} else if ((coutstordocid == null) || ("".equals(coutstordocid))) {
			ret_error = "{\"result\":\"0\",\"message\":\"仓库为空。\"}";
		} else if ((ctrantypeid == null) || ("".equals(ctrantypeid))) {
			ret_error = "{\"result\":\"0\",\"message\":\"出入库类型为空。\"}";
		} else if ((cdeptid == null) || ("".equals(cdeptid))) {
			ret_error = "{\"result\":\"0\",\"message\":\"领料部门为空。\"}";
		} else if ((creator == null) || ("".equals(creator))) {
			ret_error = "{\"result\":\"0\",\"message\":\"创建人为空。\"}";
		}
		return ret_error;
	}

	public String getPreBillCode5(String nbcrcode, String pk_group,
			String pk_org, MaterialOutVO avo5) throws BusinessException {
		IBillcodeManage billCodeManager = (IBillcodeManage) AMProxy
				.lookup(IBillcodeManage.class);
		if (billCodeManager == null) {
			return null;
		}

		String newCode5 = billCodeManager.getBillCode_RequiresNew(nbcrcode,
				pk_group, pk_org, avo5);
		return newCode5;
	}

	public String getPreBillCode6(String nbcrcode, String pk_group,
			String pk_org, SaleOrderVO avo5) throws BusinessException {
		IBillcodeManage billCodeManager = (IBillcodeManage) AMProxy
				.lookup(IBillcodeManage.class);
		if (billCodeManager == null) {
			return null;
		}

		String newCode5 = billCodeManager.getBillCode_RequiresNew(nbcrcode,
				pk_group, pk_org, avo5);
		return newCode5;
	}

	private String getString(Object obj) {
		if (obj != null) {
			return String.valueOf(obj);
		}

		return "";
	}
}
