package com.zj.mybatisplus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zj.mybatisplus.dao.TStudentDao;
import com.zj.mybatisplus.entity.TStudent;
import com.zj.mybatisplus.service.TStudentService;
import org.springframework.stereotype.Service;

/**
 * (TStudent)表服务实现类
 *
 * @author makejava
 * @since 2023-12-10 21:40:05
 */
@Service("tStudentService")
public class TStudentServiceImpl extends ServiceImpl<TStudentDao, TStudent> implements TStudentService {

}

