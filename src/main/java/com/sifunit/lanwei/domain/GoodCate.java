package com.sifunit.lanwei.domain;

import java.util.Date;

public class GoodCate {
    private Long goodCateId;

    private String goodCateName;

    private Long parentCateId;

    private String goodCateDesc;

    private Boolean flag;

    private Date createTime;

    private Date updateTiem;

    public GoodCate(Long goodCateId, String goodCateName, Long parentCateId, String goodCateDesc, Boolean flag, Date createTime, Date updateTiem) {
        this.goodCateId = goodCateId;
        this.goodCateName = goodCateName;
        this.parentCateId = parentCateId;
        this.goodCateDesc = goodCateDesc;
        this.flag = flag;
        this.createTime = createTime;
        this.updateTiem = updateTiem;
    }

    public GoodCate() {
        super();
    }

    public Long getGoodCateId() {
        return goodCateId;
    }

    public void setGoodCateId(Long goodCateId) {
        this.goodCateId = goodCateId;
    }

    public String getGoodCateName() {
        return goodCateName;
    }

    public void setGoodCateName(String goodCateName) {
        this.goodCateName = goodCateName == null ? null : goodCateName.trim();
    }

    public Long getParentCateId() {
        return parentCateId;
    }

    public void setParentCateId(Long parentCateId) {
        this.parentCateId = parentCateId;
    }

    public String getGoodCateDesc() {
        return goodCateDesc;
    }

    public void setGoodCateDesc(String goodCateDesc) {
        this.goodCateDesc = goodCateDesc == null ? null : goodCateDesc.trim();
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

    public Date getUpdateTiem() {
        return updateTiem;
    }

    public void setUpdateTiem(Date updateTiem) {
        this.updateTiem = updateTiem;
    }
}