package com.baike.dao;

import com.baike.model.Template;

import java.util.List;

public interface TemplateMapper {
    int deleteByPrimaryKey(Integer templateId);

    int insert(Template record);

    int insertSelective(Template record);

    Template selectByPrimaryKey(Integer templateId);

    List<Template> selectAll();

    int updateByPrimaryKeySelective(Template record);

    int updateByPrimaryKeyWithBLOBs(Template record);

    int updateByPrimaryKey(Template record);
}