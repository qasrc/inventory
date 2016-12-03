package com.msunsoft.model;

import java.util.Date;

/**
 * 应收款表
 *
 * @author Administrator
 *         Created on 2016/11/29  11:36
 */
public class Account_Receivable {
    private Long ar_id;//应收款编号
    private Long ar_inv;//发票号
    private Date ar_inv_date;//填票日期
    private Long so_id;//销售单编号
    private Long comm_id;//货物编号
    private Long clie_id;//客户编号
    private Long ar_comm_amount;//数量
    private Double ar_sale_price;//销售价
    private Double ar_money;//应收款金额
    private Date ar_date;//收款日期
    private String ar_desc;//详细说明
    private Date ar_sale_date;//销售日期
    private Integer isAr;//状态
    private Long dr_id;//（减）预收

    public Account_Receivable() {
    }

    public Account_Receivable(Long ar_id, Long ar_inv, Date ar_inv_date, Long so_id, Long comm_id, Long clie_id, Long ar_comm_amount, Double ar_sale_price, Double ar_money, Date ar_date, String ar_desc, Date ar_sale_date, Integer isAr, Long dr_id) {

        this.ar_id = ar_id;
        this.ar_inv = ar_inv;
        this.ar_inv_date = ar_inv_date;
        this.so_id = so_id;
        this.comm_id = comm_id;
        this.clie_id = clie_id;
        this.ar_comm_amount = ar_comm_amount;
        this.ar_sale_price = ar_sale_price;
        this.ar_money = ar_money;
        this.ar_date = ar_date;
        this.ar_desc = ar_desc;
        this.ar_sale_date = ar_sale_date;
        this.isAr = isAr;
        this.dr_id = dr_id;
    }

    public Long getAr_id() {

        return ar_id;
    }

    public void setAr_id(Long ar_id) {
        this.ar_id = ar_id;
    }

    public Long getAr_inv() {
        return ar_inv;
    }

    public void setAr_inv(Long ar_inv) {
        this.ar_inv = ar_inv;
    }

    public Date getAr_inv_date() {
        return ar_inv_date;
    }

    public void setAr_inv_date(Date ar_inv_date) {
        this.ar_inv_date = ar_inv_date;
    }

    public Long getSo_id() {
        return so_id;
    }

    public void setSo_id(Long so_id) {
        this.so_id = so_id;
    }

    public Long getComm_id() {
        return comm_id;
    }

    public void setComm_id(Long comm_id) {
        this.comm_id = comm_id;
    }

    public Long getClie_id() {
        return clie_id;
    }

    public void setClie_id(Long clie_id) {
        this.clie_id = clie_id;
    }

    public Long getAr_comm_amount() {
        return ar_comm_amount;
    }

    public void setAr_comm_amount(Long ar_comm_amount) {
        this.ar_comm_amount = ar_comm_amount;
    }

    public Double getAr_sale_price() {
        return ar_sale_price;
    }

    public void setAr_sale_price(Double ar_sale_price) {
        this.ar_sale_price = ar_sale_price;
    }

    public Double getAr_money() {
        return ar_money;
    }

    public void setAr_money(Double ar_money) {
        this.ar_money = ar_money;
    }

    public Date getAr_date() {
        return ar_date;
    }

    public void setAr_date(Date ar_date) {
        this.ar_date = ar_date;
    }

    public String getAr_desc() {
        return ar_desc;
    }

    public void setAr_desc(String ar_desc) {
        this.ar_desc = ar_desc;
    }

    public Date getAr_sale_date() {
        return ar_sale_date;
    }

    public void setAr_sale_date(Date ar_sale_date) {
        this.ar_sale_date = ar_sale_date;
    }

    public Integer getAr() {
        return isAr;
    }

    public void setAr(Integer ar) {
        isAr = ar;
    }

    public Long getDr_id() {
        return dr_id;
    }

    public void setDr_id(Long dr_id) {
        this.dr_id = dr_id;
    }

    @Override
    public String toString() {
        return "Account_receivable{" +
                "ar_id=" + ar_id +
                ", ar_inv=" + ar_inv +
                ", ar_inv_date=" + ar_inv_date +
                ", so_id=" + so_id +
                ", comm_id=" + comm_id +
                ", clie_id=" + clie_id +
                ", ar_comm_amount=" + ar_comm_amount +
                ", ar_sale_price=" + ar_sale_price +
                ", ar_money=" + ar_money +
                ", ar_date=" + ar_date +
                ", ar_desc='" + ar_desc + '\'' +
                ", ar_sale_date=" + ar_sale_date +
                ", isAr=" + isAr +
                ", dr_id=" + dr_id +
                '}';
    }
}
