package com.zj.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zj.dto.PageAddress;
import com.zj.dto.PageResult;
import com.zj.entity.TAddress;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (TAddress)表数据库访问层
 *
 * @author makejava
 * @since 2023-03-06 21:52:39
 */
public interface TAddressDao extends BaseMapper<TAddress> {

    /**
    * 批量新增数据（MyBatis原生foreach方法）
    *
    * @param entities List<TAddress> 实例对象列表
    * @return 影响行数
    */
    int insertBatch(@Param("entities") List<TAddress> entities);

    /**
    * 批量新增或按主键更新数据（MyBatis原生foreach方法）
    *
    * @param entities List<TAddress> 实例对象列表
    * @return 影响行数
    * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
    */
    int insertOrUpdateBatch(@Param("entities") List<TAddress> entities);

    /**
     * 分页查询
     * @param pageAddress
     * @return
     */
    PageResult queryPageInfo(PageAddress pageAddress);

}

