package com.baike.service;

import com.baike.model.Login;
import com.baike.model.Register;
import com.baike.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by huanghaojian on 17/1/5.
 */
public interface LoginService {
    public User login(Login login);
    public void getNewVaildCode(HttpServletRequest request, HttpServletResponse response, HttpSession session);
    //注册，发送验证码到邮箱
    public Object sendVaildCodeToEmail(String email,HttpSession session);
    //注册
    public int register(Register register);
    //忘记密码，发送验证码到邮箱
    public Object SendResetValidCodeToEmail(String email , HttpSession session);
    //忘记密码
    public int updatePassword(int userId,String password);

    public int duplicateNameChecking(String userName);
    public int duplicateEmailChecking(String email);
}
