package com.msunsoft.model;

import java.util.Date;

/**
 * 调货申请表
 *
 * @author Administrator
 *         Created on 2016/11/29  11:05
 */
public class Cargo_Transfer_Apply {
    private Long cta_id;//申请编号
    private Long stor_id;//门店编号
    private Long comm_id;//货物编号
    private Long cta_amount;//申请数量
    private Date cta_date;//日期
    private String cta_person;//申请人
    private String cta_desc;//申请说明
    private Integer cta_isReply;//回复状态

    public Cargo_Transfer_Apply() {
    }

    public Cargo_Transfer_Apply(Long cta_id, Long stor_id, Long comm_id, Long cta_amount, Date cta_date, String cta_person, String cta_desc, Integer cta_isReply) {
        this.cta_id = cta_id;
        this.stor_id = stor_id;
        this.comm_id = comm_id;
        this.cta_amount = cta_amount;
        this.cta_date = cta_date;
        this.cta_person = cta_person;
        this.cta_desc = cta_desc;
        this.cta_isReply = cta_isReply;
    }

    public Long getCta_id() {
        return cta_id;
    }

    public void setCta_id(Long cta_id) {
        this.cta_id = cta_id;
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

    public Long getCta_amount() {
        return cta_amount;
    }

    public void setCta_amount(Long cta_amount) {
        this.cta_amount = cta_amount;
    }

    public Date getCta_date() {
        return cta_date;
    }

    public void setCta_date(Date cta_date) {
        this.cta_date = cta_date;
    }

    public String getCta_person() {
        return cta_person;
    }

    public void setCta_person(String cta_person) {
        this.cta_person = cta_person;
    }

    public String getCta_desc() {
        return cta_desc;
    }

    public void setCta_desc(String cta_desc) {
        this.cta_desc = cta_desc;
    }

    public Integer getCta_isReply() {
        return cta_isReply;
    }

    public void setCta_isReply(Integer cta_isReply) {
        this.cta_isReply = cta_isReply;
    }

    @Override
    public String toString() {
        return "Cargo_Transfer_Apply{" +
                "cta_id=" + cta_id +
                ", stor_id=" + stor_id +
                ", comm_id=" + comm_id +
                ", cta_amount=" + cta_amount +
                ", cta_date=" + cta_date +
                ", cta_person='" + cta_person + '\'' +
                ", cta_desc='" + cta_desc + '\'' +
                ", cta_isReply=" + cta_isReply +
                '}';
    }
}
