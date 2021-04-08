package com.sifunit.lanwei.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ProductDetail {

    private long productId;

    private String productName;

    private String productNo;

    private String productSerial;

    private long productNum;

    private String productColor;

    private String productionDesc;

    private String imageUrl;

    private String productSize;

    private String attachInfo;

    private Long productCateId;

    private String productCateName;

    private String productDesc;

    private List<ProceDetail> procedures;

}
