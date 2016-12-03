package com.msunsoft.model;


/**
 * 业务员清单表
 */
public class Operator_Bill {

	private Long oper_id;
	private String oper_spell_code;
	private String oper_name;
	private String oper_sex;
	private String oper_tel;
	private String oper_mobile_tel;
	private String oper_address;
	private String oper_postcode;
	private String oper_ID_number;
	private String oper_sort;
	
	public Operator_Bill() {
		super();
	}

	public Operator_Bill(Long oper_id, String oper_spell_code, String oper_name, String oper_sex, String oper_tel,
			String oper_mobile_tel, String oper_address, String oper_postcode, String oper_ID_number,
			String oper_sort) {
		super();
		this.oper_id = oper_id;
		this.oper_spell_code = oper_spell_code;
		this.oper_name = oper_name;
		this.oper_sex = oper_sex;
		this.oper_tel = oper_tel;
		this.oper_mobile_tel = oper_mobile_tel;
		this.oper_address = oper_address;
		this.oper_postcode = oper_postcode;
		this.oper_ID_number = oper_ID_number;
		this.oper_sort = oper_sort;
	}

	public Long getOper_id() {
		return oper_id;
	}

	public void setOper_id(Long oper_id) {
		this.oper_id = oper_id;
	}

	public String getOper_spell_code() {
		return oper_spell_code;
	}

	public void setOper_spell_code(String oper_spell_code) {
		this.oper_spell_code = oper_spell_code;
	}

	public String getOper_name() {
		return oper_name;
	}

	public void setOper_name(String oper_name) {
		this.oper_name = oper_name;
	}

	public String getOper_sex() {
		return oper_sex;
	}

	public void setOper_sex(String oper_sex) {
		this.oper_sex = oper_sex;
	}

	public String getOper_tel() {
		return oper_tel;
	}

	public void setOper_tel(String oper_tel) {
		this.oper_tel = oper_tel;
	}

	public String getOper_mobile_tel() {
		return oper_mobile_tel;
	}

	public void setOper_mobile_tel(String oper_mobile_tel) {
		this.oper_mobile_tel = oper_mobile_tel;
	}

	public String getOper_address() {
		return oper_address;
	}

	public void setOper_address(String oper_address) {
		this.oper_address = oper_address;
	}

	public String getOper_postcode() {
		return oper_postcode;
	}

	public void setOper_postcode(String oper_postcode) {
		this.oper_postcode = oper_postcode;
	}

	public String getOper_ID_number() {
		return oper_ID_number;
	}

	public void setOper_ID_number(String oper_ID_number) {
		this.oper_ID_number = oper_ID_number;
	}

	public String getOper_sort() {
		return oper_sort;
	}

	public void setOper_sort(String oper_sort) {
		this.oper_sort = oper_sort;
	}

	@Override
	public String toString() {
		return "Operator_Bill [oper_id=" + oper_id + ", oper_spell_code=" + oper_spell_code + ", oper_name=" + oper_name
				+ ", oper_sex=" + oper_sex + ", oper_tel=" + oper_tel + ", oper_mobile_tel=" + oper_mobile_tel
				+ ", oper_address=" + oper_address + ", oper_postcode=" + oper_postcode + ", oper_ID_number="
				+ oper_ID_number + ", oper_sort=" + oper_sort + "]";
	}
	
}
