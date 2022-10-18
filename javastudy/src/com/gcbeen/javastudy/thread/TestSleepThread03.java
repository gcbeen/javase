package com.gcbeen.javastudy.thread;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestSleepThread03 {

    public static void main(String[] args) {
        // 获取当前系统时间
        Date date = new Date(System.currentTimeMillis());
        while (true) {
            try {
                Thread.sleep(1000);
                // 更新系统时间
                System.out.println(new SimpleDateFormat("HH:mm:ss").format(date));
                date = new Date(System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
