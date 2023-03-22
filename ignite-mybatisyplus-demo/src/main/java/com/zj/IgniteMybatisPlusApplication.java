package com.zj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author: zj
 * @Date: 2023/3/16 21:11
 * @Version: 1.0
 */
@SpringBootApplication
@MapperScan("com.zj.dao")
public class IgniteMybatisPlusApplication {
    public static void main(String[] args) {
        SpringApplication.run(IgniteMybatisPlusApplication.class, args);
    }
}
