package com.msunsoft.model;


/**
 *门店清单表
 */
public class Store_Bill {

	private Long store_id;
	private String store_name;
	private String store_address;
	private String store_desc;
	
	public Store_Bill() {
		super();
	}

	public Store_Bill(Long store_id, String store_name, String store_address, String store_desc) {
		super();
		this.store_id = store_id;
		this.store_name = store_name;
		this.store_address = store_address;
		this.store_desc = store_desc;
	}

	public Long getStore_id() {
		return store_id;
	}

	public void setStore_id(Long store_id) {
		this.store_id = store_id;
	}

	public String getStore_name() {
		return store_name;
	}

	public void setStore_name(String store_name) {
		this.store_name = store_name;
	}

	public String getStore_address() {
		return store_address;
	}

	public void setStore_address(String store_address) {
		this.store_address = store_address;
	}

	public String getStore_desc() {
		return store_desc;
	}

	public void setStore_desc(String store_desc) {
		this.store_desc = store_desc;
	}

	@Override
	public String toString() {
		return "store_bill [store_id=" + store_id + ", store_name=" + store_name + ", store_address=" + store_address
				+ ", store_desc=" + store_desc + "]";
	}
	
}
