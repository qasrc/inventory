package com.msunsoft.service.impl;

import com.msunsoft.exception.ServiceException;
import com.msunsoft.mapper.infoManager.Suppliers_BillMapper;
import com.msunsoft.model.Suppliers_Bill;
import com.msunsoft.service.Suppliers_BillService;
import com.msunsoft.utils.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Administrator
 *         Created on 2016/11/29  16:45
 */
@Service
public class Suppliers_BillServiceImpl implements Suppliers_BillService {

    @Autowired
    private Suppliers_BillMapper suppliers_billMapper;

    /**
     * 添加
     * @param suppliers_bill
     */
    @Override
    public void addSuppliers(Suppliers_Bill suppliers_bill) {
        int status = suppliers_billMapper.addDomain(suppliers_bill);
        if (status!=1) {
            throw new ServiceException("添加失败");
        }
    }

    /**
     * 更新
     * @param suppliers_bill
     */
    @Override
    public void updateSuppliers(Suppliers_Bill suppliers_bill) {
        int status = suppliers_billMapper.updateDomain(suppliers_bill);
        if (status!=1) {
            throw new ServiceException("更新失败");
        }
    }

    /**
     * 删除
     * @param id
     */
    @Override
    public void deleteSuppliersById(Long id) {
        int status = suppliers_billMapper.deleteDomain(id);
        if (status!=1) {
            throw new ServiceException("删除失败");
        }
    }

    /**
     * 根据id获取
     * @param id
     * @return
     */
    @Override
    public Suppliers_Bill getSuppliersById(Long id) {
        return suppliers_billMapper.findDomainById(id);
    }

    /**
     * 分页获取
     * @param pageInfo
     */
    @Override
    public void getPageContentSu(PageInfo pageInfo) {
        pageInfo.setRows(suppliers_billMapper.findPageCondition(pageInfo));
        pageInfo.setTotal(suppliers_billMapper.findPageCount(pageInfo));
    }


}
