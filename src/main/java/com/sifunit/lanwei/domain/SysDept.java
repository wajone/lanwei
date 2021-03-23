package com.sifunit.lanwei.domain;

import java.util.Date;

public class SysDept {
    private Long deptId;

    private String deptName;

    private Long deptParentId;

    private String deptParentName;

    private String deptDesc;

    private Boolean flag;

    private Date createTime;

    private Date updateTime;

    public SysDept(Long deptId, String deptName, Long deptParentId, String deptParentName, String deptDesc, Boolean flag, Date createTime, Date updateTime) {
        this.deptId = deptId;
        this.deptName = deptName;
        this.deptParentId = deptParentId;
        this.deptParentName = deptParentName;
        this.deptDesc = deptDesc;
        this.flag = flag;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public SysDept() {
        super();
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName == null ? null : deptName.trim();
    }

    public Long getDeptParentId() {
        return deptParentId;
    }

    public void setDeptParentId(Long deptParentId) {
        this.deptParentId = deptParentId;
    }

    public String getDeptParentName() {
        return deptParentName;
    }

    public void setDeptParentName(String deptParentName) {
        this.deptParentName = deptParentName == null ? null : deptParentName.trim();
    }

    public String getDeptDesc() {
        return deptDesc;
    }

    public void setDeptDesc(String deptDesc) {
        this.deptDesc = deptDesc == null ? null : deptDesc.trim();
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