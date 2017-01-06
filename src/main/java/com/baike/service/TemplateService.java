package com.baike.service;

import com.baike.model.Template;
import java.util.List;

public interface TemplateService {

    List<Template> selectAll();

    Template findById(int templateId);

    void insertTemplate(Template template);

    void deleteTemplate(int templateId);

    void updateTemplate(Template template);

}
