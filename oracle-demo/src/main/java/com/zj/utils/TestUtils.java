package com.zj.utils;

import com.zj.config.UrlConfig;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author: zj
 * @Date: 2023/3/10 21:00
 * @Version: 1.0
 */
@Slf4j
public class TestUtils {

    public static String url = ApplicationUtils.getBean(UrlConfig.class).getUrl();

    public static String getUrl() {
        UrlConfig bean = ApplicationUtils.getBean(UrlConfig.class);
        return bean.getUrl();
    }

    public static String getFiledUrl() {
        return url;
    }
}
