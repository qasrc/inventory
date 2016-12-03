package com.msunsoft.controller.infoManager;

import com.google.common.collect.Maps;
import com.msunsoft.controller.BaseController;
import com.msunsoft.model.Suppliers_Bill;
import com.msunsoft.utils.PageInfo;
import com.msunsoft.utils.Result;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * 供货商清单
 * @author zhan
 *         Created on 2016/12/02  18:59
 */
@Controller
@RequestMapping("/suppliers_bill")
public class Suppliers_BillController extends BaseController{

    private static Logger logger = Logger.getLogger(Suppliers_BillController.class);

    /**
     * 供货商清单页面
     * @return
     */
    @RequestMapping("/manager")
    public String supplierList() {
        return "/infoManager/suppliersBillList";
    }


    @RequestMapping("/dataGrid")
    @ResponseBody
    public PageInfo dataGrid(Integer page, Integer rows, String sort, String order) {
        PageInfo pageInfo = new PageInfo(page, rows, sort, order);
        Map<String,Object> condition = Maps.newHashMap();
        pageInfo.setCondition(condition);
        suppliers_billService.getPageContentSu(pageInfo);
        System.out.println(pageInfo.toString());
        return pageInfo;
    }

    @RequestMapping("/editPage")
    public String editPage(Long supp_id,Model model) {

        System.out.println("=============="+supp_id);
        try {
            Suppliers_Bill suppliers_bill = suppliers_billService.getSuppliersById(supp_id);
            model.addAttribute("supp", suppliers_bill);
        } catch (RuntimeException e) {
            logger.error(e);
        }
        return "/infoManager/suppliersEdit";
    }

    /**
     * 更新
     * @param suppliers_bill
     * @return
     */
    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    @ResponseBody
    public Result edit(Suppliers_Bill suppliers_bill){
        Result result = new Result();
        try {
            System.out.println(suppliers_bill.toString());
            suppliers_billService.updateSuppliers(suppliers_bill);
            System.out.println("---------------");
            result.setSuccess(true);
            result.setMsg("更新成功");
            return result;
        } catch (RuntimeException e) {
            logger.error(e);
            result.setMsg("更新失败");
            return result;
        }
    }


    /**
     * 查看详细信息
     * @param model
     * @param id
     * @return
     */
    @RequestMapping("/detail")
    public String detailGrid(Model model, Long id) {
        Suppliers_Bill suppliers_bill = suppliers_billService.getSuppliersById(id);
        model.addAttribute("supp", suppliers_bill);
        return "/infoManager/suppliersDetail";
    }

    /**
     *根据id删除
     * @param supp_id
     * @return
     */
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    @ResponseBody
    public Result delete(Long supp_id) {
        Result result = new Result();
        try {
            suppliers_billService.deleteSuppliersById(supp_id);
            result.setSuccess(true);
            result.setMsg("删除成功");
            return result;
        } catch (RuntimeException e) {
            logger.error(e);
            result.setMsg("删除失败");
            return result;
        }
    }

    /**
     * 添加页面
     * @return
     */
    @RequestMapping("/addPage")
    public String addPage() {
        return "/infoManager/suppliersAdd";
    }


    /**
     * 添加
     * @param suppliers_bill
     * @return
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    public Result add(Suppliers_Bill suppliers_bill) {
        Result result = new Result();
        try {
            suppliers_billService.addSuppliers(suppliers_bill);
            result.setSuccess(true);
            result.setMsg("添加成功");
            return result;
        } catch (RuntimeException e) {
            logger.error(e);
            result.setMsg("添加失败");
            return result;
        }
    }


}
