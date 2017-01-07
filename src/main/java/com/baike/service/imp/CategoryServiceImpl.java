package com.baike.service.imp;

import com.baike.dao.CategoryMapper;
import com.baike.model.Category;
import com.baike.service.CategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2016/11/23/023.
 */

@Service
public class CategoryServiceImpl implements CategoryService {

    @Resource
    private CategoryMapper categoryMapper;


    public Category selectByName(String key) {
        return categoryMapper.selectByName(key);
    }

    public List<Category> getCategoryList() {
        return categoryMapper.getCategoryList();
    }
}
