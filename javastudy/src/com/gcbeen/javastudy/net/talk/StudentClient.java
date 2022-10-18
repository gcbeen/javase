package com.gcbeen.javastudy.net.talk;

public class StudentClient {

    public static void main(String[] args) {
        new Thread(new TalkSend(7777,"localhost",8900)).start();
        new Thread(new TalkReceive(9999),"老师").start();
    }

}
