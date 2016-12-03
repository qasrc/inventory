package com.msunsoft.service.impl;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.msunsoft.exception.ServiceException;
import com.msunsoft.mapper.Popedom_Bill_Mapper;
import com.msunsoft.mapper.Resources_Bill_Mapper;
import com.msunsoft.mapper.Resources_Popedom_Bill_Mapper;
import com.msunsoft.mapper.User_Bill_Mapper;
import com.msunsoft.model.Resources_Bill;
import com.msunsoft.model.Resources_Popedom_Bill;
import com.msunsoft.model.User_Bill;
import com.msunsoft.service.Resources_BillService;
import com.msunsoft.utils.Tree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * @author zhan
 *         Created on 2016/11/29  13:27
 */
@Service
public class ResourcesBillServiceImpl implements Resources_BillService {


    @Autowired
    private Resources_Bill_Mapper resources_bill_mapper;

    @Autowired
    private Resources_Popedom_Bill_Mapper resources_popedom_bill_mapper;

    @Autowired
    private Popedom_Bill_Mapper popedom_bill_mapper;

    @Autowired
    private User_Bill_Mapper user_bill_mapper;

    /**
     * 获取资源列表
     *
     * @return
     */
    @Override
    public List<Tree> findTree(User_Bill user_bill) {

        //模拟从数据库中取出数据，分为两级菜单
        List<Tree> trees = Lists.newArrayList();

        //获取当前用户的角色id
        Long roleId = user_bill_mapper.getUserById(user_bill.getUser_id()).getPopedom_id();
        //获取当前角色所拥有的资源ID
        Set<Long> resourceIds = Sets.newHashSet();
        List<Resources_Popedom_Bill> rpb = resources_popedom_bill_mapper.getRPBByPopeId(roleId);
        if (rpb == null) {
            return null;
        }

        for (Resources_Popedom_Bill resources_popedom_bill : rpb) {
            resourceIds.add(resources_popedom_bill.getResources_id());
        }
        //获取当前用户对应的所有角色
        List<Resources_Bill> resources_bills = Lists.newArrayList();
        Iterator<Long> ids = resourceIds.iterator();
        while(ids.hasNext()){
            resources_bills.add(resources_bill_mapper.getResourceById(ids.next()));
        }

        if (resources_bills.size()>0) {
            for (Resources_Bill resources_bill_first : resources_bills) {
                //获取父级菜单
                if (resources_bill_first!=null&&resources_bill_first.getPid()==null) {
                    Tree parentTree = new Tree();
                    parentTree.setId(resources_bill_first.getId());
                    parentTree.setIconCls(resources_bill_first.getIcon());
                    parentTree.setText(resources_bill_first.getName());
                    parentTree.setAttributes(resources_bill_first.getUrl());
                    List<Tree> childTrees = Lists.newArrayList();
                    for (Resources_Bill resources_bill_second : resources_bills) {
                        //获取父菜单下的子菜单
                        if (resources_bill_second.getPid()!=null&& Objects.equals(resources_bill_first.getId(), resources_bill_second.getPid())) {
                            Tree childTree = new Tree();
                            childTree.setId(resources_bill_second.getId());
                            childTree.setText(resources_bill_second.getName());
                            childTree.setIconCls(resources_bill_second.getIcon());
                            childTree.setAttributes(resources_bill_second.getUrl());
                            childTrees.add(childTree);
                        }
                    }
                    parentTree.setChildren(childTrees);
                    trees.add(parentTree);
                }
            }
        }

        /*for (int i = 0; i < 2; i++) {
            Tree tree = new Tree();
            tree.setId(Long.parseLong(i + ""));
            tree.setText("系统管理" + i);
            tree.setIconCls("icon-folder");
            tree.setAttributes("#");
            //二级菜单
            List<Tree> childTrees = Lists.newArrayList();
            for (int j = 0; j < 5; j++) {
                Tree childTree = new Tree();
                childTree.setId(Long.parseLong(j + 100 + ""));
                childTree.setText("子菜单" + j);
                childTree.setIconCls("icon-cancel");
                childTree.setAttributes("#");
                childTrees.add(childTree);
            }
            tree.setChildren(childTrees);

            trees.add(tree);
        }*/

        return trees;
    }

    /**
     * 获取所有的资源列表
     *
     * @return
     */
    @Override
    public List<Tree> findAllTree() {
        List<Tree> trees = Lists.newArrayList();
        List<Resources_Bill> resources_bills = resources_bill_mapper.findResourceByPidNull();
        if (resources_bills == null) {
            return null;
        }
        for (Resources_Bill resources_bill : resources_bills) {
            Tree treeParent = new Tree();
            treeParent.setId(resources_bill.getId());
            treeParent.setIconCls(resources_bill.getIcon());
            treeParent.setText(resources_bill.getName());
            treeParent.setAttributes(resources_bill.getUrl());
            //获取当前父菜单下的所有子菜单
            List<Resources_Bill> resources_bills_child = resources_bill_mapper.findResourceByPid(resources_bill.getId());
            if (resources_bills_child != null) {
                List<Tree> treeChild = Lists.newArrayList();
                for (Resources_Bill resourcesBillChild : resources_bills_child) {
                    Tree childTree = new Tree();
                    childTree.setId(resourcesBillChild.getId());
                    childTree.setAttributes(resourcesBillChild);
                    childTree.setIconCls(resourcesBillChild.getIcon());
                    childTree.setText(resourcesBillChild.getName());
                    treeChild.add(childTree);
                }
                treeParent.setChildren(treeChild);
            } else {
                treeParent.setState("close");
            }
            trees.add(treeParent);
        }
        return trees;
    }

    /**
     * 获取所有资源
     * @return
     */
    @Override
    public List<Resources_Bill> findResourcesAll() {
        return resources_bill_mapper.findAllResource();
    }

    /**
     * 添加资源
     *
     * @param resources_bill
     */
    @Override
    public void addResource(Resources_Bill resources_bill) {
        resources_bill_mapper.insertResource(resources_bill);
    }


    @Override
    public void updateResource(Resources_Bill resources_bill) {
        int status = resources_bill_mapper.updateResource(resources_bill);
        if (status != 1) {
            throw new ServiceException("更新资源失败");
        }

    }

    @Override
    public void deleteResource(Long id) {
        int status = resources_bill_mapper.deleteResource(id);
        if (status != 1) {
            throw new ServiceException("删除资源失败");
        }
    }

    @Override
    public Resources_Bill findResourceById(Long id) {
        return resources_bill_mapper.getResourceById(id);
    }


}
