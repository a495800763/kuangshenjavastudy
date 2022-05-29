package com.liumengqi.exceptiondemo;

public class ExceptionTest {
    public static void main(String[] args) {
        int a= 1;
        int b =0;
        try {
            //监控区域
            System.out.println(a/b);
        }catch (ArithmeticException e){
            e.printStackTrace();
            System.out.println("程序出现异常，分母不能为0");
        }finally {
            //善后工作
            System.out.println("finally");
        }
    }
}
