package com.msunsoft.model;

import java.util.Date;

/**
 * 调拨单
 *
 * @author Administrator
 *         Created on 2016/11/29  12:34
 */
public class Cargo_Transfer_Bill {
    private Long ctb_id;//调拨单编号
    private Long stor_id;//门店编号
    private Long comm_id;//货物编号
    private Long ctb_amount;//调货数量
    private Date ctb_date;//日期
    private Long isCtb;//调拨状态

    public Cargo_Transfer_Bill() {
    }

    public Cargo_Transfer_Bill(Long ctb_id, Long stor_id, Long comm_id, Long ctb_amount, Date ctb_date, Long isCtb) {

        this.ctb_id = ctb_id;
        this.stor_id = stor_id;
        this.comm_id = comm_id;
        this.ctb_amount = ctb_amount;
        this.ctb_date = ctb_date;
        this.isCtb = isCtb;
    }

    public Long getCtb_id() {

        return ctb_id;
    }

    public void setCtb_id(Long ctb_id) {
        this.ctb_id = ctb_id;
    }

    public Long getStor_id() {
        return stor_id;
    }

    public void setStor_id(Long stor_id) {
        this.stor_id = stor_id;
    }

    public Long getComm_id() {
        return comm_id;
    }

    public void setComm_id(Long comm_id) {
        this.comm_id = comm_id;
    }

    public Long getCtb_amount() {
        return ctb_amount;
    }

    public void setCtb_amount(Long ctb_amount) {
        this.ctb_amount = ctb_amount;
    }

    public Date getCtb_date() {
        return ctb_date;
    }

    public void setCtb_date(Date ctb_date) {
        this.ctb_date = ctb_date;
    }

    public Long getIsCtb() {
        return isCtb;
    }

    public void setIsCtb(Long isCtb) {
        this.isCtb = isCtb;
    }

    @Override
    public String toString() {
        return "cargo_transfer_bill{" +
                "ctb_id=" + ctb_id +
                ", stor_id=" + stor_id +
                ", comm_id=" + comm_id +
                ", ctb_amount=" + ctb_amount +
                ", ctb_date=" + ctb_date +
                ", isCtb=" + isCtb +
                '}';
    }
}
