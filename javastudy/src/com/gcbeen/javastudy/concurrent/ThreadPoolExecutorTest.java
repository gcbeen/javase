package com.gcbeen.javastudy.concurrent;

import java.util.concurrent.*;

/**
 * new ThreadPoolExecutor.AbortPolicy() // 银行满了，还有人进来，不处理这个人的，抛出异常
 * new ThreadPoolExecutor.CallerRunsPolicy() // 哪来的去哪里！
 * new ThreadPoolExecutor.DiscardPolicy() //队列满了，丢掉任务，不会抛出异常！
 * new ThreadPoolExecutor.DiscardOldestPolicy() //队列满了，尝试去和最早的竞争，也不会抛出异常！
 */
public class ThreadPoolExecutorTest {

    public static void main(String[] args) {
        // 自定义线程池！工作 ThreadPoolExecutor
        ExecutorService threadPool = new ThreadPoolExecutor(2,
                5,
                3, TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()//银行人满了，还有人进来，不处理这个人，抛出异常
        );

        try {
            // 最大承载：Deque + max
            // 超过 抛出异常： RejectedExecutionException
            for (int i = 1; i <= 80; i++) {
                // 使用了线程池之后，使用线程池来创建线程
                Runnable runnable = () -> {
                    System.out.println(Thread.currentThread().getName() + "  OK");
                };
                threadPool.execute(runnable);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 线程池用完，程序结束，关闭线程池
            threadPool.shutdown();
        }
    }

}
