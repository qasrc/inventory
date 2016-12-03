package com.msunsoft.service.impl;

import com.msunsoft.exception.ServiceException;
import com.msunsoft.mapper.User_Bill_Mapper;
import com.msunsoft.model.User_Bill;
import com.msunsoft.service.User_BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Administrator
 *         Created on 2016/11/29  16:46
 */
@Service
public class User_BillServiceImpl implements User_BillService {

    @Autowired
    private User_Bill_Mapper user_bill_mapper;

    @Override
    public User_Bill findUserById(Long id) {
        return user_bill_mapper.getUserById(id);
    }

    @Override
    public User_Bill findUserByName(String name) {
        return user_bill_mapper.getUserByUserName(name);
    }

    @Override
    public void addUser(User_Bill user_bill,Long roleId) {
        int status = user_bill_mapper.insertUser(user_bill);
        if (status!=1) {
            throw new ServiceException("添加用户失败");
        }
    }

    @Override
    public void updateUser(User_Bill user_bill) {

    }

    @Override
    public void deleteUserById(Long id) {
    }
}
