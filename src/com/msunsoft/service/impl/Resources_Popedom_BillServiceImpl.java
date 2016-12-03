package com.msunsoft.service.impl;

import com.msunsoft.exception.ServiceException;
import com.msunsoft.mapper.Resources_Popedom_Bill_Mapper;
import com.msunsoft.model.Resources_Popedom_Bill;
import com.msunsoft.service.Resources_Popedom_BillService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhan
 *         Created on 2016/11/30  18:42
 */
@Service
public class Resources_Popedom_BillServiceImpl implements Resources_Popedom_BillService {

    private static Logger logger = Logger.getLogger(Resources_Popedom_BillService.class);

    @Autowired
    private Resources_Popedom_Bill_Mapper resources_popedom_bill_mapper;

    @Override
    public void addRPB(Resources_Popedom_Bill resources_popedom_bill) {
        int status = resources_popedom_bill_mapper.insertRPB(resources_popedom_bill);
        if (status!=1) {
            logger.error("添加失败:"+resources_popedom_bill.toString());
            throw new ServiceException("添加失败");
        }
    }

    @Override
    public void updateRPB(Resources_Popedom_Bill resources_popedom_bill) {
        int status = resources_popedom_bill_mapper.updateRPB(resources_popedom_bill);
        if (status!=1) {
            logger.error("修改失败："+resources_popedom_bill.toString());
            throw new ServiceException("修改失败");
        }
    }

    @Override
    public void deleteRPBById(Long id) {
        int status = resources_popedom_bill_mapper.deletePRB(id);
        if (status!=1) {
            logger.error("删除失败"+id);
            throw new ServiceException("删除失败");
        }
    }

    @Override
    public Resources_Popedom_Bill getRPBById(Long id) {
        return resources_popedom_bill_mapper.getRPBById(id);
    }

    @Override
    public List<Resources_Popedom_Bill> getRPBByPopeId(Long id) {
        return resources_popedom_bill_mapper.getRPBByPopeId(id);
    }
}
