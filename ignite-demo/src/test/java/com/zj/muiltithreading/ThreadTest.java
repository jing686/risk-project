package com.zj.muiltithreading;

import org.junit.Test;

import java.util.Random;
import java.util.concurrent.*;
import java.util.function.*;

/**
 * @Author: zj
 * @Date: 2023/2/18 23:42
 * @Version: 1.0
 */
public class ThreadTest {

    @Test
    public void startThread1() {
        new Thread1().start();
        for (int i = 0; i < 50; i++) {
            System.out.println(Thread.currentThread().getName() + "执行" + i);
        }
    }

    @Test
    public void startThread2() {
        new Thread(new Thread2()).start();
        for (int i = 0; i < 50; i++) {
            System.out.println(Thread.currentThread().getName() + "执行" + i);
        }
    }

    @Test
    public void startThread3() {
        new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                System.out.println(Thread.currentThread().getName() + "执行" + i);
            }
        }).start();
        for (int i = 0; i < 50; i++) {
            System.out.println(Thread.currentThread().getName() + "执行" + i);
        }
    }

    @Test
    public void startThread4() {
        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 50; i++) {
                    System.out.println(Thread.currentThread().getName() + "执行" + i);
                }
            }
        }.start();
        for (int i = 0; i < 50; i++) {
            System.out.println(Thread.currentThread().getName() + "执行" + i);
        }
    }

    @Test
    public void startThread5() throws ExecutionException, InterruptedException {
        Thread5 t1 = new Thread5();
        Thread5 t2 = new Thread5();
        Thread5 t3 = new Thread5();
        Thread5 t4 = new Thread5();

        //创建服务
        ExecutorService ser = Executors.newFixedThreadPool(3);

        //提交执行
        Future<Integer> r1 = ser.submit(t1);
        Future<Integer> r2 = ser.submit(t2);
        Future<Integer> r3 = ser.submit(t3);
        Future<Integer> r4 = ser.submit(t4);
        for (int j = 0; j < 1000; j++) {
            ser.submit(() -> {
                int sum = 0;
                for (int i = 0; i < 50; i++) {
                    sum++;
                    System.out.println(Thread.currentThread().getName() + "执行" + i);
                }
                return sum;
            });
        }

        //获取结果
        Integer result1 = r1.get();
        Integer result2 = r2.get();
        Integer result3 = r3.get();
        Integer result4 = r4.get();

        //结束服务 shutdownNow() 方法会返回阻塞队列中的任务list结果集
//        List<Runnable> runnables = ser.shutdownNow();
//        System.out.println("runnables = " + runnables);
        ser.shutdown();

        System.out.println("result1 = " + result1);
        System.out.println("result2 = " + result2);
        System.out.println("result3 = " + result3);
        System.out.println("result4 = " + result4);
    }

    @Test
    public void syncTest() throws ExecutionException, InterruptedException {
        Runnable runnable = () -> System.out.println("无返回结果异步任务");
        CompletableFuture.runAsync(runnable);

        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("有返回值的异步任务");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Hello World";
        });
        String result = future.get();
        System.out.println("result = " + result);
    }

    @Test
    public void completableFutureTest() throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
            }
            if (new Random().nextInt(10) % 2 == 0) {
                int i = 12 / 0;
            }
            System.out.println("执行结束！");
            return "test";
        });
        // 任务完成或异常方法完成时执行该方法
        // 如果出现了异常,任务结果为null
        future.whenComplete(new BiConsumer<String, Throwable>() {
            @Override
            public void accept(String t, Throwable action) {
                System.out.println(t + " 执行完成！");
            }
        });
        // 出现异常时先执行该方法
        future.exceptionally(new Function<Throwable, String>() {
            @Override
            public String apply(Throwable t) {
                System.out.println("执行失败：" + t.getMessage());
                return "异常xxxx";
            }
        });

        future.get();
    }

    /**
     * thenApply
     * thenApply接收一个函数作为参数，使用该函数处理上一个CompletableFuture调用的结果，并返回一个具有处理结果的Future对象。
     */
    @Test
    public void thenApplyTest() throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            int result = 100;
            System.out.println("第一次运算：" + result);
            return result;
        }).thenApply(number -> {
            int result = number * 3;
            System.out.println("第二次运算：" + result);
            return result;
        });
        Integer result = future.get();
        System.out.println("result = " + result);
    }

    /**
     * thenCompose
     * thenCompose的参数为一个返回CompletableFuture实例的函数，该函数的参数是先前计算步骤的结果。
     */
    @Test
    public void thenComposeTest() throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> future = CompletableFuture
                .supplyAsync(new Supplier<Integer>() {
                    @Override
                    public Integer get() {
                        int number = new Random().nextInt(30);
                        System.out.println("第一次运算：" + number);
                        return number;
                    }
                })
                .thenCompose(new Function<Integer, CompletionStage<Integer>>() {
                    @Override
                    public CompletionStage<Integer> apply(Integer param) {
                        return CompletableFuture.supplyAsync(new Supplier<Integer>() {
                            @Override
                            public Integer get() {
                                int number = param * 2;
                                System.out.println("第二次运算：" + number);
                                return number;
                            }
                        });
                    }
                });
        System.out.println(future.get());
    }

    /**
     * thenAccept
     * 观察该系列函数的参数类型可知，它们是函数式接口Consumer，这个接口只有输入，没有返回值。
     */
    @Test
    public void thenAcceptTest() throws ExecutionException, InterruptedException {
        CompletableFuture<Void> future = CompletableFuture
                .supplyAsync(() -> {
                    int number = new Random().nextInt(10);
                    System.out.println("第一次运算：" + number);
                    return number;
                }).thenAccept(number ->
                        System.out.println("第二次运算：" + number * 5));
        System.out.println(future.get());
    }

    /**
     * thenAcceptBoth
     * thenAcceptBoth函数的作用是，当两个CompletionStage都正常完成计算的时候，就会执行提供的action消费两个异步的结果。
     */
    @Test
    public void thenAcceptBothTest() throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> futrue1 = CompletableFuture.supplyAsync(new Supplier<Integer>() {
            @Override
            public Integer get() {
                int number = new Random().nextInt(3) + 1;
                try {
                    TimeUnit.SECONDS.sleep(number);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("任务1结果：" + number);
                return number;
            }
        });

        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(new Supplier<Integer>() {
            @Override
            public Integer get() {
                int number = new Random().nextInt(3) + 1;
                try {
                    TimeUnit.SECONDS.sleep(number);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("任务2结果：" + number);
                return number;
            }
        });

        futrue1.thenAcceptBoth(future2, new BiConsumer<Integer, Integer>() {
            @Override
            public void accept(Integer x, Integer y) {
                System.out.println("x = " + x);
                System.out.println("y = " + y);
                System.out.println("最终结果：" + (x + y));
            }
        });

        Integer result1 = futrue1.get();
        System.out.println("result1 = " + result1);
    }

    /**
     * thenRun
     * thenRun也是对线程任务结果的一种消费函数，与thenAccept不同的是，
     * thenRun会在上一阶段 CompletableFuture计算完成的时候执行一个Runnable，而Runnable并不使用该CompletableFuture计算的结果。
     */
    @Test
    public void thenRunTest() throws ExecutionException, InterruptedException {
        CompletableFuture<Void> future = CompletableFuture.supplyAsync(() -> {
            int number = new Random().nextInt(10);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
            }
            System.out.println("第一阶段：" + number);
            return number;
        }).thenRun(() ->
                System.out.println("thenRun 执行"));
        Void unused = future.get();
        System.out.println(unused);
    }

    /**
     * thenCombine
     * 合并两个线程任务的结果，并进一步处理。
     */
    @Test
    public void thenCombineTest() throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> future1 = CompletableFuture
                .supplyAsync(new Supplier<Integer>() {
                    @Override
                    public Integer get() {
                        int number = new Random().nextInt(10);
                        System.out.println("任务1结果：" + number);
                        return number;
                    }
                });
        CompletableFuture<Integer> future2 = CompletableFuture
                .supplyAsync(new Supplier<Integer>() {
                    @Override
                    public Integer get() {
                        int number = new Random().nextInt(10);
                        System.out.println("任务2结果：" + number);
                        return number;
                    }
                });

        CompletableFuture<Integer> result = future1
                .thenCombine(future2, new BiFunction<Integer, Integer, Integer>() {
                    @Override
                    public Integer apply(Integer x, Integer y) {
                        return x + y;
                    }
                });
        System.out.println("组合后结果：" + result.get());
    }

    /**
     * applyToEither
     * 两个线程任务相比较，先获得执行结果的，就对该结果进行下一步的转化操作。
     */
    @Test
    public void applyEitherTest() throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> future1 = CompletableFuture
                .supplyAsync(new Supplier<Integer>() {
                    @Override
                    public Integer get() {
                        int number = new Random().nextInt(10);
                        try {
                            TimeUnit.SECONDS.sleep(number);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("任务1结果:" + number);
                        return number;
                    }
                });
        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(new Supplier<Integer>() {
            @Override
            public Integer get() {
                int number = new Random().nextInt(10);
                try {
                    TimeUnit.SECONDS.sleep(number);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("任务2结果:" + number);
                return number;
            }
        });

        future1.applyToEither(future2, new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer number) {
                System.out.println("最快结果：" + number);
                return number * 2;
            }
        });

        future1.get();
        future2.get();
    }

    /**
     * acceptEither
     * 两个线程任务相比较，先获得执行结果的，就对该结果进行下一步的消费操作
     */
    @Test
    public void acceptEitherTest() throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(new Supplier<Integer>() {
            @Override
            public Integer get() {
                int number = new Random().nextInt(10) + 1;
                try {
                    TimeUnit.SECONDS.sleep(number);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("第一阶段：" + number);
                return number;
            }
        });

        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(new Supplier<Integer>() {
            @Override
            public Integer get() {
                int number = new Random().nextInt(10) + 1;
                try {
                    TimeUnit.SECONDS.sleep(number);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("第二阶段：" + number);
                return number;
            }
        });

        future1.acceptEither(future2, new Consumer<Integer>() {
            @Override
            public void accept(Integer number) {
                System.out.println("最快结果：" + number);
            }
        });

        future1.get();
        future2.get();
    }

    /**
     * runAfterEither
     * 两个线程任务相比较，有任何一个执行完成，就进行下一步操作，不关心运行结果。
     */
    @Test
    public void runAfterEitherTest() throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(new Supplier<Integer>() {
            @Override
            public Integer get() {
                int number = new Random().nextInt(5);
                try {
                    TimeUnit.SECONDS.sleep(number);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("任务1结果：" + number);
                return number;
            }
        });

        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(new Supplier<Integer>() {
            @Override
            public Integer get() {
                int number = new Random().nextInt(5);
                try {
                    TimeUnit.SECONDS.sleep(number);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("任务2结果:" + number);
                return number;
            }
        });

        future1.runAfterEither(future2, new Runnable() {
            @Override
            public void run() {
                System.out.println("已经有一个任务完成了");
            }
        }).join();
        future1.get();
        future2.get();
    }

    /**
     * anyOf
     * anyOf() 的参数是多个给定的 CompletableFuture，当其中的任何一个完成时，方法返回这个 CompletableFuture。
     */
    @Test
    public void anyOfTest() throws ExecutionException, InterruptedException {
        Random random = new Random();
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(random.nextInt(5));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "hello";
        });

        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(random.nextInt(1));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "world";
        });
        System.out.println("future1 = " + future1);
        System.out.println("future2 = " + future2);
        CompletableFuture<Object> result = CompletableFuture.anyOf(future1, future2);
        System.out.println("result.get() = " + result.get());
    }

    /**
     * allOf
     * allOf方法用来实现多 CompletableFuture 的同时返回。
     */
    @Test
    public void allOfTest() {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("future1完成！");
            return "future1完成！";
        });

        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("future2完成！");
            return "future2完成！";
        });

        CompletableFuture<Void> combindFuture = CompletableFuture.allOf(future1, future2);

        try {
            combindFuture.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
