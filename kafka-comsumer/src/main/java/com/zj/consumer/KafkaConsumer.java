package com.zj.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

/**
 * @Author: zj
 * @Date: 2023/2/17 23:08
 * @Version: 1.0
 */
@Component
public class KafkaConsumer {

    @KafkaListener(topics = "testTopic")
    public void messageListener(ConsumerRecord<?, ?> record, Acknowledgment acknowledgment) {
        // 消费的哪个topic、partition的消息,打印出消息内容
        System.out.println("简单消费："+record.topic()+"-"+record.partition()+"-"+record.value());

        // 手动确认
        acknowledgment.acknowledge();
    }
}
