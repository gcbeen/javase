package com.gcbeen.javastudy.oop;

public class Application {

    static void test(int a) throws MyException {
        System.out.println("参数 a 是：" + a);
        if (a > 10) {
            throw new MyException(a);
        }
        System.out.println("ok");
    }

    public static void main(String[] args) {
        try {
            test(12);
        } catch (MyException e) {
            e.printStackTrace();
            System.out.println("MyException > " + e);
        }

        new Work().walk();

        new UserServiceImp().add("gcbeen");

        Outer outer = new Outer();
        Outer.Inner inner = outer.new Inner();

        Outer.StaticInner staticInner = new Outer.StaticInner();
        staticInner.staticIn();

    }
}
