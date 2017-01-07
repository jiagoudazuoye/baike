package com.baike.service;

import com.baike.model.Entry;

import java.util.List;

/**
 * Created by xiechur on 2017/1/4/004.
 */
public interface EntryService {

    public Entry findEntryById(int id);

     List<Entry> selectAll();

    public int addEntry(Entry entry);

    public int updateEntry(Entry entry);

    public List selectBySubId(int id);

    public List searchGoodByKey(String k);

    public List getEntryByUserId(int userId);

    public  Entry getEntryByName(String entryName);
}
