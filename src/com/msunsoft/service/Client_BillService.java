package com.msunsoft.service;

import com.msunsoft.model.Client_Bill;
import com.msunsoft.utils.PageInfo;

/**
 * 客户清单表
 *
 * @author Administrator
 *         Created on 2016/11/29  15:50
 */
public interface Client_BillService {


    /**
     * 添加
     * @param client_bill
     */
    void addClient_Bill(Client_Bill client_bill);

    /**
     * 更新
     * @param client_bill
     */
    void updateClient_Bill(Client_Bill client_bill);

    /**
     * 根据id删除
     * @param id
     */
    void deleteClient_Bill(Long id);

    /**
     * 根据id查找
     * @param id
     * @return
     */
    Client_Bill findClient_BillById(Long id);

    /**
     * 分页查询
     * @param pageInfo
     * @return
     */
    void findClient_BillPageCondition(PageInfo pageInfo);
}
