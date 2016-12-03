package com.msunsoft.mapper.infoManager;

import com.msunsoft.mapper.BaseMapper;
import com.msunsoft.model.Operator_Bill;
import com.msunsoft.utils.PageInfo;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 业务员Mapper
 *
 * @author zhan
 *         Created on 2016/12/03  14:41
 */
@Component
public interface Operator_BillMapper extends BaseMapper<Operator_Bill>{

    /**
     * 分页查询
     * @param pageInfo
     * @return
     */
    List<Operator_Bill> findPageCondition(PageInfo pageInfo);

    /**
     * 数量
     * @param pageInfo
     * @return
     */
    int findPageCount(PageInfo pageInfo);

}
