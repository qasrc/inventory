package com.msunsoft.controller;

import com.msunsoft.utils.Result;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author zhan
 *         Created on 2016/11/28  22:29
 */
@Controller
public class LoginController extends BaseController{

    private static Logger logger = Logger.getLogger(LoginController.class);


    /**
     * 登录页面
     * @return
     */
    @RequestMapping("/login")
    public String login() {
        return "/login";
    }

    /**
     * 登录验证
     * @param username
     * @param password
     * @return
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public Result login_post(String username,String password) {
        Result result = new Result();
        if (StringUtils.isBlank(username)) {
            result.setMsg("用户名不能为空");
            return result;
        }
        if (StringUtils.isBlank(password)) {
            result.setMsg("密码不能为空");
            return result;
        }

        //得到当前登录主体
        Subject user = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            user.login(token);
        } catch (UnknownAccountException e) {
            logger.error("账号不存在：{}", e);
            result.setMsg("账号不存在");
            return result;
        } catch (DisabledAccountException e) {
            logger.error("账号未启用：{}", e);
            result.setMsg("账号未启用");
            return result;
        } catch (IncorrectCredentialsException e) {
            logger.error("密码错误：{}", e);
            result.setMsg("密码错误");
            return result;
        } catch (RuntimeException e) {
            logger.error("未知错误,请联系管理员：{}", e);
            result.setMsg("未知错误,请联系管理员");
            return result;
        }
        result.setSuccess(true);
        return result;
    }

    @RequestMapping("/index")
    public String indexPage() {
        return "/index";
    }
}
