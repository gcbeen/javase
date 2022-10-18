package com.gcbeen.javastudy.annotation;

public class Test02 {

    @SuppressWarnings("all")
    public void testFunction01() {
        System.out.println("testFunction01");
    }

    @SuppressWarnings("unchecked")
    public void testFunction02() {
        System.out.println("testFunction02");
    }

    @SuppressWarnings(value = {"unckecked", "deprecation"})
    public void testFunction03() {
        System.out.println("testFunction03");
    }

    public static void main(String[] args) {
        System.out.println("test2");
    }

}
