package com.zj.controller;

import com.zj.common.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: zj
 * @Date: 2023/3/12 14:30
 * @Version: 1.0
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @GetMapping("/login")
    public R login(String username, String password) {
        log.info("username - {} - password - {}", username, password);
        return R.createSuccess();
    }
}
