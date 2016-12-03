package com.msunsoft.model;

/**
 * 销售日报表
 *
 * @author Administrator
 *         Created on 2016/11/29  11:20
 */
public class Posa {
    private Long posa_id;//日期编号
    private Long stor_id;//门店编号
    private Long posa_pos;//收款机号
    private Long comm_id;//货物编号
    private Long posa_shift;//班次
    private Long posa_sale_amount;//销售数量
    private Double posa_receivable_money;//应收金额
    private Double posa_received_money;//实收金额
    private Double posa_price;//库存单价

    public Posa() {
    }

    public Posa(Long posa_id, Long stor_id, Long posa_pos, Long comm_id, Long posa_shift, Long posa_sale_amount, Double posa_receivable_money, Double posa_received_money, Double posa_price) {
        this.posa_id = posa_id;
        this.stor_id = stor_id;
        this.posa_pos = posa_pos;
        this.comm_id = comm_id;
        this.posa_shift = posa_shift;
        this.posa_sale_amount = posa_sale_amount;
        this.posa_receivable_money = posa_receivable_money;
        this.posa_received_money = posa_received_money;
        this.posa_price = posa_price;
    }

    public Long getPosa_id() {
        return posa_id;
    }

    public void setPosa_id(Long posa_id) {
        this.posa_id = posa_id;
    }

    public Long getStor_id() {
        return stor_id;
    }

    public void setStor_id(Long stor_id) {
        this.stor_id = stor_id;
    }

    public Long getPosa_pos() {
        return posa_pos;
    }

    public void setPosa_pos(Long posa_pos) {
        this.posa_pos = posa_pos;
    }

    public Long getComm_id() {
        return comm_id;
    }

    public void setComm_id(Long comm_id) {
        this.comm_id = comm_id;
    }

    public Long getPosa_shift() {
        return posa_shift;
    }

    public void setPosa_shift(Long posa_shift) {
        this.posa_shift = posa_shift;
    }

    public Long getPosa_sale_amount() {
        return posa_sale_amount;
    }

    public void setPosa_sale_amount(Long posa_sale_amount) {
        this.posa_sale_amount = posa_sale_amount;
    }

    public Double getPosa_receivable_money() {
        return posa_receivable_money;
    }

    public void setPosa_receivable_money(Double posa_receivable_money) {
        this.posa_receivable_money = posa_receivable_money;
    }

    public Double getPosa_received_money() {
        return posa_received_money;
    }

    public void setPosa_received_money(Double posa_received_money) {
        this.posa_received_money = posa_received_money;
    }

    public Double getPosa_price() {
        return posa_price;
    }

    public void setPosa_price(Double posa_price) {
        this.posa_price = posa_price;
    }

    @Override
    public String toString() {
        return "Posa{" +
                "posa_id=" + posa_id +
                ", stor_id=" + stor_id +
                ", posa_pos=" + posa_pos +
                ", comm_id=" + comm_id +
                ", posa_shift=" + posa_shift +
                ", posa_sale_amount=" + posa_sale_amount +
                ", posa_receivable_money=" + posa_receivable_money +
                ", posa_received_money=" + posa_received_money +
                ", posa_price=" + posa_price +
                '}';
    }
}
