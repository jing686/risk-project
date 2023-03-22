package com.zj.controller;

import com.zj.model.Person;
import com.zj.repository.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.cache.Cache;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zj
 * @Date: 2023/3/1 23:37
 * @Version: 1.0
 */
@RestController
@RequestMapping("/ignite")
@Slf4j
public class PersonController {

    @Resource
    private PersonRepository personRepository;

    @RequestMapping("/{name}")
    public List<Person> queryByName(@PathVariable("name") String name) {
        log.info("查询参数为：{}", name);
        List<Cache.Entry<Integer, Person>> entries = personRepository.findByFirstName(name);
        List<Person> personList = new ArrayList<>();
        for (Cache.Entry<Integer, Person> entry : entries) {
            Integer key = entry.getKey();
            Person value = entry.getValue();
            value.setId(key);
            personList.add(value);
        }
        return personList;
    }
}
