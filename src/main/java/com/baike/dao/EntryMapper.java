package com.baike.dao;

import com.baike.model.Entry;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EntryMapper {
    int deleteByPrimaryKey(Integer entryId);

    int insert(Entry record);

    int insertSelective(Entry record);

    Entry selectByPrimaryKey(Integer entryId);

    List<Entry> selectAll();

    int updateByPrimaryKeySelective(Entry record);

    int updateByPrimaryKey(Entry record);

    List<Entry> selectBySubId(@Param("subId")int subId);

    List<Entry> selectByName(@Param("name")String name);

    List<Entry> selectByUserId(@Param("userId")int userId);
}