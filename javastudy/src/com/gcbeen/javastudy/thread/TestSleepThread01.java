package com.gcbeen.javastudy.thread;

// 模拟网络延迟:放大问题的发生性
public class TestSleepThread01 implements Runnable {
    // 票数
    private int ticketNums = 10;

    public static void main(String[] args) {
        TestSleepThread01 thread01 = new TestSleepThread01();
        new Thread(thread01, "张三").start();
        new Thread(thread01, "李四").start();
        new Thread(thread01, "王五").start();
        new Thread(thread01, "赵六").start();

    }

    @Override
    public void run() {
        while (true) {
            if (ticketNums <= 0) {
                break;
            }
            // 捕获异常
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "---》拿到了第" + ticketNums + "张票");
            ticketNums--;
        }
    }
}
