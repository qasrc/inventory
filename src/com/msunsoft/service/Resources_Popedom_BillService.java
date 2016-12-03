package com.msunsoft.service;

import com.msunsoft.model.Resources_Popedom_Bill;

import java.util.List;

/**
 * 资源角色对应关系service
 *
 * @author zhan
 *         Created on 2016/11/30  18:42
 */

public interface Resources_Popedom_BillService {

    /**
     * 插入
     * @param resources_popedom_bill
     */
    void addRPB(Resources_Popedom_Bill resources_popedom_bill);

    /**
     * 更新
     * @param resources_popedom_bill
     */
    void updateRPB(Resources_Popedom_Bill resources_popedom_bill);

    /**
     * 根据id删除
     * @param id
     */
    void deleteRPBById(Long id);

    /**
     * 根据主键id查询
     * @param id
     * @return
     */
    Resources_Popedom_Bill getRPBById(Long id);

    /**
     * 根据角色id进行查询
     * @param id
     * @return
     */
    List<Resources_Popedom_Bill> getRPBByPopeId(Long id);
}
