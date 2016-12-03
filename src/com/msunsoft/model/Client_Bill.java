package com.msunsoft.model;


/**
 *客户清单表
 */
public class Client_Bill {

	private Long clie_id;
	private String clie_spell_code;
	private String clie_shortname;
	private String clie_name;
	private String clie_linkman;
	private String clie_address;
	private String clie_postcode;
	private String clie_tel;
	private String clie_fax;
	private String clie_bank;
	private String clie_iban;
	private String clie_sort;
	private Long oper_id;
	private String clie_creditlimt;
	
	public Client_Bill() {
		super();
	}

	public Client_Bill(Long clie_id, String clie_spell_code, String clie_shortname, String clie_name,
			String clie_linkman, String clie_address, String clie_postcode, String clie_tel, String clie_fax,
			String clie_bank, String clie_iban, String clie_sort, Long oper_id, String clie_creditLimt) {
		super();
		this.clie_id = clie_id;
		this.clie_spell_code = clie_spell_code;
		this.clie_shortname = clie_shortname;
		this.clie_name = clie_name;
		this.clie_linkman = clie_linkman;
		this.clie_address = clie_address;
		this.clie_postcode = clie_postcode;
		this.clie_tel = clie_tel;
		this.clie_fax = clie_fax;
		this.clie_bank = clie_bank;
		this.clie_iban = clie_iban;
		this.clie_sort = clie_sort;
		this.oper_id = oper_id;
		this.clie_creditlimt = clie_creditLimt;
	}

	public Long getClie_id() {
		return clie_id;
	}

	public void setClie_id(Long clie_id) {
		this.clie_id = clie_id;
	}

	public String getClie_spell_code() {
		return clie_spell_code;
	}

	public void setClie_spell_code(String clie_spell_code) {
		this.clie_spell_code = clie_spell_code;
	}

	public String getClie_shortname() {
		return clie_shortname;
	}

	public void setClie_shortname(String clie_shortname) {
		this.clie_shortname = clie_shortname;
	}

	public String getClie_name() {
		return clie_name;
	}

	public void setClie_name(String clie_name) {
		this.clie_name = clie_name;
	}

	public String getClie_linkman() {
		return clie_linkman;
	}

	public void setClie_linkman(String clie_linkman) {
		this.clie_linkman = clie_linkman;
	}

	public String getClie_address() {
		return clie_address;
	}

	public void setClie_address(String clie_address) {
		this.clie_address = clie_address;
	}

	public String getClie_postcode() {
		return clie_postcode;
	}

	public void setClie_postcode(String clie_postcode) {
		this.clie_postcode = clie_postcode;
	}

	public String getClie_tel() {
		return clie_tel;
	}

	public void setClie_tel(String clie_tel) {
		this.clie_tel = clie_tel;
	}

	public String getClie_fax() {
		return clie_fax;
	}

	public void setClie_fax(String clie_fax) {
		this.clie_fax = clie_fax;
	}

	public String getClie_bank() {
		return clie_bank;
	}

	public void setClie_bank(String clie_bank) {
		this.clie_bank = clie_bank;
	}

	public String getClie_iban() {
		return clie_iban;
	}

	public void setClie_iban(String clie_iban) {
		this.clie_iban = clie_iban;
	}

	public String getClie_sort() {
		return clie_sort;
	}

	public void setClie_sort(String clie_sort) {
		this.clie_sort = clie_sort;
	}

	public Long getOper_id() {
		return oper_id;
	}

	public void setOper_id(Long oper_id) {
		this.oper_id = oper_id;
	}

	public String getClie_creditlimt() {
		return clie_creditlimt;
	}

	public void setClie_creditlimt(String clie_creditLimt) {
		this.clie_creditlimt = clie_creditLimt;
	}

	@Override
	public String toString() {
		return "Client_Bill [clie_id=" + clie_id + ", clie_spell_code=" + clie_spell_code + ", clie_shortname="
				+ clie_shortname + ", clie_name=" + clie_name + ", clie_linkman=" + clie_linkman + ", clie_address="
				+ clie_address + ", clie_postcode=" + clie_postcode + ", clie_tel=" + clie_tel + ", clie_fax="
				+ clie_fax + ", clie_bank=" + clie_bank + ", clie_iban=" + clie_iban + ", clie_sort=" + clie_sort
				+ ", oper_id=" + oper_id + ", clie_creditLimt=" + clie_creditlimt + "]";
	}
	
}
