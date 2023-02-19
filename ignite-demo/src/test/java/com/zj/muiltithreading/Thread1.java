package com.zj.muiltithreading;

/**
 * @Author: zj
 * @Date: 2023/2/18 23:42
 * @Version: 1.0
 */
public class Thread1 extends Thread{

    @Override
    public void run() {

        for (int i = 0; i < 50; i++) {
            System.out.println(Thread.currentThread().getName() + "执行" + i);
        }
    }
}

