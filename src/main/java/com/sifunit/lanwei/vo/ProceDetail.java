package com.sifunit.lanwei.vo;

import lombok.Data;

@Data
public class ProceDetail {

    private Long proceId;

    private String proceNo;

    private String proceName;

    private String proceDesc;

    private Long completedNum;

    private Long goalNum;
}
