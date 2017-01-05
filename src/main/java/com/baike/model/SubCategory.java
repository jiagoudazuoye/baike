package com.baike.model;

public class SubCategory {
    private Integer subCategoryId;

    private String subCategoryName;

    private Integer categogryId;

    public Integer getSubCategoryId() {
        return subCategoryId;
    }

    public void setSubCategoryId(Integer subCategoryId) {
        this.subCategoryId = subCategoryId;
    }

    public String getSubCategoryName() {
        return subCategoryName;
    }

    public void setSubCategoryName(String subCategoryName) {
        this.subCategoryName = subCategoryName == null ? null : subCategoryName.trim();
    }

    public Integer getCategogryId() {
        return categogryId;
    }

    public void setCategogryId(Integer categogryId) {
        this.categogryId = categogryId;
    }
}