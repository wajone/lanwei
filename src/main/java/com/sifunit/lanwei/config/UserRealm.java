package com.sifunit.lanwei.config;

import com.sifunit.lanwei.domain.Perm;
import com.sifunit.lanwei.domain.Role;
import com.sifunit.lanwei.domain.User;
import com.sifunit.lanwei.service.IPermService;
import com.sifunit.lanwei.service.IRoleService;
import com.sifunit.lanwei.service.IUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.LinkedList;
import java.util.List;

public class UserRealm extends AuthorizingRealm {

    @Autowired
    IUserService userService;
    IRoleService roleService;
    IPermService permService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("授权");


        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();
        if (user != null) {
            SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
            List<String> roles = new LinkedList<>();
            List<String> perms = new LinkedList<>();
            for (Role role : roleService.getRoleList(user.getUserId())) {
                roles.add(role.getRoleName());
            }

            for (Perm perm : permService.getPermList(user.getUserId())) {
                perms.add(perm.getPermUrl());
            }

            simpleAuthorizationInfo.addRoles(roles);
            simpleAuthorizationInfo.addStringPermissions(perms);
            return simpleAuthorizationInfo;
        }
        subject.getSession().setAttribute("loginuser", user);
        //simpleAuthorizationInfo.addStringPermission("/*");
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("认证");
        UsernamePasswordToken userToken = (UsernamePasswordToken) authenticationToken;
        //链接数据库查询用户
        System.out.println(userToken.getUsername());
        User user = userService.selectByUsername(userToken.getUsername());
        System.out.println(user);
        if (user == null) {
            return null;
        }
        Subject currentUser = SecurityUtils.getSubject();
        currentUser.getSession().setAttribute("loginuser", user);

        return new SimpleAuthenticationInfo(user, user.getPassword(), "");
    }
}
