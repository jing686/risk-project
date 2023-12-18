package com.zj.time;

/**
 * @Author: zj
 * @Date: 2023/5/28 16:11
 * @Version: 1.0
 */
public class StringTest {
    public static void main(String[] args) {
        String value = new String("123");
        String substring = value.substring(0);
        System.out.println(substring);
        String substring1 = value.substring(0, 2);
        System.out.println(substring1);

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("123");
        stringBuilder.insert(1, "test");
        String s = stringBuilder.toString();
        System.out.println(s);
    }

}
