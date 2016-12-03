package com.msunsoft.mapper;

import java.util.List;

/**
 * 基类mapper
 *
 * @author zhan
 *         Created on 2016/12/01  8:11
 */
public interface BaseMapper<T> {

    /**
     * 添加实体
     * @param t
     * @return
     */
    int addDomain(T t);

    /**
     * 删除实体
     * @param id
     * @return
     */
    int deleteDomain(Long id);

    /**
     * 更新实体
     * @param t
     * @return
     */
    int updateDomain(T t);

    /**
     * 根据id获取
     * @param id
     * @return
     */
    T findDomainById(Long id);

    /**
     * 获取所有
     * @return
     */
    List<T> findAllDomainById();


}
