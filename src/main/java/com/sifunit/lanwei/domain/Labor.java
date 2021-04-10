package com.sifunit.lanwei.domain;

import lombok.Data;

import java.util.Date;

@Data
public class Labor {
    private Long laborId;

    private Long empId;

    private String empName;

    private Long productionId;

    private Long productId;

    private String productName;

    private Long proceId;

    private String proceName;

    private Long submitNum;

    private String submitEmpName;

    private Date submitTime;

}