package com.msunsoft.model;

import java.util.Date;

public class Purchase_Contract {

	private Long pc_id;
	private Long supp_id;
	private Long comm_id;
	private double purc_price;
	private String pc_pay_method;
	private String pc_pay_period;
	private Date pc_date;
	private String pc_period;
	
	public Purchase_Contract() {
		super();
	}
	
	public Purchase_Contract(Long pc_id, Long supp_id, Long comm_id, double purc_price, String pc_pay_method,
			String pc_pay_period, Date pc_date, String pc_period) {
		super();
		this.pc_id = pc_id;
		this.supp_id = supp_id;
		this.comm_id = comm_id;
		this.purc_price = purc_price;
		this.pc_pay_method = pc_pay_method;
		this.pc_pay_period = pc_pay_period;
		this.pc_date = pc_date;
		this.pc_period = pc_period;
	}
	
	public Long getPc_id() {
		return pc_id;
	}
	public void setPc_id(Long pc_id) {
		this.pc_id = pc_id;
	}
	public Long getSupp_id() {
		return supp_id;
	}
	public void setSupp_id(Long supp_id) {
		this.supp_id = supp_id;
	}
	public Long getComm_id() {
		return comm_id;
	}
	public void setComm_id(Long comm_id) {
		this.comm_id = comm_id;
	}
	public double getPurc_price() {
		return purc_price;
	}
	public void setPurc_price(double purc_price) {
		this.purc_price = purc_price;
	}
	public String getPc_pay_method() {
		return pc_pay_method;
	}
	public void setPc_pay_method(String pc_pay_method) {
		this.pc_pay_method = pc_pay_method;
	}
	public String getPc_pay_period() {
		return pc_pay_period;
	}
	public void setPc_pay_period(String pc_pay_period) {
		this.pc_pay_period = pc_pay_period;
	}
	public Date getPc_date() {
		return pc_date;
	}
	public void setPc_date(Date pc_date) {
		this.pc_date = pc_date;
	}
	public String getPc_period() {
		return pc_period;
	}
	public void setPc_period(String pc_period) {
		this.pc_period = pc_period;
	}
	
	@Override
	public String toString() {
		return "Purchase_Contract [pc_id=" + pc_id + ", supp_id=" + supp_id + ", comm_id=" + comm_id + ", purc_price="
				+ purc_price + ", pc_pay_method=" + pc_pay_method + ", pc_pay_period=" + pc_pay_period + ", pc_date="
				+ pc_date + ", pc_period=" + pc_period + "]";
	}
	
}
