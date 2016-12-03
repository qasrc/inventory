package com.msunsoft.model;

/**
 *仓库清单表
 */
public class Depot_Bill {

	private Long depo_id;
	private String depo_name;
	private String depo_sort;
	private String depo_desc;
	public Depot_Bill() {
		super();
	}
	public Depot_Bill(Long depo_id, String depo_name, String depo_sort, String depo_desc) {
		super();
		this.depo_id = depo_id;
		this.depo_name = depo_name;
		this.depo_sort = depo_sort;
		this.depo_desc = depo_desc;
	}
	public Long getDepo_id() {
		return depo_id;
	}
	public void setDepo_id(Long depo_id) {
		this.depo_id = depo_id;
	}
	public String getDepo_name() {
		return depo_name;
	}
	public void setDepo_name(String depo_name) {
		this.depo_name = depo_name;
	}
	public String getDepo_sort() {
		return depo_sort;
	}
	public void setDepo_sort(String depo_sort) {
		this.depo_sort = depo_sort;
	}
	public String getDepo_desc() {
		return depo_desc;
	}
	public void setDepo_desc(String depo_desc) {
		this.depo_desc = depo_desc;
	}
	@Override
	public String toString() {
		return "Depot_Bill [depo_id=" + depo_id + ", depo_name=" + depo_name + ", depo_sort=" + depo_sort
				+ ", depo_desc=" + depo_desc + "]";
	}
	
	
}
