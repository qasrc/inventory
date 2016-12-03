package com.msunsoft.model;

/**
 *销售退货单
 */
public class Sale_Mrb {

	private Long sm_id;
	private Long so_id;
	private Long sm_amount;
	private Double sale_price;
	private Long depo_id;
	
	public Sale_Mrb() {
		super();
	}
	
	
	public Sale_Mrb(Long sm_id, Long so_id, Long sm_amount, Double sale_price, Long depo_id) {
		super();
		this.sm_id = sm_id;
		this.so_id = so_id;
		this.sm_amount = sm_amount;
		this.sale_price = sale_price;
		this.depo_id = depo_id;
	}
	public Long getSm_id() {
		return sm_id;
	}
	public void setSm_id(Long sm_id) {
		this.sm_id = sm_id;
	}
	public Long getSo_id() {
		return so_id;
	}
	public void setSo_id(Long so_id) {
		this.so_id = so_id;
	}
	public Long getSm_amount() {
		return sm_amount;
	}
	public void setSm_amount(Long sm_amount) {
		this.sm_amount = sm_amount;
	}
	public Double getSale_price() {
		return sale_price;
	}
	public void setSale_price(Double sale_price) {
		this.sale_price = sale_price;
	}
	public Long getDepo_id() {
		return depo_id;
	}
	public void setDepo_id(Long depo_id) {
		this.depo_id = depo_id;
	}
	@Override
	public String toString() {
		return "Sale_Mrb [sm_id=" + sm_id + ", so_id=" + so_id + ", sm_amount=" + sm_amount + ", sale_price="
				+ sale_price + ", depo_id=" + depo_id + "]";
	}
	
}
