package com.baike.dao;

import com.baike.model.SubCategory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SubCategoryMapper {
    int deleteByPrimaryKey(Integer subCategoryId);

    int insert(SubCategory record);

    int insertSelective(SubCategory record);

    SubCategory selectByPrimaryKey(Integer subCategoryId);

    int updateByPrimaryKeySelective(SubCategory record);

    int updateByPrimaryKey(SubCategory record);

    List<SubCategory> selectByCategoryId(@Param("cId") Integer cId);

    SubCategory selectByName(@Param("name") String name);
}