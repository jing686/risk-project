package com.zj.mybatisplus.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zj.mybatisplus.entity.TAdmin;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (TAdmin)表数据库访问层
 *
 * @author makejava
 * @since 2023-12-10 21:40:05
 */
public interface TAdminDao extends BaseMapper<TAdmin> {

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<TAdmin> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<TAdmin> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<TAdmin> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<TAdmin> entities);

}

