package com.zj.model;


import com.zj.common.BasePage;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 分类
 */
@Data
public class Category extends BasePage implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    //类型 1 菜品分类 2 套餐分类
    private Integer ttype;

    //分类名称
    private String name;

    //顺序
    private Integer sort;

    //创建时间
    private Timestamp createTime;

    //更新时间
    private Timestamp updateTime;

    //创建人
    private Long createUser;

    //修改人
    private Long updateUser;

}
