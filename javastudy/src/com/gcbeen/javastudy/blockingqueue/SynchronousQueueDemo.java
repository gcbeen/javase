package com.gcbeen.javastudy.blockingqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class SynchronousQueueDemo {

    public static void main(String[] args) {
        BlockingQueue<String> synchronousQueue = new SynchronousQueue<>();
        // 网queue中添加元素
        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + " put 01");
                synchronousQueue.put("1");
                System.out.println(Thread.currentThread().getName() + " put 02");
                synchronousQueue.put("2");
                System.out.println(Thread.currentThread().getName() + " put 03");
                synchronousQueue.put("3");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        // 取出元素
        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + " take " + synchronousQueue.take());
                System.out.println(Thread.currentThread().getName() + " take " + synchronousQueue.take());
                System.out.println(Thread.currentThread().getName() + " take " + synchronousQueue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

}
