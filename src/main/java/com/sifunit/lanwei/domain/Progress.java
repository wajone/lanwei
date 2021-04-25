package com.sifunit.lanwei.domain;

import java.util.Date;

public class Progress {
    private Long id;

    private Long productionId;

    private Long productId;

    private Long proceId;

    private Long completedNum;

    private Long goalNum;

    private Float procePrice;

    private String proceComment;

    private Date createTime;

    private Date finishdTime;

    public Progress(Long id, Long productionId, Long productId, Long proceId, Long completedNum, Long goalNum, Float procePrice, String proceComment, Date createTime, Date finishdTime) {
        this.id = id;
        this.productionId = productionId;
        this.productId = productId;
        this.proceId = proceId;
        this.completedNum = completedNum;
        this.goalNum = goalNum;
        this.procePrice = procePrice;
        this.proceComment = proceComment;
        this.createTime = createTime;
        this.finishdTime = finishdTime;
    }

    public Progress() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductionId() {
        return productionId;
    }

    public void setProductionId(Long productionId) {
        this.productionId = productionId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getProceId() {
        return proceId;
    }

    public void setProceId(Long proceId) {
        this.proceId = proceId;
    }

    public Long getCompletedNum() {
        return completedNum;
    }

    public void setCompletedNum(Long completedNum) {
        this.completedNum = completedNum;
    }

    public Long getGoalNum() {
        return goalNum;
    }

    public void setGoalNum(Long goalNum) {
        this.goalNum = goalNum;
    }

    public Float getProcePrice() {
        return procePrice;
    }

    public void setProcePrice(Float procePrice) {
        this.procePrice = procePrice;
    }

    public String getProceComment() {
        return proceComment;
    }

    public void setProceComment(String proceComment) {
        this.proceComment = proceComment == null ? null : proceComment.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getFinishdTime() {
        return finishdTime;
    }

    public void setFinishdTime(Date finishdTime) {
        this.finishdTime = finishdTime;
    }
}