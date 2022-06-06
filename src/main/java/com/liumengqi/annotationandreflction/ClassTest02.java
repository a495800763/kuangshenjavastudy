package com.liumengqi.annotationandreflction;

import java.lang.annotation.ElementType;

public class ClassTest02 {
    public static void main(String[] args) {
        Class<Object> c1 = Object.class;
        System.out.println("类："+c1);
        Class<Comparable> c2 = Comparable.class;
        System.out.println("接口："+c2);
        Class<String[]> c3 = String[].class;
        System.out.println("一维数组："+c3);
        Class<int[][]> c4 = int[][].class;
        System.out.println("二维数组："+c4);
        Class<Override> c5 = Override.class;
        System.out.println("注解："+c5);
        Class<ElementType> c6 = ElementType.class;
        System.out.println("枚举："+c6);
        Class<Integer> c7 = Integer.class;
        System.out.println("基本数据类型："+c7);
        Class<Void> c8 = void.class;
        System.out.println("void类型："+c8);
        Class<Class> c9 = Class.class;
        System.out.println("Class类："+c9);
    }
}
