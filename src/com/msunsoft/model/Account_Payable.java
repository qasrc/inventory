package com.msunsoft.model;

import java.util.Date;

/**
 * 应付款表
 *
 * @author Administrator
 *         Created on 2016/11/29  11:41
 */
public class Account_Payable {
    private Long ap_id;//应付款编号
    private Long ap_INV;//发票号
    private Date ap_INV_date;//填票日期
    private Long pid_id;//进货单编号
    private Long comm_id;//货物编号
    private Long supp_id;//供货商编号
    private Long ap_comm_amount;//数量
    private Double ap_purchase_price;//进货单价
    private Double ap_money;//应付款金额
    private Date ap_date;//付款日期
    private String ap_desc;//详细说明
    private Integer isAp;//状态
    private Long dp_id;//（减）预付

    public Account_Payable() {
    }

    public Account_Payable(Long ap_id, Long ap_INV, Date ap_INV_date, Long pid_id, Long comm_id, Long supp_id, Long ap_comm_amount, Double ap_purchase_price, Double ap_money, Date ap_date, String ap_desc, Integer isAp, Long dp_id) {

        this.ap_id = ap_id;
        this.ap_INV = ap_INV;
        this.ap_INV_date = ap_INV_date;
        this.pid_id = pid_id;
        this.comm_id = comm_id;
        this.supp_id = supp_id;
        this.ap_comm_amount = ap_comm_amount;
        this.ap_purchase_price = ap_purchase_price;
        this.ap_money = ap_money;
        this.ap_date = ap_date;
        this.ap_desc = ap_desc;
        this.isAp = isAp;
        this.dp_id = dp_id;
    }

    public Long getAp_id() {

        return ap_id;
    }

    public void setAp_id(Long ap_id) {
        this.ap_id = ap_id;
    }

    public Long getAp_INV() {
        return ap_INV;
    }

    public void setAp_INV(Long ap_INV) {
        this.ap_INV = ap_INV;
    }

    public Date getAp_INV_date() {
        return ap_INV_date;
    }

    public void setAp_INV_date(Date ap_INV_date) {
        this.ap_INV_date = ap_INV_date;
    }

    public Long getPid_id() {
        return pid_id;
    }

    public void setPid_id(Long pid_id) {
        this.pid_id = pid_id;
    }

    public Long getComm_id() {
        return comm_id;
    }

    public void setComm_id(Long comm_id) {
        this.comm_id = comm_id;
    }

    public Long getSupp_id() {
        return supp_id;
    }

    public void setSupp_id(Long supp_id) {
        this.supp_id = supp_id;
    }

    public Long getAp_comm_amount() {
        return ap_comm_amount;
    }

    public void setAp_comm_amount(Long ap_comm_amount) {
        this.ap_comm_amount = ap_comm_amount;
    }

    public Double getAp_purchase_price() {
        return ap_purchase_price;
    }

    public void setAp_purchase_price(Double ap_purchase_price) {
        this.ap_purchase_price = ap_purchase_price;
    }

    public Double getAp_money() {
        return ap_money;
    }

    public void setAp_money(Double ap_money) {
        this.ap_money = ap_money;
    }

    public Date getAp_date() {
        return ap_date;
    }

    public void setAp_date(Date ap_date) {
        this.ap_date = ap_date;
    }

    public String getAp_desc() {
        return ap_desc;
    }

    public void setAp_desc(String ap_desc) {
        this.ap_desc = ap_desc;
    }

    public Integer getAp() {
        return isAp;
    }

    public void setAp(Integer ap) {
        isAp = ap;
    }

    public Long getDp_id() {
        return dp_id;
    }

    public void setDp_id(Long dp_id) {
        this.dp_id = dp_id;
    }

    @Override
    public String toString() {
        return "Account_payable{" +
                "ap_id=" + ap_id +
                ", ap_INV=" + ap_INV +
                ", ap_INV_date=" + ap_INV_date +
                ", pid_id=" + pid_id +
                ", comm_id=" + comm_id +
                ", supp_id=" + supp_id +
                ", ap_comm_amount=" + ap_comm_amount +
                ", ap_purchase_price=" + ap_purchase_price +
                ", ap_money=" + ap_money +
                ", ap_date=" + ap_date +
                ", ap_desc='" + ap_desc + '\'' +
                ", isAp=" + isAp +
                ", dp_id=" + dp_id +
                '}';
    }
}
