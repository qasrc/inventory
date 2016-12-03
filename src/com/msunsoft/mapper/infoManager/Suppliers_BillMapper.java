package com.msunsoft.mapper.infoManager;

import com.msunsoft.mapper.BaseMapper;
import com.msunsoft.model.Suppliers_Bill;
import com.msunsoft.utils.PageInfo;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author zhan
 *         Created on 2016/12/02  15:08
 */
@Component
public interface Suppliers_BillMapper extends BaseMapper<Suppliers_Bill> {

    List<Suppliers_Bill> findPageCondition(PageInfo pageInfo);

    int findPageCount(PageInfo pageInfo);


}
