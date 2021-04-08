package com.sifunit.lanwei.vo;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
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

    private Boolean isCompleted;

    private Integer level;

    private List<ProductDetail> products;
}
