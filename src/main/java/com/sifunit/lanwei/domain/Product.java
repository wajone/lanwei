package com.sifunit.lanwei.domain;

import java.util.Date;

public class Product {
    private Long productId;

    private String productNo;

    private String imageUrl;

    private String productName;

    private String productSize;

    private String attachInfo;

    private Long productCateId;

    private String productCateName;

    private String productDesc;

    private Boolean flag;

    private Date createTime;

    private Date updateTime;

    public Product(Long productId, String productNo, String imageUrl, String productName, String productSize, String attachInfo, Long productCateId, String productCateName, String productDesc, Boolean flag, Date createTime, Date updateTime) {
        this.productId = productId;
        this.productNo = productNo;
        this.imageUrl = imageUrl;
        this.productName = productName;
        this.productSize = productSize;
        this.attachInfo = attachInfo;
        this.productCateId = productCateId;
        this.productCateName = productCateName;
        this.productDesc = productDesc;
        this.flag = flag;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Product() {
        super();
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductNo() {
        return productNo;
    }

    public void setProductNo(String productNo) {
        this.productNo = productNo == null ? null : productNo.trim();
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl == null ? null : imageUrl.trim();
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public String getProductSize() {
        return productSize;
    }

    public void setProductSize(String productSize) {
        this.productSize = productSize == null ? null : productSize.trim();
    }

    public String getAttachInfo() {
        return attachInfo;
    }

    public void setAttachInfo(String attachInfo) {
        this.attachInfo = attachInfo == null ? null : attachInfo.trim();
    }

    public Long getProductCateId() {
        return productCateId;
    }

    public void setProductCateId(Long productCateId) {
        this.productCateId = productCateId;
    }

    public String getProductCateName() {
        return productCateName;
    }

    public void setProductCateName(String productCateName) {
        this.productCateName = productCateName == null ? null : productCateName.trim();
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc == null ? null : productDesc.trim();
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