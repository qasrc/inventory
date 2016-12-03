package com.msunsoft.mapper;

import com.msunsoft.model.Popedom_Bill;
import com.msunsoft.utils.PageInfo;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 用户权限mapper
 *
 * @author zhan
 *         Created on 2016/11/29  20:51
 */
@Component
public interface Popedom_Bill_Mapper {

    /**
     * 插入popedom
     *
     * @param popedom_bill
     * @return
     */
    int insertPopedom(Popedom_Bill popedom_bill);

    /**
     * 删除popedom
     *
     * @param id
     * @return
     */
    int deletePopedom(Long id);

    /**
     * 更新popedom
     *
     * @param popedom_bill
     * @return
     */
    int updatePopedom(Popedom_Bill popedom_bill);

    /**
     * 根据id获取popedom
     *
     * @param id
     * @return
     */
    Popedom_Bill getPopedomById(Long id);


    /**
     * 获取所有
     *
     * @return
     */
    List<Popedom_Bill> getAllPopedom();

    /**
     * 获取所有
     *
     * @return
     */
    List<Popedom_Bill> getAllGridDate(PageInfo pageInfo);
    /**
     *
     * @param id
     * @return
     */
    String getPopeNameById(Long id);

    /**
     * 获取总记录的条数
     * @param pageInfo
     * @return
     */
    Integer findDateCount(PageInfo pageInfo);


}
