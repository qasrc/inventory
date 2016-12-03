package com.msunsoft.model;

/**
 *商品清单表
 */
public class Commodity_Bill {

	private Long comm_id;
	private String comm_bar_code;
	private String comm_name;
	private String comm_spell_code;
	private String comm_standard;
	private String comm_unit;
	private String comm_producing_area;
	private String comm_sort;
	private Double purchase_price;
	private Double sale_price1;
	private Double sale_price2;
	private Double lowest_sale_price;
	
	public Commodity_Bill() {
		super();
	}

	public Commodity_Bill(Long comm_id, String comm_bar, String comm_name, String comm_spell_code, String comm_standard,
			String comm_unit, String comm_producing_area, String comm_sort, Double purchase_price, Double sale_price1,
			Double sale_price2, Double lowest_sale_price) {
		super();
		this.comm_id = comm_id;
		this.comm_bar_code = comm_bar;
		this.comm_name = comm_name;
		this.comm_spell_code = comm_spell_code;
		this.comm_standard = comm_standard;
		this.comm_unit = comm_unit;
		this.comm_producing_area = comm_producing_area;
		this.comm_sort = comm_sort;
		this.purchase_price = purchase_price;
		this.sale_price1 = sale_price1;
		this.sale_price2 = sale_price2;
		this.lowest_sale_price = lowest_sale_price;
	}

	public Long getComm_id() {
		return comm_id;
	}

	public void setComm_id(Long comm_id) {
		this.comm_id = comm_id;
	}

	public String getComm_bar() {
		return comm_bar_code;
	}

	public void setComm_bar(String comm_bar) {
		this.comm_bar_code = comm_bar;
	}

	public String getComm_name() {
		return comm_name;
	}

	public void setComm_name(String comm_name) {
		this.comm_name = comm_name;
	}

	public String getComm_spell_code() {
		return comm_spell_code;
	}

	public void setComm_spell_code(String comm_spell_code) {
		this.comm_spell_code = comm_spell_code;
	}

	public String getComm_standard() {
		return comm_standard;
	}

	public void setComm_standard(String comm_standard) {
		this.comm_standard = comm_standard;
	}

	public String getComm_unit() {
		return comm_unit;
	}

	public void setComm_unit(String comm_unit) {
		this.comm_unit = comm_unit;
	}

	public String getComm_producing_area() {
		return comm_producing_area;
	}

	public void setComm_producing_area(String comm_producing_area) {
		this.comm_producing_area = comm_producing_area;
	}

	public String getComm_sort() {
		return comm_sort;
	}

	public void setComm_sort(String comm_sort) {
		this.comm_sort = comm_sort;
	}

	public Double getPurchase_price() {
		return purchase_price;
	}

	public void setPurchase_price(Double purchase_price) {
		this.purchase_price = purchase_price;
	}

	public Double getSale_price1() {
		return sale_price1;
	}

	public void setSale_price1(Double sale_price1) {
		this.sale_price1 = sale_price1;
	}

	public Double getSale_price2() {
		return sale_price2;
	}

	public void setSale_price2(Double sale_price2) {
		this.sale_price2 = sale_price2;
	}

	public Double getLowest_sale_price() {
		return lowest_sale_price;
	}

	public void setLowest_sale_price(Double lowest_sale_price) {
		this.lowest_sale_price = lowest_sale_price;
	}

	@Override
	public String toString() {
		return "Commodity_Bill [comm_id=" + comm_id + ", comm_bar=" + comm_bar_code + ", comm_name=" + comm_name
				+ ", comm_spell_code=" + comm_spell_code + ", comm_standard=" + comm_standard + ", comm_unit="
				+ comm_unit + ", comm_producing_area=" + comm_producing_area + ", comm_sort=" + comm_sort
				+ ", purchase_price=" + purchase_price + ", sale_price1=" + sale_price1 + ", sale_price2=" + sale_price2
				+ ", lowest_sale_price=" + lowest_sale_price + "]";
	}
	
}
