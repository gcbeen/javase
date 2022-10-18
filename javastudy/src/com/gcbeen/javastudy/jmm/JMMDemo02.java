package com.gcbeen.javastudy.jmm;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 不保证原子性
 * number <=2w
 */
public class JMMDemo02 {

    private static volatile AtomicInteger number = new AtomicInteger();
    // private static int number = 0;

    public static void add() {
        number.incrementAndGet();
        // number++;
        // ++ 不是一个原子性操作，是2~3个操作
    }

    public static void main(String[] args) {
        //理论上number  === 20000

        for (int i = 1; i <= 20; i++) {
            new Thread(() -> {
                for (int j = 1; j <= 1000; j++) {
                    add();
                }
            }).start();
        }

        while (Thread.activeCount() > 2) {
            //main  gc
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName() + ",num=" + number);
    }
}


