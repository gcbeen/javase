package com.gcbeen.javastudy.thread;

import java.util.ArrayList;
import java.util.List;

// 线程不安全的集合
public class TestUnsafeList  implements  Runnable{

    static List myList;

    @Override
    public void run() {
        System.out.println("开始调度线程");
        this.add();
    }

    private void add() {
        for (int i = 0; i < 150; i++) {
            this.myList.add(Thread.currentThread().getName() + i);
        }
    }

    public static void main(String[] args) {
        myList = new ArrayList<>();
        TestUnsafeList myThread = new TestUnsafeList();
        Thread thread1 = new Thread(myThread, "thread1");
        Thread thread2 = new Thread(myThread, "thread2");
        Thread thread3 = new Thread(myThread, "thread3");
        thread1.start();
        thread2.start();
        thread3.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(myList.size());
    }
}

