package com.ljj.sync;

import org.openjdk.jol.info.ClassLayout;

/**
 * @Author liujj
 * @Description 调用hashcode后就不能偏向了
 * @Date 2020/4/28 16:40
 */
public class ObjectHashCode {

    static A a;

    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(5000);
        a = new A();
        a.hashCode();
        System.out.println("before lock");
        System.out.println(ClassLayout.parseInstance(a).toPrintable());
        synchronized (a) {
            System.out.println("lock ing");
            System.out.println(ClassLayout.parseInstance(a).toPrintable());
        }
        System.out.println("after lock");
        System.out.println(ClassLayout.parseInstance(a).toPrintable());
    }

    private static class A {

    }

}
