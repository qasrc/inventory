package com.msunsoft.controller;

import com.google.common.collect.Maps;
import com.msunsoft.model.Popedom_Bill;
import com.msunsoft.utils.PageInfo;
import com.msunsoft.utils.Result;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * 权限管理
 *
 * @author zhan
 *         Created on 2016/12/01  11:08
 */
@Controller
@RequestMapping("/popedom")
public class PopedomController extends BaseController {

    @RequestMapping("manager")
    public String listPage() {
        return "/admin/popedom";
    }

    @RequestMapping("/dataGrid")
    @ResponseBody
    public PageInfo dataGrid(Integer page, Integer rows, String sort, String order) {
        PageInfo pageInfo = new PageInfo(page, rows, sort, order);
        Map<String,Object> condition = Maps.newHashMap();
        pageInfo.setCondition(condition);
        popedomService.findAllDateGrid(pageInfo);
        return pageInfo;
    }

    @RequestMapping("/grantPage")
    public String popedomGrant(Long id, ModelMap modelMap) {
        System.out.println("=============" + id);
        modelMap.put("id", id);
        return "/admin/popeGrant";
    }


    /**
     * 授权
     * @param id
     * @param resourceIds
     * @return
     */
    @RequestMapping("/grant")
    @ResponseBody
    public Result popedomGrant(Long id, String resourceIds) {
        System.out.println(id + "　　　   :    " + resourceIds);
        Result result = new Result();
        try {
            popedomService.updatePopedomResource(id, resourceIds);
            result.setSuccess(true);
            result.setMsg("更新成功");
            return result;
        } catch (RuntimeException e) {
            result.setMsg("更新失败");
            return result;
        }
    }

    @RequestMapping("/addPage")
    public String addPage() {
        return "/admin/popedomAdd";
    }

    @RequestMapping(value = "/addPope",method = RequestMethod.POST)
    @ResponseBody
    public Result add(Popedom_Bill popedom_bill) {
        System.out.println(popedom_bill.toString());
        Result result = new Result();
        try {
            popedomService.addPopedom(popedom_bill);
            result.setMsg("添加成功");
            result.setSuccess(true);
            return result;
        } catch (RuntimeException e) {
            result.setMsg("添加角色失败");
            return result;
        }
    }

    @RequestMapping("/findResourceIdListByRoleId")
    @ResponseBody
    public Result findResourceIdByPopeId(Long id) {
        Result result = new Result();
        try {
            List<Long> resourceIds = popedomService.findResourceIdByPopeId(id);
            result.setObj(resourceIds);
            result.setSuccess(true);
            return result;
        } catch (RuntimeException e) {
            result.setMsg("根据角色获取资源失败");
            return result;
        }
    }
}
