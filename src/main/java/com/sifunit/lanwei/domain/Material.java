package com.sifunit.lanwei.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Material {
    private Long materialId;

    private String materialNo;

    private String materialName;

    private Long materialCateId;

    private String materialCateName;

    private Long materialUnitId;

    private String materialUnitName;

    private String materialDesc;

    private String materialSize;

    private Boolean flag;

    private Date createTime;

    private Date updateTime;


}