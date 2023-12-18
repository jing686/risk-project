package com.zj.mybatisplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author: zj
 * @Date: 2023/12/10 21:35
 * @Version: 1.0
 */
@SpringBootApplication
@MapperScan("com.zj.mybatisplus.dao")
public class MybatisPlusDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(MybatisPlusDemoApplication.class, args);
    }

}
