package com.zj.entity;


import lombok.Data;

import java.sql.Date;

/**
 * (TOwners)表实体类
 *
 * @author makejava
 * @since 2023-03-06 21:52:39
 */
@Data
public class TOwners {

    private Long id;

    private Object name;

    private Long addressid;

    private Object housenumber;

    private Object watermeter;

    private Date adddate;

    private Long ownertypeid;

}

