package com.gcbeen.javastudy.oop;

public class Cat extends Pet {

    static {
        System.out.println("静态代码块");
    }

    {
        System.out.println("匿名代码块");
    }

    public Cat() {
        System.out.println("构造方法");
    }
}
