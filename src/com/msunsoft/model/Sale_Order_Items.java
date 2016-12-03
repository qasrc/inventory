package com.msunsoft.model;


/**
 *销售订单明细表
 */
public class Sale_Order_Items {

	private Long soi_id;
	private Long so_id;
	private Long comm_id;
	private Long so_amount;
	private Long sale_price;
	
	public Sale_Order_Items() {
		super();
	}

	public Sale_Order_Items(Long soi_id, Long so_id, Long comm_id, Long so_amount, Long sale_price) {
		super();
		this.soi_id = soi_id;
		this.so_id = so_id;
		this.comm_id = comm_id;
		this.so_amount = so_amount;
		this.sale_price = sale_price;
	}

	public Long getSoi_id() {
		return soi_id;
	}

	public void setSoi_id(Long soi_id) {
		this.soi_id = soi_id;
	}

	public Long getSo_id() {
		return so_id;
	}

	public void setSo_id(Long so_id) {
		this.so_id = so_id;
	}

	public Long getComm_id() {
		return comm_id;
	}

	public void setComm_id(Long comm_id) {
		this.comm_id = comm_id;
	}

	public Long getSo_amount() {
		return so_amount;
	}

	public void setSo_amount(Long so_amount) {
		this.so_amount = so_amount;
	}

	public Long getSale_price() {
		return sale_price;
	}

	public void setSale_price(Long sale_price) {
		this.sale_price = sale_price;
	}

	@Override
	public String toString() {
		return "Sale_Order_Items [soi_id=" + soi_id + ", so_id=" + so_id + ", comm_id=" + comm_id + ", so_amount="
				+ so_amount + ", sale_price=" + sale_price + "]";
	} 
	
}
