package com.zj.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ignite.cache.query.annotations.QuerySqlField;

/**
 * @Author: zj
 * @Date: 2023/3/1 23:31
 * @Version: 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    @QuerySqlField(index = true)
    private Integer id;

    @QuerySqlField(index = true)
    private String firstName;

    @QuerySqlField(index = true)
    private String phone;

}
