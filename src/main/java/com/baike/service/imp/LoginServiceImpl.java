package com.baike.service.imp;

import com.baike.dao.LoginMapper;
import com.baike.model.Login;
import com.baike.model.Register;
import com.baike.model.User;
import com.baike.service.LoginService;
import com.baike.util.Mail.MailSenderInfo;
import com.baike.util.Mail.SimpleMailSender;
import com.baike.util.MyResult;
import com.baike.util.ValidCodeGenerator;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by huanghaojian on 17/1/5.
 */
@Service
public class LoginServiceImpl implements LoginService {
    @Resource
    private LoginMapper loginMapper;
    @Resource
    private ValidCodeGenerator validCodeGenerator;
    public User login(Login login){
        String userName=login.getUserName();
        String password=login.getPassword();
        return loginMapper.login(userName,password);
    }
    public void getNewVaildCode(HttpServletRequest request, HttpServletResponse response, HttpSession session){
        String vaildCode=validCodeGenerator.getRandcode(request,response);
        session.setAttribute("loginVaildCode",vaildCode);
    }
    public int register(Register register){
        return loginMapper.register(register);
    }
    public int duplicateNameChecking(String userName){
        return loginMapper.duplicateNameChecking(userName);
    }
    public int duplicateEmailChecking(String email){
        return loginMapper.duplicateEmailChecking(email);
    }
    public Object sendVaildCodeToEmail(String email,HttpSession session){
        MailSenderInfo mailInfo =new MailSenderInfo();
        mailInfo.setMailServerHost("stmp.126.com");
        mailInfo.setMailServerPort("25");
        mailInfo.setValidate(true);
        mailInfo.setUserName("a18826077190@126.com");
        mailInfo.setPassword("xiechur123");
        mailInfo.setFromAddress("a18826077190@126.com");
        mailInfo.setToAddress(email);
        mailInfo.setSubject("baike用户注册验证码");
        StringBuffer stringBuffer=new StringBuffer("\"点击下面链接查看验证码，48小时生，否则需要重新获取，链接只能使用一次，请尽快使用！</br>");
        stringBuffer.append("你的验证码是：");
        stringBuffer.append(session.getAttribute("registerValidCode"));
        mailInfo.setContent(stringBuffer.toString());
        SimpleMailSender simpleMailSender=new SimpleMailSender();
        boolean b=simpleMailSender.sendTextMail(mailInfo);
        if(b){
            System.out.println("邮件发送");
            return MyResult.getResult();
        }else {
            return MyResult.getResult(0,"发送失败","");
        }
    }
    public Object SendResetValidCodeToEmail(String email , HttpSession session){
        MailSenderInfo mailInfo =new MailSenderInfo();
        mailInfo.setMailServerHost("stmp.126.com");
        mailInfo.setMailServerPort("25");
        mailInfo.setValidate(true);
        mailInfo.setUserName("a18826077190@126.com");
        mailInfo.setPassword("xiechur123");
        mailInfo.setFromAddress("a18826077190@126.com");
        mailInfo.setToAddress(email);
        mailInfo.setSubject("baike用户重设密码验证码");
        StringBuffer stringBuffer=new StringBuffer("\"点击下面链接查看验证码，48小时生，否则需要重新获取，链接只能使用一次，请尽快使用！</br>");
        stringBuffer.append("你的验证码是：");
        stringBuffer.append(session.getAttribute("resetValidCode"));
        mailInfo.setContent(stringBuffer.toString());
        SimpleMailSender simpleMailSender=new SimpleMailSender();
        boolean b=simpleMailSender.sendTextMail(mailInfo);
        if(b){
            System.out.println("邮件发送");
            return MyResult.getResult();
        }else {
            return MyResult.getResult(0,"发送失败","");
        }
    }
    public int updatePassword(int userId, String password) {
        return loginMapper.updatePassword(userId,password);
    }
}

