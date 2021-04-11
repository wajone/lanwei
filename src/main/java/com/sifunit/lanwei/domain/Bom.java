package com.sifunit.lanwei.domain;

import lombok.Data;

import java.util.Date;

@Data
public class Bom {
    private Long bomId;

    private Long productId;

    private Long materialId;

    private Long unitId;

    private Long materialNum;

    private String comment;

    private Date createTime;

    private Date updateTime;

}