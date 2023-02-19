package com.zj.kafkatest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zj.KafkaApplication;
import com.zj.common.EventModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.concurrent.ListenableFuture;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author: zj
 * @Date: 2023/2/17 21:51
 * @Version: 1.0
 */
@SpringBootTest(classes = KafkaApplication.class)
@RunWith(SpringRunner.class)
public class KafkaProducerTest {
    @Autowired
    private KafkaTemplate kafkaTemplate;

    @Test
    public void myTest() {
        for (int i = 0; i < 10; i++) {
            ListenableFuture listenableFuture = kafkaTemplate.send("testTopic", i % 3, null, "这是一条boot 卡夫卡消息" + i);
/*            listenableFuture.addCallback(new ListenableFutureCallback() {
                @Override
                public void onFailure(Throwable ex) {
                    System.out.println("消息发送失败！");
                }

                @Override
                public void onSuccess(Object result) {
                    System.out.println("消息发送成功！");
                }
            });*/
        }
    }

    @Test
    public void sendEventTest() throws JsonProcessingException {
        for (int i = 0; i < 10; i++) {
            EventModel eventModel = new EventModel();
            eventModel.setEventId(i);
            eventModel.setMessage("这是一条测试消息" + i);
            eventModel.setPrice(new BigDecimal(i));
            eventModel.setStartTime(new Date(System.currentTimeMillis()));
            eventModel.setEndTime(new Date(System.currentTimeMillis()));
            ObjectMapper objectMapper = new ObjectMapper();
            String message = objectMapper.writeValueAsString(eventModel);
            kafkaTemplate.send("eventTopic", i % 3, null, message);
        }
    }
}
