package com.gcbeen.javainterview;

import java.util.concurrent.atomic.AtomicStampedReference;

public class AtomicStampReferenceDemo {

    static AtomicStampedReference<Integer> money = new AtomicStampedReference<Integer>(100, 0);

    static Integer money2 = Integer.valueOf(100);

    public static void main(String[] args) {
        // testAccount();
        testAtomicStampReference();
    }

    // 模拟：第一次取钱阻塞。再操作一次没阻塞，应该只有第二次取钱成功
    public static void testAtomicStampReference() {
        // 阻塞取钱
        new Thread(() -> {
            int stamp = money.getStamp();
            System.out.println("阻塞取钱 stamp的值是" + stamp);
            Integer account = money.getReference();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (money.compareAndSet(account, account - 100, stamp, stamp + 1)) {
                System.out.println("阻塞取钱 成功 目前余额：" + money.getReference() + "元");
            } else {
                System.out.println("阻塞取钱 失败 目前余额：" + money.getReference() + "元");
            }
        }).start();

        // 正常取钱
        new Thread(() -> {
            int stamp = money.getStamp();
            System.out.println("正常取钱 stamp的值是" + stamp);
            Integer account = money.getReference();
            if (money.compareAndSet(account, account - 100, stamp, stamp + 1)) {
                System.out.println("正常取钱 目前余额：" + money.getReference() + "元");
            }
        }).start();

        // 充值
        new Thread(() -> {
            int stamp = money.getStamp();
            System.out.println("充值 stamp的值是" + stamp);
            Integer account = money.getReference();
            if (money.compareAndSet(account, account + 100, stamp, stamp + 1)) {
                System.out.println("充值成功 目前余额：" + money.getReference() + "元");
            }
        }).start();

    }


    // 模拟：第一次取钱阻塞。再操作一次没阻塞，应该只有第二次取钱成功
    public static void testAccount() {
        // 阻塞取钱
        new Thread(() -> {
            int oldMoney = money2;
            int money3 =  oldMoney - 100;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (oldMoney == money2) {
                money2 = money3;
                System.out.println("阻塞取钱，目前余额：" + money2 + "元");
            }
        }).start();

        // 正常取钱
        new Thread(() -> {
            int oldMoney = money2;
            int money3 =  oldMoney - 100;
            if (oldMoney == money2) {
                money2 = money3;
                System.out.println("正常取钱，目前余额：" + money2 + "元");
            }
        }).start();

        // 充值
        new Thread(() -> {
            int oldMoney = money2;
            int money3 =  oldMoney + 100;
            if (oldMoney == money2) {
                money2 = money3;
                System.out.println("充值成功，目前余额：" + money2 + "元");
            }
        }).start();
    }

}

