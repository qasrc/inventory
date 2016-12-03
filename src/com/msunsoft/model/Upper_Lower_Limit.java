package com.msunsoft.model;

/**
 * 上下限对照表
 *
 * @author Administrator
 *         Created on 2016/11/29  11:46
 */
public class Upper_Lower_Limit {
    private Long ull_id;//对照编号
    private Long depo_id;//仓库编号
    private Long comm_id;//货物编号
    private Long ull_upper;//上限数量
    private Long ull_lower;//下限数量
    private Long ull_optimal;//最佳存量
    private String ull_desc;//备注

    public Upper_Lower_Limit() {
    }

    public Upper_Lower_Limit(Long ull_id, Long depo_id, Long comm_id, Long ull_upper, Long ull_lower, Long ull_optimal, String ull_desc) {

        this.ull_id = ull_id;
        this.depo_id = depo_id;
        this.comm_id = comm_id;
        this.ull_upper = ull_upper;
        this.ull_lower = ull_lower;
        this.ull_optimal = ull_optimal;
        this.ull_desc = ull_desc;
    }

    public Long getUll_id() {

        return ull_id;
    }

    public void setUll_id(Long ull_id) {
        this.ull_id = ull_id;
    }

    public Long getDepo_id() {
        return depo_id;
    }

    public void setDepo_id(Long depo_id) {
        this.depo_id = depo_id;
    }

    public Long getComm_id() {
        return comm_id;
    }

    public void setComm_id(Long comm_id) {
        this.comm_id = comm_id;
    }

    public Long getUll_upper() {
        return ull_upper;
    }

    public void setUll_upper(Long ull_upper) {
        this.ull_upper = ull_upper;
    }

    public Long getUll_lower() {
        return ull_lower;
    }

    public void setUll_lower(Long ull_lower) {
        this.ull_lower = ull_lower;
    }

    public Long getUll_optimal() {
        return ull_optimal;
    }

    public void setUll_optimal(Long ull_optimal) {
        this.ull_optimal = ull_optimal;
    }

    public String getUll_desc() {
        return ull_desc;
    }

    public void setUll_desc(String ull_desc) {
        this.ull_desc = ull_desc;
    }

    @Override
    public String toString() {
        return "Upper_lower_limit{" +
                "ull_id=" + ull_id +
                ", depo_id=" + depo_id +
                ", comm_id=" + comm_id +
                ", ull_upper=" + ull_upper +
                ", ull_lower=" + ull_lower +
                ", ull_optimal=" + ull_optimal +
                ", ull_desc='" + ull_desc + '\'' +
                '}';
    }
}
