package com.ljj.jdk.test;

public class ParentChildInit {

    static String str = "parent_str";

    static {
        System.out.println("Parent static block invoke");
    }

    public static void main(String[] args) {
        System.out.println(Child.str);
    }

    static class Child extends ParentChildInit {
        static String strChild = "child_str";

        static {
            System.out.println("Child static block invoke");
        }
    }
}
