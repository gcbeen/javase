package com.gcbeen.javastudy.functioninterface;

import java.util.function.Supplier;

// Supplier 供给型接口 没有参数，只有返回值
public class SuppierDemo {

    public static void main(String[] args) {
        Supplier supplier = new Supplier<Integer>() {
            @Override
            public Integer get() {
                return 1024;
            }
        };

        System.out.println(supplier.get());
        //只要是函数型接口，就可以用 lambda表达式简化
        Supplier supplier2 = () -> {
            return 1024;
        };

        System.out.println(supplier2.get());
    }

}
