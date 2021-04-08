package com.sifunit.lanwei.domain;

import java.util.Date;

public class Emp {
    private Long empId;

    private String empNo;

    private String empName;

    private Date empBirthday;

    private Long deptId;

    private String deptName;

    private Boolean onJob;

    private Date hiredate;

    private Date updateTime;

    public Emp(Long empId, String empNo, String empName, Date empBirthday, Long deptId, String deptName, Boolean onJob, Date hiredate, Date updateTime) {
        this.empId = empId;
        this.empNo = empNo;
        this.empName = empName;
        this.empBirthday = empBirthday;
        this.deptId = deptId;
        this.deptName = deptName;
        this.onJob = onJob;
        this.hiredate = hiredate;
        this.updateTime = updateTime;
    }

    public Emp() {
        super();
    }

    public Long getEmpId() {
        return empId;
    }

    public void setEmpId(Long empId) {
        this.empId = empId;
    }

    public String getEmpNo() {
        return empNo;
    }

    public void setEmpNo(String empNo) {
        this.empNo = empNo == null ? null : empNo.trim();
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName == null ? null : empName.trim();
    }

    public Date getEmpBirthday() {
        return empBirthday;
    }

    public void setEmpBirthday(Date empBirthday) {
        this.empBirthday = empBirthday;
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

    public Boolean getOnJob() {
        return onJob;
    }

    public void setOnJob(Boolean onJob) {
        this.onJob = onJob;
    }

    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}