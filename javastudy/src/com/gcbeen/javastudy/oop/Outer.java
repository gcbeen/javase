package com.gcbeen.javastudy.oop;

public class Outer {

    private int id = 10;
    public void out() {
        System.out.println("out 方法");
    }

    class Inner {
        public void in() {
            System.out.println("in 方法");
        }

        public void getId() {
            System.out.println(id);
        }


    }

    static class StaticInner {
        public void staticIn() {
            System.out.println("staticIn 方法");
        }
    }



}
