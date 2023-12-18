package com.zj.mybatisplus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zj.mybatisplus.dao.TAdminDao;
import com.zj.mybatisplus.entity.TAdmin;
import com.zj.mybatisplus.service.TAdminService;
import org.springframework.stereotype.Service;

/**
 * (TAdmin)表服务实现类
 *
 * @author makejava
 * @since 2023-12-10 21:40:05
 */
@Service("tAdminService")
public class TAdminServiceImpl extends ServiceImpl<TAdminDao, TAdmin> implements TAdminService {

}

