package com.ljj.reflect;

public class Test {

    public static void main(String[] args) {
        int modifier = Test.class.getModifiers();
        System.out.println(modifier);
    }
}
