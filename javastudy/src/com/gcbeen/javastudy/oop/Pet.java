package com.gcbeen.javastudy.oop;

public class Pet {

    private String name;
    protected int age;

    public Pet() {
//        System.out.println(this.age);
//        System.out.println(this.name);
//        System.out.println("=Pet()=");
    }

    public Pet(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void test() {
        System.out.println("父类");
    }
}
