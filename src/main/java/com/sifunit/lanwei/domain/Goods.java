package com.sifunit.lanwei.domain;

import java.util.Date;

public class Goods {
    private Long goodId;

    private String goodImages;

    private String goodNum;

    private String goodName;

    private String goodSize;

    private String goodInnerRing;

    private String goodDesc;

    private Date createTime;

    public Goods(Long goodId, String goodImages, String goodNum, String goodName, String goodSize, String goodInnerRing, String goodDesc, Date createTime) {
        this.goodId = goodId;
        this.goodImages = goodImages;
        this.goodNum = goodNum;
        this.goodName = goodName;
        this.goodSize = goodSize;
        this.goodInnerRing = goodInnerRing;
        this.goodDesc = goodDesc;
        this.createTime = createTime;
    }

    public Goods() {
        super();
    }

    public Long getGoodId() {
        return goodId;
    }

    public void setGoodId(Long goodId) {
        this.goodId = goodId;
    }

    public String getGoodImages() {
        return goodImages;
    }

    public void setGoodImages(String goodImages) {
        this.goodImages = goodImages == null ? null : goodImages.trim();
    }

    public String getGoodNum() {
        return goodNum;
    }

    public void setGoodNum(String goodNum) {
        this.goodNum = goodNum;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName == null ? null : goodName.trim();
    }

    public String getGoodSize() {
        return goodSize;
    }

    public void setGoodSize(String goodSize) {
        this.goodSize = goodSize == null ? null : goodSize.trim();
    }

    public String getGoodInnerRing() {
        return goodInnerRing;
    }

    public void setGoodInnerRing(String goodInnerRing) {
        this.goodInnerRing = goodInnerRing == null ? null : goodInnerRing.trim();
    }

    public String getGoodDesc() {
        return goodDesc;
    }

    public void setGoodDesc(String goodDesc) {
        this.goodDesc = goodDesc == null ? null : goodDesc.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}