package com.ljj.aop.chapter10;

@AnyJoinpointAnnotation
public class MockTarget {

    public void test(String user) {
        System.out.println("MockTarget-test:" + user);
    }

    public void test2() {
        System.out.println("MockTarget-test===");
    }

    public void test3(User user) {
        System.out.println("test3");
        System.out.println(user);
    }
}
