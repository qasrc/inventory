package com.msunsoft.mapper;

import com.msunsoft.model.User_Bill;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 用户mapper
 *
 * @author zhan
 *         Created on 2016/11/29  20:51
 */
@Component
public interface User_Bill_Mapper {

    /**
     * 插入user
     * @param user_bill
     * @return
     */
    int insertUser(User_Bill user_bill);

    /**
     * 更新user
     * @param user_bill
     * @return
     */
    int updateUser(User_Bill user_bill);

    /**
     * 根据id删除user
     * @param user_id
     * @return
     */
    int delUser(Long user_id);

    /**
     * 根据id查询user
     * @param user_id
     * @return
     */
    User_Bill getUserById(Long user_id);


    /**
     * 根据名字查询user
     * @param username
     * @return
     */
    User_Bill getUserByUserName(String username);

    /**
     * 得到所有user
     * @return
     */
    List<User_Bill> getAllUser();


}
