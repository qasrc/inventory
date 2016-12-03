package com.msunsoft.model;


/**
 *用户权限表
 */
public class Popedom_Bill {

	private Long pope_id;
	private String pope_name;
	
	public Popedom_Bill() {
		super();
	}

	public Popedom_Bill(Long pope_id, String pope_name) {
		super();
		this.pope_id = pope_id;
		this.pope_name = pope_name;
	}

	public Long getPope_id() {
		return pope_id;
	}

	public void setPope_id(Long pope_id) {
		this.pope_id = pope_id;
	}

	public String getPope_name() {
		return pope_name;
	}

	public void setPope_name(String pope_name) {
		this.pope_name = pope_name;
	}

	@Override
	public String toString() {
		return "Popedom_Bill [pope_id=" + pope_id + ", pope_name=" + pope_name + "]";
	}
	
}
