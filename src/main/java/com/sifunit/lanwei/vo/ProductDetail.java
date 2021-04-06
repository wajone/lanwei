package com.sifunit.lanwei.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class ProductDetail {

    private long productId;

    private String productName;

    private String productSerial;

    private long productNum;

    private String productColor;

    private String productionDesc;
}
