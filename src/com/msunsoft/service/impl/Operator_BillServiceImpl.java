package com.msunsoft.service.impl;

import com.msunsoft.exception.ServiceException;
import com.msunsoft.mapper.infoManager.Operator_BillMapper;
import com.msunsoft.model.Operator_Bill;
import com.msunsoft.service.Operator_BillService;
import com.msunsoft.utils.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Administrator
 *         Created on 2016/11/29  16:41
 */
@Service
public class Operator_BillServiceImpl implements Operator_BillService {

    @Autowired
    private Operator_BillMapper operator_billMapper;

    @Override
    public Operator_Bill findOperatorById(Long id) {
        return operator_billMapper.findDomainById(id);
    }

    @Override
    public void deleteOperatorById(Long id) {
        int status = operator_billMapper.deleteDomain(id);
        if (status!=1) {
            throw new ServiceException("删除失败");
        }
    }

    @Override
    public void addOperator(Operator_Bill operator_bill) {
        int status = operator_billMapper.addDomain(operator_bill);
        if (status!=1) {
            throw new ServiceException("添加失败");
        }
    }

    @Override
    public void updateOperator(Operator_Bill operator_bill) {
        int status = operator_billMapper.updateDomain(operator_bill);
        if(status!=1){
            throw new ServiceException("更新失败");
        }
    }

    @Override
    public void findPageCondition(PageInfo pageInfo) {
        pageInfo.setRows(operator_billMapper.findPageCondition(pageInfo));
        pageInfo.setTotal(operator_billMapper.findPageCount(pageInfo));
    }
}
