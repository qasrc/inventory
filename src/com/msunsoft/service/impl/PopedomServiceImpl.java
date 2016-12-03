package com.msunsoft.service.impl;

import com.google.common.collect.Lists;
import com.msunsoft.exception.ServiceException;
import com.msunsoft.mapper.Popedom_Bill_Mapper;
import com.msunsoft.mapper.Resources_Popedom_Bill_Mapper;
import com.msunsoft.model.Popedom_Bill;
import com.msunsoft.model.Resources_Popedom_Bill;
import com.msunsoft.service.PopedomService;
import com.msunsoft.utils.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhan
 *         Created on 2016/11/28  22:20
 */
@Service
public class PopedomServiceImpl implements PopedomService {

    @Autowired
    private Popedom_Bill_Mapper popedom_bill_mapper;
    @Autowired
    private Resources_Popedom_Bill_Mapper resources_popedom_bill_mapper;


    /**
     * 根据id获取
     * @param id
     * @return
     */
    @Override
    public Popedom_Bill findPopedomByUserId(Long id) {
        return popedom_bill_mapper.getPopedomById(id);
    }

    /**
     * 添加
     * @param popedom_bill
     */
    @Override
    public void addPopedom(Popedom_Bill popedom_bill) {
        int status = popedom_bill_mapper.insertPopedom(popedom_bill);
        if (status!=1) {
            throw new ServiceException("添加失败");
        }
    }

    /**
     * 更新
     * @param popedom_bill
     */
    @Override
    public void updatePopedom(Popedom_Bill popedom_bill) {
        int status = popedom_bill_mapper.updatePopedom(popedom_bill);
        if (status!=1) {
            throw new ServiceException("更新失败");
        }
    }

    /**
     * 根据id删除
     * @param id
     */
    @Override
    public void deletePopedom(Long id) {
        int status = popedom_bill_mapper.deletePopedom(id);
        if (status!=1) {
            throw new ServiceException("删除失败");
        }
    }

    @Override
    public List<Popedom_Bill> getAllPopedom() {

        return popedom_bill_mapper.getAllPopedom();
    }

    /**
     * 获取数据
     * @param pageInfo
     */
    @Override
    public void findAllDateGrid(PageInfo pageInfo) {
        pageInfo.setRows(popedom_bill_mapper.getAllGridDate(pageInfo));
        pageInfo.setTotal(popedom_bill_mapper.findDateCount(pageInfo));

    }

    /**
     * 根据角色id获取资源id集合
     * @param pope_id
     * @return
     */
    @Override
    public List<Long> findResourceIdByPopeId(Long pope_id) {
        List<Resources_Popedom_Bill> resources_popedom_bills = resources_popedom_bill_mapper.getRPBByPopeId(pope_id);
        List<Long> resourceIds = Lists.newArrayList();
        if (resources_popedom_bills != null) {
            for (Resources_Popedom_Bill resources_popedom_bill : resources_popedom_bills) {
                resourceIds.add(resources_popedom_bill.getResources_id());
            }
        }
        return resourceIds;
    }

    /**
     * 更新角色和资源的对应关系
     * @param id
     * @param resourceIds
     */
    @Override
    public void updatePopedomResource(Long id, String resourceIds) {
        //获取角色资源对应表的id
//        List<Resources_Popedom_Bill> resourcePopeIds = popedom_bill_mapper.findResource_Popedom_Bill_ByPopedomId(id);
        List<Resources_Popedom_Bill> resourcePopeIds = resources_popedom_bill_mapper.getRPBByPopeId(id);
        if (resourcePopeIds != null) {
            for (Resources_Popedom_Bill resourcePope : resourcePopeIds) {
                //根据主键id获取资源的id
//                newIds.add(resources_popedom_bill_mapper.getRPBById(resourcePopeId).getResources_id());
                //根据主键删除
                resources_popedom_bill_mapper.deletePRB(resourcePope.getId());
            }
        }
        String[] ids = resourceIds.split(",");
        Resources_Popedom_Bill resources_popedom_bill = new Resources_Popedom_Bill();
        if (ids.length>0) {
            for (String s : ids) {
                resources_popedom_bill.setPopedom_bill_id(id);
                resources_popedom_bill.setResources_id(Long.parseLong(s));
                resources_popedom_bill_mapper.insertRPB(resources_popedom_bill);
            }
        }
    }
}
