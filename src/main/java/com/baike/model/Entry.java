package com.baike.model;

import java.util.Date;

public class Entry {
    private Integer entryId;

    private Integer templateId;

    private String entryName;

    private String keyword;

    private Integer createBy;

    private Date createTime;

    private Integer state;

    private Integer subCategoryId;

    private String content;

    public Integer getEntryId() {
        return entryId;
    }

    public void setEntryId(Integer entryId) {
        this.entryId = entryId;
    }

    public Integer getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Integer templateId) {
        this.templateId = templateId;
    }

    public String getEntryName() {
        return entryName;
    }

    public void setEntryName(String entryName) {
        this.entryName = entryName == null ? null : entryName.trim();
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword == null ? null : keyword.trim();
    }

    public Integer getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getSubCategoryId() {
        return subCategoryId;
    }

    public void setSubCategoryId(Integer subCategoryId) {
        this.subCategoryId = subCategoryId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    @Override
    public String toString() {
        return "Entry{" +
                "entryId=" + entryId +
                ", templateId=" + templateId +
                ", entryName='" + entryName + '\'' +
                ", keyword='" + keyword + '\'' +
                ", createBy=" + createBy +
                ", createTime=" + createTime +
                ", state=" + state +
                ", subCategoryId=" + subCategoryId +
                ", content='" + content + '\'' +
                '}';
    }
}