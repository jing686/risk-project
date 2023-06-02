package com.zj.dao.master;

import com.zj.entity.Admin;

import java.util.List;

public interface AdminDao {

    /**
     * 查询所有
     * @return
     */
    List<Admin> selectAll();
}

