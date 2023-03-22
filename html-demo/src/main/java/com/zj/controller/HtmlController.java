package com.zj.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: zj
 * @Date: 2023/3/13 22:31
 * @Version: 1.0
 */
@RestController
@RequestMapping("/test")

public class HtmlController {

    @RequestMapping("/page")
    public String page() {

        return "success";
    }
}
