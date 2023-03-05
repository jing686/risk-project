package com.zj.muiltithreading;

import java.util.concurrent.locks.ReentrantLock;

public class LockDemoReentrantLock {
    private int i = 0;
    private ReentrantLock reentrantLock = new ReentrantLock();

    public void inCreate() {
        reentrantLock.lock();

        try {
            i++;
        } finally {
            reentrantLock.unlock();//注意：一般的释放锁的操作都放到finally中，
            // 多线程可能会出错而停止运行，如果不释放锁其他线程都不会拿到该锁
        }

    }


    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        lock.lock();
        LockDemoReentrantLock lockDemoReentrantLock = new LockDemoReentrantLock();
        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                lockDemoReentrantLock.inCreate();
            }).start();
        }


    }
}