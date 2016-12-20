package com.baike.controller;

import com.baike.common.SpringMvcActionContext;
import com.baike.model.User;
import com.baike.service.UserService;
import com.baike.util.MyResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * Created by xiechur on 2016/8/25.
 */
@Controller
@RequestMapping(value = "/user")
public class UserController extends SpringMvcActionContext{

    @Resource
    private UserService userService;


    /**
     * 查询用户列表
     */
    @RequestMapping(value = "userList")
    @ResponseBody
    public Object selectUser(){
        List<User> userList = userService.selectAll();
        return MyResult.getResult(1,"",userList);
    }



}
