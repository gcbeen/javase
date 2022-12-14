package com.gcbeen.javastudy.concurrent;

import java.util.concurrent.atomic.AtomicInteger;

public class CasDemo2 {

    // CAS compareAndSet : 比较并交换！
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(2020);


        //平时写的SQL：乐观锁

        //期望 更新
        //public final boolean compareAndSet(int expect, int update)
        // 如果我期望的值达到了，那么就更新，否则，就不更新, CAS 是CPU的并发原语！
        // ============== 捣乱的线程 ==================
        System.out.println(atomicInteger.compareAndSet(2020, 2021));
        System.out.println(atomicInteger.get());
        System.out.println(atomicInteger.compareAndSet(2021, 2020));
        System.out.println(atomicInteger.get());

        // ============== 期望的线程 ==================
        System.out.println(atomicInteger.compareAndSet(2020, 77777));
        System.out.println(atomicInteger.get());
    }

}
