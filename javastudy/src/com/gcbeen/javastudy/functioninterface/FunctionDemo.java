package com.gcbeen.javastudy.functioninterface;

import java.util.function.Function;

// Function 函数型接口, 有一个输入参数，有一个输出,
// 只要是函数型接口，就可以用 lambda表达式简化
public class FunctionDemo {

    public static void main(String[] args) {
        // 工具类：输出输入的值
        Function function1 = new Function<String, String>() {
            @Override
            public String apply(String str) {
                return str;
            }
        };
        System.out.println(function1.apply("111"));

        // 只要是函数型接口，就可以用 lambda表达式简化
        Function function2 = (str) -> {
            return str;
        };

        System.out.println(function2.apply("123"));
    }

}
