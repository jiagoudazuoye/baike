package com.baike.service;

import com.baike.model.ModifyInfo;

import java.util.List;

/**
 * Created by xiechur on 2017/1/7/007.
 */
public interface ModifyInfoService {

    public int addModifyInfo(ModifyInfo modifyInfo);

    public List<ModifyInfo> getMyModify(int userId);

    public List<ModifyInfo> getModifies(int entryId);
}
