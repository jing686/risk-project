package com.zj.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: zj
 * @Date: 2023/3/10 20:59
 * @Version: 1.0
 */
@Configuration
@Data
public class UrlConfig {
    @Value("${zj.self.url}")
    private String url;
}
