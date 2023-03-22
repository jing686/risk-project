package com.zj.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zj.dao.TPricetableDao;
import com.zj.entity.TPricetable;
import com.zj.service.TPricetableService;
import org.springframework.stereotype.Service;

/**
 * (TPricetable)表服务实现类
 *
 * @author makejava
 * @since 2023-03-06 21:52:40
 */
@Service("tPricetableService")
public class TPricetableServiceImpl extends ServiceImpl<TPricetableDao, TPricetable> implements TPricetableService {

}

