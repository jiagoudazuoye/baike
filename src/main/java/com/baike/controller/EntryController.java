package com.baike.controller;

import com.baike.common.SpringMvcActionContext;
import com.baike.model.Comment;
import com.baike.model.Entry;
import com.baike.service.CommentService;
import com.baike.service.EntryService;
import com.baike.util.StringUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/1/4/004.
 */
@Controller
public class EntryController extends SpringMvcActionContext {

    @Resource
    private EntryService entryService;
    @Resource
    private CommentService commentService;

    /***
     * 获取 词条详情
     * @param entryId
     * @return
     */
    @RequestMapping("/entry/{entryId}")
    public ModelAndView details(@PathVariable("entryId")Integer entryId){
        ModelAndView mv = new ModelAndView();
        Entry entry = new Entry();
        entry = entryService.findEntryById(entryId);
        String keyWords=entry.getKeyword();
        if (StringUtil.isNotEmpty(keyWords)){
            String arr[]=keyWords.split(" ");
            mv.addObject("keyWords", StringUtil.filterWhite(Arrays.asList(arr)));//把a,b,c变成一个数组[a,b,c]
        }else {
            mv.addObject("keyWords",null);
        }
        mv.addObject("entry",entry);
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("entryId", entry.getEntryId());
        mv.addObject("commentList",commentService.getCommentList(entryId));//评论列表
        mv.addObject("mainPage", "entry/view.jsp");//${mainPage}
        mv.addObject("pageTitle",entry.getEntryName()+"_互动百科系统");//标题，用于html的title标签
        mv.setViewName("main");//  main.jsp
        return mv;
    }

    /***
     * 修改词条
     * @param entry
     * @return
     */
    @RequestMapping("/entry/edit")
    @ResponseBody
    public Object editEntry(Entry entry){
        Map<String,Object> map = new HashMap<String, Object>();
        int result = entryService.updateEntry(entry);
        if (result > 0){
            map.put("success",true);
        }else {
            map.put("success",false);
        }
        return map;
    }

//    @RequestMapping("")

//    @RequestMapping("search")
//    @ResponseBody
//    public List<Entry> entries(String key){
//
//    }

}
