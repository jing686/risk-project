package com.zj.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ListProcessor {

    public static void main(String[] args) throws InterruptedException {
        // 初始化数据
        List<Integer> list1 = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            list1.add(i);
        }
        List<Integer> list2 = new ArrayList<>();
        for (int i = 11; i <= 20; i++) {
            list2.add(i);
        }
        List<Integer> list3 = new ArrayList<>();
        for (int i = 21; i <= 30; i++) {
            list3.add(i);
        }

        // 创建一个ExecutorService
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // 异步处理每个List集合并返回处理结果的CompletionStage
        CompletionStage<List<Integer>> stage1 = CompletableFuture.supplyAsync(() -> {
            List<Integer> result = new ArrayList<>();
            for (int i : list1) {
                result.add(i * 2);
            }
            return result;
        }, executor);

        CompletionStage<List<Integer>> stage2 = CompletableFuture.supplyAsync(() -> {
            List<Integer> result = new ArrayList<>();
            for (int i : list2) {
                result.add(i * 3);
            }
            return result;
        }, executor);

        CompletionStage<List<Integer>> stage3 = CompletableFuture.supplyAsync(() -> {
            List<Integer> result = new ArrayList<>();
            for (int i : list3) {
                result.add(i * 4);
            }
            return result;
        }, executor);

        // 合并所有CompletionStage的处理结果
        CompletionStage<List<Integer>> allStages = stage1.thenCombine(stage2, (list1Result, list2Result) -> {
            List<Integer> resultList = new ArrayList<>();
            resultList.addAll(list1Result);
            resultList.addAll(list2Result);
            return resultList;
        }).thenCombine(stage3, (resultList, list3Result) -> {
            resultList.addAll(list3Result);
            return resultList;
        });

        // 等待所有任务完成并汇总结果
        List<Integer> resultList = allStages.toCompletableFuture().join();

        // 输出结果
        System.out.println(resultList);

        // 关闭ExecutorService 111 adfas adf adfadsf
        executor.shutdown();
    }
}
