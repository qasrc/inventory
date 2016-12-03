package com.msunsoft.controller.infoManager;

import com.google.common.collect.Maps;
import com.msunsoft.controller.BaseController;
import com.msunsoft.model.Operator_Bill;
import com.msunsoft.utils.PageInfo;
import com.msunsoft.utils.Result;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * 业务员controller
 *
 * @author zhan
 *         Created on 2016/12/03  15:15
 */
@Controller
@RequestMapping("/operator")
public class Operator_BillController extends BaseController{

    private static Logger logger = Logger.getLogger(Operator_BillController.class);

    @RequestMapping("/manager")
    public String operatorList() {
        return "/infoManager/operatorBillList";
    }

    @RequestMapping("/dataGrid")
    @ResponseBody
    public PageInfo gridDate(Integer page,Integer rows,String sort,String order){
        PageInfo pageInfo = new PageInfo(page, rows, sort, order);
        Map<String, Object> condition = Maps.newHashMap();
        pageInfo.setCondition(condition);
        operator_billService.findPageCondition(pageInfo);
        System.out.println(pageInfo.toString());
        return pageInfo;
    }

    /**
     * 添加页面
     * @return
     */
    @RequestMapping("/addPage")
    public String addPage() {
        return "/infoManager/operatorBillAdd";
    }


    /**
     * 添加
     * @param operator_bill
     * @return
     */
    @RequestMapping("/add")
    @ResponseBody
    public Result add(Operator_Bill operator_bill) {
        Result result = new Result();
        try {
            operator_billService.addOperator(operator_bill);
            result.setSuccess(true);
            result.setMsg("添加成功");
            return result;
        } catch (RuntimeException e) {
            logger.error(e);
            result.setMsg("添加失败");
            return result;
        }
    }


    /**
     * 更新页面
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/editPage")
    public String editPage(Long id, Model model) {
        Operator_Bill operator_bill = operator_billService.findOperatorById(id);
        System.out.println(operator_bill.toString());
        model.addAttribute("oper", operator_bill);
        return "/infoManager/operatorBillEdit";
    }

    /**
     * 更新
     * @param operator_bill
     * @return
     */
    @RequestMapping("/edit")
    @ResponseBody
    public Result edit(Operator_Bill operator_bill) {
        Result result = new Result();
        try {
            operator_billService.updateOperator(operator_bill);
            result.setMsg("更新成功");
            result.setSuccess(true);
            return result;
        } catch (RuntimeException e) {
            logger.error(e);
            result.setMsg("更新失败");
            return result;
        }
    }

}
