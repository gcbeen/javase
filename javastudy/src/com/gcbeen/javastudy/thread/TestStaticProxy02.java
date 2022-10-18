package com.gcbeen.javastudy.thread;

public class TestStaticProxy02 {

    public static void main(String[] args) {
        new Thread(() -> System.out.println("金石良缘、木石前盟")).start();
        new WeddingCompany(new You()).happyMary();
    }

}
