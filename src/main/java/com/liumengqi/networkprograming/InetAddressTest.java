package com.liumengqi.networkprograming;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 测试IP
 */
public class InetAddressTest {
    public static void main(String[] args) {
        InetAddressFunction();
    }

    private static void InetAddressFunction() {
        try {
            InetAddress inetAddress1 = InetAddress.getByName("127.0.0.1");
            System.out.println(inetAddress1);
            InetAddress inetAddress3 = InetAddress.getByName("localhost");
            System.out.println(inetAddress3);
            InetAddress inetAddress4 = InetAddress.getLocalHost();
            System.out.println(inetAddress4);
            //查询网络地址
            InetAddress inetAddress2 = InetAddress.getByName("www.baidu.com");
            System.out.println(inetAddress2);

            //常用方法
            System.out.println(inetAddress2.getAddress());
            //获取规范的名称
            System.out.println(inetAddress2.getCanonicalHostName());
            //获取IP
            System.out.println(inetAddress2.getHostAddress());
            //获取域名
            System.out.println(inetAddress2.getHostName());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
