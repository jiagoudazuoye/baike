package com.baike.controller;

import com.baike.common.SpringMvcActionContext;
import com.baike.model.Comment;
import com.baike.service.CommentService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.security.interfaces.ECKey;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiechur on 2017/1/4/004.
 */
@Controller
public class CommentController extends SpringMvcActionContext {

    @Resource
    private CommentService commentService;

    /***
     * 添加评论
     * @param comment
     * @return
     */
    @RequestMapping("comment/save")//
    @ResponseBody//声明返回json
    public Object save(Comment comment){
        Map<String,Object> map = new HashMap<String, Object>();
        int result = commentService.addComment(comment);
        if (result > 0){
            map.put("success",true);
        }else {
            map.put("success",false);
        }
        return map;
    }

    //   {"success",ture}

}
