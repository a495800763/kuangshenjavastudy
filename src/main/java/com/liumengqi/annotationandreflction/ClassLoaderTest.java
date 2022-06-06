package com.liumengqi.annotationandreflction;

public class ClassLoaderTest {
    public static void main(String[] args) {
        A a = new A();
        System.out.println(A.m);
    }
}

class A{

    /**
     * 在类的初始化阶段 <clinit>方法将所有static代码块集合在一起进行赋值，这个
     * 集合的顺序与代码中定义的顺序有关，比如如下代码块
     * 将static int m =100; 放在 m=300; 前面 则 最终A.m=300
     * 反之A.m=100;
     */
    static int m =100;
    static {
        System.out.println("A的静态代码块初始化");
        m=300;
    }



    public A(){
        System.out.println("A的无参构造函数初始化");
    }
}
