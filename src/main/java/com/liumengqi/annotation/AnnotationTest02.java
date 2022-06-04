package com.liumengqi.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解
 */
public class AnnotationTest02 {

    //注解参数显式赋值，可以定义默认值
    @MyAnnotation2(name="柳梦琦",schools = {"地质大学","园林高中"})
    public void function (){

    }


    @MyAnnotation3("LIUMENGQI")
    public void funtion2(){

    }
}


@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface  MyAnnotation2{
    //注解的参数：参数类型+参数名+() default 默认值
    String name() default "";
    int age() default 0;
    int id() default -1;// -1代表不存在
    String[] schools() default {"清华大学"};

}

@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation3{
    /* 注解只有一个参数时，只有参数名叫“value”时，在使用时才可以省略，即可以写成 @MyAnnotation3("LIUMENGQI")
    * 否则必须写出参数名 即 @MyAnnotation3(name ="LIUMENGQI")*/
    String value();
}