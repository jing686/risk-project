package com.zj.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zj.dao.PersonDao;
import com.zj.entity.Person;
import com.zj.service.PersonService;
import org.springframework.stereotype.Service;

/**
 * (Person)表服务实现类
 *
 * @author makejava
 * @since 2023-03-16 21:13:17
 */
@Service
public class PersonServiceImpl extends ServiceImpl<PersonDao, Person> implements PersonService {

}

