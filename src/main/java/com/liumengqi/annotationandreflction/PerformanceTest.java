package com.liumengqi.annotationandreflction;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 反射对比普通方式调用的性能测试
 */
public class PerformanceTest {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        test1();
        test2();
        test3();
    }

    private static final long EXECUTIONTIMES = 1000000000;

    /**
     * 反射方式调用
     */
    public static void test2() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        User user = new User();

        Class<? extends User> c1 = user.getClass();

        Method getName = c1.getDeclaredMethod("getName", null);

        long startTime = System.currentTimeMillis();
        for (long i = 0; i < EXECUTIONTIMES; i++) {
            getName.invoke(user,null);
        }
        long endTime =  System.currentTimeMillis();
        System.out.println("通过反射方式执行get方法10亿次："+(endTime-startTime)+"ms");
    }

    /**
     * 普通方式调用
     */
    public static void test1(){
        User user = new User();
        long startTime = System.currentTimeMillis();
        for (long i = 0; i < EXECUTIONTIMES; i++) {
            user.getName();
        }
        long endTime =  System.currentTimeMillis();
        System.out.println("通过普通方式执行get方法10亿次："+(endTime-startTime)+"ms");
    }

    /**
     *  关闭检测后反射方式调用
     */
    public static void test3() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        User user = new User();

        Class<? extends User> c1 = user.getClass();

        Method getName = c1.getDeclaredMethod("getName", null);
        getName.setAccessible(true);
        long startTime = System.currentTimeMillis();
        for (long i = 0; i < EXECUTIONTIMES; i++) {
            getName.invoke(user,null);
        }
        long endTime =  System.currentTimeMillis();
        System.out.println("关闭检测后反射执行get方法10亿次："+(endTime-startTime)+"ms");
    }

}
