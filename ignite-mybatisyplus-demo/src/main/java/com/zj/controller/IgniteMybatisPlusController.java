package com.zj.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: zj
 * @Date: 2023/3/16 21:14
 * @Version: 1.0
 */
@RestController
@RequestMapping("/ignite")
public class IgniteMybatisPlusController {

    @RequestMapping("/test")
    public String test() {
        return "success!";
    }
}
