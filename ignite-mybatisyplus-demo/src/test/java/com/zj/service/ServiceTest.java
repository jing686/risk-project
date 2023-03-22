package com.zj.service;

import com.zj.dao.StudentDao;
import com.zj.entity.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Author: zj
 * @Date: 2023/3/16 21:17
 * @Version: 1.0
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ServiceTest {

    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentDao studentDao;

    @Test
    public void test1() {
        List<Student> list = studentService.list();
        System.out.println(list);
    }

    @Test
    public void test2() {
        Student studentsById = studentDao.findStudentsById("1");
        System.out.println(studentsById);
    }

}
