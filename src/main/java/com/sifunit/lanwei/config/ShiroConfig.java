package com.sifunit.lanwei.config;


import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {
    //ShiroFilterFactoryBean
    @Bean(name = "shiroFilterFactoryBean")
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("defaultWebSecurityManager") DefaultWebSecurityManager defaultWebSecurityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);
        //添加shiro的内置过滤器
        /*
            anon：无需认证就可以访问
            authc：必须认证了才能访问
            user：必须拥有 记住我 功能才能访问
            perms：拥有对某个资源的权限才能访问
            role：拥有某个角色权限才能访问

         */
        Map<String, String> filterMap = new LinkedHashMap<>();
        /**
         * 允许匿名访问静态资源
         */
        filterMap.put("/images/**", "anon");
        filterMap.put("/css/**", "anon");
        filterMap.put("/js/**", "anon");
        filterMap.put("/lib/**", "anon");
        filterMap.put("/fonts/**", "anon");
        filterMap.put("/plugin/**", "anon");
        /**
         * 允许匿名访问登录页面和登录操作
         */
        filterMap.put("/login", "anon");
        filterMap.put("/loginAuth", "anon");
        filterMap.put("/captcha", "anon");
        /**
         * 其它所有请求需要登录认证后才能访问
         */
        filterMap.put("/**", "authc");


        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);
        shiroFilterFactoryBean.setLoginUrl("/login");
        shiroFilterFactoryBean.setUnauthorizedUrl("/noauth");

        return shiroFilterFactoryBean;
    }

    //DefaultWebSecurityManager
    @Bean(name="defaultWebSecurityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm) {
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        defaultWebSecurityManager.setRealm(userRealm);
        return defaultWebSecurityManager;
    }

    //创建realm对象
    @Bean
    public UserRealm userRealm() {
        UserRealm userRealm = new UserRealm();

        return new UserRealm();
    }


    @Bean
    public ShiroDialect getShiroDialect() {
        return new ShiroDialect();
    }
}
