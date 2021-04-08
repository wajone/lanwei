package com.sifunit.lanwei.domain;

import java.util.Date;

public class Unit {
    private Long unitId;

    private String unitName;

    private String unitDesc;

    private Date createTime;

    private Date updateTime;

    public Unit(Long unitId, String unitName, String unitDesc, Date createTime, Date updateTime) {
        this.unitId = unitId;
        this.unitName = unitName;
        this.unitDesc = unitDesc;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Unit() {
        super();
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

    public String getUnitDesc() {
        return unitDesc;
    }

    public void setUnitDesc(String unitDesc) {
        this.unitDesc = unitDesc == null ? null : unitDesc.trim();
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