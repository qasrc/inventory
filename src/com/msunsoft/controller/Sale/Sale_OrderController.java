package com.msunsoft.controller.Sale;

import com.google.common.collect.Maps;
import com.msunsoft.controller.BaseController;
import com.msunsoft.model.Sale_Order;
import com.msunsoft.utils.PageInfo;
import com.msunsoft.utils.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Sale_OrderController
 *
 * @author zhang
 *         Created on 2016/11/30  14:02
 */
@Controller
@RequestMapping("/salecontroller")
public class Sale_OrderController extends BaseController{
    private static Logger logger = LoggerFactory.getLogger(Sale_OrderController.class);

    @RequestMapping("/add")
    public String test() {
        return "/sale";
    }


    @RequestMapping(value ="/dataGrid", method = RequestMethod.POST)
    @ResponseBody
    public PageInfo getDataGrid(Integer page, Integer rows, String order, String sort) {
        PageInfo pageInfo = new PageInfo(page, rows, sort, order);
        Map<String, Object> condition = Maps.newHashMap();
        pageInfo.setCondition(condition);
        sale_orderService.findDataGrid(pageInfo);
        return pageInfo;
    }

    /**
     * 跳转到增加销售订单的页面
     * @return
     */
    @RequestMapping(value = "/addPage")
    public String addSale(){
         return "/sale/sale_orderAdd";
    }


    @RequestMapping(value = "/Add",method = RequestMethod.POST)
    @ResponseBody
    public Result add(Sale_Order sale_order){
        System.out.println(sale_order.toString());
       Result result = new Result();
       try {
           sale_orderService.addSale_Order(sale_order);
           result.setSuccess(true);
           result.setMsg("添加成功！");
           return result;
       }
       catch (RuntimeException e){
           logger.error("添加角色失败：{}", e);
           result.setMsg(e.getMessage());
           return result;
       }

    }
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    @ResponseBody
    public Result deleteStudents(Long so_id) {
       // System.out.println("id============" + so_id);
        Result result = new Result();
        try {
            sale_orderService.deleteSale_Order(so_id);
            result.setSuccess(true);
            result.setMsg("删除成功");
            return result;
        } catch (RuntimeException e) {
            logger.error("删除失败", new Throwable(e));
            result.setMsg("删除失败");
            return result;
        }
    }

    @RequestMapping("/editPage")
    public String editPage(HttpServletRequest request, Long so_id) {
        Sale_Order sale_order = sale_orderService.findSale_OrderById(so_id);
        request.setAttribute("sale_order", sale_order);
        return "/sale/Sale_OrderEdit";
    }

}
