package com.liumengqi.networkprograming.tcpfileuploaddemo;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class TCPFileUpload {
    public static void main(String[] args) throws IOException {
        //1 创建一个socket 链接
        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 9000);
        //2 创建一个输出流
        OutputStream os = socket.getOutputStream();
        //拿到文件流
        FileInputStream fis = new FileInputStream(new File("timg.jpg"));
        //写出文件到服务端
        byte[] buffer = new byte[1024];
        int len;
        while ((len=fis.read(buffer))!=-1){
            os.write(buffer,0,len);
        }

        // 通知服务器传输已经完毕
        socket.shutdownOutput();

        // 确定服务器接收到文件才能断开链接
        InputStream resultInputStream = socket.getInputStream();
        //string  byte[]

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buffer2 = new byte[1024];
        int len2;
        while ((len2=resultInputStream.read(buffer2))!=-1){
            baos.write(buffer2,0,len2);
        }
        System.out.println(baos.toString());

        //关闭资源
        baos.close();
        resultInputStream.close();
        fis.close();
        os.close();
        socket.close();


    }
}
