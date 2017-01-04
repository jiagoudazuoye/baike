package com.baike.dao;

import com.baike.model.Template;

public interface TemplateMapper {
    int deleteByPrimaryKey(Integer templateId);

    int insert(Template record);

    int insertSelective(Template record);

    Template selectByPrimaryKey(Integer templateId);

    int updateByPrimaryKeySelective(Template record);

    int updateByPrimaryKeyWithBLOBs(Template record);

    int updateByPrimaryKey(Template record);
}