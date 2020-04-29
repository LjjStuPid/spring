package com.ljj.sync;

import org.openjdk.jol.info.ClassLayout;

/**
 * @Author liujj
 * @Description 调用wait方法后，直接升级为重量级锁
 * @Date 2020/4/28 16:35
 */
public class ObjectWait {

    static A a;

    public static void main(String[] args) throws InterruptedException {
        a = new A();
        System.out.println("before lock");
        System.out.println(ClassLayout.parseInstance(a).toPrintable());

        Thread t1 = new Thread(() -> {
            synchronized (a) {
                try {
                    synchronized (a) {
                        System.out.println("before wait");
                        System.out.println(ClassLayout.parseInstance(a).toPrintable());
                        a.wait();
                        System.out.println("after wait");
                        System.out.println(ClassLayout.parseInstance(a).toPrintable());
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        Thread.sleep(7000);
        synchronized (a) {
            a.notifyAll();
        }
    }


    private static class A {

    }
}
