package com.gcbeen.javastudy.thread;

public class TestLambda02 {

    public static void main(String[] args) {
        // 1.lambda
        ILove love = (int a) -> {
            System.out.println("木石前盟 -->" + a);
        };
        // 2.lambda简化1.0
        love = (a) -> {
            System.out.println("木石前盟 --> " + a);
        };
        // 3.lambda简化2.0
        love = a -> {
            System.out.println("木石前盟 --> " + a);
        };
        // 4.lambda简化4.0
        love = a -> System.out.println("木石前盟 --> " + a);

        love.love(100);
    }
}

// 1.定义一个函数式接口
interface ILove {
    void love(int a);
}
