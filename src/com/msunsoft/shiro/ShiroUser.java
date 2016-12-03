/**
 *
 */
package com.msunsoft.shiro;

import java.io.Serializable;

/**
 * @description：自定义Authentication对象，使得Subject除了携带用户的登录名外还可以携带更多信息
 */
public class ShiroUser implements Serializable {

    private static final long serialVersionUID = -1373760761780840081L;
    public Long id;
    public String name;
    public Long popedomId;

    public ShiroUser() {
    }

    public ShiroUser(Long id, String name, Long popedomId) {
        this.id = id;
        this.name = name;
        this.popedomId = popedomId;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPopedomId() {
        return popedomId;
    }

    public void setPopedomId(Long popedomId) {
        this.popedomId = popedomId;
    }
}