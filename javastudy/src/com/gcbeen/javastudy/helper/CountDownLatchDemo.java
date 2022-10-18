package com.gcbeen.javastudy.helper;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {
        // 总数是6
        int N = 6;
        CountDownLatch countDownLatch = new CountDownLatch(N);
        for (int i = 0; i < N; i++) {
            new Thread(() -> {
                System.out.println("NO: " + Thread.currentThread().getName() + " go out");
                countDownLatch.countDown();
            }, String.valueOf(i)).start();
        }
        // 等待计数器归零才会向下执行
        countDownLatch.await();
        System.out.println(countDownLatch.getCount());
    }

}
