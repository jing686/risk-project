package com.zj.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zj.dao.TOperatorDao;
import com.zj.entity.TOperator;
import com.zj.service.TOperatorService;
import org.springframework.stereotype.Service;

/**
 * (TOperator)表服务实现类
 *
 * @author makejava
 * @since 2023-03-06 21:52:39
 */
@Service("tOperatorService")
public class TOperatorServiceImpl extends ServiceImpl<TOperatorDao, TOperator> implements TOperatorService {

}

