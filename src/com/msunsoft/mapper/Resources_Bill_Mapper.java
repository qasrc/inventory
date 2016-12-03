package com.msunsoft.mapper;

import com.msunsoft.model.Resources_Bill;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 用户资源mapper
 *
 * @author zhan
 *         Created on 2016/11/29  20:52
 */
@Component
public interface Resources_Bill_Mapper {

    /**
     * 插入
     *
     * @param resources_bill
     * @return
     */
    int insertResource(Resources_Bill resources_bill);

    /**
     * 更新
     *
     * @param resources_bill
     * @return
     */
    int updateResource(Resources_Bill resources_bill);

    /**
     * 删除
     *
     * @param id
     * @return
     */
    int deleteResource(Long id);

    /**
     * 根据id查找
     *
     * @param id
     * @return
     */
    Resources_Bill getResourceById(Long id);

    /**
     * 获取所有
     *
     * @return
     */
    List<Resources_Bill> findAllResource();

    /**
     * 获取二级菜单
     *
     * @return
     */
    List<Resources_Bill> findResourceByPid(@Param("pid") Long pid);

    /**
     * 获取一级菜单
     * @return
     */
    List<Resources_Bill> findResourceByPidNull();


}
