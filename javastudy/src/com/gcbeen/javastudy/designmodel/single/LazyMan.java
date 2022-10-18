package com.gcbeen.javastudy.designmodel.single;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

// 懒汉式单例
// 道高一尺，魔高一丈！
public class LazyMan {

    //定义一个别人不知道的变量
    private static boolean hello = false;

    // 私有化构造器
    private LazyMan() {
        synchronized (LazyMan.class) {
            if (hello == false) {
                hello = true;
            } else {
                throw new RuntimeException("不要试图使用反射破坏异常");
            }
        }
        System.out.println(Thread.currentThread().getName() + "OK");
    }

    private volatile static LazyMan lazyMan;

//    public static LazyMan getInstance() {
//        if (lazyMan == null) {
//            lazyMan = new LazyMan();
//        }
//        return lazyMan;
//    }

    // 双重检测锁模式的 懒汉式单例 DCL懒汉式
    public static LazyMan getInstance() {
        if (lazyMan == null) {
            synchronized (LazyMan.class) {
                if (lazyMan == null) {
                    lazyMan = new LazyMan();// 不是一个原子性操作
                    /**
                     * 1. 分配内存空间
                     * 2、执行构造方法，初始化对象
                     * 3、把这个对象指向这个空间
                     * 执行顺序123,132都有可能
                     * A：123
                     * B：132
                     * B把这个对象指向这个空间，发现不为空执行return
                     * 但是此时在线程A中，lazyMan 还没有完成构造，
                     * lazyMan 要加 volatile，防止指令重排
                     */
                }
            }
        }
        return lazyMan;
    }


    // 多线程并发
    public static void main(String[] args) throws Exception {
        Constructor<LazyMan> declaredConstructor = LazyMan.class.getDeclaredConstructor(null);
        declaredConstructor.setAccessible(true);//无视私有
        LazyMan instance1 = declaredConstructor.newInstance();
        System.out.println(instance1);
        Field hello = LazyMan.class.getDeclaredField("hello");
        hello.setAccessible(true);
        hello.set(instance1, false);
        LazyMan instance2 = declaredConstructor.newInstance();
        System.out.println(instance2);
    }
}
