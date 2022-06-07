package com.liumengqi.annotationandreflction;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 获取类的信息初步
 */
public class ClassInfamationDemo {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> c1 = Class.forName("com.liumengqi.annotationandreflction.User");


        //c1=new User().getClass();


        //获取类的名字
        System.out.println(c1.getName());
        System.out.println(c1.getSimpleName());

        System.out.println("---------");
        //getFields只能得到public 的属性
        Field[] fields = c1.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }

        System.out.println("---------");
        //getDeclaredFields可以获得所有的属性
        Field[] fieldsNew = c1.getDeclaredFields();
        for (Field field : fieldsNew) {
            System.out.println(field);
        }
        System.out.println("---------");
        //获得本类及其父类的所有public方法
        Method[] methods = c1.getMethods();
        for (Method method : methods) {
            System.out.println("getMethods RETURN:"+method);
        }

        System.out.println("---------");
        //获得本类的所有方法
        Method[] declaredMethods = c1.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println("getDeclaredMethods RETURN:"+declaredMethod);
        }
    }
}
