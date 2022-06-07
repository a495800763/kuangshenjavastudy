package com.liumengqi.annotationandreflction;

public class ClassLoaderDemo {
    public static void main(String[] args) throws ClassNotFoundException {

        //获取系统类的加载器 -->SystemClassLoader
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);

        //获取系统类加载器的父类加载器-->拓展类加载器 ExtensionClassLoader
        ClassLoader parent = systemClassLoader.getParent();
        System.out.println(parent);

        //获取拓展类加载器的父类加载器-->BootstrapClassLoader
        //该加载器无法直接获取
        ClassLoader bootStrapClassLoader = parent.getParent();
        // 返回null
        System.out.println(bootStrapClassLoader);

        System.out.println("======================================");

        // 测试当前类是哪个类加载的
        Class<?> thisClass = Class.forName("com.liumengqi.annotationandreflction.ClassLoaderDemo");
        ClassLoader classLoader = thisClass.getClassLoader();
        System.out.println(classLoader);
        System.out.println("======================================");
        //rt包下java的核心类库由根加载器加载，打印加载器为null
        Class<?> class2 = Class.forName("java.lang.Object");
        ClassLoader classLoader2 = class2.getClassLoader();
        System.out.println(classLoader2);


        //如何获得系统类加载器可以加载的路径,<当前程序所有可用的类的路径>
        System.out.println(System.getProperty("java.class.path"));

        /*
        * C:\Program Files\Java\jdk1.8.0_181\jre\lib\charsets.jar;
        * C:\Program Files\Java\jdk1.8.0_181\jre\lib\deploy.jar;
        * C:\Program Files\Java\jdk1.8.0_181\jre\lib\ext\access-bridge-64.jar;
        * C:\Program Files\Java\jdk1.8.0_181\jre\lib\ext\cldrdata.jar;
        * C:\Program Files\Java\jdk1.8.0_181\jre\lib\ext\dnsns.jar;
        * C:\Program Files\Java\jdk1.8.0_181\jre\lib\ext\jaccess.jar;
        * C:\Program Files\Java\jdk1.8.0_181\jre\lib\ext\jfxrt.jar;
        * C:\Program Files\Java\jdk1.8.0_181\jre\lib\ext\localedata.jar;
        * C:\Program Files\Java\jdk1.8.0_181\jre\lib\ext\nashorn.jar;
        * C:\Program Files\Java\jdk1.8.0_181\jre\lib\ext\sunec.jar;
        * C:\Program Files\Java\jdk1.8.0_181\jre\lib\ext\sunjce_provider.jar;
        * C:\Program Files\Java\jdk1.8.0_181\jre\lib\ext\sunmscapi.jar;
        * C:\Program Files\Java\jdk1.8.0_181\jre\lib\ext\sunpkcs11.jar;
        * C:\Program Files\Java\jdk1.8.0_181\jre\lib\ext\zipfs.jar;
        * C:\Program Files\Java\jdk1.8.0_181\jre\lib\javaws.jar;
        * C:\Program Files\Java\jdk1.8.0_181\jre\lib\jce.jar;
        * C:\Program Files\Java\jdk1.8.0_181\jre\lib\jfr.jar;
        * C:\Program Files\Java\jdk1.8.0_181\jre\lib\jfxswt.jar;
        * C:\Program Files\Java\jdk1.8.0_181\jre\lib\jsse.jar;
        * C:\Program Files\Java\jdk1.8.0_181\jre\lib\management-agent.jar;
        * C:\Program Files\Java\jdk1.8.0_181\jre\lib\plugin.jar;
        * C:\Program Files\Java\jdk1.8.0_181\jre\lib\resources.jar;
        * C:\Program Files\Java\jdk1.8.0_181\jre\lib\rt.jar;
        * D:\githubprogram\kuangshenjavastudy\target\classes;
        * F:\Program Files\JetBrains\IntelliJ IDEA 2019.3.2\lib\idea_rt.jar

         * */
    }
}
