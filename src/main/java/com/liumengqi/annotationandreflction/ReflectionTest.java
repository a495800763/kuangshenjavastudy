package com.liumengqi.annotationandreflction;

/**
 * 反射测试类
 */
public class ReflectionTest {
    public static void main(String[] args) throws ClassNotFoundException {
        //通过反射获取类的Class对象
        Class<?> c1 = Class.forName("com.liumengqi.annotationandreflction.User");
        System.out.println(c1);
        Class<?> c2 = Class.forName("com.liumengqi.annotationandreflction.User");
        Class<?> c3 = Class.forName("com.liumengqi.annotationandreflction.User");
        Class<?> c4 = Class.forName("com.liumengqi.annotationandreflction.User");
        //一个类在内存中只有一个Class对象，总是得到这一个对象，
        //一个类被加载后，类的整个结构都会被封装在这个Class对象中
        System.out.println(c1.hashCode());
        System.out.println(c2.hashCode());
        System.out.println(c3.hashCode());
        System.out.println(c4.hashCode());
        //通过对象反射得到其Class 对象，得到的也是内存中相同且唯一的那个Class
        Class<? extends User> c5 = new User().getClass();
        System.out.println(c4.hashCode());
        ClassLoader classLoader = c5.getClassLoader();
        System.out.println(classLoader);

        //Class 本身也是 一个Class 类的对象
        Class<? extends Class> c6 = c5.getClass();
        System.out.println(c6.hashCode());
    }
}


class User{
    private String name;
    private int id;
    private int age;

    public User() {
    }

    public User(String name, int id, int age) {
        this.name = name;
        this.id = id;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    private String parseAge2Chinese(int age){
        return "test";
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", age=" + age +
                '}';
    }
}
