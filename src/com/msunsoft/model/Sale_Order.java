package com.msunsoft.model;

import java.util.Date;

/**
 *销售订单表
 */
public class Sale_Order {

	private Long so_id;
	private Long clie_id;
	private Date so_date;
	private Date so_begain_date;
	private Date so_end_date;
	private Long oper_id;
	private String cbill;
	public Sale_Order() {
		super();
	}
	public Sale_Order(Long so_id, Long clie_id, Date so_date, Date so_begain_date, Date so_end_date, Long oper_id,
			String cbill) {
		super();
		this.so_id = so_id;
		this.clie_id = clie_id;
		this.so_date = so_date;
		this.so_begain_date = so_begain_date;
		this.so_end_date = so_end_date;
		this.oper_id = oper_id;
		this.cbill = cbill;
	}
	public Long getSo_id() {
		return so_id;
	}
	public void setSo_id(Long so_id) {
		this.so_id = so_id;
	}
	public Long getClie_id() {
		return clie_id;
	}
	public void setClie_id(Long clie_id) {
		this.clie_id = clie_id;
	}
	public Date getSo_date() {
		return so_date;
	}
	public void setSo_date(Date so_date) {
		this.so_date = so_date;
	}
	public Date getSo_begain_date() {
		return so_begain_date;
	}
	public void setSo_begain_date(Date so_begain_date) {
		this.so_begain_date = so_begain_date;
	}
	public Date getSo_end_date() {
		return so_end_date;
	}
	public void setSo_end_date(Date so_end_date) {
		this.so_end_date = so_end_date;
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
		return "Sale_Order [so_id=" + so_id + ", clie_id=" + clie_id + ", so_date=" + so_date + ", so_begain_date="
				+ so_begain_date + ", so_end_date=" + so_end_date + ", oper_id=" + oper_id + ", cbill=" + cbill + "]";
	}
	
}
