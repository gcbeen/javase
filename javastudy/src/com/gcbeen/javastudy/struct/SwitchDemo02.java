package com.gcbeen.javastudy.struct;

import java.util.Scanner;

/**
 * @author gcbeen
 */
public class SwitchDemo02 {

    public static void main(String[] args) {
        char a = 'b';
        switch (a) {
            case 'a':
                System.out.println('a');
                break;
            case 'b':
                System.out.println('b');
                break;
            default:
                break;
        }

        String name = "小蚂蚁";
        switch (name) {
            case "蝼蚁":
                System.out.println("蝼蚁");
                break;
            case "小蚂蚁":
                System.out.println("小蚂蚁");
                break;
            default:
                System.out.println("错误");
        }

        String str = "world";
        switch (str) {
            case "hello":
                System.out.println("hello");
                break;
            case "world":
                System.out.println("world");
                break;
            default:
                break;
        }


        // 打印101~150之间的所有质数
        // 质数是指在大的自然数中，除1和它本身以外不再有其他因数的自然数。
        int count = 0;
        outer : for (int i = 101; i < 150; i++) {
            for (int j = 2; j < i / 2; j++) {
                if (i % j == 0) {
                    continue outer;
                }
            }
            System.out.print(i + " ");
        }

    }

}
