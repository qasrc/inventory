package com.msunsoft.controller.infoManager;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.msunsoft.controller.BaseController;
import com.msunsoft.model.Client_Bill;
import com.msunsoft.model.User_Bill;
import com.msunsoft.utils.PageInfo;
import com.msunsoft.utils.Result;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * 客户资料维护
 * @author zhan
 *         Created on 2016/12/01  19:13
 */
@Controller
@RequestMapping("/client_bill")
public class Client_BillController extends BaseController{

    private static Logger logger = Logger.getLogger(Client_BillController.class);

    @RequestMapping("/manager")
    public String manager() {
        return "/infoManager/clientBillList";
    }

    @RequestMapping("/dataGrid")
    @ResponseBody
    public PageInfo dataGrid(Integer page, Integer rows, String sort, String order) {
        PageInfo pageInfo = new PageInfo(page, rows, sort, order);
        Map<String, Object> conditions = Maps.newHashMap();
        pageInfo.setCondition(conditions);
        client_billService.findClient_BillPageCondition(pageInfo);
        return pageInfo;
    }

    @RequestMapping("/addPage")
    public String addPage(Model model) {
        User_Bill user_bill = new User_Bill(2L, "tom", "totoro", 1L);
        User_Bill user_bill1 = new User_Bill(3L, "jom", "too", 2L);
        //获取业务员编号
        List<User_Bill> names = Lists.newArrayList();
        names.add(user_bill);
        names.add(user_bill1);
        model.addAttribute("names", names);
        return "/infoManager/clientBillAdd";
    }

    @RequestMapping("/add")
    @ResponseBody
    public Result addClient(Client_Bill client_bill) {
        Result result = new Result();
        try {
            client_billService.addClient_Bill(client_bill);
            result.setMsg("添加成功");
            result.setSuccess(true);
            return result;
        } catch (RuntimeException e) {
            result.setMsg("添加失败");
            logger.error(e);
            return result;
        }
    }

    /**
     * 更新
     * @param client_bill
     * @return
     */
    @RequestMapping(value = "/edit")
    @ResponseBody
    public Result edit(Client_Bill client_bill) {
        System.out.println("================="+client_bill.toString());
        Result result = new Result();
        try {
            client_billService.updateClient_Bill(client_bill);
            result.setMsg("修改成功");
            result.setSuccess(true);
            return result;
        } catch (RuntimeException e) {
            logger.error(e);
            result.setMsg("更新失败");
            return result;
        }
    }

    /**
     * 编辑页面
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/editPage")
    public String editClient(Long id,Model model) {
        Client_Bill client_bill = client_billService.findClient_BillById(id);
        User_Bill user_bill = new User_Bill(2L, "tom", "totoro", 1L);
        User_Bill user_bill1 = new User_Bill(3L, "jom", "too", 2L);
        //获取业务员编号
        List<User_Bill> names = Lists.newArrayList();
        names.add(user_bill);
        names.add(user_bill1);
        model.addAttribute("names", names);
        model.addAttribute("client", client_bill);
        return "/infoManager/clientBillEdit";
    }


    /**
     * 显示详情
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/detailPage")
    public String detailClient(Long id,Model model) {
        Client_Bill client_bill = client_billService.findClient_BillById(id);
        model.addAttribute("client", client_bill);
        return "/infoManager/clientBillDetail";
    }

    /**
     * 根据id删除
     * @param id
     * @return
     */
    @RequestMapping("/delete")
    @ResponseBody
    public Result deleteClientById(Long id) {
        Result result = new Result();
        try {
            client_billService.deleteClient_Bill(id);
            result.setMsg("删除成功");
            result.setSuccess(true);
            return result;
        } catch (RuntimeException e) {
            result.setMsg("删除失败");
            return result;
        }
    }



}
