package com.baike.controller.manage;


import com.baike.model.PageBean;
import com.baike.model.Entry;
import com.baike.service.EntryService;
import com.baike.service.UserService;
import com.baike.util.MyResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.stereotype.Controller;
import javax.annotation.Resource;
import java.util.List;


/**
 * Created by Y410P on 2017/1/6.
 */
@Controller
@RequestMapping("manage/entry")
public class ManageEntryController {

    @Resource
    private EntryService entryService;
    @Resource
    private UserService userService;
    /**
     * 词条审核
     */
    @RequestMapping(value = "entryList")
    @ResponseBody
    public Object selectEntries(){

        List<Entry> entriesList = entryService.selectAll();
        return MyResult.getResult(1,"",entriesList);
    }
    @RequestMapping(value="check/{entryId}")
    @ResponseBody
    public Object update(@PathVariable("entryId") Integer entryId){
        Entry entry=entryService.findEntryById(entryId);
        return MyResult.getResult(1,"",entry);
    }


    @RequestMapping(value = "auditsucess")
    @ResponseBody
    public Object auditSucess(@RequestParam int entryId){
        Entry entry=entryService.findEntryById(entryId);
        entry.setState(1);
        entryService.updateEntry(entry);
        return MyResult.getResult(1,"审核通过",null);
    }
    @RequestMapping(value = "auditfail")
    @ResponseBody
    public Object auditFail(@RequestParam int entryId){
        Entry entry=entryService.findEntryById(entryId);
        entry.setState(2);
        entryService.updateEntry(entry);
        return MyResult.getResult(0,"审核未通过",null);
    }
    @RequestMapping(value = "cancel")
    public String cancel(){
        return "redirect:entryList.jsp";
    }

}
