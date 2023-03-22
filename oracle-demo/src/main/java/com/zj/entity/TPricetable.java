package com.zj.entity;


import lombok.Data;

import java.math.BigDecimal;

/**
 * (TPricetable)表实体类
 *
 * @author makejava
 * @since 2023-03-06 21:52:40
 */
@Data
public class TPricetable {

    private Long id;

    private BigDecimal price;

    private Long ownertypeid;

    private Long minnum;

    private Long maxnum;

}

