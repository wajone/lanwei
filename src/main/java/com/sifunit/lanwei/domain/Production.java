package com.sifunit.lanwei.domain;

import lombok.Data;

import java.util.Date;

@Data
public class Production {
    private Long productionId;

    private String productionNo;

    private String contactNo;

    private String exportNo;

    private Long customerId;

    private Date createTime;

    private Date advanceTime;

    private Date realTime;

    private Boolean isCompleted;

}