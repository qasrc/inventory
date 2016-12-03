package com.msunsoft.model;

import java.util.Date;

/**
 * 报损报溢表
 *
 * @author Administrator
 *         Created on 2016/11/29  12:29
 */
public class Report_Profit_Loss {
    private Long rpl_id;//报损报溢编号
    private Long comm_id;//货物编号
    private Long depo_id;//仓库编号
    private Long rpl_amount;//货物数量
    private Double rpl_money;//货物金额
    private Date rpl_date;//制单日期
    private String duty_person;//责任人
    private String cbill;//制单人

    public Report_Profit_Loss() {
    }

    public Report_Profit_Loss(Long rpl_id, Long comm_id, Long depo_id, Long rpl_amount, Double rpl_money, Date rpl_date, String duty_person, String cbill) {

        this.rpl_id = rpl_id;
        this.comm_id = comm_id;
        this.depo_id = depo_id;
        this.rpl_amount = rpl_amount;
        this.rpl_money = rpl_money;
        this.rpl_date = rpl_date;
        this.duty_person = duty_person;
        this.cbill = cbill;
    }

    public Long getRpl_id() {

        return rpl_id;
    }

    public void setRpl_id(Long rpl_id) {
        this.rpl_id = rpl_id;
    }

    public Long getComm_id() {
        return comm_id;
    }

    public void setComm_id(Long comm_id) {
        this.comm_id = comm_id;
    }

    public Long getDepo_id() {
        return depo_id;
    }

    public void setDepo_id(Long depo_id) {
        this.depo_id = depo_id;
    }

    public Long getRpl_amount() {
        return rpl_amount;
    }

    public void setRpl_amount(Long rpl_amount) {
        this.rpl_amount = rpl_amount;
    }

    public Double getRpl_money() {
        return rpl_money;
    }

    public void setRpl_money(Double rpl_money) {
        this.rpl_money = rpl_money;
    }

    public Date getRpl_date() {
        return rpl_date;
    }

    public void setRpl_date(Date rpl_date) {
        this.rpl_date = rpl_date;
    }

    public String getDuty_person() {
        return duty_person;
    }

    public void setDuty_person(String duty_person) {
        this.duty_person = duty_person;
    }

    public String getCbill() {
        return cbill;
    }

    public void setCbill(String cbill) {
        this.cbill = cbill;
    }

    @Override
    public String toString() {
        return "Report_profit_loss{" +
                "rpl_id=" + rpl_id +
                ", comm_id=" + comm_id +
                ", depo_id=" + depo_id +
                ", rpl_amount=" + rpl_amount +
                ", rpl_money=" + rpl_money +
                ", rpl_date=" + rpl_date +
                ", duty_person='" + duty_person + '\'' +
                ", cbill='" + cbill + '\'' +
                '}';
    }
}
