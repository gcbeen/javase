package com.gcbeen.javastudy.asyncinvoke;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class SupplyAsyncTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // completableFuture.get(); // 获取阻塞执行结果
        // 有返回值的 supplyAsync 异步回调
        // ajax，成功和失败的回调
        // 失败返回的是错误信息；
        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "supplyAsync=>Integer");
//            int i = 10 / 0;
            return 1024;
        });

        System.out.println(completableFuture.whenComplete((t, u) -> {
            System.out.println("t=>" + t);// 正常的返回结果
            System.out.println("u=>" + u);// 错误信息：

        }).exceptionally((e) -> {
            System.out.println(e.getMessage());
            return 233;// 可以获取到错误的返回结果
        }).get());
    }

    // 工作中：
    // succee Code 200
    // error Code 404 500


}
