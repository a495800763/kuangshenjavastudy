package com.liumengqi.networkprograming.urldemo;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class UrlDown {

    private static final String URL = "http://localhost:8080/liumengqi/exampleFile.txt";

    public static void main(String[] args) throws Exception {
        URL url = new URL(URL);

        HttpURLConnection connection = (HttpURLConnection)url.openConnection();

        InputStream inputStream = connection.getInputStream();

        FileOutputStream fos = new FileOutputStream("downloadFile.txt");

        byte[] buffer = new byte[1024];
        int len;
        while ((len=inputStream.read(buffer))!=-1){
            fos.write(buffer,0,len);
        }

        fos.close();
        inputStream.close();
        //断开连接
        connection.disconnect();
    }

}
