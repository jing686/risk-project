package com.zj.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zj.dao.StudentDao;
import com.zj.entity.Student;
import com.zj.service.StudentService;
import org.springframework.stereotype.Service;

/**
 * (Student)表服务实现类
 *
 * @author makejava
 * @since 2023-03-16 21:13:17
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentDao, Student> implements StudentService {

}

