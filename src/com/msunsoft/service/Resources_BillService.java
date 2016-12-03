package com.msunsoft.service;

import com.msunsoft.model.Resources_Bill;
import com.msunsoft.model.User_Bill;
import com.msunsoft.utils.Tree;

import java.util.List;

/**
 * 资源
 *
 * @author zhan
 *         Created on 2016/11/29  13:25
 */
public interface Resources_BillService {

    /**
     * 根据角色获取资源列表
     * @return
     */
    List<Tree> findTree(User_Bill user_bill);

    /**
     * 获取所有的资源树
     * @return
     */
    List<Tree> findAllTree();


    /**
     * 获取所有资源列表
     * @return
     */
    List<Resources_Bill> findResourcesAll();

    /**
     * 添加资源
     * @param resources_bill
     * @return
     */
    void addResource(Resources_Bill resources_bill);

    /**
     * 更新资源
     * @param resources_bill
     */
    void updateResource(Resources_Bill resources_bill);

    /**
     * 根据id删除资源
     * @param id
     */
    void deleteResource(Long id);

    /**
     * 根据id查询资源
     * @param id
     * @return
     */
    Resources_Bill findResourceById(Long id);



}
