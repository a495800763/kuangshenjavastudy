package com.liumengqi.annotationandreflction;

/**
 * 测试Class类的创建方式
 */
public class ClassTest {
    public static void main(String[] args) throws ClassNotFoundException {
        Person person = new Student();
        System.out.println("这个人是："+person.name);

        //方式一：通过对象获得Class对象
        Class<? extends Person> c1 = person.getClass();
        System.out.println(c1.hashCode());
        // 方式二：通过forName 获得
        Class<?> c2 = Class.forName("com.liumengqi.annotationandreflction.Student");
        System.out.println(c2.hashCode());

        //方式三 ： 通过类名.Class 获得
        Class<Student> c3 = Student.class;
        System.out.println(c3.hashCode());

        //方式四：基本内置类型的包装类的type属性
        Class<Integer> c4 = Integer.TYPE;
        System.out.println("Integer类型的Class对象的HashCode:"+c4.hashCode());
        //获得父类的类型
        Class<?> c5 = c1.getSuperclass();
        System.out.println("c1对象的类型的父类类型Class对象是:"+c5);

    }
}

class Person{
    public String name;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}

class Student extends Person{
    public Student(){
        this.name="学生";
    }
}


class Teacher extends Person{
    public Teacher(){
        this.name="老师";
    }
}
