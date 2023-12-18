package com.zj;

import com.zj.redis.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.Map;

/**
 * @Author: zj
 * @Date: 2023/7/27 22:07
 * @Version: 1.0
 */
@SpringBootTest
public class SpringDataTest {
    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Test
    public void test1() {
        ValueOperations valueOperations = redisTemplate.opsForValue();
        User user = new User();
        user.setAge(19);
        user.setName("zhangsan");
        valueOperations.set("name", "zhangsan");

        Object name = valueOperations.get("name");
        System.out.println("name = " + name);
    }

    @Test
    public void test2() {
        ValueOperations valueOperations = redisTemplate.opsForValue();
        User user = new User();
        user.setAge(19);
        user.setName("zhangsan");
        valueOperations.set("user", user);

        User result = (User) valueOperations.get("user");
        System.out.println("result = " + result);
    }

    @Test
    public void test3() {
        stringRedisTemplate.opsForValue().set("name", "lisi");
        String name = stringRedisTemplate.opsForValue().get("name");
        System.out.println("name = " + name);
    }

    @Test
    public void testHash() {
        HashOperations<String, Object, Object> stringObjectObjectHashOperations = stringRedisTemplate.opsForHash();
        stringObjectObjectHashOperations.put("user:100", "name", "zhangsan");
        stringObjectObjectHashOperations.put("user:100", "age", "18");

        Map<Object, Object> entries = stringObjectObjectHashOperations.entries("user:100");
        for (Map.Entry<Object, Object> objectObjectEntry : entries.entrySet()) {
            Object key = objectObjectEntry.getKey();
            Object value = objectObjectEntry.getValue();
            System.out.println("key = " + key);
            System.out.println("value = " + value);
        }
    }
}
