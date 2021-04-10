package com.sifunit.lanwei.domain;

import lombok.Data;

import java.util.Date;

@Data
public class Material {
    private Long materialId;

    private String materialNo;

    private String materialName;

    private Long materialCateId;

    private String materialCateName;

    private String materialDesc;

    private String materialSize;

    private Boolean flag;

    private Date createTime;

    private Date updateTime;


}