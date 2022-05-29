package com.liumengqi.exceptiondemo.customexception;

/**
 * 自定义异常类
 */
public class MyException extends Exception {
//传递数字>10 抛出异常

    private int detail;

    public MyException(int a){
        this.detail=a;
    }

    @Override
    public String toString() {
        return "MyException{" +
                "detail=" + detail +
                '}';
    }
}
