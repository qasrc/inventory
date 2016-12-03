package com.msunsoft.model;

/**
 *  用户清单表
 */
public class User_Bill {
	
	private Long user_id;
	private String user_name;
	private String user_password;
	private Long popedom_id;

	public User_Bill() {
	}

	public User_Bill(Long user_id, String user_name, String user_password, Long popedom_id) {
		this.user_id = user_id;
		this.user_name = user_name;
		this.user_password = user_password;
		this.popedom_id = popedom_id;
	}

	@Override
	public String toString() {
		return "User_Bill{" +
				"user_id=" + user_id +
				", user_name='" + user_name + '\'' +
				", user_password='" + user_password + '\'' +
				", popedom_id=" + popedom_id +
				'}';
	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

	public Long getPopedom_id() {
		return popedom_id;
	}

	public void setPopedom_id(Long popedom_id) {
		this.popedom_id = popedom_id;
	}
}
