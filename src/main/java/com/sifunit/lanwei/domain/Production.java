package com.sifunit.lanwei.domain;

import java.util.Date;

public class Production {
    private Long productionId;

    private String productionNo;

    private String contactNo;

    private String exportNo;

    private Long customerId;

    private Date orderTime;

    private Date advanceTime;

    private Date realTime;

    private Boolean isCompleted;

    private Integer level;

    private String maker;

    private String comment;

    private Date createTime;

    private Date updateTime;

    public Production(Long productionId, String productionNo, String contactNo, String exportNo, Long customerId, Date orderTime, Date advanceTime, Date realTime, Boolean isCompleted, Integer level, String maker, String comment, Date createTime, Date updateTime) {
        this.productionId = productionId;
        this.productionNo = productionNo;
        this.contactNo = contactNo;
        this.exportNo = exportNo;
        this.customerId = customerId;
        this.orderTime = orderTime;
        this.advanceTime = advanceTime;
        this.realTime = realTime;
        this.isCompleted = isCompleted;
        this.level = level;
        this.maker = maker;
        this.comment = comment;
        this.createTime = createTime;
        this.updateTime = updateTime;
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

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
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

    public Boolean getIsCompleted() {
        return isCompleted;
    }

    public void setIsCompleted(Boolean isCompleted) {
        this.isCompleted = isCompleted;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker == null ? null : maker.trim();
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
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