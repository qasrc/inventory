package com.msunsoft.model;

import java.util.Date;

/**
 *进货单
 */
public class Purchase_In_Bill {

	private Long pib_id;
	private Long supp_id;
	private Date pib_date;
	private Long oper_id;
	private String cbill;
	private String inspector;
	private String keeper;
	public Purchase_In_Bill() {
		super();
	}
	
	public Purchase_In_Bill(Long pib_id, Long supp_id, Date pib_date, Long oper_id, String cbill, String inspector,
			String keeper) {
		super();
		this.pib_id = pib_id;
		this.supp_id = supp_id;
		this.pib_date = pib_date;
		this.oper_id = oper_id;
		this.cbill = cbill;
		this.inspector = inspector;
		this.keeper = keeper;
	}

	public Long getPib_id() {
		return pib_id;
	}

	public void setPib_id(Long pib_id) {
		this.pib_id = pib_id;
	}

	public Long getSupp_id() {
		return supp_id;
	}

	public void setSupp_id(Long supp_id) {
		this.supp_id = supp_id;
	}

	public Date getPib_date() {
		return pib_date;
	}

	public void setPib_date(Date pib_date) {
		this.pib_date = pib_date;
	}

	public Long getOper_id() {
		return oper_id;
	}

	public void setOper_id(Long oper_id) {
		this.oper_id = oper_id;
	}

	public String getCbill() {
		return cbill;
	}

	public void setCbill(String cbill) {
		this.cbill = cbill;
	}

	public String getInspector() {
		return inspector;
	}

	public void setInspector(String inspector) {
		this.inspector = inspector;
	}

	public String getKeeper() {
		return keeper;
	}

	public void setKeeper(String keeper) {
		this.keeper = keeper;
	}

	@Override
	public String toString() {
		return "Purchase_In_Bill [pib_id=" + pib_id + ", supp_id=" + supp_id + ", pib_date=" + pib_date + ", oper_id="
				+ oper_id + ", cbill=" + cbill + ", inspector=" + inspector + ", keeper=" + keeper + "]";
	}
	
	
}
