package com.msunsoft.model;

import java.util.Date;

/**
 * 进销存汇总表
 *
 * @author Administrator
 *         Created on 2016/11/29  11:25
 */
public class Jxc_Gather {
    private Long jg_id;//结账编号
    private Date jg_date;//结账日期
    private Long comm_id;//货物编号
    private Long last_checkout_amount;//上期结账数量
    private Double last_checkout_money;//上期结账金额
    private Long debit_amount;//借方数量
    private Double debit_money;//借方金额
    private Long credit_amount;//贷方数量
    private Double credit_money;//贷方金额
    private Long now_checkout_amount;//本期结存数量
    private Double noe_checkout_money;//本期结存金额
    private String jg_desc;//备注

    public Jxc_Gather() {
    }

    public Jxc_Gather(Long jg_id, Date jg_date, Long comm_id, Long last_checkout_amount, Double last_checkout_money, Long debit_amount, Double debit_money, Long credit_amount, Double credit_money, Long now_checkout_amount, Double noe_checkout_money, String jg_desc) {
        this.jg_id = jg_id;
        this.jg_date = jg_date;
        this.comm_id = comm_id;
        this.last_checkout_amount = last_checkout_amount;
        this.last_checkout_money = last_checkout_money;
        this.debit_amount = debit_amount;
        this.debit_money = debit_money;
        this.credit_amount = credit_amount;
        this.credit_money = credit_money;
        this.now_checkout_amount = now_checkout_amount;
        this.noe_checkout_money = noe_checkout_money;
        this.jg_desc = jg_desc;
    }

    public Long getJg_id() {
        return jg_id;
    }

    public void setJg_id(Long jg_id) {
        this.jg_id = jg_id;
    }

    public Date getJg_date() {
        return jg_date;
    }

    public void setJg_date(Date jg_date) {
        this.jg_date = jg_date;
    }

    public Long getComm_id() {
        return comm_id;
    }

    public void setComm_id(Long comm_id) {
        this.comm_id = comm_id;
    }

    public Long getLast_checkout_amount() {
        return last_checkout_amount;
    }

    public void setLast_checkout_amount(Long last_checkout_amount) {
        this.last_checkout_amount = last_checkout_amount;
    }

    public Double getLast_checkout_money() {
        return last_checkout_money;
    }

    public void setLast_checkout_money(Double last_checkout_money) {
        this.last_checkout_money = last_checkout_money;
    }

    public Long getDebit_amount() {
        return debit_amount;
    }

    public void setDebit_amount(Long debit_amount) {
        this.debit_amount = debit_amount;
    }

    public Double getDebit_money() {
        return debit_money;
    }

    public void setDebit_money(Double debit_money) {
        this.debit_money = debit_money;
    }

    public Long getCredit_amount() {
        return credit_amount;
    }

    public void setCredit_amount(Long credit_amount) {
        this.credit_amount = credit_amount;
    }

    public Double getCredit_money() {
        return credit_money;
    }

    public void setCredit_money(Double credit_money) {
        this.credit_money = credit_money;
    }

    public Long getNow_checkout_amount() {
        return now_checkout_amount;
    }

    public void setNow_checkout_amount(Long now_checkout_amount) {
        this.now_checkout_amount = now_checkout_amount;
    }

    public Double getNoe_checkout_money() {
        return noe_checkout_money;
    }

    public void setNoe_checkout_money(Double noe_checkout_money) {
        this.noe_checkout_money = noe_checkout_money;
    }

    public String getJg_desc() {
        return jg_desc;
    }

    public void setJg_desc(String jg_desc) {
        this.jg_desc = jg_desc;
    }

    @Override
    public String toString() {
        return "Jxc_gather{" +
                "jg_id=" + jg_id +
                ", jg_date=" + jg_date +
                ", comm_id=" + comm_id +
                ", last_checkout_amount=" + last_checkout_amount +
                ", last_checkout_money=" + last_checkout_money +
                ", debit_amount=" + debit_amount +
                ", debit_money=" + debit_money +
                ", credit_amount=" + credit_amount +
                ", credit_money=" + credit_money +
                ", now_checkout_amount=" + now_checkout_amount +
                ", noe_checkout_money=" + noe_checkout_money +
                ", jg_desc='" + jg_desc + '\'' +
                '}';
    }
}
