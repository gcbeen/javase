package com.gcbeen.javastudy.method;

public class HomeWork01 {

    private static int x = 10;

    public static void updataeValue(int value){
        value = 3 * value;
        System.out.println("value的值:" + value);
    }

    public static void main(String[] args) {
        System.out.println("调用前的值:" + x);
        updataeValue(x);
        System.out.println("调用后的值:" + x);
    }

}
