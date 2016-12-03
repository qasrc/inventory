package com.msunsoft.service;

import com.msunsoft.model.Popedom_Bill;
import com.msunsoft.utils.PageInfo;

import java.util.List;

/**
 * 用户角色
 * @author zhan
 *         Created on 2016/11/28  21:37
 */
public interface PopedomService {

    /**
     * 根据id查询
     * @param id
     * @return
     */
    Popedom_Bill findPopedomByUserId(Long id);

    /**
     * 添加
     * @param popedom_bill
     */
    void addPopedom(Popedom_Bill popedom_bill);

    /**
     * 更新
     * @param popedom_bill
     */
    void updatePopedom(Popedom_Bill popedom_bill);

    /**
     * 删除
     * @param id
     */
    void deletePopedom(Long id);

    /**
     * 获取所有
     * @return
     */
    List<Popedom_Bill> getAllPopedom();

    /**
     * 分页获取数据
     * @param pageInfo
     */
    void findAllDateGrid(PageInfo pageInfo);

    /**
     * 根据角色id获取资源id集合
     * @param id
     * @return
     */
    List<Long> findResourceIdByPopeId(Long id);

    /**
     * 根据id更新权限和资源的对应关系
     * @param id
     * @param resourceIds
     */
    void updatePopedomResource(Long id, String resourceIds);

//    List<Long> findResource_Popedom_Bill_ids(Long id);

}
