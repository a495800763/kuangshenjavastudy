package com.liumengqi.annotationandreflction;


/**
 * 测试类在什么时候被初始化
 */
public class ClassTest03 {

    static {
        System.out.println("Main类被加载");
    }

    public static void main(String[] args) throws ClassNotFoundException {
        //1 主动引用
        //Son son = new Son();

        //反射也会产生主动引用
        //Class<?> name = Class.forName("com.liumengqi.annotationandreflction.Son");


        //通过子类调父类的static 域，不会产生子类的初始化加载
        //int b = Son.b;

        //通过数组new,不会产生类的任何加载
        //Son[] array = new Son[10];

        // 通过类调用其final 常量，不会产生类相关的任何加载初始化
        int m = Son.M;


    }
}

class Father{
    static int b =2;
    static {
        System.out.println("父类被加载");
    }

}

class Son extends  Father{
    static {
        System.out.println("子类被加载");
        m=300;
    }

    static int m=100;
    static final int M=1;
}