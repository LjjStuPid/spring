package com.ljj.sync;

import org.openjdk.jol.info.ClassLayout;

/**
 * @Author liujj
 * @Description TODO
 * @Date 2020/4/28 16:09
 */
public class HeavyLockHead {

    static A a;

    public static void main(String[] args) throws InterruptedException {
        a = new A();
        System.out.println("before lock");
        System.out.println(ClassLayout.parseInstance(a).toPrintable());
        Thread t1 = new Thread(() -> {
            synchronized (a) {
                try {
                    Thread.sleep(5000);
                    System.out.println("t1 release");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        Thread.sleep(1000);
        System.out.println("t1 lock ing");
        // 轻量级锁
        System.out.println(ClassLayout.parseInstance(a).toPrintable());

        // 此时t1线程把a锁住，并未释放，但是sync主线程这个时候过来争抢这把锁，所以锁升级为重量级锁
        sync();
        System.out.println("after lock");
        // 重量级锁
        System.out.println(ClassLayout.parseInstance(a).toPrintable());

        System.gc();
        System.out.println("after gc()");

        System.out.println(ClassLayout.parseInstance(a).toPrintable());


    }

    public static void sync() {
        synchronized (a) {
            System.out.println("t1 main lock");
            System.out.println(ClassLayout.parseInstance(a).toPrintable());
        }
    }


    private static class A {
        private int i = 0;

    }
}
