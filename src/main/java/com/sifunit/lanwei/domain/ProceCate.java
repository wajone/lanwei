package com.sifunit.lanwei.domain;

import java.util.Date;

public class ProceCate {
    private Long proceCateId;

    private String proceCateName;

    private Long parentProceCateId;

    private String proceCateDesc;

    private Boolean flag;

    private Date createTime;

    private Date updateTime;

    public ProceCate(Long proceCateId, String proceCateName, Long parentProceCateId, String proceCateDesc, Boolean flag, Date createTime, Date updateTime) {
        this.proceCateId = proceCateId;
        this.proceCateName = proceCateName;
        this.parentProceCateId = parentProceCateId;
        this.proceCateDesc = proceCateDesc;
        this.flag = flag;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public ProceCate() {
        super();
    }

    public Long getProceCateId() {
        return proceCateId;
    }

    public void setProceCateId(Long proceCateId) {
        this.proceCateId = proceCateId;
    }

    public String getProceCateName() {
        return proceCateName;
    }

    public void setProceCateName(String proceCateName) {
        this.proceCateName = proceCateName == null ? null : proceCateName.trim();
    }

    public Long getParentProceCateId() {
        return parentProceCateId;
    }

    public void setParentProceCateId(Long parentProceCateId) {
        this.parentProceCateId = parentProceCateId;
    }

    public String getProceCateDesc() {
        return proceCateDesc;
    }

    public void setProceCateDesc(String proceCateDesc) {
        this.proceCateDesc = proceCateDesc == null ? null : proceCateDesc.trim();
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