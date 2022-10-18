package com.gcbeen.javastudy.net;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class URLDemo02 {

    public static void main(String[] args) throws Exception {

        // 1.下载地址
        URL url = new URL("http://localhost:8080/gcbeen/hello.html");

        // 2.连接到这个资源 HTTP
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

        InputStream is = urlConnection.getInputStream();

        FileOutputStream stream = new FileOutputStream(new File("same.txt"));

        byte[] bytes = new byte[1024];
        int len = 0;
        while ((len = is.read(bytes)) != -1) {
            stream.write(bytes, 0, len);
        }

        stream.close();
        is.close();
        urlConnection.disconnect();

    }


}
