package com.gcbeen.javainterview;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.nio.BufferOverflowException;
import java.sql.SQLException;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;


class A {

}

public class InterViewCode {

    volatile static  boolean flag = false;

    static char c;

    public static void main(String[] args) throws FileNotFoundException, InterruptedException {

        List<Integer> integerList = new ArrayList<>();
        Set<Integer> integerSet = new HashSet<>();

        integerList.contains(Integer.valueOf(1));
        integerSet.contains(Integer.valueOf(1));

        String str;

        Vector vector;

        Stack stack;

        LinkedHashSet linkedHashSet;

        TreeSet treeSet;

        LinkedHashMap linkHashMap;

        RuntimeException rumtimeException;

        ArithmeticException arithmeticException;

        System.out.printf("%c", c);
        short s1 = 1;
        s1 = (short) (s1 + 1);
        short s2 = 1;
        s2 += 1;
        System.out.println(c == '\u0000');

        byte a = 127;
        byte b = 127;
        b += a;
        // b = a + b;
        System.out.println(Byte.MAX_VALUE);
        System.out.println(b);

//        int div = 1/0;
        ConcurrentHashMap concurrentHashMap;

//        new BufferOverflowException();

//        new FileInputStream("aaa.txt");

        Class  cls = Integer.class;
        Class cls2 = Integer.TYPE;
        Integer integer = Integer.valueOf(1);
        Class<A> aClass = A.class;
        // System.gc();
        // Runtime.getRuntime().gc();
        Runtime.getRuntime().freeMemory();
        Runtime.getRuntime().totalMemory();

        integer.getClass();

        Runnable t1 = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    long time = System.currentTimeMillis();
                    try {
                        Thread.sleep(3000);
                        Thread.currentThread().interrupt();
                    } catch (InterruptedException e) {
                        // break;
                    }
                    System.out.println("============================");
                    System.out.println(Thread.currentThread().isInterrupted());
                    long diff = System.currentTimeMillis() - time;
                    if (diff < 3000) {
                        System.out.println("diff" + diff);
                        break;
                    }

                }
            }
        };

        Thread thread = new Thread(t1);
        thread.start();
        thread.join();
        System.out.println("join 后");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // thread.interrupt();

        // integer.notifyAll();
        // integer.wait();
        System.out.println(Thread.interrupted());

        System.out.println(thread.isInterrupted());
         Thread.yield();

         // thread.stop();

        ReentrantLock reentrantLock = new ReentrantLock();
        try {
            reentrantLock.lockInterruptibly();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }

        ReadWriteLock readWriteLock = new ReentrantReadWriteLock();


        //Callable


        // AtomicInteger atomicInteger = new AtomicInteger(1);
        // atomicInteger.incrementAndGet();

        // DelayQueue<Integer> delayQueue;
        SynchronousQueue synchronousQueue;
        // throw new FileNotFoundException();

    }

}
