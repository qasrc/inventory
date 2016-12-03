package com.msunsoft.model;

import java.util.Date;

/**
 * 预收款
 *
 * @author Administrator
 *         Created on 2016/11/29  11:34
 */
public class Deposit_Received {
    private Long dr_id;//预收款编号
    private Long dr_inv;//发票号
    private Date dr_inv_date;//填票日期
    private Long clie_id;//客户编号
    private Double dr_money;//预收款总额
    private Date dr_date;//收款日期

    public Deposit_Received() {
    }

    public Deposit_Received(Long dr_id, Long dr_inv, Date dr_inv_date, Long clie_id, Double dr_money, Date dr_date) {

        this.dr_id = dr_id;
        this.dr_inv = dr_inv;
        this.dr_inv_date = dr_inv_date;
        this.clie_id = clie_id;
        this.dr_money = dr_money;
        this.dr_date = dr_date;
    }

    public Long getDr_id() {

        return dr_id;
    }

    public void setDr_id(Long dr_id) {
        this.dr_id = dr_id;
    }

    public Long getDr_inv() {
        return dr_inv;
    }

    public void setDr_inv(Long dr_inv) {
        this.dr_inv = dr_inv;
    }

    public Date getDr_inv_date() {
        return dr_inv_date;
    }

    public void setDr_inv_date(Date dr_inv_date) {
        this.dr_inv_date = dr_inv_date;
    }

    public Long getClie_id() {
        return clie_id;
    }

    public void setClie_id(Long clie_id) {
        this.clie_id = clie_id;
    }

    public Double getDr_money() {
        return dr_money;
    }

    public void setDr_money(Double dr_money) {
        this.dr_money = dr_money;
    }

    public Date getDr_date() {
        return dr_date;
    }

    public void setDr_date(Date dr_date) {
        this.dr_date = dr_date;
    }

    @Override
    public String toString() {
        return "Deposit_received{" +
                "dr_id=" + dr_id +
                ", dr_inv=" + dr_inv +
                ", dr_inv_date=" + dr_inv_date +
                ", clie_id=" + clie_id +
                ", dr_money=" + dr_money +
                ", dr_date=" + dr_date +
                '}';
    }
}
