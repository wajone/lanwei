package com.sifunit.lanwei.domain;

import java.util.Date;

public class Customer {
    private Long customerId;

    private String customerName;

    private String personName;

    private String personTel;

    private String area;

    private String email;

    private String zipCode;

    private String customerDesc;

    private Date createTime;

    private Date updateTime;

    public Customer(Long customerId, String customerName, String personName, String personTel, String area, String email, String zipCode, String customerDesc, Date createTime, Date updateTime) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.personName = personName;
        this.personTel = personTel;
        this.area = area;
        this.email = email;
        this.zipCode = zipCode;
        this.customerDesc = customerDesc;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Customer() {
        super();
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName == null ? null : customerName.trim();
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName == null ? null : personName.trim();
    }

    public String getPersonTel() {
        return personTel;
    }

    public void setPersonTel(String personTel) {
        this.personTel = personTel == null ? null : personTel.trim();
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode == null ? null : zipCode.trim();
    }

    public String getCustomerDesc() {
        return customerDesc;
    }

    public void setCustomerDesc(String customerDesc) {
        this.customerDesc = customerDesc == null ? null : customerDesc.trim();
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