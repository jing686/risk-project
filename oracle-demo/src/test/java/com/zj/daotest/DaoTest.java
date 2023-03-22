package com.zj.daotest;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zj.controller.TAccountController;
import com.zj.dao.TAddressDao;
import com.zj.dto.PageAddress;
import com.zj.dto.PageResult;
import com.zj.entity.TAccount;
import com.zj.entity.TAddress;
import com.zj.service.TAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zj adsf
 * @Date: 2023/3/6 22:26
 * @Version: 1.0 阿的说法
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class DaoTest {
    @Resource
    private TAccountService accountService;

    @Resource
    private TAccountController accountController;

    @Resource
    private TAddressDao addressDao;

    @Test
    public void test1() {
        List<TAccount> list = accountService.list();
        System.out.println(list);
    }

    @Test
    public void test2() {
        Page<TAccount> page = new Page<>(1, 10);
        Page<TAccount> pageresult = accountService.page(page);
        List<TAccount> records = pageresult.getRecords();
        for (TAccount record : records) {
            System.out.println(record);
        }
    }

    /**
     * todo 批量插入待修改 oracle的批量插入方式不一致
     */
    @Test
    public void test3() {
        List<TAddress> params = new ArrayList<>();
        params.add(new TAddress(null, "深圳市宝安区1", 10L, 10L));
        params.add(new TAddress(null, "深圳市宝安区2", 10L, 10L));
        params.add(new TAddress(null, "深圳市宝安区3", 10L, 10L));
        int result = addressDao.insertBatch(params);
    }

    @Test
    public void testPage() {
        List<TAccount> list = accountService.list();
        System.out.println(list);

        //使用分页插件
//        PageHelper.startPage(2, 3);
        PageHelper.startPage(2, 5, true);
        PageInfo<TAccount> infos = new PageInfo<TAccount>(list);

        List<TAccount> list1 = infos.getList();
        System.out.println(list1);

        int pages = infos.getPages();
        long total = infos.getTotal();
    }

    @Test
    public void testSelfPage() {
        PageAddress pageAddress = new PageAddress();
        pageAddress.setStart(1);
        pageAddress.setSize(5);
        pageAddress.setId(3L);
        PageResult pageResults = addressDao.queryPageInfo(pageAddress);

        String s = JSON.toJSONString(pageAddress);
        System.out.println(s);
        System.out.println(pageResults);
    }
}
