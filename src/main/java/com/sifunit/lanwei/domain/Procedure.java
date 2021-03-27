package com.sifunit.lanwei.domain;

import java.util.Date;

public class Procedure {
    private Long proceId;

    private String proceNo;

    private String proceName;

    private Long proceCateId;

    private String proceCateName;

    private String proceDesc;

    private Boolean flag;

    private Date createTime;

    private Date updateTime;

    public Procedure(Long proceId, String proceNo, String proceName, Long proceCateId, String proceCateName, String proceDesc, Boolean flag, Date createTime, Date updateTime) {
        this.proceId = proceId;
        this.proceNo = proceNo;
        this.proceName = proceName;
        this.proceCateId = proceCateId;
        this.proceCateName = proceCateName;
        this.proceDesc = proceDesc;
        this.flag = flag;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Procedure() {
        super();
    }

    public Long getProceId() {
        return proceId;
    }

    public void setProceId(Long proceId) {
        this.proceId = proceId;
    }

    public String getProceNo() {
        return proceNo;
    }

    public void setProceNo(String proceNo) {
        this.proceNo = proceNo == null ? null : proceNo.trim();
    }

    public String getProceName() {
        return proceName;
    }

    public void setProceName(String proceName) {
        this.proceName = proceName == null ? null : proceName.trim();
    }

    public Long getProceCateId() {
        return proceCateId;
    }

    public String getProceCateName() {
        return proceCateName;
    }

    public void setProceCateName(String proceCateName) {
        this.proceCateName = proceCateName;
    }

    public void setProceCateId(Long proceCateId) {
        this.proceCateId = proceCateId;
    }

    public String getProceDesc() {
        return proceDesc;
    }

    public void setProceDesc(String proceDesc) {
        this.proceDesc = proceDesc == null ? null : proceDesc.trim();
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