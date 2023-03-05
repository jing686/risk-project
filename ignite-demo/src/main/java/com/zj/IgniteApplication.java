package com.zj;

import org.apache.ignite.springdata22.repository.config.EnableIgniteRepositories;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author: zj
 * @Date: 2023/3/1 23:32
 * @Version: 1.0
 */
@SpringBootApplication
@EnableIgniteRepositories
public class IgniteApplication {
    public static void main(String[] args) {
        SpringApplication.run(IgniteApplication.class, args);
    }
}
