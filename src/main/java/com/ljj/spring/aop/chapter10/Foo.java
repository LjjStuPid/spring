package com.ljj.spring.aop.chapter10;

/**
 * @Author liujj
 * @Description TODO
 * @Date 2019/9/9 14:24
 */
@AnyJoinpointAnnotation
public class Foo {

    public void method1() {
        System.out.println("method1 execution.");
    }

    public void method2() {
        System.out.println("method2 execution2");
    }

}
