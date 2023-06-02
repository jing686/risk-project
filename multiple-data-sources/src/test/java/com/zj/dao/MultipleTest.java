package com.zj.dao;

import com.zj.dao.master.AdminDao;
import com.zj.dao.slave.TAddressDao;
import com.zj.entity.Admin;
import com.zj.entity.TAddress;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MultipleTest {
    @Autowired
    private AdminDao adminDao;
    @Autowired
    private TAddressDao tAddressDao;

    @Test
    public void test() {
        List<Admin> admins = adminDao.selectAll();
        System.out.println("mysql 数据 --> " + admins);

        List<TAddress> list = tAddressDao.selectAll();
        System.out.println("oracle 数据 --> " + list);
    }

}
