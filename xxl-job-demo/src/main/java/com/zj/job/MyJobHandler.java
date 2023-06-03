package com.zj.job;

import com.xxl.job.core.context.XxlJobHelper;
import com.xxl.job.core.handler.annotation.XxlJob;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @Author: zj
 * @Date: 2023/4/13 21:32
 * @Version: 1.0
 */
@Component
@Slf4j
public class MyJobHandler {

    @XxlJob("myJobHandler")
    public void myJobHandler() {
        String param = XxlJobHelper.getJobParam();
        log.info("param = {}", param);
        log.info("定时任务调用了！！！");
    }

    @XxlJob("myJobHandlerTest")
    public void myJobHandlerTest() {
        String param = XxlJobHelper.getJobParam();
        log.info("myJobHandlerTest param = {}", param);
        log.info(" myJobHandlerTest 定时任务调用了！！！");
    }
}
