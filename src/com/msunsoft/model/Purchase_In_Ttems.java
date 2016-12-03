package com.msunsoft.model;


/**
 *进货单明细表
 */
public class Purchase_In_Ttems {

	private Long pii_id;
	private Long pib_id;
	private Long comm_id;
	private Long pii_amount;
	private Long purc_price;
	
	public Purchase_In_Ttems() {
		super();
	}
	
	public Purchase_In_Ttems(Long pii_id, Long pib_id, Long comm_id, Long pii_amount, Long purc_price) {
		super();
		this.pii_id = pii_id;
		this.pib_id = pib_id;
		this.comm_id = comm_id;
		this.pii_amount = pii_amount;
		this.purc_price = purc_price;
	}
	public Long getPii_id() {
		return pii_id;
	}
	public void setPii_id(Long pii_id) {
		this.pii_id = pii_id;
	}
	public Long getPib_id() {
		return pib_id;
	}
	public void setPib_id(Long pib_id) {
		this.pib_id = pib_id;
	}
	public Long getComm_id() {
		return comm_id;
	}
	public void setComm_id(Long comm_id) {
		this.comm_id = comm_id;
	}
	public Long getPii_amount() {
		return pii_amount;
	}
	public void setPii_amount(Long pii_amount) {
		this.pii_amount = pii_amount;
	}
	public Long getPurc_price() {
		return purc_price;
	}
	public void setPurc_price(Long purc_price) {
		this.purc_price = purc_price;
	}
	
	@Override
	public String toString() {
		return "Purchase_In_Ttems [pii_id=" + pii_id + ", pib_id=" + pib_id + ", comm_id=" + comm_id + ", pii_amount="
				+ pii_amount + ", purc_price=" + purc_price + "]";
	}
	
}
