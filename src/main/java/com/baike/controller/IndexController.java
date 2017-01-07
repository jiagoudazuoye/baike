package com.baike.controller;

import com.baike.common.SpringMvcActionContext;
import com.baike.model.Category;
import com.baike.service.CategoryService;
import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/1/7/007.
 */
@Controller
public class IndexController extends SpringMvcActionContext{
    private static final transient Logger log = org.slf4j.LoggerFactory.getLogger(IndexController.class);
    @Resource
    private CategoryService categoryService;

    @RequestMapping(value = {"/","/index"},method= RequestMethod.GET)
    public ModelAndView index(){
        System.out.println("............................................................");
        ModelAndView modelAndView=new ModelAndView("main");
        List<Category> categoryList = categoryService.getCategoryList();
        modelAndView.addObject("categoryList",categoryList);
        return modelAndView;
    }
}
