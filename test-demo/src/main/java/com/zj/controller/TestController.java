package com.zj.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: zj
 * @Date: 2023/4/30 15:20
 * @Version: 1.0
 */
@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {

    @RequestMapping("/login")
    public String login(String username, String password) {
        log.info("username: {}, password:{}", username, password);
        return "success";
    }
}
