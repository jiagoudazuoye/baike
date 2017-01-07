package com.baike.service.imp;

import com.baike.dao.ModifyInfoMapper;
import com.baike.model.ModifyInfo;
import com.baike.service.ModifyInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/1/7/007.
 */
@Service
public class ModifyInfoServiceImpl implements ModifyInfoService{

    @Resource
    private ModifyInfoMapper modifyInfoMapper;


    public int addModifyInfo(ModifyInfo modifyInfo) {
        return modifyInfoMapper.insertSelective(modifyInfo);
    }

    public List<ModifyInfo> getMyModify(int userId) {
        return modifyInfoMapper.selectByUserId(userId);
    }

    public List<ModifyInfo> getModifies(int entryId) {
        return modifyInfoMapper.selectByEntryId(entryId);
    }
}
