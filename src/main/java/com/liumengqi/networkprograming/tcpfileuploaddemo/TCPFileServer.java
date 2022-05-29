package com.liumengqi.networkprograming.tcpfileuploaddemo;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPFileServer {
    public static void main(String[] args) throws IOException {
        //1 服务端创建服务 serversocket
        ServerSocket serverSocket = new ServerSocket(9000);
        //2 监听客户端的链接
        //阻塞式监听，客户端链接完之后代码才会继续
        Socket socket = serverSocket.accept();
        //3.获取输入流
        InputStream is = socket.getInputStream();
        //4.文件输出到本地
        FileOutputStream fos = new FileOutputStream(new File("receive.jpg"));
        byte[] buffer = new byte[1024];
        int len;
        while ((len=is.read(buffer))!=-1){
            fos.write(buffer,0,len);
        }

        // 通知客户端接收完毕
        OutputStream os = socket.getOutputStream();
        os.write("我接受完毕了，你可以断开了".getBytes());

        // 关闭资源
        os.close();
        fos.close();
        is.close();
        socket.close();
        serverSocket.close();
    }
}
