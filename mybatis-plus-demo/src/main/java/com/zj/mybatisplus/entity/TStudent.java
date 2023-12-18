package com.zj.mybatisplus.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * (TStudent)表实体类
 *
 * @author makejava
 * @since 2023-12-10 21:40:05
 */
@Data
@TableName(value = "t_student")
public class TStudent {

    private Integer id;

    private Integer stno;

    private String name;

    private String sex;

    private Integer age;

}

