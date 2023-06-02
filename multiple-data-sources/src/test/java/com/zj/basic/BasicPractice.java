package com.zj.basic;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: zj
 * @Date: 2023/4/19 22:30
 * @Version: 1.0
 */
public class BasicPractice {
    public static void main(String[] args) {
        Person p1 = new Person(1l, "jack");
        Person p2 = new Person(3l, "jack chou");
        Person p3 = new Person(2l, "tom");
        Person p4 = new Person(4l, "hanson");
        Person p5 = new Person(5l, "胶布虫");

//        List<Person> persons = Arrays.asList(p1, p2, p3, p4, p5, p5, p1, p2, p2);
//
//        List<Person> personList = new ArrayList<>();
//        // 去重
//        persons.stream().forEach(
//                p -> {
//                    if (!personList.contains(p)) {
//                        personList.add(p);
//                    }
//                }
//        );
//        System.out.println(personList);

        /*List<Person> persons = Arrays.asList(p1, p2, p3, p4, p5, p5, p1, p2, p2);

        ArrayList<Person> collect = persons.stream().collect(
                Collectors.collectingAndThen(
                        Collectors.toCollection(
                                () -> new TreeSet<>(Comparator.comparing(o -> o.getId() + o.getName()))
                        ), ArrayList::new
                )
        );
        System.out.println(collect);*/

        List<Person> persons = Arrays.asList(p1, p2, p3, p4, p5, p5, p1, p2, p2);

//        Collections.sort(persons, new Comparator<Person>() {
//            @Override
//            public int compare(Person o1, Person o2) {
//                return o1.getId().compareTo(o2.getId());
//            }
//        });
//        System.out.println(persons);

        List<Person> collect = persons.stream().sorted(Comparator.comparing(Person::getId)).collect(Collectors.toList());
        System.out.println(collect);
    }
}
