package com.ljj.spring.aop.chapter7;

/**
 * @Author liujj
 * @Description TODO
 * @Date 2020/1/13 16:00
 */
public class HelloWorld {

    public void sayHello() {
        System.out.println("hello world !");
    }

    public static void main(String[] args) {

        Object object = new Object();
        synchronized (object) {
            System.out.println(Thread.holdsLock("dasfadsf"));
        }
    }
}
