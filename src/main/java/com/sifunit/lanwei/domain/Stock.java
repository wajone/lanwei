package com.sifunit.lanwei.domain;

import java.util.Date;

public class Stock {
    private Long stockId;

    private String materialNo;

    private String materialName;

    private Long materialCateId;

    private String materialCateName;

    private Long stockNum;

    private Long unitId;

    private String unitName;

    private Date createTime;

    private Date updateTime;

    public Stock(Long stockId, String materialNo, String materialName, Long materialCateId, String materialCateName, Long stockNum, Long unitId, String unitName, Date createTime, Date updateTime) {
        this.stockId = stockId;
        this.materialNo = materialNo;
        this.materialName = materialName;
        this.materialCateId = materialCateId;
        this.materialCateName = materialCateName;
        this.stockNum = stockNum;
        this.unitId = unitId;
        this.unitName = unitName;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Stock() {
        super();
    }

    public Long getStockId() {
        return stockId;
    }

    public void setStockId(Long stockId) {
        this.stockId = stockId;
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

    public Long getStockNum() {
        return stockNum;
    }

    public void setStockNum(Long stockNum) {
        this.stockNum = stockNum;
    }

    public Long getUnitId() {
        return unitId;
    }

    public void setUnitId(Long unitId) {
        this.unitId = unitId;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName == null ? null : unitName.trim();
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