package com.ljj.sync;

import org.openjdk.jol.info.ClassLayout;

import java.util.concurrent.TimeUnit;

/**
 * @Author liujj
 * @Description TODO
 * @Date 2020/4/28 16:59
 */
public class MyTest {

    static final Object lock = new Object();

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            synchronized (lock) {
                try {
                    TimeUnit.MILLISECONDS.sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("t1");
            }
        });
        t1.start();

        Thread t2 = new Thread(() -> {
            synchronized (lock) {
                System.out.println("t2");
            }
        });
        t2.start();

        System.out.println(ClassLayout.parseInstance(lock).toPrintable());
    }
}
