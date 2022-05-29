package com.liumengqi.networkprograming.tcpdemo;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * TCP客户端
 */
public class TcpClint {
    public static void main(String[] args) {

        Socket serverSocket=null;
        OutputStream os=null;
        try {
            //1 要知道服务器的地址
            InetAddress serverIP = InetAddress.getByName("127.0.0.1");
            // 要知道端口号
            int port = 9999;
            //创建一个socket链接
            serverSocket = new Socket(serverIP, port);
            //使用IO流发送消息
            os = serverSocket.getOutputStream();
            os.write("你好，欢迎学习java网络编程相关知识".getBytes());
        }  catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(os!=null){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(serverSocket!=null){
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
