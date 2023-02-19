package com.zj.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zj.common.EventModel;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

/**
 * @Author: zj
 * @Date: 2023/2/17 23:45
 * @Version: 1.0
 */
@Component
public class EventConsumer {

    @KafkaListener(topics = "eventTopic")
    public void eventListener(ConsumerRecord<?, ?> record, Acknowledgment acknowledgment) throws JsonProcessingException {
        // 消费的哪个topic、partition的消息,打印出消息内容
        System.out.println("简单消费：" + record.topic() + "-" + record.partition() + "-" + record.value());
        ObjectMapper mapper = new ObjectMapper();
        EventModel eventModel = mapper.readValue((String) record.value(), EventModel.class);
        System.out.println(eventModel.toString());
        // 手动确认
        acknowledgment.acknowledge();
    }
}
