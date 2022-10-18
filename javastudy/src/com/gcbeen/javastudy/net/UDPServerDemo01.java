package com.gcbeen.javastudy.net;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServerDemo01 {

    public static void main(String[] args) throws Exception{
        // 1.开放端口
        DatagramSocket socket = new DatagramSocket(9090);
        // 2.接收数据包
        byte[] buffer = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buffer, 0, buffer.length);

        socket.receive(packet); // 阻塞接受
        System.out.println(packet.getAddress().getHostAddress());
        System.out.println(new String(packet.getData()));
        // 3.关闭连接
        socket.close();

    }

}
