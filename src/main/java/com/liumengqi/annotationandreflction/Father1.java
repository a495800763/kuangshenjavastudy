package com.liumengqi.annotationandreflction;

public class Father1 {

    private int i = test();
    private static int j = method();

    static {
        System.out.print("(1)");
    }

    public Father1() {
        System.out.print("(2)");
    }

    {
        System.out.print("(3)");
    }

    public int test() {
        System.out.print("(4)");
        return 1;
    }

    public static int method() {
        System.out.println("(5)");
        return 1;
    }

}

class Son1 {
    private int i = test();
    private static int j = method();

    static {
        System.out.print("(6)");
    }

    public Son1() {
        System.out.print("(7)");
    }

    {
        System.out.print("(8)");
    }

    public int test() {
        System.out.print("(9)");
        return 1;
    }

    public static int method() {
        System.out.println("(10)");
        return 1;
    }

    public static void main(String[] args) {
        Son1 s1 = new Son1();
        System.out.println();
        Son1 s2 = new Son1();
    }
}

