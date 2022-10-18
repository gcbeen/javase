package com.gcbeen.javastudy.thread;

import java.util.concurrent.CopyOnWriteArrayList;

// 测试JUC安全类型的集合
public class TestThreadJuc {

    public static void main(String[] args) {


        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        for (int k = 0; k < 3; k++) {
            new Thread(() -> {
                for (int i = 0; i < 10000; i++) {
                    list.add(Thread.currentThread().getName());
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
