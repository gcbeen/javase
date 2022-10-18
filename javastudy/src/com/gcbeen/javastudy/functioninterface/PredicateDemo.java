package com.gcbeen.javastudy.functioninterface;

import java.util.function.Predicate;

// 断定型接口：有一个输入参数，返回值只能是 布尔值！
public class PredicateDemo {

    public static void main(String[] args) {
        // 判断字符串是否为空
        Predicate<String> predicate = new Predicate<String>() {
            @Override
            public boolean test(String str) {
                return str.isEmpty();
            }
        };
        System.out.println(predicate.test(""));

        // 只要是函数型接口，就可以用 lambda表达式简化
        Predicate<String> predicate2 = (str) -> {
            return str.isEmpty();
        };

        System.out.println(predicate2.test("asddd"));
    }

}
