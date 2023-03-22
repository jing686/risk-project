package com.zj.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zj.dao.TAccountDao;
import com.zj.entity.TAccount;
import com.zj.service.TAccountService;
import org.springframework.stereotype.Service;

/**
 * (TAccount)表服务实现类
 *
 * @author makejava
 * @since 2023-03-06 21:52:39
 */
@Service("tAccountService")
public class TAccountServiceImpl extends ServiceImpl<TAccountDao, TAccount> implements TAccountService {

}

