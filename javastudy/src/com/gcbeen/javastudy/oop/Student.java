package com.gcbeen.javastudy.oop;

public class Student extends Person {
    // 属性私有
    private String name;
    private int age;

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // 设置属性的方法
    // 获取属性的方法
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

    @Override
    public void test() {
        System.out.println("子类");
    }
}
