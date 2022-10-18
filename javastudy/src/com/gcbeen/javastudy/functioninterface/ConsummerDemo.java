package com.gcbeen.javastudy.functioninterface;

import java.util.function.Consumer;

// Consumer 消费型接口: 只有输入，没有返回值
public class ConsummerDemo {

    public static void main(String[] args) {
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String str) {
                System.out.println(str);
            }
        };


        //只要是函数型接口，就可以用 lambda表达式简化
        Consumer<String> consumer1 = (str) -> {
            System.out.println(str);
        };
        consumer.accept("qwre");
    }


}
