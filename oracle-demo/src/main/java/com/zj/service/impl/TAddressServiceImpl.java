package com.zj.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zj.dao.TAddressDao;
import com.zj.entity.TAddress;
import com.zj.service.TAddressService;
import org.springframework.stereotype.Service;

/**
 * (TAddress)表服务实现类
 *
 * @author makejava
 * @since 2023-03-06 21:52:39
 */
@Service("tAddressService")
public class TAddressServiceImpl extends ServiceImpl<TAddressDao, TAddress> implements TAddressService {

}

