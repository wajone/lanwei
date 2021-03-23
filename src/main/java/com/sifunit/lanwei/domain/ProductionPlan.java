package com.sifunit.lanwei.domain;

import java.util.Date;

public class ProductionPlan {
    private Long proId;

    private String proNumber;

    private String proContractNum;

    private String proExportNum;

    private Date proOrderTime;

    private Date proAdvanceTime;

    private Date proRealTime;

    public ProductionPlan(Long proId, String proNumber, String proContractNum, String proExportNum, Date proOrderTime, Date proAdvanceTime, Date proRealTime) {
        this.proId = proId;
        this.proNumber = proNumber;
        this.proContractNum = proContractNum;
        this.proExportNum = proExportNum;
        this.proOrderTime = proOrderTime;
        this.proAdvanceTime = proAdvanceTime;
        this.proRealTime = proRealTime;
    }

    public ProductionPlan() {
        super();
    }

    public Long getProId() {
        return proId;
    }

    public void setProId(Long proId) {
        this.proId = proId;
    }

    public String getProNumber() {
        return proNumber;
    }

    public void setProNumber(String proNumber) {
        this.proNumber = proNumber == null ? null : proNumber.trim();
    }

    public String getProContractNum() {
        return proContractNum;
    }

    public void setProContractNum(String proContractNum) {
        this.proContractNum = proContractNum == null ? null : proContractNum.trim();
    }

    public String getProExportNum() {
        return proExportNum;
    }

    public void setProExportNum(String proExportNum) {
        this.proExportNum = proExportNum == null ? null : proExportNum.trim();
    }

    public Date getProOrderTime() {
        return proOrderTime;
    }

    public void setProOrderTime(Date proOrderTime) {
        this.proOrderTime = proOrderTime;
    }

    public Date getProAdvanceTime() {
        return proAdvanceTime;
    }

    public void setProAdvanceTime(Date proAdvanceTime) {
        this.proAdvanceTime = proAdvanceTime;
    }

    public Date getProRealTime() {
        return proRealTime;
    }

    public void setProRealTime(Date proRealTime) {
        this.proRealTime = proRealTime;
    }
}