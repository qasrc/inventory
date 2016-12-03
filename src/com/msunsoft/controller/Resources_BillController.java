package com.msunsoft.controller;

import com.msunsoft.model.Resources_Bill;
import com.msunsoft.utils.Result;
import com.msunsoft.utils.Tree;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 资源控制器
 * @author zhan
 *         Created on 2016/11/29  13:22
 */
@Controller
@RequestMapping("/resource")
public class Resources_BillController extends BaseController{

    private static Logger logger = Logger.getLogger(Resources_BillController.class);


    /**
     * 获取资源列表
     * @return
     */
    @RequestMapping(value = "/tree",method = RequestMethod.POST)
    @ResponseBody
    public List<Tree> findTree() {
        return resourcesBillService.findTree(getCurrentUser());
    }


    /**
     * 资源列表页面
     * @return
     */
    @RequestMapping("/manager")
    public String manager() {
        return "/admin/resource";
    }

    /**
     * 获取所有资源列表
     * @return
     */
    @RequestMapping("/dataTree")
    @ResponseBody
    public List<Resources_Bill> dataGrid() {
        return resourcesBillService.findResourcesAll();
    }

    /**
     * 跳转到添加页
     * @return
     */
    @RequestMapping("/addPage")
    public String addResource() {
        return "/admin/resourceAdd";
    }

    /**
     * 添加资源
     * @param resources_bill
     * @return
     */
    @RequestMapping("/addResource")
    @ResponseBody
    public Result addResource(Resources_Bill resources_bill) {
        Result result = new Result();
        try {
            resourcesBillService.addResource(resources_bill);
            result.setSuccess(true);
            result.setMsg("添加成功");
            return result;
        } catch (RuntimeException e) {
            logger.error("添加失败", e);
            result.setMsg("添加失败");
            return result;
        }
    }

    /**
     * 根据id删除资源
     * @param id
     * @return
     */
    @RequestMapping(value="/delete",method = RequestMethod.POST)
    @ResponseBody
    public Result delete(Long id) {
        System.out.println(id);
        Result result = new Result();
        try {
            resourcesBillService.deleteResource(id);
            result.setMsg("资源删除成功");
            result.setSuccess(true);
            return result;
        } catch (RuntimeException e) {
            result.setMsg("资源删除失败");
            return result;
        }
    }

    @RequestMapping("/grant")
    @ResponseBody
    public Result grant(Long id, String resourceIds) {
        Result result = new Result();
        try {
            popedomService.updatePopedomResource(id, resourceIds);
            result.setSuccess(true);
            result.setMsg("更新成功");
            return result;
        } catch (RuntimeException e) {
            result.setMsg("授权失败");
            return result;
        }
    }



    /**
     * 获取所有的资源列表
     * @return
     */
    @RequestMapping("/allTree")
    @ResponseBody
    public List<Tree> getAllTree() {
        return resourcesBillService.findAllTree();
    }
}
