package com.gcbeen.javastudy.method;

public class Demo02 {

    public static void main(String[] args) {
        int max = max(10, 20);
        System.out.println(max);

        double max2 = max(10.0, 20.0);
        System.out.println(max2);
    }

    // 比大小
    public static int max(int num1, int num2) {
        int result = 0;
        if (num1 == num2) {
            System.out.println("num1==num2");
            return 0;   // 终止方法
        }
        if (num1 > num2) {
            result = num1;
        } else {
            result = num2;
        }
        return result;
    }

    // 比大小
    public static double max(double num1, double num2) {
        double result = 0;
        if (num1 == num2) {
            System.out.println("num1==num2");
            return 0;   // 终止方法
        }
        if (num1 > num2) {
            result = num1;
        } else {
            result = num2;
        }
        return result;
    }

}
