package com.msunsoft.mapper.infoManager;

import com.msunsoft.mapper.BaseMapper;
import com.msunsoft.model.Client_Bill;
import com.msunsoft.utils.PageInfo;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 客户清单表mapper
 *
 * @author zhan
 *         Created on 2016/12/01  14:39
 */
@Component
public interface Client_BillMapper extends BaseMapper<Client_Bill>{

    List<Client_Bill> findPageCondition(PageInfo pageInfo);

    int findPageCount(PageInfo pageInfo);


}
