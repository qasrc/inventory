package com.msunsoft.shiro;

import com.google.common.collect.Lists;
import com.msunsoft.model.Popedom_Bill;
import com.msunsoft.model.Resources_Bill;
import com.msunsoft.model.Resources_Popedom_Bill;
import com.msunsoft.model.User_Bill;
import com.msunsoft.service.PopedomService;
import com.msunsoft.service.Resources_BillService;
import com.msunsoft.service.Resources_Popedom_BillService;
import com.msunsoft.service.User_BillService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 自定义realm
 *
 * @description：shiro权限认证
 */
public class ShiroDbRealm extends AuthorizingRealm {

    private static Logger LOGGER = LoggerFactory.getLogger(ShiroDbRealm.class);

    @Autowired
    private User_BillService user_billService;
    @Autowired
    private PopedomService popedomService;
    @Autowired
    private Resources_BillService resources_billService;
    @Autowired
    private Resources_Popedom_BillService resources_popedom_billService;

    /**
     * Shiro登录认证(原理：用户提交 用户名和密码  --- shiro 封装令牌 ---- realm 通过用户名将密码查询返回 ---- shiro 自动去比较查询出密码和用户输入密码是否一致---- 进行登陆控制 )
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(
            AuthenticationToken authcToken) throws AuthenticationException {
        LOGGER.info("Shiro开始登录认证");
        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
        User_Bill user = user_billService.findUserByName(token.getUsername());
        // 账号不存在
        if (user == null) {
            return null;
        }

        Popedom_Bill popedom_bill = popedomService.findPopedomByUserId(user.getPopedom_id());
        Long popedom = popedom_bill.getPope_id();
        ShiroUser shiroUser = new ShiroUser(user.getUser_id(), user.getUser_name(), popedom);
        // 认证缓存信息
        return new SimpleAuthenticationInfo(shiroUser, user.getUser_password().toCharArray(), getName());

    }

    /**
     * Shiro权限认证
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(
            PrincipalCollection principals) {
        //principals当前认证的主体
        ShiroUser shiroUser = (ShiroUser) principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        Long id = shiroUser.getPopedomId();
        //资源列表
        List<Resources_Bill> resources_bills = Lists.newArrayList();
        //资源名称
        List<String> resourceName = Lists.newArrayList();
        //获取资源角色对应关系
        List<Resources_Popedom_Bill> resources_popedom_bill = resources_popedom_billService.getRPBByPopeId(id);
        if (resources_popedom_bill != null) {
            for (Resources_Popedom_Bill resourcesPopedomBill : resources_popedom_bill) {
                resources_bills.add(resources_billService.findResourceById(resourcesPopedomBill.getResources_id()));
            }
            //获取资源列表
            if (resources_bills.size() > 0) {
                for (Resources_Bill resources_bill : resources_bills) {
                    resourceName.add(resources_bill.getUrl());
                }
            }
        }
        String userRole = popedomService.findPopedomByUserId(id).getPope_name();
        info.addStringPermissions(resourceName);
        info.addRole(userRole);
        return info;
    }
}
