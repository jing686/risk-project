package com.zj.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zj.dao.TAreaDao;
import com.zj.entity.TArea;
import com.zj.service.TAreaService;
import org.springframework.stereotype.Service;

/**
 * (TArea)表服务实现类
 *
 * @author makejava
 * @since 2023-03-06 21:52:39
 */
@Service("tAreaService")
public class TAreaServiceImpl extends ServiceImpl<TAreaDao, TArea> implements TAreaService {

}

