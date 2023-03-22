package com.zj.muiltithreading;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Predicate;

public class BiConsumer_addthen_Ex1 {
    public static void main(String[] args) {
        Map<String, Integer> contacts = new HashMap<>();

        Predicate<Integer> predicate = i -> i % 2 == 1;

        contacts.put("John", 123456);
        contacts.put("Bill", 12580);
        contacts.put("Lisa", 16979);

        BiConsumer<String, Integer> biConsumer1 =
                (name, phone) -> System.out.println("Name: " + name + " Number: " + phone);
        BiConsumer<String, Integer> biConsumer2 =
                (name, phone) -> System.out.println("Name: "+ name.toUpperCase() + " Number: " + phone);

        contacts.forEach(biConsumer1.andThen(biConsumer2));

    }
}
