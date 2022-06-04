package com.liumengqi.annotation;

import java.lang.annotation.*;

/**
 * 测试元注解
 */
public class AnnotationTest {


    @MyAnnotation
    public void test(){

    }
}


/**
 * 自定义一个注解
 */
//target:表示注解可以在那些地方使用
@Target(value={ElementType.METHOD,ElementType.TYPE})
//retention 表示注解在哪种级别下仍然有效, source<class<runtime
@Retention(RetentionPolicy.RUNTIME)
//表示是否将本注解生成在javadoc中
@Documented
//子类可以继承父类的注解
@Inherited
@interface MyAnnotation{

}
