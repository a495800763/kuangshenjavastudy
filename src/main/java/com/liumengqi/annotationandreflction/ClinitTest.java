package com.liumengqi.annotationandreflction;

public class ClinitTest {

    static class Parent {
        static {
            A = 2;
        }
        public static int A = 1;
    }

    static class Sub extends Parent {

        public static int B = A;
    }

    public static void main(String[] args) {
        System.out.println(Sub.B);
    }



}
