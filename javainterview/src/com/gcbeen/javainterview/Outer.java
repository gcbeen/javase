package com.gcbeen.javainterview;

import java.util.Stack;
import java.util.Vector;

public class Outer {

    static class StaticInner {
        public void methodA() {

        }
    }

    class Inner {

    }

}

class Test {
    public static void main(String[] args) {
        Outer.StaticInner staticInner = new Outer.StaticInner();
        System.out.println(staticInner);
        Outer outer = new Outer();
        Outer.Inner inner = outer.new Inner();
        System.out.println(outer);
        System.out.println(inner);
    }
}
