package com.msunsoft.model;


/**
 *采购订单明细表
 */
public class Purchase_Order_Items {

	private Long poi_id;
	private Long po_id;
	private Long comm_id;
	private Long poi_amount;
	private Double purc_price;
	
	public Purchase_Order_Items() {
		super();
	}
	
	public Purchase_Order_Items(Long poi_id, Long po_id, Long comm_id, Long poi_amount, Double purc_price) {
		super();
		this.poi_id = poi_id;
		this.po_id = po_id;
		this.comm_id = comm_id;
		this.poi_amount = poi_amount;
		this.purc_price = purc_price;
	}
	public Long getPoi_id() {
		return poi_id;
	}
	public void setPoi_id(Long poi_id) {
		this.poi_id = poi_id;
	}
	public Long getPo_id() {
		return po_id;
	}
	public void setPo_id(Long po_id) {
		this.po_id = po_id;
	}
	public Long getComm_id() {
		return comm_id;
	}
	public void setComm_id(Long comm_id) {
		this.comm_id = comm_id;
	}
	public Long getPoi_amount() {
		return poi_amount;
	}
	public void setPoi_amount(Long poi_amount) {
		this.poi_amount = poi_amount;
	}
	public Double getPurc_price() {
		return purc_price;
	}
	public void setPurc_price(Double purc_price) {
		this.purc_price = purc_price;
	}
	
	@Override
	public String toString() {
		return "Purchase_Order_Items [poi_id=" + poi_id + ", po_id=" + po_id + ", comm_id=" + comm_id + ", poi_amount="
				+ poi_amount + ", purc_price=" + purc_price + "]";
	}
	
}
