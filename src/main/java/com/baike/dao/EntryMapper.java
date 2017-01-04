package com.baike.dao;

import com.baike.model.Entry;

public interface EntryMapper {
    int deleteByPrimaryKey(Integer entryId);

    int insert(Entry record);

    int insertSelective(Entry record);

    Entry selectByPrimaryKey(Integer entryId);

    int updateByPrimaryKeySelective(Entry record);

    int updateByPrimaryKeyWithBLOBs(Entry record);

    int updateByPrimaryKey(Entry record);
}