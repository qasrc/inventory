package com.msunsoft.service.impl;

import com.msunsoft.exception.ServiceException;
import com.msunsoft.mapper.Salemapper.Sale_Ordermapper;
import com.msunsoft.model.Sale_Order;
import com.msunsoft.service.Sale_OrderService;
import com.msunsoft.utils.PageInfo;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhang
 *         Created on 2016/11/30  13:19
 */
@Service
public class Sale_OrderServiceImpl implements Sale_OrderService {
    @Autowired
    private Sale_Ordermapper sale_ordermapper;
    private static Logger LOGGER= Logger.getLogger(Sale_OrderServiceImpl.class);
    @Override
    public void addSale_Order(Sale_Order sale_order) {
        int insert= sale_ordermapper.insertSo(sale_order);
        if (insert != 1) {
            LOGGER.warn("插入失败，参数：{}", new Throwable(sale_order.toString()));

            throw new ServiceException("插入失败");
        }
    }


    @Override
    public void deleteSale_Order(Long so_id) {
        int update = sale_ordermapper.deleteSale_OrderById(so_id);
        if (update != 1) {
            LOGGER.warn("删除失败，id：{}");
            throw new ServiceException("删除失败");
        }
    }

    @Override
    public void updateSale_Order(Sale_Order sale_order) {
        int update = sale_ordermapper.updateSale_Order(sale_order);
        if (update != 1) {
            LOGGER.warn("更新失败，参数：{}");
            throw new ServiceException("更新失败");
        }
    }


    @Override
    public void findDataGrid(PageInfo pageInfo) {
        pageInfo.setRows(sale_ordermapper.findSale_OrderPageCondition(pageInfo));
        pageInfo.setTotal(sale_ordermapper.findSale_OrderPageCount(pageInfo));
    }

    @Override
    public Sale_Order findSale_OrderById(Long so_id) {
       return sale_ordermapper.findSale_OrderById(so_id);
    }

}
