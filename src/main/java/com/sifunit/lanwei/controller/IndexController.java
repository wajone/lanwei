package com.sifunit.lanwei.controller;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import com.sifunit.lanwei.common.SysResult;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;

@Controller
public class IndexController {

    @Autowired
    private Producer captchaProducer;

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

    @RequestMapping("trueLogin")
    public String trueLogin() {
        return "login";

    }

    @RequestMapping("/loginAuth")
    @ResponseBody
    public SysResult loginAuth(String username, String password, boolean rememberMe, Model model, HttpServletRequest request) {

        SysResult sysResult = new SysResult(false);
        String captchaId = (String)
                request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
        String parameter = request.getParameter("veritycode");
        if (!captchaId.equals(parameter)) {
            sysResult.setData("验证码错误！");
            return sysResult;
        }

        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        token.setRememberMe(rememberMe);
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

    @RequestMapping(value = "/captcha")
    public void getKaptchaImage(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //用字节数组存储
        byte[] captchaChallengeAsJpeg = null;
        ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();
        ServletOutputStream responseOutputStream =
                response.getOutputStream();
        final HttpSession httpSession = request.getSession();
        try {
            //生产验证码字符串并保存到session中
            String createText = captchaProducer.createText();
            //打印随机生成的字母和数字
            //log.debug(createText);
            httpSession.setAttribute(Constants.KAPTCHA_SESSION_KEY, createText);
            //使用生产的验证码字符串返回一个BufferedImage对象并转为byte写入到byte数组中
            BufferedImage challenge = captchaProducer.createImage(createText);
            ImageIO.write(challenge, "jpg", jpegOutputStream);
            captchaChallengeAsJpeg = jpegOutputStream.toByteArray();
            response.setHeader("Cache-Control", "no-store");
            response.setHeader("Pragma", "no-cache");
            response.setDateHeader("Expires", 0);
            response.setContentType("image/jpeg");
            //定义response输出类型为image/jpeg类型，使用response输出流输出图片的byte数组
            responseOutputStream.write(captchaChallengeAsJpeg);
            responseOutputStream.flush();
        } catch (IllegalArgumentException e) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        } finally {
            responseOutputStream.close();
        }
    }

}
