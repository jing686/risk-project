package com.zj.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * (TAddress)表实体类
 *
 * @author makejava
 * @since 2023-03-06 21:52:39
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TAddress {

    private Long id;

    private String name;

    private Long areaid;

    private Long operatorid;
}

