package com.sifunit.lanwei.domain;

import java.util.Date;

public class Production {
    private Long productionId;

    private String productionNo;

    private String contactNo;

    private String exportNo;

    private Long customerId;

    private Date createTime;

    private Date advanceTime;

    private Date realTime;

    public Production(Long productionId, String productionNo, String contactNo, String exportNo, Long customerId, Date createTime, Date advanceTime, Date realTime) {
        this.productionId = productionId;
        this.productionNo = productionNo;
        this.contactNo = contactNo;
        this.exportNo = exportNo;
        this.customerId = customerId;
        this.createTime = createTime;
        this.advanceTime = advanceTime;
        this.realTime = realTime;
    }

    public Production() {
        super();
    }

    public Long getProductionId() {
        return productionId;
    }

    public void setProductionId(Long productionId) {
        this.productionId = productionId;
    }

    public String getProductionNo() {
        return productionNo;
    }

    public void setProductionNo(String productionNo) {
        this.productionNo = productionNo == null ? null : productionNo.trim();
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo == null ? null : contactNo.trim();
    }

    public String getExportNo() {
        return exportNo;
    }

    public void setExportNo(String exportNo) {
        this.exportNo = exportNo == null ? null : exportNo.trim();
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getAdvanceTime() {
        return advanceTime;
    }

    public void setAdvanceTime(Date advanceTime) {
        this.advanceTime = advanceTime;
    }

    public Date getRealTime() {
        return realTime;
    }

    public void setRealTime(Date realTime) {
        this.realTime = realTime;
    }
}