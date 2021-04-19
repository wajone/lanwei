package com.sifunit.lanwei.domain;

public class ProductionContent {
    private Long id;

    private Long productionId;

    private Long productId;

    private String productSerial;

    private Long productNum;

    private String productColor;

    private Long productUnitId;

    private String productionDesc;

    public ProductionContent(Long id, Long productionId, Long productId, String productSerial, Long productNum, String productColor, Long productUnitId, String productionDesc) {
        this.id = id;
        this.productionId = productionId;
        this.productId = productId;
        this.productSerial = productSerial;
        this.productNum = productNum;
        this.productColor = productColor;
        this.productUnitId = productUnitId;
        this.productionDesc = productionDesc;
    }

    public ProductionContent() {
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

    public String getProductSerial() {
        return productSerial;
    }

    public void setProductSerial(String productSerial) {
        this.productSerial = productSerial == null ? null : productSerial.trim();
    }

    public Long getProductNum() {
        return productNum;
    }

    public void setProductNum(Long productNum) {
        this.productNum = productNum;
    }

    public String getProductColor() {
        return productColor;
    }

    public void setProductColor(String productColor) {
        this.productColor = productColor == null ? null : productColor.trim();
    }

    public Long getProductUnitId() {
        return productUnitId;
    }

    public void setProductUnitId(Long productUnitId) {
        this.productUnitId = productUnitId;
    }

    public String getProductionDesc() {
        return productionDesc;
    }

    public void setProductionDesc(String productionDesc) {
        this.productionDesc = productionDesc == null ? null : productionDesc.trim();
    }
}