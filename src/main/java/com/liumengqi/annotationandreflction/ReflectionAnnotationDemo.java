package com.liumengqi.annotationandreflction;

import java.lang.annotation.*;
import java.lang.reflect.Field;

/**
 * 反射操作注解测试
 */
public class ReflectionAnnotationDemo {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        //通过反射获得Student2这个pojo类的信息
        Class<?> c1 = Class.forName("com.liumengqi.annotationandreflction.Student2");
        //通过反射获取注解
        Annotation[] annotations = c1.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }

        // 获取注解的value 值
        TableKuang annotation = c1.getAnnotation(TableKuang.class);
        String va = annotation.value();
        System.out.println(va);

        //获取类中指定域上的指定注解
        Field name = c1.getDeclaredField("name");
        FieldKuang fieldKuang = name.getAnnotation(FieldKuang.class);
        String columnName = fieldKuang.columnName();
        int length = fieldKuang.length();
        String type = fieldKuang.type();
        System.out.println(columnName+";"+length+";"+type);
    }

}

@TableKuang("db_student")
class Student2{
    @FieldKuang(columnName = "db_id",type = "int",length = 10)
    private int id;
    @FieldKuang(columnName = "db_age",type = "int",length = 10)
    private int age;
    @FieldKuang(columnName = "db_name",type = "varchar",length = 6)
    private String name;

    public Student2(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public Student2() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student2{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}

/**
 * 定义数据库名称对应关系的注解
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface TableKuang{
    /**
     * 表名
     * @return
     */
    String value();
}

/**
 * 定义数据库字段对应关系的注解
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface FieldKuang{
    /**
     * 列名
     * @return
     */
    String columnName();

    /**
     * 类型
     * @return
     */
    String type();

    /**
     * 字段长度
     * @return
     */
    int length();
}
