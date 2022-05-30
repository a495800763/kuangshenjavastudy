package com.liumengqi.networkprograming.udpchat;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class TalkReceiver implements Runnable {
    DatagramSocket socket = null;
    private int port;
    private String msgFrom;

    public TalkReceiver(int port,String msgFrom) {
        this.port = port;
        this.msgFrom=msgFrom;
        try {
            socket=new DatagramSocket(port);
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                //准备接收包裹
                byte[] container = new byte[1024];
                DatagramPacket packet = new DatagramPacket(container, 0, container.length);
                //阻塞式接收包裹
                socket.receive(packet);

                byte[] data = packet.getData();
                String receiveData = new String(data, 0, data.length);
                System.out.println(msgFrom+"==>"+receiveData);
                if (receiveData.equals("bye")) {
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        socket.close();
    }
}
