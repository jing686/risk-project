package com.zj.mybatisplus.controller;


import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zj.mybatisplus.entity.TAdmin;
import com.zj.mybatisplus.service.TAdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * (TAdmin)表控制层
 *
 * @author makejava
 * @since 2023-12-10 21:40:04
 */
@RestController
@RequestMapping("tAdmin")
@Slf4j
public class TAdminController {
    @Autowired
    private TAdminService adminService;

    @GetMapping("/test")
    public String test1() {
        BaseMapper<TAdmin> baseMapper = adminService.getBaseMapper();
        List<TAdmin> tAdmins = baseMapper.selectList(null);
        log.info("##tAdmins =>{}", tAdmins);
        return JSON.toJSONString(tAdmins);
    }

    @GetMapping("/insert")
    @Transactional
    public String insert(Integer id) {
        BaseMapper<TAdmin> baseMapper = adminService.getBaseMapper();
        TAdmin admin = new TAdmin();
        admin.setId(id);
        admin.setName("zhangsan_" + id);
        admin.setPassword("123_" + id);
        baseMapper.insert(admin);
        System.out.println(1/0);
        return "insert success!";
    }


}

