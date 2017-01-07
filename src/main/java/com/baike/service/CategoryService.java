package com.baike.service;


import com.baike.model.Category;

import java.util.List;

/**
 * Created by Administrator on 2016/11/23/023.
 */
public interface CategoryService {

    public Category selectByName(String key);

    public List<Category> getCategoryList();

}
