package com.zj.entity;


import lombok.Data;

import java.math.BigDecimal;
import java.sql.Date;

/**
 * (TAccount)表实体类
 *
 * @author makejava
 * @since 2023-03-06 21:52:39
 */
@Data
public class TAccount {

    private Long id;

    private Long owneruuid;

    private Long ownertype;

    private Long areaid;

    private String year;

    private String month;

    private Long num0;

    private Long num1;

    private Long usenum;

    private Long meteruser;

    private Date meterdate;

    private BigDecimal money;

    private String isfee;

    private Date feedate;

    private Long feeuser;

}

