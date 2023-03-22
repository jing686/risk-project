package com.zj.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: zj
 * @Date: 2023/3/5 21:55
 * @Version: 1.0
 */
@RestController
@RequestMapping("/category")
@Slf4j
public class CategoryController {

    @GetMapping("/page")
    public String queryByPage(int page, int pageSize) {
        log.debug("接收参数 - page:{} -- pageSize:{}", page, pageSize);
        return "相应成功！";
    }
}
