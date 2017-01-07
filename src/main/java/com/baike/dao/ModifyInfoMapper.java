package com.baike.dao;

import com.baike.model.ModifyInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ModifyInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ModifyInfo record);

    int insertSelective(ModifyInfo record);

    ModifyInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ModifyInfo record);

    int updateByPrimaryKey(ModifyInfo record);

    public List<ModifyInfo> selectByUserId(@Param("userId")int userId);

    public List<ModifyInfo> selectByEntryId(@Param("entryId")int entryId);
}