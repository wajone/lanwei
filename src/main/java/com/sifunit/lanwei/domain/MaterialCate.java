package com.sifunit.lanwei.domain;

import java.util.Date;

public class MaterialCate {
    private Long materialCateId;

    private String materialCateName;

    private Long parentCateId;

    private String materialCateDesc;

    private Boolean flag;

    private Date createTime;

    private Date updateTime;

    public MaterialCate(Long materialCateId, String materialCateName, Long parentCateId, String materialCateDesc, Boolean flag, Date createTime, Date updateTime) {
        this.materialCateId = materialCateId;
        this.materialCateName = materialCateName;
        this.parentCateId = parentCateId;
        this.materialCateDesc = materialCateDesc;
        this.flag = flag;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public MaterialCate() {
        super();
    }

    public Long getMaterialCateId() {
        return materialCateId;
    }

    public void setMaterialCateId(Long materialCateId) {
        this.materialCateId = materialCateId;
    }

    public String getMaterialCateName() {
        return materialCateName;
    }

    public void setMaterialCateName(String materialCateName) {
        this.materialCateName = materialCateName == null ? null : materialCateName.trim();
    }

    public Long getParentCateId() {
        return parentCateId;
    }

    public void setParentCateId(Long parentCateId) {
        this.parentCateId = parentCateId;
    }

    public String getMaterialCateDesc() {
        return materialCateDesc;
    }

    public void setMaterialCateDesc(String materialCateDesc) {
        this.materialCateDesc = materialCateDesc == null ? null : materialCateDesc.trim();
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}