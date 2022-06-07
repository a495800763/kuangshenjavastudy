package com.liumengqi.annotationandreflction;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 通过反射动态的创建对象测试
 */
public class DenamicObjectDemo {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        //获得Class 对象
        Class<?> c1 = Class.forName("com.liumengqi.annotationandreflction.User");

        //Function1(c1);
        //Function2(c1);
        //Function3(c1);
        Function4(c1);

    }

    /**
     * 通过反射操作属性
     * @param c1
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws NoSuchFieldException
     */
    private static void Function4(Class<?> c1) throws InstantiationException, IllegalAccessException, NoSuchFieldException {
        User user4 = (User)c1.newInstance();
        //得到User类的name 属性
        Field name = c1.getDeclaredField("name");
        //通过Field类直接对user4对象的name 属性进行赋值
        //如果属性是private的 ，则报IllegalAccessException 错误
        //可手动在field层面对其Accessible进行更改
        name.setAccessible(true);
        name.set(user4,"柳梦琦的名字");
        System.out.println(user4.getName());
    }

    /**
     *  通过反射调用方法
     * @param c1
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     */
    private static void Function3(Class<?> c1) throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {

        User user3 = (User)c1.newInstance();
        //得到user类的setName方法
        Method setName = c1.getDeclaredMethod("setName", String.class);
        //在user3上调用setName方法，参数是"柳梦琦"
        //invoke 调用，激活
        setName.invoke(user3,"柳梦琦");
        System.out.println(user3.getName());
    }

    /**
     *  通过指定构造器创建对象
     * @param c1
     * @throws NoSuchMethodException
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     */
    private static void Function2(Class<?> c1) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        Constructor constructor = c1.getDeclaredConstructor(String.class, int.class, int.class);
        User newInstance = (User)constructor.newInstance("Liumengqi", 001, 18);
        System.out.println(newInstance);
    }

    /**
     * newInstance() 方法本质即调用类中的无参构造器，如果没有无参构造器则报错
     * @param c1
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    private static void Function1( Class<?> c1) throws IllegalAccessException, InstantiationException {
        //java.lang.NoSuchMethodException: com.liumengqi.annotationandreflction.User.<init>()
        User user = (User)c1.newInstance();
        System.out.println(user);
    }
}
