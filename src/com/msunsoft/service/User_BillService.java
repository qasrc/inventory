package com.msunsoft.service;

import com.msunsoft.model.User_Bill;

/**
 * 用户清单表
 *
 * @author Administrator
 *         Created on 2016/11/29  16:00
 */
public interface User_BillService {

    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    User_Bill findUserById(Long id);

    /**
     * 根据姓名查询用户，有名字重复问题
     * @param name
     * @return
     */
    User_Bill findUserByName(String name);

    /**
     * 增加用户
     * @param user_bill
     * @return
     */
    void addUser(User_Bill user_bill,Long roleId);

    /**
     * 更新用户
     * @param user_bill
     * @return
     */
    void updateUser(User_Bill user_bill);

    /**
     * 根据id删除用户
     * @param id
     * @return
     */
    void deleteUserById(Long id);



}
