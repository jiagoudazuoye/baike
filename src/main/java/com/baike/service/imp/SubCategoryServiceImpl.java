package com.baike.service.imp;

import com.baike.dao.SubCategoryMapper;
import com.baike.model.SubCategory;
import com.baike.service.SubCategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2016/11/23/023.
 */
@Service
public class SubCategoryServiceImpl implements SubCategoryService {



    @Resource
    private SubCategoryMapper subCategoryMapper;

    public SubCategory selectByName(String key) {
        return subCategoryMapper.selectByName(key);
    }

    public List<SubCategory> selectByCategoryId(int id) {
        return subCategoryMapper.selectByCategoryId(id);
    }
}
