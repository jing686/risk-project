package com.zj.stream;

/**
 * @Author: zj
 * @Date: 2023/2/18 22:39
 * @Version: 1.0
 */


import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest {
    public static void main(String[] args) {
        //Collection接口的stream()或parallelStream()方法；
        //list流
        Stream<String> listStream = Lists.newArrayList("11", "22", "33").stream();
        //map可以分别获取Entry、key、value的Stream流
        Stream<Map.Entry<Object, Object>> mapEntryStream = Maps.newHashMap().entrySet().stream();
        Stream<Object> mapKsyStream = Maps.newHashMap().keySet().stream();
        Stream<Object> stream = Maps.newHashMap().values().stream();

        //静态的Stream.of()、Stream.empty()方法；
        Stream<Object> ofStream = Stream.of();
        Stream<Object> emptyStream = Stream.empty();

        //Arrays.stream(array, from, to)；
        IntStream intArrayStream = Arrays.stream(new int[]{1, 2, 3});

        //静态的Stream.generate()方法生成无限流，接受一个不包含引元的函数；
        Stream<Integer> generateStream = Stream.generate(new Random()::nextInt);

        //静态的Stream.iterate()方法生成无限流，接受一个种子值(起始值)以及一个迭代函数（增长操作函数）；
        Stream<Integer> iterateStream = Stream.iterate(0, x -> x + 1).limit(4);

        //Pattern接口的splitAsStream(input)方法；
        Stream<String> patternStream = Pattern.compile("ll").splitAsStream("Hello");

        try {
            //静态的Files.lines(path)、Files.lines(path, charSet)方法；
            Stream<String> fileStream = Files.lines(Paths.get("d://"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        //静态的Stream.concat()方法将两个流连接起来。
        Stream<Integer> concatStream = Stream.concat(generateStream, iterateStream);
    }

    @Test
    public void streamTest() {
        //创建原始数据
        List<Employee> list = new ArrayList<>();
        Employee ceo = new Employee("张三", 56, "男", 50000.42D, "浙江杭州", "浙江杭州", "ceo", null);
        Employee manager1 = new Employee("李四", 47, "女", 20000.7D, "浙江宁波", "浙江宁波", "经理", ceo);
        Employee manager2 = new Employee("王五", 45, "男", 24000.5D, "浙江金华", "浙江金华", "经理", ceo);
        Employee employee1 = new Employee("麻六", 27, "女", 7000.6D, "浙江宁波", "广东广州", "售前", manager1);
        Employee employee2 = new Employee("孙七", 28, "男", 8000.8D, "浙江宁波", "广东深圳", "售后", manager1);
        Employee employee3 = new Employee("赵八", 27, "女", 9500.2D, "浙江杭州", "云南昆明", "售前", manager2);
        Employee employee4 = new Employee("钱九", 18, "男", 9000.0D, "浙江杭州", "云南玉溪", "售后", manager2);
        list.add(ceo);
        list.add(manager1);
        list.add(manager2);
        list.add(employee1);
        list.add(employee2);
        list.add(employee3);
        list.add(employee4);


        //查找名字为张三的员工信息，并打印出来
//        list.stream()
//                .filter(employee -> StringUtils.equals("张三", employee.getName()))
//                .forEach(employee -> System.out.println(employee.getName()));

        //收集公司里所有员工的名字，并打印出来
//        list.stream()
//                .map(employee -> employee.getName())
//                .forEach(name-> System.out.println(name));

        //公司加入一个新人，找出公司所有员工中年龄为18的并打印出来
//        List<Employee> newList = new ArrayList<>();
//        newList.add(new Employee("新人", 18, "女", 5000.7D, "浙江金华", "浙江金华", "售前", null));
//        Stream.of(list, newList)
//                .flatMap(employees -> employees.stream()
//                        .filter(employee -> employee.getAge() == 18))
//                .forEach(employee -> System.out.println(employee.getName()));

//        List<List<Integer>> lists = new ArrayList<>();
//        List<Integer> list1 = new ArrayList<>();
//        list1.add(4444);
//        list1.add(33333);
//        list1.add(444444);
//        lists.add(list1);
//        lists.stream().flatMap(Collection::stream).forEach(System.out::println);

        //获取第一个员工的数据并打印出来
//        list.stream().limit(1).forEach(employee -> System.out.println(employee.getName()));

        //为了去重在加一个ceo数据
//        list.add(ceo);
        //跳过前6条数据并打印名字出来
//        list.stream().distinct().forEach(employee -> System.out.println(employee.getName()));

        //按公司员工的薪资水平排序，并打印名字
//        list.stream()
//                .sorted((e1,e2) -> (int) (e2.getSalary() - e1.getSalary()))
//                .forEach(employee -> System.out.println(employee.getName() + "-->salary: " + employee.getSalary()));

        //打印公司员工的名字和职位
//        list.stream()
//                .peek(employee -> System.out.print(employee.getName() + ":"))
//                .forEach(employee -> System.out.println(employee.getPosition()));

        //把公司员工按照职位分组，collectGroup的key为position值，value为对象中position和key相同的集合
//        Map<String, List<Employee>> collectGroup = list.stream()
//                .collect(Collectors.groupingBy(employee -> employee.getPosition()));
//        System.out.println(JSON.toJSONString(collectGroup));

        //Collectors.counting()计算list的size，等价于list.stream().count()
//        Long collectCount = list.stream().collect(Collectors.counting());
//        //collectCount值为7
//        System.out.println(collectCount);

        //Collectors.toSet()转换成set，舍弃重复值
//        Set<Employee> collectSet = list.stream().collect(Collectors.toSet());
//        System.out.println(JSON.toJSONString(collectSet));

        //Collectors.toMap()根据传入的属性获取对应属性的key和value
//        Map<String, String> collectMap = list.stream()
//                .collect(Collectors.toMap(Employee::getName, Employee::getPosition));
//        System.out.println(JSON.toJSONString(collectMap));

        //Collectors.averagingDouble()计算list中属性为salary的平均值
//        Double collectDouble = list.stream().collect(Collectors.averagingDouble(Employee::getSalary));
//        //collectDouble=18214.745714285713
//        System.out.println(collectDouble);

        //Collectors.averagingInt()计算list中属性为age的平均值
        //averagingInt和averagingDouble差不多，不同的地方在于averagingInt在执行会把元素看成int，最后结果为Double，而averagingDouble在执行的时候会把元素看成Double，返回也是Double
//        Double collectInt = list.stream().collect(Collectors.averagingInt(Employee::getAge));
//        //collectInt=36.42857142857143
//        System.out.println(collectInt);

        //Collectors.mapping()相当于list.stream().map()，收集name属性
        //Collectors.joining()每次收集一次name都在后面加上,最后一次没有
        String collectMapping = list.stream().collect(Collectors.mapping(Employee::getName, Collectors.joining(",")));
        //collectMapping=张三,李四,王五,麻六,孙七,赵八,钱九
        System.out.println(collectMapping);

        //Collectors.maxBy()求最大值,相当于list.stream().max()
        Employee employeeMax = list.stream().collect(Collectors.maxBy((a, b) -> a.getAge() - b.getAge())).get();
        //employeeMax的age属性为56
        System.out.println(employeeMax.getAge());

        //Collectors.minBy()和Collectors.maxBy()类似，相当于list.stream().min()
        Employee employeeMin = list.stream().collect(Collectors.minBy((a, b) -> a.getAge() - b.getAge())).get();
        //employeeMin的age属性为25
        System.out.println(employeeMin.getAge());

        //Collectors.reducing()和list.stream().reduce()方法类似
//        Employee employeeReducing = list.stream().collect(Collectors.reducing((a, b) -> {
//            return a.getSalary() > b.getSalary() ? a : b;
//        })).get();
//        //employeeReducing的salary属性为50000.42
//        System.out.println(employeeReducing.getSalary());

        System.out.println("=====================");

        //findFirst查找list第一个元素,相当于list.get(0)
        Employee employeeFindFirst = list.stream().findFirst().get();
        System.out.println(employeeFindFirst);

        //findAny查找任意一个,如果有多个只会匹配第一个
        Employee employeeFindAny = list.stream().findAny().get();
        System.out.println(employeeFindAny);

        //anyMatch，只要有符合条件的就返回true,默认为false
        boolean anyMatch = list.stream().anyMatch(employee -> 27 == employee.getAge());
        //anyMatch=true
        System.out.println(anyMatch);

        //allMatch，必须都符合条件的才返回true，默认为true
        boolean allMatch = list.stream().allMatch(employee -> 27 == employee.getAge());
        //allMatch=false
        System.out.println(allMatch);

        //noneMatch，必须全部不匹配才返回true，默认为true
        boolean noneMatch = list.stream().noneMatch(employee -> 27 == employee.getAge());
        //noneMatch=false
        System.out.println(noneMatch);
        System.out.println("0-----------------------------------0");

        //reduce规约计算，入参n个值，返回1个值
        Double reduce = list.stream().map(Employee::getSalary).reduce((a, b) -> {
            return a + b;
        }).get();
        //reduce=127503.22
        System.out.println(reduce);

        //计算list的count，相当于list.size()
        long count = list.stream().count();
        //count=7
        System.out.println(count);

        //计算list中相关值的最大值
        Employee max = list.stream().max((a, b) -> a.getAge() - b.getAge()).get();
        //max的age属性为56
        System.out.println(max.getAge());

        //计算list中相关值的最小值
        Employee min = list.stream().min((a, b) -> a.getAge() - b.getAge()).get();
        //min的age属性为25
        System.out.println(min.getAge());

    }
}

