package com.zj.mybatisplus.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * (TAdmin)表实体类
 *
 * @author makejava
 * @since 2023-12-10 21:40:05
 */
@Data
@TableName(value = "t_admin")
public class TAdmin {

    private Integer id;

    private String username;

    private String password;

    private String name;

    private String sex;

    private Date birthday;

    private String power;

    private String jiguan;


}

