package com.msunsoft.model;

import java.util.Date;

/**
 *采购订单
 */
public class Purchase_Order {
	
	private Long po_id;
	private Long supp_id;
	private Date po_date;
	private Date po_begain_date;
	private Date po_end_date;
	private Long oper_id;
	private String cbill;
	
	public Purchase_Order() {
		super();
	}

	public Purchase_Order(Long po_id, Long supp_id, Date po_date, Date po_begain_date, Date po_end_date, Long oper_id,
			String cbill) {
		super();
		this.po_id = po_id;
		this.supp_id = supp_id;
		this.po_date = po_date;
		this.po_begain_date = po_begain_date;
		this.po_end_date = po_end_date;
		this.oper_id = oper_id;
		this.cbill = cbill;
	}

	public Long getPo_id() {
		return po_id;
	}

	public void setPo_id(Long po_id) {
		this.po_id = po_id;
	}

	public Long getSupp_id() {
		return supp_id;
	}

	public void setSupp_id(Long supp_id) {
		this.supp_id = supp_id;
	}

	public Date getPo_date() {
		return po_date;
	}

	public void setPo_date(Date po_date) {
		this.po_date = po_date;
	}

	public Date getPo_begain_date() {
		return po_begain_date;
	}

	public void setPo_begain_date(Date po_begain_date) {
		this.po_begain_date = po_begain_date;
	}

	public Date getPo_end_date() {
		return po_end_date;
	}

	public void setPo_end_date(Date po_end_date) {
		this.po_end_date = po_end_date;
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

	@Override
	public String toString() {
		return "Purchase_Order [po_id=" + po_id + ", supp_id=" + supp_id + ", po_date=" + po_date + ", po_begain_date="
				+ po_begain_date + ", po_end_date=" + po_end_date + ", oper_id=" + oper_id + ", cbill=" + cbill + "]";
	}
	
	
}
