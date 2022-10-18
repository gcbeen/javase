package com.gcbeen.javastudy.thread;

public class TestLambda {

    public static void main(String[] args) {
        // 简化 创建接口对象
        ILike like = () -> {
            System.out.println("I like Lambda5");
        };
        like.like();
    }
}

// 1.定义一个函数式接口
interface ILike {
    void like();
}
