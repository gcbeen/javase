package com.gcbeen.javastudy.net;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class TCPClientDemo02 {

    public static void main(String[] args) throws Exception {
        // 1.建立连接
        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"),9000);
        // 2.创建输出流
        OutputStream os = socket.getOutputStream();
        // 3.读取文件
        // 源文件放到项目根目录
        // File 创建 根目录默认是项目目录
        FileInputStream stream = new FileInputStream(new File("gcbeen.jpg"));
        // 4.输出测试文件
        byte[] buffer = new byte[1024];
        int len = 0;
        while((len = stream.read(buffer)) != -1){
            os.write(buffer,0,len);
        }
        // 5.通知服务器已发送完成
        socket.shutdownOutput();
        // 6.确定服务器已经收到，断开连接
        InputStream inputStream = socket.getInputStream();

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] buffer2 = new byte[1024];
        int len2 = 0;
        while((len2 = stream.read(buffer2)) != -1){
            byteArrayOutputStream.write(buffer2,0,len2);
        }

        System.out.println(byteArrayOutputStream);

        // 7.关闭流
        byteArrayOutputStream.close();
        inputStream.close();
        stream.close();
        os.close();
        socket.close();

    }


}
