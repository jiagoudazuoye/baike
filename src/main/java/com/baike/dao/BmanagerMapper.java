package com.baike.dao;

import com.baike.model.Bmanager;

public interface BmanagerMapper {
    int deleteByPrimaryKey(Integer bmanagerId);

    int insert(Bmanager record);

    int insertSelective(Bmanager record);

    Bmanager selectByPrimaryKey(Integer bmanagerId);

    int updateByPrimaryKeySelective(Bmanager record);

    int updateByPrimaryKey(Bmanager record);
}