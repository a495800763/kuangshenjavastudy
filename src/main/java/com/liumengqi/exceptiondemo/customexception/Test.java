package com.liumengqi.exceptiondemo.customexception;

public class Test {
    public static void main(String[] args) {
        try {
            test(11);
        } catch (MyException e) {
            System.out.println("MyException=>>"+e);
        }
    }

    static void  test(int a) throws MyException {
        System.out.println("传递的参数为："+a);
        if(a>10){
            //抛出
            throw  new MyException(a);
        }else{
            System.out.println("ok");
        }
    }
}
