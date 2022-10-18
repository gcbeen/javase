package com.gcbeen.javastudy.blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

public class BlockingQueueDemo {

    public static void main(String[] args) throws InterruptedException {
        // List, Set的父类 Collection
        // BlockQueue 不是新的东西继承自 Collection
        // 什么情况下会使用阻塞队列：多线程并发处理，线程池
        test4();

    }
    // 抛出异常
    public static void test1 () {
        // 队列的大小
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue<>(3);
        System.out.println(arrayBlockingQueue.add("a"));
        System.out.println(arrayBlockingQueue.add("b"));
        System.out.println(arrayBlockingQueue.add("c"));
        System.out.println(arrayBlockingQueue.element());//查看队首元素
        // java.lang.IllegalStateException
        // System.out.println(arrayBlockingQueue.add("d"));
        System.out.println("=============");
        // 队列移除顺序
        System.out.println(arrayBlockingQueue.remove());
        System.out.println(arrayBlockingQueue.remove());
        System.out.println(arrayBlockingQueue.remove());
        // java.util.NoSuchElementException
        // System.out.println(arrayBlockingQueue.remove());
    }

    // 不抛出异常
    public static void test2 () {
        // 队列的大小
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue<>(3);
        System.out.println(arrayBlockingQueue.offer("a"));
        System.out.println(arrayBlockingQueue.offer("b"));
        System.out.println(arrayBlockingQueue.offer("c"));
        // java.lang.IllegalStateException
        System.out.println(arrayBlockingQueue.offer("d"));
        System.out.println(arrayBlockingQueue.peek());
        System.out.println("=============");
        // 队列移除顺序
        System.out.println(arrayBlockingQueue.poll());
        System.out.println(arrayBlockingQueue.poll());
        System.out.println(arrayBlockingQueue.poll());
        System.out.println(arrayBlockingQueue.poll());

    }


    // 等待阻塞(一直阻塞)
    public static void test3 () throws InterruptedException {
        // 队列的大小
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue<>(3);
        arrayBlockingQueue.put("a");
        arrayBlockingQueue.put("b");
        arrayBlockingQueue.put("c");
        // 队列没有位置,一直阻塞
        // arrayBlockingQueue.put("d");
        System.out.println("=============");
        // 队列移除顺序
        System.out.println(arrayBlockingQueue.take());
        System.out.println(arrayBlockingQueue.take());
        System.out.println(arrayBlockingQueue.take());
        // 没有这个元素,一直阻塞
        // System.out.println(arrayBlockingQueue.take());
    }


    // 等待阻塞(等待超时)
    public static void test4 () throws InterruptedException {
        //队列的大小
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue<>(3);
        System.out.println(arrayBlockingQueue.offer("a"));
        System.out.println(arrayBlockingQueue.offer("b"));
        System.out.println(arrayBlockingQueue.offer("c"));
        // 等待超过两秒退出
        arrayBlockingQueue.offer("d", 2, TimeUnit.SECONDS);
        System.out.println(arrayBlockingQueue.poll());
        System.out.println(arrayBlockingQueue.poll());
        // 等待超过两秒九退出
        System.out.println(arrayBlockingQueue.poll(2, TimeUnit.SECONDS));
    }

    }

