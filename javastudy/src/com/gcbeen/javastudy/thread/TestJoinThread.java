package com.gcbeen.javastudy.thread;

import java.util.concurrent.TimeUnit;

public class TestJoinThread implements Runnable {

    public static void main(String[] args) throws InterruptedException{
        // 启动线程
        TestJoinThread joinThread = new TestJoinThread();
        Thread thread = new Thread(joinThread);
        thread.start();
        Thread.sleep(3000);
        // Thread
        TimeUnit.SECONDS.sleep(3);

        // 主线程
        for (int i = 0; i < 500; i++) {
            if(i==200){
                // 插队，main 线程阻塞
                thread.join();
            }
            System.out.println("main" + i);
        }
    }

    @Override
    public void run() {
        for (int i = 0; i < 500; i++) {
            System.out.println("线程VIP" + i);
        }
    }
}
