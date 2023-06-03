package com.zj.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: zj
 * @Date: 2023/6/3 14:50
 * @Version: 1.0
 */
@RestController
@Slf4j
public class HttpTestController {

    @RequestMapping(value = "/test1", method = RequestMethod.GET)
    public String test1(String param) {
        log.info("test1接收参数 - {}", param);
        return param;
    }

    @RequestMapping(value = "/test2", method = RequestMethod.POST)
    public String test2(String param, @RequestBody RequestParam requestParam) {
        log.info("test12接收参数 - {}", param);
        log.info("test12接收参数 - {}", requestParam);
        return param;
    }
}
