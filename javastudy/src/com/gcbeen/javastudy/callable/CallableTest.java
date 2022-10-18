package com.gcbeen.javastudy.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException, ExecutionException {
        //new Thread(new Runnable()).start();
        //new Thread(new FutureTask<V>()).start();
        //new Thread(new FutureTask<V>( Callable )).start();

        //new Thread().start();// 怎么启动Callable
        System.out.println("xxx");
        MyThread thread = new MyThread();
        FutureTask futureTask = new FutureTask(thread);//适配类

        new Thread(futureTask, "A").start();
        new Thread(futureTask, "B").start();// 结果会被缓存，效率高，结果只打印一次

        //获取Callable的返回结果
        String o = (String)futureTask.get();//这个get 方法可能会产生阻塞！把他放到最后 或者使用异步通信来处理！

        System.out.println("返回结果：" + o);
    }
}

class MyThread implements Callable<String> {

    @Override
    public String call() throws Exception {
        System.out.println("Callable");
        // 耗时的操作
        return "hello";
    }

}
