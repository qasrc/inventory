package com.msunsoft.mapper.Salemapper;

import com.msunsoft.model.Sale_Order;
import com.msunsoft.utils.PageInfo;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Sale_OrderMapper
 *
 * @author zhang
 *         Created on 2016/11/30  9:01
 */
@Component
public interface Sale_Ordermapper {
    /**
     * 添加销售订单
     */
    int insertSo(Sale_Order sale_order);

    /**
     * 查询销售订单
     */
    // Sale_Order findSale_Order(Long so_id);

    /**
     * 删除销售订单
     */
    int deleteSale_OrderById(Long so_id);

    /**
     * 查询销售订单列表
     */
    List findSale_OrderPageCondition(PageInfo pageInfo);


    int findSale_OrderPageCount(PageInfo pageInfo);

    /**
     * 更新销售列表
     */
    int updateSale_Order(Sale_Order sale_order);

    /**
     * 通过ID查询销售订单
     * @param so_id
     * @return
     */

    Sale_Order findSale_OrderById(Long so_id);

}
