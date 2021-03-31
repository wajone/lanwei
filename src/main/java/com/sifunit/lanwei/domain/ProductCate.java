package com.sifunit.lanwei.domain;

import java.util.Date;

public class ProductCate {
    private Long productCateId;

    private String productCateName;

    private Long parentCateId;

    private String productCateDesc;

    private Boolean flag;

    private Date createTime;

    private Date updateTime;

    public ProductCate(Long productCateId, String productCateName, Long parentCateId, String productCateDesc, Boolean flag, Date createTime, Date updateTime) {
        this.productCateId = productCateId;
        this.productCateName = productCateName;
        this.parentCateId = parentCateId;
        this.productCateDesc = productCateDesc;
        this.flag = flag;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public ProductCate() {
        super();
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

    public Long getParentCateId() {
        return parentCateId;
    }

    public void setParentCateId(Long parentCateId) {
        this.parentCateId = parentCateId;
    }

    public String getProductCateDesc() {
        return productCateDesc;
    }

    public void setProductCateDesc(String productCateDesc) {
        this.productCateDesc = productCateDesc == null ? null : productCateDesc.trim();
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