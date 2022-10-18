package com.gcbeen.javastudy.net.talk;

public class TeacherClient {

    public static void main(String[] args) {
        new Thread(new TalkSend(5555,"localhost",9999)).start();
        new Thread(new TalkReceive(8900),"学生").start();
    }

}
