package com.baike.controller.manage;


import com.baike.common.SpringMvcActionContext;
import com.baike.model.Template;
import com.baike.model.Admin;
import com.baike.service.TemplateService;
import com.baike.util.MyResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * Created by Y410P on 2017/1/6.
 */
@Controller
@RequestMapping("manage/entry")
public class ManageTemplateController extends SpringMvcActionContext{

    @Resource
    private TemplateService templateService;
    /**
     * 模板管理
     */
    @RequestMapping(value = "templateList")
    @ResponseBody
    public Object selectTemplates(){

        List<Template> tempsList = templateService.selectAll();
        return MyResult.getResult(1,"",tempsList);
    }

    @RequestMapping(value="template/{templateId}")
    @ResponseBody
    public Object viewTemplate(@PathVariable("templateId") Integer templateId ){
        Template template=templateService.findById(templateId);
        return MyResult.getResult(1,"",template);
    }

    @RequestMapping(value="updateTemplate")
    @ResponseBody
    public Object updateTemplate(Template template){
        HttpSession session=getSession();
        Admin  bmanager=(Admin) session.getAttribute("admin");
        int id=template.getTemplateId();
        Template pretemp=templateService.findById(id);
        pretemp.setUpdateBy(bmanager.getAdminId());
        Date date=new Date();
        pretemp.setUpdateTime(date);
        pretemp.setSubCategoryId(template.getSubCategoryId());
        pretemp.setContent(template.getContent());
        templateService.updateTemplate(pretemp);
        return MyResult.getResult(1,"",null);
    }

    @RequestMapping(value="deleteTemplate")
    @ResponseBody
    public Object deleteTemplate(@RequestParam("templateId") int templateId){
        templateService.deleteTemplate(templateId);
        return MyResult.getResult(1,"",null);
    }
    @RequestMapping(value="createTemplate")
    @ResponseBody
    public Object createTemplate(Template template){
        HttpSession session=getSession();
        Admin  bmanager=(Admin) session.getAttribute("admin");
        Template newtemp=new Template();
        Date date=new Date();
        newtemp.setCreateTime(date);
        newtemp.setCreateBy(bmanager.getAdminId());
        newtemp.setSubCategoryId(template.getSubCategoryId());
        newtemp.setContent(template.getContent());
        templateService.insertTemplate(newtemp);
        return MyResult.getResult(1,"",null);
    }

}
