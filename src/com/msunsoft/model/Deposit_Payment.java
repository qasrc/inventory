package com.msunsoft.model;

import java.util.Date;

/**
 * 预付款表
 *
 * @author Administrator
 *         Created on 2016/11/29  11:30
 */
public class Deposit_Payment {
    private Long dp_id;//预付款编号
    private Long dp_inv;//发票号
    private Date dp_inv_date;//填票日期
    private Long clie_id;//客户编号
    private Double dp_money;//预付款总额
    private Date dp_date;//付款日期

    public Deposit_Payment() {
    }

    public Deposit_Payment(Long dp_id, Long dp_inv, Date dp_inv_date, Long clie_id, Double dp_money, Date dp_date) {
        this.dp_id = dp_id;
        this.dp_inv = dp_inv;
        this.dp_inv_date = dp_inv_date;
        this.clie_id = clie_id;
        this.dp_money = dp_money;
        this.dp_date = dp_date;
    }

    public Long getDp_id() {
        return dp_id;
    }

    public void setDp_id(Long dp_id) {
        this.dp_id = dp_id;
    }

    public Long getDp_inv() {
        return dp_inv;
    }

    public void setDp_inv(Long dp_inv) {
        this.dp_inv = dp_inv;
    }

    public Date getDp_inv_date() {
        return dp_inv_date;
    }

    public void setDp_inv_date(Date dp_inv_date) {
        this.dp_inv_date = dp_inv_date;
    }

    public Long getClie_id() {
        return clie_id;
    }

    public void setClie_id(Long clie_id) {
        this.clie_id = clie_id;
    }

    public Double getDp_money() {
        return dp_money;
    }

    public void setDp_money(Double dp_money) {
        this.dp_money = dp_money;
    }

    public Date getDp_date() {
        return dp_date;
    }

    public void setDp_date(Date dp_date) {
        this.dp_date = dp_date;
    }

    @Override
    public String toString() {
        return "Deposit_payment{" +
                "dp_id=" + dp_id +
                ", dp_inv=" + dp_inv +
                ", dp_inv_date=" + dp_inv_date +
                ", clie_id=" + clie_id +
                ", dp_money=" + dp_money +
                ", dp_date=" + dp_date +
                '}';
    }
}
