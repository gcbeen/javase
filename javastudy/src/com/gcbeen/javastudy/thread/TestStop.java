package com.gcbeen.javastudy.thread;

public class TestStop implements Runnable {
    // 1. 线程运行当标识
    private boolean flag = true;

    @Override
    public void run() {
        int i = 0;
        while (flag) {
            System.out.println("run ... Thread " + i++);
        }
    }

    // 2.设置一个公开的方法停止线程，转换标识位
    public void stop() {
        this.flag = false;
    }

    public static void main(String[] args) {
        TestStop stop = new TestStop();
        new Thread(stop).start();
        for (int i = 0; i < 1000; i++) {
            System.out.println("main..." + i);
            if (i == 900) {
                // 调用stop()切换标识位,让线程终止
                stop.stop();
                System.out.println("线程该停止了");
            }
        }
    }


}