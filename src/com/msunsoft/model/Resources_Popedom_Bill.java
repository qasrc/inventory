package com.msunsoft.model;

/**
 * 资源和角色的对应关系
 *
 * @author zhan
 *         Created on 2016/11/29  20:48
 */
public class Resources_Popedom_Bill {
    private Long id;

    private Long popedom_bill_id;

    private Long resources_id;

    public Resources_Popedom_Bill() {
    }

    public Resources_Popedom_Bill(Long id, Long popedom_bill_id, Long resources_id) {
        this.id = id;
        this.popedom_bill_id = popedom_bill_id;
        this.resources_id = resources_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPopedom_bill_id() {
        return popedom_bill_id;
    }

    public void setPopedom_bill_id(Long popedom_bill_id) {
        this.popedom_bill_id = popedom_bill_id;
    }

    public Long getResources_id() {
        return resources_id;
    }

    public void setResources_id(Long resources_id) {
        this.resources_id = resources_id;
    }
}
