package com.zj.muiltithreading;

import java.util.concurrent.Callable;

/**
 * @Author: zj
 * @Date: 2023/2/18 23:55
 * @Version: 1.0
 */
public class Thread5 implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 0; i < 50; i++) {
            sum++;
            System.out.println(Thread.currentThread().getName() + "执行" + i);
        }
        return sum;
    }
}
