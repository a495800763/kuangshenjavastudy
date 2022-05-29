package com.liumengqi.networkprograming;

import java.net.InetSocketAddress;

public class InetSocketAddressTest {
    public static void main(String[] args) {
        InetSocketAddress address = new InetSocketAddress("127.0.0.1", 8080);
        System.out.println(address);
        InetSocketAddress address2= new InetSocketAddress("localhost", 8080);
        System.out.println(address2);

        System.out.println(address.getAddress());
        System.out.println(address.getHostName());
        System.out.println(address.getPort());
    }
}
