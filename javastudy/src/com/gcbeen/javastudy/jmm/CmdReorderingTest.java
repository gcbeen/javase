package com.gcbeen.javastudy.jmm;

// 指令重排序测试


import java.util.concurrent.*;

public class CmdReorderingTest {
    private static boolean stopFlag = false;
    private static int counter = 0;
    private static int x = 0;
    private static int y = 0;
    private static int a = 0;
    private static int b = 0;

    public static void main(String[] args) throws Exception {

        ForkJoinPool forkJoinPool = new ForkJoinPool();
            // 最大承载：Deque + max
            // 超过 抛出异常： RejectedExecutionException

            while (stopFlag != true) {
                x = 0;
                y = 0;
                a = 0;
                b = 0;
                ForkJoinTask<Integer> submit1 = forkJoinPool.submit(new RecursiveTask<Integer>() {
                    @Override
                    protected Integer compute() {
                        return null;
                    }
                });

                Integer aInt = submit1.get();
//            Thread thread1 = new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    x = a;
//                    b = 1;
//                }
//            });
//            Thread thread2 = new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    y = b;
//                    a = 2;
//                }
//            });
//            thread1.start();
//            thread2.start();
//            counter++;
//            thread1.join();
//            thread2.join();



                System.out.println("结果： x = " + x + ", y = " + y);
                if (x != 0 && y != 0) {
                    System.out.println("第 " + counter + " 组线程的修改之后 x = " + x + "且 y = " + y);
                    break;
                }
            }






        System.out.println("程序即将退出...");
    }
}

