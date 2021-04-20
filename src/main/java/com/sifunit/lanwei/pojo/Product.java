package com.sifunit.lanwei.pojo;

import lombok.Data;

import java.util.Date;

@Data
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

    private String productUnitName;

    private Boolean flag;

    private Date createTime;

    private Date updateTime;

}