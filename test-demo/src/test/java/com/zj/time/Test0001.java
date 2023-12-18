package com.zj.time;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * @Author: zj
 * @Date: 2023/7/18 22:56
 * @Version: 1.0
 */
public class Test0001 {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        ArrayList<Integer> array = new ArrayList<>();
        array.add(1);
        Class<? extends ArrayList> aClass = array.getClass();
        Method add = aClass.getMethod("add", Object.class);
        add.invoke(array, "hello");
        add.invoke(array, "world");

        System.out.println(array);
    }
}
