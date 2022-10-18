package com.gcbeen.javastudy.reflection;

public class TestActiveReference {

    // 一、一定会发生类的初始化
    static {
        // 1. 当虚拟机启动时，先初始化 main方法 所在的类；
        System.out.println("main方法 所在类被加载！");
    }

    public static void main(String[] args) throws ClassNotFoundException {
        // 1.空方法体时
        // main方法 所在类被加载！

        // 2. new一个类的对象时
        // Son son = new Son();
        // 4. 使用 java.lang.reflect 包的方法对类进行反射调用
        // Class.forName("com.gcbeen.reflection.Son");
        /*
        2 和 4 的 输出结果
        main方法 所在类被加载！
        父类被加载
        子类被加载
         */

        // 3. 调用类的静态变量（除了fina常量）和静态方法时
        // System.out.println(Son.m);
        /*
        输出结果
        main方法 所在类被加载！
        父类被加载
        子类被加载
        300
         */


        // 二、不会发生类的初始化
        // 1. 当访问一个静态域时，只有真正声明这个域的类才会被初始化。如：当通过子类引用父类的静态变量，不会导致子类初始化；
        System.out.println(Son.fatherB);
        /*
        输出结果
        main方法 所在类被加载！
        父类被加载
        2
         */
        // 2. 通过数组定义类引用，不会触发此类的初始化
        // Son[] array = new Son[5];
        /*
        输出结果
        main方法 所在类被加载！
         */
        // 3. 引用常量不会触发此类的初始化（常量在链接阶段就存入调用类的常量池中了）
        // System.out.println(Son.a);
        /*
        输出结果
        main方法 所在类被加载！
        1
         */

    }
}

class Father {
    static int fatherB = 2;

    static {
        // 5. 当初始化一个类，如果其父类没有被初始化，则先会初始化它的父类
        System.out.println("父类被加载");
    }
}

class Son extends Father {
    static {
        System.out.println("子类被加载");
        m = 100;
    }

    static int m = 300;
    static final int a = 1;

}
