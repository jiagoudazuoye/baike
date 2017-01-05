package com.baike.controller;

import com.baike.common.SpringMvcActionContext;
import com.baike.model.Category;
import com.baike.model.Comment;
import com.baike.model.Entry;
import com.baike.model.SubCategory;
import com.baike.service.*;
import com.baike.util.StringUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.*;

/**
 * Created by Administrator on 2017/1/4/004.
 */
@Controller
public class EntryController extends SpringMvcActionContext {

    @Resource
    private EntryService entryService;
    @Resource
    private CommentService commentService;
    @Resource
    private CategoryService categoryService;
    @Resource
    private SubCategoryService subCategoryService;

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
        System.out.println(entry.toString());
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


    @RequestMapping(value="searchGoodByKey")
    public ModelAndView search(String key){
        ModelAndView modelAndView = new ModelAndView();
        Category category = categoryService.selectByName(key);
        if (category ==null)
        {
            SubCategory subCategory = subCategoryService.selectByName(key);
            if(subCategory != null){
                System.out.println("subCategory != null");
                List<Entry> entryList = entryService.selectBySubId(subCategory.getSubCategoryId());
                modelAndView.addObject(entryList);
                modelAndView.setViewName("");//视图
                return modelAndView;
            } else {
                System.out.println("subCategory == null");
                List<Entry> entryList = entryService.searchGoodByKey(key);
                if (entryList != null){
                    System.out.println("entryList != null");
                    modelAndView.addObject(entryList);
                    modelAndView.setViewName("");
                    return modelAndView;
                }else {
                    System.out.println("goodList == null");
                    modelAndView.setViewName("");
                    return modelAndView;
                }
            }
        }
        else{
            List<SubCategory> subCategoryList = subCategoryService.selectByCategoryId(category.getCategoryId());
            List<Entry> c = new ArrayList<Entry>();
            for(int i = 0; i<subCategoryList.size();i++){
                int id = subCategoryList.get(i).getSubCategoryId();
                System.out.println(id);
                List<Entry> entryList = entryService.selectBySubId(id);
                System.out.println(entryList);
                Entry entry= new Entry();
                for (int j= 0; j < entryList.size();j++){
                    entry = entryList.get(j);
                    System.out.println(".........................");
                    System.out.println(entry.toString());
                    c.add(entry);
                }
            }
            modelAndView.addObject("entryList",c);
            modelAndView.setViewName("");
            return modelAndView;
        }
    }


    @RequestMapping("getMyEntry")
    public ModelAndView getMyEntry(int userId){
        ModelAndView modelAndView = new ModelAndView();
        List<Entry> entryList = entryService.getEntryByUserId(userId);
        modelAndView.addObject("entryList",entryList);
        if (entryList.size() > 0){
            modelAndView.setViewName("");
            return  modelAndView;
        }
        modelAndView.setViewName("");
        return  modelAndView;


    }

}
