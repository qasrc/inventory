package com.msunsoft.model;

import java.util.Date;

/**
 *进价调整单
 */
public class Update_Purchase_Price {

	private Long upp_id;
	private Long pii_id;
	private Long upp_amount;
	private Double old_purchase_price;
	private Double new_purchase_price;
	private Date upp_date;
	private String cbill;
	
	public Update_Purchase_Price() {
		super();
	}

	public Update_Purchase_Price(Long upp_id, Long pii_id, Long upp_amount, Double old_purchase_price,
			Double new_purchase_price, Date upp_date, String cbill) {
		super();
		this.upp_id = upp_id;
		this.pii_id = pii_id;
		this.upp_amount = upp_amount;
		this.old_purchase_price = old_purchase_price;
		this.new_purchase_price = new_purchase_price;
		this.upp_date = upp_date;
		this.cbill = cbill;
	}

	public Long getUpp_id() {
		return upp_id;
	}

	public void setUpp_id(Long upp_id) {
		this.upp_id = upp_id;
	}

	public Long getPii_id() {
		return pii_id;
	}

	public void setPii_id(Long pii_id) {
		this.pii_id = pii_id;
	}

	public Long getUpp_amount() {
		return upp_amount;
	}

	public void setUpp_amount(Long upp_amount) {
		this.upp_amount = upp_amount;
	}

	public Double getOld_purchase_price() {
		return old_purchase_price;
	}

	public void setOld_purchase_price(Double old_purchase_price) {
		this.old_purchase_price = old_purchase_price;
	}

	public Double getNew_purchase_price() {
		return new_purchase_price;
	}

	public void setNew_purchase_price(Double new_purchase_price) {
		this.new_purchase_price = new_purchase_price;
	}

	public Date getUpp_date() {
		return upp_date;
	}

	public void setUpp_date(Date upp_date) {
		this.upp_date = upp_date;
	}

	public String getCbill() {
		return cbill;
	}

	public void setCbill(String cbill) {
		this.cbill = cbill;
	}

	@Override
	public String toString() {
		return "Update_Purchase_Price [upp_id=" + upp_id + ", pii_id=" + pii_id + ", upp_amount=" + upp_amount
				+ ", old_purchase_price=" + old_purchase_price + ", new_purchase_price=" + new_purchase_price
				+ ", upp_date=" + upp_date + ", cbill=" + cbill + "]";
	}
	
	
}
