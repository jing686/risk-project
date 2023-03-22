package com.zj.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zj.dao.TOwnersDao;
import com.zj.entity.TOwners;
import com.zj.service.TOwnersService;
import org.springframework.stereotype.Service;

/**
 * (TOwners)表服务实现类
 *
 * @author makejava
 * @since 2023-03-06 21:52:39
 */
@Service("tOwnersService")
public class TOwnersServiceImpl extends ServiceImpl<TOwnersDao, TOwners> implements TOwnersService {

}

