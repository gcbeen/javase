package com.gcbeen.javastudy.helper;

import java.util.concurrent.*;

class Driver2 {

    public static void main(String[] args)  throws InterruptedException {
        int N = 6;
        CountDownLatch doneSignal = new CountDownLatch(N);
        for (int i = 0; i < N; i++) {
            new Thread(new WorkerRunnable(doneSignal, i)).start();
        }
        doneSignal.await();           // wait for all to finish
    }
}

class WorkerRunnable implements Runnable {
    private final CountDownLatch doneSignal;
    private final int i;
    WorkerRunnable(CountDownLatch doneSignal, int i) {
        this.doneSignal = doneSignal;
        this.i = i;
    }
    public void run() {
        doWork(i);
        doneSignal.countDown();
    }

    void doWork(int i) {
        System.out.println("doWork: " + i);
    }
}
