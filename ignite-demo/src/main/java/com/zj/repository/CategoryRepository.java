package com.zj.repository;

import com.zj.model.Category;
import org.apache.ignite.springdata22.repository.IgniteRepository;
import org.apache.ignite.springdata22.repository.config.Query;
import org.apache.ignite.springdata22.repository.config.RepositoryConfig;

import javax.cache.Cache;
import java.util.List;

/**
 * @Author: zj
 * @Date: 2023/3/5 21:44
 * @Version: 1.0
 */
@RepositoryConfig(cacheName = "category")
public interface CategoryRepository extends IgniteRepository<Category, Long> {

    @Query("select * from category")
    List<Cache.Entry<Long, Category>> selectAll();
}
