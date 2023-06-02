package com.zj.dao.slave;

import com.zj.entity.TAddress;
import java.util.List;


public interface TAddressDao {

    /**
     * 查询所有
     * @return
     */
    List<TAddress> selectAll();
}

