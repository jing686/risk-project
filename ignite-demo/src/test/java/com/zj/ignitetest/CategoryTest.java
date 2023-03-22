package com.zj.ignitetest;

import com.zj.model.Category;
import com.zj.repository.CategoryRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.cache.Cache;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zj
 * @Date: 2023/3/5 21:47
 * @Version: 1.0
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class CategoryTest {
    @Resource
    private CategoryRepository categoryRepository;

    @Test
    public void selectAll() {
        List<Cache.Entry<Long, Category>> entries = categoryRepository.selectAll();
        List<Category> list = new ArrayList<>();
        for (Cache.Entry<Long, Category> entry : entries) {
            Category value = entry.getValue();
            value.setId(entry.getKey());
            list.add(value);
        }

        System.out.println(list);
    }
}
