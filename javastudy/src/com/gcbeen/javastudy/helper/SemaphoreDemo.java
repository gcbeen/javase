package com.gcbeen.javastudy.helper;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreDemo {

    public static void main(String[] args) {
        // 线程数量：停车位! 用来限流！
        Semaphore semaphore = new Semaphore(3);
        for (int i = 1; i <= 6; i++) {
            new Thread(() -> {
                //acquire() 得到
                //release() 释放
                try {
                    semaphore.acquire();
                    System.out.println("NO: " + Thread.currentThread().getName() + "抢到车位！");
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                    System.out.println("-> NO: " + Thread.currentThread().getName() + "离开车位！");
                }
            }, String.valueOf(i)).start();
        }
    }


}
