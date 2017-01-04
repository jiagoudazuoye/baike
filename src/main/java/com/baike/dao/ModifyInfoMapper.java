package com.baike.dao;

import com.baike.model.ModifyInfo;

public interface ModifyInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ModifyInfo record);

    int insertSelective(ModifyInfo record);

    ModifyInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ModifyInfo record);

    int updateByPrimaryKey(ModifyInfo record);
}