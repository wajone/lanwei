package com.sifunit.lanwei.domain;

import java.util.Date;

public class Bom {
    private Long bomId;

    private Long productId;

    private Long materialId;

    private Long materialNum;

    private String maker;

    private String materialComment;

    private Date createTime;

    private Date updateTime;

    public Bom(Long bomId, Long productId, Long materialId, Long materialNum, String maker, String materialComment, Date createTime, Date updateTime) {
        this.bomId = bomId;
        this.productId = productId;
        this.materialId = materialId;
        this.materialNum = materialNum;
        this.maker = maker;
        this.materialComment = materialComment;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Bom() {
        super();
    }

    public Long getBomId() {
        return bomId;
    }

    public void setBomId(Long bomId) {
        this.bomId = bomId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getMaterialId() {
        return materialId;
    }

    public void setMaterialId(Long materialId) {
        this.materialId = materialId;
    }

    public Long getMaterialNum() {
        return materialNum;
    }

    public void setMaterialNum(Long materialNum) {
        this.materialNum = materialNum;
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker == null ? null : maker.trim();
    }

    public String getMaterialComment() {
        return materialComment;
    }

    public void setMaterialComment(String materialComment) {
        this.materialComment = materialComment == null ? null : materialComment.trim();
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