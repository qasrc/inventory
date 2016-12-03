package com.msunsoft.model;


/**
 *库存表
 */
public class Stock {

	private Long comm_id;
	private String amount;
	private Double money;
	private String depo_id;
	
	public Stock() {
		super();
	}

	public Stock(Long comm_id, String amount, Double money, String depo_id) {
		super();
		this.comm_id = comm_id;
		this.amount = amount;
		this.money = money;
		this.depo_id = depo_id;
	}

	public Long getComm_id() {
		return comm_id;
	}

	public void setComm_id(Long comm_id) {
		this.comm_id = comm_id;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	public String getDepo_id() {
		return depo_id;
	}

	public void setDepo_id(String depo_id) {
		this.depo_id = depo_id;
	}

	@Override
	public String toString() {
		return "Stock [comm_id=" + comm_id + ", amount=" + amount + ", money=" + money + ", depo_id=" + depo_id + "]";
	}
	
}
