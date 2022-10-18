package com.gcbeen.javastudy.annotation;

import java.util.ArrayList;
import java.util.List;

public class Test03 {

    // Override 重写的注解
    @Override
    public String toString() {
        return super.toString();
    }

    // @Deprecated 不推荐使用,但可以使用,或者存在更好的更新方式
    @Deprecated
    public static void test() {
        System.out.println("Deprecated");
    }

    // @SuppressWarnings 镇压警告
    @SuppressWarnings("all")
    public void test01() {
        List<String> list = new ArrayList<>();
    }

    public static void main(String[] args) {
        test();
    }


}
