package com.gcbeen.javastudy.collection;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;

public class ListTest {

    public static void main(String[] args) throws InterruptedException {

        // List<Object> arrayList = new ArrayList<>();

        /**
         * 解决方案
         * 1. List<String> arrayList = new Vector<>();
         * 2. List<String> arrayList = Collections.synchronizedList(new ArrayList<>());
         * 3. List<String> arrayList = new CopyOnWriteArrayList<>();
         */
        List<String> arrayList = new CopyOnWriteArrayList<>();
        List<String> list = new Vector<>();//Collections.synchronizedList(new ArrayList<>());
        for (int i = 1; i <= 10; i++) {
            new Thread(() -> {
                arrayList.add(UUID.randomUUID().toString().substring(0, 5));
                System.out.println(arrayList);
            }, String.valueOf(i)).start();
        }
        TimeUnit.SECONDS.sleep(10);
        System.out.println("最后结果：");
        System.out.println(arrayList);
    }

}
