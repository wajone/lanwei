package com.sifunit.lanwei.domain;

import java.util.Date;

public class Material {
    private Long materialId;

    private String materialNo;

    private String materialName;

    private Long materialCateId;

    private String materialCateName;

    private String materialDesc;

    private Boolean flag;

    private Date createTime;

    private Date updateTime;

    public Material(Long materialId, String materialNo, String materialName, Long materialCateId, String materialCateName, String materialDesc, Boolean flag, Date createTime, Date updateTime) {
        this.materialId = materialId;
        this.materialNo = materialNo;
        this.materialName = materialName;
        this.materialCateId = materialCateId;
        this.materialCateName = materialCateName;
        this.materialDesc = materialDesc;
        this.flag = flag;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Material() {
        super();
    }

    public Long getMaterialId() {
        return materialId;
    }

    public void setMaterialId(Long materialId) {
        this.materialId = materialId;
    }

    public String getMaterialNo() {
        return materialNo;
    }

    public void setMaterialNo(String materialNo) {
        this.materialNo = materialNo == null ? null : materialNo.trim();
    }

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName == null ? null : materialName.trim();
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

    public String getMaterialDesc() {
        return materialDesc;
    }

    public void setMaterialDesc(String materialDesc) {
        this.materialDesc = materialDesc == null ? null : materialDesc.trim();
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