package com.gcbeen.javastudy.helper;

import java.util.concurrent.CountDownLatch;

public class Driver1 {

    public static void main(String[] args) throws InterruptedException {
        int N = 6;
        CountDownLatch startSignal = new CountDownLatch(1);
        CountDownLatch doneSignal = new CountDownLatch(N);

        for (int i = 0; i < N; ++i) {
            new Thread(new Worker(startSignal, doneSignal)).start();
        }

        System.out.println("startSignal.countDown 前");
        startSignal.countDown();
        System.out.println("startSignal.countDown 后");
        doneSignal.await();
        System.out.println("完成");
    }

}

class Worker implements Runnable {
    private final CountDownLatch startSignal;
    private final CountDownLatch doneSignal;

    Worker(CountDownLatch startSignal, CountDownLatch doneSignal) {
        this.startSignal = startSignal;
        this.doneSignal = doneSignal;
    }

    public void run() {
        try {
            startSignal.await();
            doWork();
            doneSignal.countDown();
        } catch (InterruptedException ex) {

        }
        // return;
    }

    void doWork() {
        System.out.println(" doWork...");
    }
}
