package com.gcbeen.javastudy.thread;

import java.util.ArrayList;
import java.util.List;

// 线程安全的集合 同步块
public class TestSafeList {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        for (int k = 0; k < 3; k++) {
            new Thread(() -> {
                for (int i = 0; i < 10000; i++) {
                    synchronized (list) {
                        list.add(Thread.currentThread().getName());
                    }
                }
            }).start();
        }

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(list.size());
    }

}
