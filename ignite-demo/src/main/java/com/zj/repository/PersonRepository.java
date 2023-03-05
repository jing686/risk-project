package com.zj.repository;


import com.zj.model.Person;
import org.apache.ignite.springdata22.repository.IgniteRepository;
import org.apache.ignite.springdata22.repository.config.Query;
import org.apache.ignite.springdata22.repository.config.RepositoryConfig;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import javax.cache.Cache;
import java.util.List;

/**
 * @Author: zj
 * @Date: 2023/3/1 23:30
 * @Version: 1.0
 */
@RepositoryConfig(cacheName = "person")
public interface PersonRepository extends IgniteRepository<Person, Integer> {
    List<Cache.Entry<Integer, Person>> findByFirstName(String name);

    @Query("SELECT id FROM Person WHERE Id > ?")
    List<Integer> selectId(Integer Id, Pageable pageable);

    @Query("select * from person")
    List<Cache.Entry<Integer, Person>> selectAll(Pageable pageable);

    @Query("SELECT max(id) from person")
    Integer getMaxId();

    @Query(value = "select * from person where id > :Id and firstName = :firstName")
    List<Cache.Entry<Integer, Person>> findByManyParams(@Param("Id") Integer Id, @Param("firstName") String firstName);

    @Query("update person set firstName = :firstName where Id = :Id")
    void updateById(@Param("Id") Integer Id, @Param("firstName") String firstName);

    void deleteById(Integer Id);

}

