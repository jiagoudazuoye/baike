package com.baike.controller;

import com.baike.common.SpringMvcActionContext;
import com.baike.model.*;
import com.baike.service.*;
import com.baike.util.StringUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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
    @Resource
    private ModifyInfoService modifyInfoService;
    @Resource
    private TemplateService templateService;

    /***
     *新建 词条
     * @return
     */
    @RequestMapping(value = "/entry/createEntry",method = RequestMethod.GET)
    public ModelAndView toCreateEntry(){
        ModelAndView mv = new ModelAndView();
        List<Template> templateList = templateService.selectAll();
        mv.addObject("templateList",templateList);
        mv.setViewName("/entry/createEntry");
        return mv;
    }

    /***
     *新建 词条
     * @param entry
     * @return
     */
    @RequestMapping(value = "/entry/createEntry",method = RequestMethod.POST)
    @ResponseBody
    public Object createEntry(Entry entry){
        entry.setCreateTime(new Date());
//        User user = (User)getSession().getAttribute("user");
//        entry.setCreateBy(user.getUserId());
        Map<String,Object> map = new HashMap<String, Object>();
        int result = entryService.addEntry(entry);
        if (result > 0){
            map.put("success",true);
        }else {
            map.put("success",false);
        }
        return map;
    }

    @RequestMapping(value = "/entry/edit/{entryId}",method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable("entryId")Integer entryId){
        ModelAndView mv = new ModelAndView();
        Entry entry = entryService.findEntryById(entryId);
        System.out.println(entry.toString());
        List<Template> templateList = templateService.selectAll();
        mv.addObject("templateList",templateList);
        if (entry != null){
            mv.addObject("entry",entry);
            mv.setViewName("/entry/editEntry");
            return mv;
        }else {
            mv.addObject("error","找不到这个词条");
            mv.setViewName("error");
            return mv;
        }

    }

    /***
     * 修改词条
     * @param entry
     * @return
     */
    @RequestMapping(value = "/entry/edit",method = RequestMethod.POST)
    @ResponseBody
    public Object editEntry(Entry entry){
        Map<String,Object> map = new HashMap<String, Object>();
        int result = entryService.updateEntry(entry);
        ModifyInfo modifyInfo = new ModifyInfo();
        modifyInfo.setEntryId(entry.getEntryId());
        modifyInfo.setModifyTime(new Date());
        User user = (User)getSession().getAttribute("user");
        modifyInfo.setUserId(user.getUserId());
        modifyInfoService.addModifyInfo(modifyInfo);
        if (result > 0){
            map.put("success",true);
        }else {
            map.put("success",false);
        }
        return map;
    }

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
//        System.out.println("-----------------------------------------------------------------------------------");
//        System.out.println(commentService.getCommentList(entryId).size());
//        System.out.println(commentService.getCommentList(entryId).get(0).toString());
//        System.out.println("-----------------------------------------------------------------------------------");
//        mv.addObject("pageTitle",entry.getEntryName()+"_互动百科系统");//标题，用于html的title标签
        mv.setViewName("/entry/view");
        return mv;
    }


    /***
     * 模糊搜索
     * @param key
     * @return
     */
    @RequestMapping(value="/entry/searchEntryByKey")
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

    /***
     * 获取我的词条
     * @param userId
     * @return
     */
    @RequestMapping("entry/getMyEntry")
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

    /***
     * 进入词条
     * @param
     * @return
     */
    @RequestMapping("entry/watchEntry")
    public ModelAndView watchEntry(String entryName){
        ModelAndView modelAndView = new ModelAndView();
        Entry entry = entryService.getEntryByName(entryName);
        modelAndView.addObject("entry",entry);
        if (entry != null){
            modelAndView.setViewName("");
            return  modelAndView;
        }
        modelAndView.addObject("error","找不到此词条");
        modelAndView.setViewName("error");
        return  modelAndView;
    }


//    @RequestMapping("getCategory")
//    public ModelAndView getCategory(){
//        ModelAndView modelAndView = new ModelAndView();
//        List<Category> categoryList = categoryService.getCategoryList();
//        modelAndView.addObject("categoryList",categoryList);
//        if (categoryList.size() > 0){
//            modelAndView.setViewName("");
//            return  modelAndView;
//        }
//        modelAndView.setViewName("");
//        return  modelAndView;
//    }

    @RequestMapping("template/findById")
    @ResponseBody
    public Object findTemplateById(@RequestParam("templateId")int templateId){
        Template template = templateService.findById(templateId);
        return template;
    }

}
