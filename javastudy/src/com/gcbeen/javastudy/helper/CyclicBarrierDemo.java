package com.gcbeen.javastudy.helper;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {

    public static void main(String[] args) {
        int N = 6;
        /**
         * 集齐7颗龙珠召唤神龙
         */
        // 召唤龙珠的线程
        CyclicBarrier cyclicBarrier = new CyclicBarrier(N, () -> {
            System.out.println("召唤神龙。。。");
        });


        for (int i = 1; i <= N; i++) {
            // lambda不能操作到 i
            int temp = i;
            new Thread(() -> {
                System.out.println("线程号: " + Thread.currentThread().getName() + " 收集第 " + temp + " 颗龙珠");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }, String.valueOf(i)).start();
        }

    }

}
