package com.zj.service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingExample {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("Hello", "world", "hello", "java", "world", "java", "python");

        // 使用Collectors.groupingBy()方法对字符串进行分组统计
        Map<String, Long> wordCount = words.stream()
                .collect(Collectors.groupingBy(String::toLowerCase, Collectors.counting()));

        // 输出统计结果
        System.out.println(wordCount);
    }
}
