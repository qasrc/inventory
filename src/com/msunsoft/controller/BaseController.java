package com.msunsoft.controller;

import com.msunsoft.model.User_Bill;
import com.msunsoft.service.*;
import com.msunsoft.shiro.ShiroUser;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * controller基类
 *
 * @author Administrator
 *         Created on 2016/11/29  16:02
 */

@Controller
public class BaseController {

    @Autowired
    protected Account_PayableService account_payableService;
    @Autowired
    protected Account_ReceivableService account_receivableService;
    @Autowired
    protected Cargo_Transfer_ApplyService cargo_transfer_applyService;
    @Autowired
    protected Cargo_Transfer_BillService cargo_transfer_billService;
    @Autowired
    protected Client_BillService client_billService;
    @Autowired
    protected Commodity_BillService commodity_billService;
    @Autowired
    protected Deposit_PaymentService deposit_paymentService;
    @Autowired
    protected Deposit_ReceivedService deposit_receivedService;
    @Autowired
    protected Depot_BillService depot_billService;
    @Autowired
    protected Jxc_GatherService jxc_gatherService;
    @Autowired
    protected Operator_BillService operator_billService;
    @Autowired
    protected PopedomService popedomService;
    @Autowired
    protected PosaService posaService;
    @Autowired
    protected Purchase_ContractService purchase_contractService;
    @Autowired
    protected Purchase_In_BillService purchase_in_billService;
    @Autowired
    protected Purchase_In_TtemsService purchase_in_ttemsService;
    @Autowired
    protected Purchase_Order_ItemsService purchase_order_itemsService;
    @Autowired
    protected Purchase_OrderService purchase_orderService;
    @Autowired
    protected Report_Profit_LossService report_profit_lossService;
    @Autowired
    protected Sale_MrbService sale_mrbService;
    @Autowired
    protected Sale_Order_ItemsService sale_order_itemsService;
    @Autowired
    protected Sale_OrderService sale_orderService;
    @Autowired
    protected StockService stockService;
    @Autowired
    protected Resources_BillService resourcesBillService;
    @Autowired
    protected Resources_Popedom_BillService resources_popedom_billService;
    @Autowired
    protected Store_BillService store_billService;
    @Autowired
    protected Suppliers_BillService suppliers_billService;
    @Autowired
    protected Update_Purchase_PriceService update_purchase_priceService;
    @Autowired
    protected Upper_Lower_LimitService upper_lower_limitService;
    @Autowired
    protected User_BillService user_billService;

    /**
     * 得到当前用户
     * @return
     */
    protected User_Bill getCurrentUser() {
        ShiroUser user = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
        return user_billService.findUserById(user.id);
    }

}
