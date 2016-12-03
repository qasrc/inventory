package com.msunsoft.service;

import com.msunsoft.model.Operator_Bill;
import com.msunsoft.utils.PageInfo;

/**
 * 业务员清单表
 *
 * @author Administrator
 *         Created on 2016/11/29  15:52
 */
public interface Operator_BillService {

    /**
     * 根据id查询
     * @param id
     * @return
     */
    Operator_Bill findOperatorById(Long id);

    /**
     * 根据id删除
     * @param id
     */
    void deleteOperatorById(Long id);

    /**
     * 添加
     * @param operator_bill
     */
    void addOperator(Operator_Bill operator_bill);

    /**
     * 更新
     * @param operator_bill
     */
    void updateOperator(Operator_Bill operator_bill);

    /**
     * 分页查询
     * @param pageInfo
     */
    void findPageCondition(PageInfo pageInfo);

}
