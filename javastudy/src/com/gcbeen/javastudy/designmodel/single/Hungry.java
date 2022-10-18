package com.gcbeen.javastudy.designmodel.single;

// 饿汉式单例
public class Hungry {
    // 一上来就实例化，可能会浪费空间
    // private byte[] data1 =new byte[1024*1024];
    // private byte[] data2 =new byte[1024*1024];
    // private byte[] data3 =new byte[1024*1024];
    // private byte[] data4 =new byte[1024*1024];

    //私有化构造器
    private Hungry() {

    }
    private final static Hungry HUNGRY = new Hungry();

    public Hungry getInstance() {
        return HUNGRY;
    }
}
