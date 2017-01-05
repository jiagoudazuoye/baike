package com.baike.service;

import com.baike.model.Entry;

/**
 * Created by xiechur on 2017/1/4/004.
 */
public interface EntryService {

    public Entry findEntryById(int id);

    public int addEntry(Entry entry);

    public int updateEntry(Entry entry);


}
