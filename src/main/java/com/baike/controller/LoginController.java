package com.baike.controller;

import com.baike.common.SpringMvcActionContext;
import com.baike.model.Login;
import com.baike.model.Register;
import com.baike.model.User;
import com.baike.service.LoginService;
import com.baike.service.UserService;
import com.baike.util.MyResult;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by huanghaojian on 17/1/5.
 */
@Controller
@RequestMapping("/login")
public class LoginController extends SpringMvcActionContext {
    String seedStr = "0123456789";
    int validCodeLength = 6;

    @Resource
    private LoginService loginService;
    @Resource
    private UserService userService;

    @RequestMapping(value = "")
    public String toLogin() {
        return "/login";
    }

    /* 登录*/
    @RequestMapping(value = "/login")
    @ResponseBody
    public Object login(Login login) {
        HttpSession session = getSession();
        System.out.println("login>>>>>>>>>>>>>>>>>>>>>>>>" + login);
        String loginValidCode = (String) session.getAttribute("loginValidCode");
        System.out.println("session中的validCode  " + loginValidCode);
        if (!checkValidCode(login.getValidCode(), loginValidCode)) {
            System.out.println("验证码错误");
            return MyResult.getResult(0, "验证码错误", "");
        } else {
            User user = null;
            user = loginService.login(login);
            if (user == null) {
                return MyResult.getResult(0, "用户名或密码错误", "");
            } else {
                session.setAttribute("user", user);
                System.out.println(
                        "session 中的user" + session.getAttribute("user")
                );
                return MyResult.getResult();
            }
        }
    }

    /*检查验证码是否正确*/
    private boolean checkValidCode(String validCode, String sessionValidCode) {
        return sessionValidCode != null && sessionValidCode.equalsIgnoreCase(validCode);
    }

    /* 获取登录验证码*/
    @RequestMapping(value = "/getNewVaildCode")
    public void getNewVaildCode(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        loginService.getNewVaildCode(request, response, session);
    }

    /*注册*/
    @RequestMapping(value = "register")
    @ResponseBody
    public Object register(Register register) {
        HttpSession session = getSession();
        String registerVaildCode = (String) session.getAttribute("registerVaildCode");
        System.out.println("session中的validCode  " + registerVaildCode);
        if (!checkValidCode(register.getValidCode(), registerVaildCode)) {
            System.out.println("验证码错误");
            return MyResult.getResult(0, "验证码错误", "");
        } else {
            int result=loginService.register(register);
            if (result >= 0) {
                return MyResult.getResult(1, "注册成功", "");
            } else {
                return MyResult.getResult(0, "注册失败", "");
            }
        }
    }
    //注册时发送验证码到邮箱
    @RequestMapping(value="sendEmail")
    @ResponseBody
    public Object sendSimpleMailSender(@RequestParam("email")String email) {
        HttpSession session = getSession();
        String registerValidCode =RegisterValidCode(validCodeLength);
        session.setAttribute("registerValidCode",registerValidCode);
        return loginService.sendVaildCodeToEmail(email,session);
    }
    //注册时生成随机验证码
    private String RegisterValidCode(int size){
        StringBuffer stringBuffer=new StringBuffer();
        int len=seedStr.length();
        for(int i=0;i<size;i++){
            char c=seedStr.charAt((int)(Math.random()*len));
            stringBuffer.append(c);
        }
        return stringBuffer.toString();
    }
    //忘记密码时重设密码发送验证码到邮箱
    @RequestMapping(value="sendResetValidCode")
    @ResponseBody
    public Object sendResetValidCode(@RequestParam("userName")String userName){
        User user=userService.findByName(userName);
        String userEmail=user.getEmail();
        if(userEmail==null||userEmail==""){
            return MyResult.getResult(0,"邮箱不能为空","");
        }else{
            HttpSession session=getSession();
            String resetValidCode=RegisterValidCode(validCodeLength);
            session.setAttribute("resetValidCode",resetValidCode);
            return loginService.SendResetValidCodeToEmail(userEmail,session);
        }
    }
    //忘记密码
    @RequestMapping(value = "resetPassword")
    @ResponseBody
    public Object resetPassword(@RequestParam("resetValidCode") String resetValidCode,@RequestParam("password") String password, HttpServletRequest request){
        HttpSession session = request.getSession(false);
        User user = (User) session.getAttribute("user");
//        System.out.println(user.toString());
        int userId = user.getUserId();
        if (resetValidCode.equals(session.getAttribute("resetValidCode").toString())){
            int result = loginService.updatePassword(userId,password);
            if (result > 0){
                return MyResult.getResult();
            }else {
                return MyResult.getResult(0,"重设密码失败","");
            }
        }else {
            return MyResult.getResult(0,"验证码不正确","");
        }
    }
    //登出
    @RequestMapping(value = "/logout")
    @ResponseBody
    public Object logout(){
        HttpSession session=getSession();
        session.removeAttribute("user");
        return  MyResult.getResult();
    }
}
