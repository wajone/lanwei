package com.sifunit.lanwei.vo;

import com.sifunit.lanwei.domain.Product;

import java.util.Date;
import java.util.List;

public class ProductionDetail {

    private Long productionId;

    private String productionNo;

    private String contactNo;

    private String exportNo;

    private Long customerId;

    private String customerName;

    private Date createTime;

    private Date advanceTime;

    private Date realTime;

    private List<Product> products;

    public ProductionDetail(Long productionId, String productionNo, String contactNo, String exportNo, Long customerId, String customerName, Date createTime, Date advanceTime, Date realTime, List<Product> products) {
        this.productionId = productionId;
        this.productionNo = productionNo;
        this.contactNo = contactNo;
        this.exportNo = exportNo;
        this.customerId = customerId;
        this.customerName = customerName;
        this.createTime = createTime;
        this.advanceTime = advanceTime;
        this.realTime = realTime;
        this.products = products;
    }

    public ProductionDetail() {
        super();
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
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
        this.productionNo = productionNo;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getExportNo() {
        return exportNo;
    }

    public void setExportNo(String exportNo) {
        this.exportNo = exportNo;
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

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
