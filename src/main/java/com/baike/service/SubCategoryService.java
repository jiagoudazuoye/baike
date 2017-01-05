package com.baike.service;


import com.baike.model.SubCategory;

import java.util.List;

/**
 * Created by xiechur on 2016/11/23/023.
 */
public interface SubCategoryService {

    public SubCategory selectByName(String key);

    public List<SubCategory> selectByCategoryId(int id);
}
