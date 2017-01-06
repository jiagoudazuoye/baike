package com.baike.service.imp;

import com.baike.dao.TemplateMapper;
import com.baike.model.Template;
import com.baike.service.TemplateService;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TemplateServiceImpl implements TemplateService {

    @Resource
    private TemplateMapper templateMapper;

    public List<Template> selectAll(){
        return templateMapper.selectAll();
    }

    public Template findById(int templateId){
        return templateMapper.selectByPrimaryKey(templateId);
    }

    public void insertTemplate(Template template){
        templateMapper.insert(template);
    }

    public void deleteTemplate(int templateId){
        templateMapper.deleteByPrimaryKey(templateId);
    }

    public void updateTemplate(Template template){
        templateMapper.updateByPrimaryKey(template);
    }

}
