package com.zj.kafka.producer;

import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

/**
 * @Author: zj
 * @Date: 2023/7/4 21:46
 * @Version: 1.0
 */
public class CustomProducerCallbackPartitions {
    public static void main(String[] args) throws InterruptedException {
        // 0、配置
        Properties properties = new Properties();
        // 连接集群
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.91.128:9092,192.168.91.128:9093,192.168.91.128:9094");
        // 指定对应的key和value的序列化类型
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        // 关联自定义分区器
        properties.put(ProducerConfig.PARTITIONER_CLASS_CONFIG, MyPartitioner.class.getName());

        // 1、创建kafka生产者对象
        KafkaProducer<String, String> producer = new KafkaProducer<>(properties);
        // 2、发送数据
        for (int i = 0; i < 10; i++) {
            ProducerRecord<String, String> record = new ProducerRecord<String, String>("first", "myTest" + i);
            producer.send(record, new Callback() {
                @Override
                public void onCompletion(RecordMetadata recordMetadata, Exception e) {
                    if (e == null) {
                        System.out.println("主题：" + recordMetadata.topic() + "分区：" + recordMetadata.partition());
                    }
                }
            });
//            TimeUnit.SECONDS.sleep(2);
        }
        // 3、关闭资源
        producer.close();
    }
}
