package com.gcbeen.javastudy.jmm;

import java.util.concurrent.TimeUnit;

public class JMMDemo01 {

    // 如果不加volatile 程序会死循环
    // 加了volatile是可以保证可见性的
    private volatile static Integer number = 0;
    // private static Integer number = 0;

    public static void main(String[] args) {
        //main线程
        //子线程1
        new Thread(() -> {
            // 死循环
            while (number == 0) {
            }
        }).start();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //子线程2
        new Thread(() -> {
            // 死循环
            while (number == 0) {
            }

        }).start();

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 结束死循环
        number = 1;
        System.out.println(number);
    }

}
