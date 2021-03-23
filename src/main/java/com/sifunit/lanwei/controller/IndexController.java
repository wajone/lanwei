package com.sifunit.lanwei.controller;

import com.sifunit.lanwei.common.SysResult;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {
    @RequestMapping({"/", "/index"})
    public String main() {
        return "index";
    }

    @RequestMapping("login")
    public String login() {
        if (SecurityUtils.getSubject().isAuthenticated()) {
            return "redirect:index";
        } else {
            return "login";
        }

    }

    @RequestMapping("/loginAuth")
    @ResponseBody
    public SysResult loginAuth(String username, String password, Model model) {
        System.out.println(password + "/" + username);
        SysResult sysResult = new SysResult(false);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            subject.login(token);
            sysResult.setResult(true);
        } catch (UnknownAccountException e) {
            sysResult.setData("账号不存在");

        } catch (IncorrectCredentialsException e) {
            sysResult.setData("密码错误");
        }

        return sysResult;

    }

    @RequestMapping("/logout")
    public String logout() {
        if (SecurityUtils.getSubject().isAuthenticated()) {
            // 退出
            SecurityUtils.getSubject().logout();
        }
        return "redirect:login.html";
    }

}
