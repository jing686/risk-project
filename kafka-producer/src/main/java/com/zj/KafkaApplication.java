package com.zj;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @Author: zj
 * @Date: 2023/2/17 21:29
 * @Version: 1.0
 */
@SpringBootApplication
public class KafkaApplication {
    public static void main(String[] args) {
        SpringApplication.run(KafkaApplication.class, args);
    }

    /**
     * 创建一个名为testTopic的Topic并设置分区数为3，分区副本数为1
     * @return
     */
    @Bean
    public NewTopic initialTopic() {
        return new NewTopic("testTopic", 3, (short) 1);
    }

    @Bean
    public NewTopic eventTopic() {
        return new NewTopic("eventTopic", 3, (short) 1);
    }
}
