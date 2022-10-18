package com.gcbeen.javastudy.jvm;

import java.util.Random;

public class JvmTest01 {

    public static void main(String[] args) {
        // 返回虚拟机试图使用的最大内存
        long max = Runtime.getRuntime().maxMemory();    // 字节：1024*1024
        // 返回jvm的总内存
        long total = Runtime.getRuntime().totalMemory();
        System.out.println("max=" + max + "字节\t" + (max/(double)1024/1024) + "MB");
        System.out.println("total=" + total + "字节\t" + (total/(double)1024/1024) + "MB");
        // 默认情况下:分配的总内存是电脑内存的1/4,初始化的内存是电脑的1/64


        String str = "gcbeen";
        while (true) {
            str += str + new Random().nextInt(88888888)
                    + new Random().nextInt(999999999);
        }

    }

}
