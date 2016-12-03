package com.msunsoft.service;

import com.msunsoft.model.Suppliers_Bill;
import com.msunsoft.utils.PageInfo;

/**
 * 供货商清单表
 *
 * @author Administrator
 *         Created on 2016/11/29  15:59
 */
public interface Suppliers_BillService {

    /**
     * 添加
     * @param suppliers_bill
     */
    void addSuppliers(Suppliers_Bill suppliers_bill);

    /**
     * 更新
     * @param suppliers_bill
     */
    void updateSuppliers(Suppliers_Bill suppliers_bill);

    /**
     * 删除
     *
     * @param id
     */
    void deleteSuppliersById(Long id);

    /**
     * 根据id删除
     * @param id
     * @return
     */
    Suppliers_Bill getSuppliersById(Long id);

    /**
     * 分页查询
     * @param pageInfo
     * @return
     */
    void getPageContentSu(PageInfo pageInfo);


}
