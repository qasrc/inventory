package com.msunsoft.mapper;

import com.msunsoft.model.Resources_Popedom_Bill;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 资源和角色对应关系mapper
 *
 * @author zhan
 *         Created on 2016/11/29  20:53
 */
@Component
public interface Resources_Popedom_Bill_Mapper {

    /**
     * 插入
     * @param resources_popedom_bill
     * @return
     */
    int insertRPB(Resources_Popedom_Bill resources_popedom_bill);


    /**
     * 更新
     * @param resources_popedom_bill
     * @return
     */
    int updateRPB(Resources_Popedom_Bill resources_popedom_bill);


    /**
     * 根据id删除
     * @param id
     * @return
     */
    int deletePRB(Long id);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    Resources_Popedom_Bill getRPBById(Long id);

    /**
     * 根据角色ID查询
     * @param id
     * @return
     */
    List<Resources_Popedom_Bill> getRPBByPopeId(Long id);


}
