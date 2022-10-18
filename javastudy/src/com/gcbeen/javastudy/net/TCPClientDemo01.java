package com.gcbeen.javastudy.net;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class TCPClientDemo01 {

    public static void main(String[] args) {
        Socket socket = null;
        OutputStream os = null;

        try {
            // 1.要知道服务器的地址
            InetAddress inetAddress = InetAddress.getByName("127.0.0.1");
            int port = 9999;
            // 2.创建一个socket链接
            socket = new Socket(inetAddress, port);
            // 3.发送信息IO流
            os = socket.getOutputStream();
            os.write("hello, tcp socket 网路连接".getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
