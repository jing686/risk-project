package com.zj.kafka.producer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;
import java.util.concurrent.ExecutionException;

/**
 * 同步发送
 * @Author: zj
 * @Date: 2023/7/4 21:46
 * @Version: 1.0
 */
public class CustomProducerSync {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 0、配置
        Properties properties = new Properties();
        // 连接集群
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.91.128:9092,192.168.91.128:9093,192.168.91.128:9094");
        // 指定对应的key和value的序列化类型
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        // 1、创建kafka生产者对象
        KafkaProducer<String, String> producer = new KafkaProducer<>(properties);
        // 2、发送数据
        for (int i = 0; i < 10; i++) {
            ProducerRecord<String, String> record = new ProducerRecord<String, String>("first", "myTest" + i);
            // 同步发送
            producer.send(record).get();
        }
        // 3、关闭资源
        producer.close();
    }
}
