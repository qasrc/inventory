package com.msunsoft.service;

import com.msunsoft.model.Sale_Order;
import com.msunsoft.utils.PageInfo;

/**
 * Sale_OrderService
 *
 * @author zhang
 *         Created on 2016/11/30  13:12
 */

public interface Sale_OrderService {
    /**
     * 增加销售订单表
     * @param sale_order
     */
    void addSale_Order(Sale_Order sale_order);

    /**
     * 删除销售订单表
     * @param so_id
     */
    void deleteSale_Order(Long so_id);

    /**
     * 更改销售订单表
     * @param sale_order
     */
    void updateSale_Order(Sale_Order sale_order);

    /**
     * 列出销售订单表
     * @param
     */
    void findDataGrid(PageInfo pageInfo);

    Sale_Order  findSale_OrderById(Long so_id);

}
