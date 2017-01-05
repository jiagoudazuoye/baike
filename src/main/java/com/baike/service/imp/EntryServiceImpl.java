package com.baike.service.imp;

import com.baike.dao.EntryMapper;
import com.baike.model.Entry;
import com.baike.service.EntryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2017/1/4/004.
 */
@Service
public class EntryServiceImpl implements EntryService{

    @Resource
    private EntryMapper entryMapper;


    public Entry findEntryById(int id) {
        return entryMapper.selectByPrimaryKey(id);
    }

    public int addEntry(Entry entry) {
        return entryMapper.insertSelective(entry);
    }

    public int updateEntry(Entry entry) {
        return entryMapper.updateByPrimaryKeySelective(entry);
    }
}
