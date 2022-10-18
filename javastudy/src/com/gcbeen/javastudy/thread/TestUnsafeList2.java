package com.gcbeen.javastudy.thread;

import java.util.ArrayList;
import java.util.List;

// 线程不安全的集合
public class TestUnsafeList2 {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                list.add(Thread.currentThread().getName());
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                list.add(Thread.currentThread().getName());
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                list.add(Thread.currentThread().getName());
            }
        }).start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(list.size());
    }

}

