package com.msunsoft.service.impl;

import com.msunsoft.exception.ServiceException;
import com.msunsoft.mapper.infoManager.Client_BillMapper;
import com.msunsoft.model.Client_Bill;
import com.msunsoft.service.Client_BillService;
import com.msunsoft.utils.PageInfo;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Administrator
 *         Created on 2016/11/29  16:40
 */
@Service
public class Client_BillServiceImpl implements Client_BillService {

    private static Logger logger = Logger.getLogger(Client_BillService.class);

    @Autowired
    private Client_BillMapper client_billMapper;

    /**
     * 添加
     * @param client_bill
     */
    @Override
    public void addClient_Bill(Client_Bill client_bill) {
        int status = client_billMapper.addDomain(client_bill);
        if (status!=1) {
            throw new ServiceException("添加失败");
        }
    }

    /**
     * 更新
     * @param client_bill
     */
    @Override
    public void updateClient_Bill(Client_Bill client_bill) {
        int status = client_billMapper.updateDomain(client_bill);
        if (status!=1) {
            throw new ServiceException("添加失败");
        }

    }

    /**
     * 删除
     * @param id
     */
    @Override
    public void deleteClient_Bill(Long id) {
        int status = client_billMapper.deleteDomain(id);
        if (status!=1) {
            throw new ServiceException("添加失败");
        }

    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @Override
    public Client_Bill findClient_BillById(Long id) {
        return client_billMapper.findDomainById(id);
    }


    /**
     * 分页查询
     * @param pageInfo
     * @return
     */
    @Override
    public void findClient_BillPageCondition(PageInfo pageInfo) {
        pageInfo.setRows(client_billMapper.findPageCondition(pageInfo));
        pageInfo.setTotal(client_billMapper.findPageCount(pageInfo));
    }
}
