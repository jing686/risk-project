package com.zj.ignitetest;

import com.zj.model.Person;
import com.zj.repository.PersonRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.cache.Cache;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: zj
 * @Date: 2023/3/5 13:57
 * @Version: 1.0
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class IgniteTest {

    @Resource
    private PersonRepository personRepository;

    @Test
    public void save() {
//        personRepository.save(3, new Person(3, "王五", "15071371523"));
        personRepository.save(4, new Person(null, "赵六", "15071371523"));
    }

    @Test
    public void saveBatch() {
        Map<Integer, Person> map = new HashMap<>();
        for (int i = 0; i < 1000; i++) {
            map.put(i + personRepository.getMaxId(), new Person(null, "testname" + i, 1507137 + i + "1253"));
        }
        personRepository.save(map);
        System.out.println("数据插入成功！");
    }

    @Test
    public void queryByName() {
        List<Cache.Entry<Integer, Person>> entries = personRepository.findByFirstName("王五");
        List<Person> personList = new ArrayList<>();
        for (Cache.Entry<Integer, Person> entry : entries) {
            Integer key = entry.getKey();
            Person value = entry.getValue();
            value.setId(key);
            personList.add(value);
        }
        System.out.println(personList);
    }

    @Test
    public void queryMaxId() {
        Integer maxId = personRepository.getMaxId();
        System.out.println("maxId = " + maxId);
    }

    @Test
    public void queryWithPage() {
        PageRequest page = PageRequest.of(0, 10, Sort.by(Sort.Direction.DESC, "id"));
        List<Integer> integers = personRepository.selectId(4, page);
        System.out.println("integers = " + integers);

        List<Cache.Entry<Integer, Person>> entries = personRepository.selectAll(page);
        List<Person> list = new ArrayList<>();
        for (Cache.Entry<Integer, Person> entry : entries) {
            Integer key = entry.getKey();
            Person value = entry.getValue();
            value.setId(key);
            list.add(value);
        }
        System.out.println(list);
    }

    @Test
    public void queryByManyParams() {
        List<Cache.Entry<Integer, Person>> entries = personRepository.findByManyParams(4, "testname998");
        Cache.Entry<Integer, Person> integerPersonEntry = entries.get(0);
        Person person = integerPersonEntry.getValue();
        person.setId(integerPersonEntry.getKey());
        System.out.println(person);
    }

    @Test
    public void updateById() {
        personRepository.updateById(1, "张三三");
        System.out.println("数据更新成功！");
    }

    @Test
    public void deleteById() {
        personRepository.deleteById(1004);
        System.out.println("数据删除成功！");
    }
}
