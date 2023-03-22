package com.zj.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zj.entity.Person;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Person)表数据库访问层
 *
 * @author makejava
 * @since 2023-03-16 21:13:17
 */
public interface PersonDao extends BaseMapper<Person> {

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Person> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Person> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Person> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Person> entities);

}

