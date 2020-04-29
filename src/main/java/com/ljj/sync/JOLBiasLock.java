package com.ljj.sync;

import org.openjdk.jol.info.ClassLayout;

/**
 * @Author liujj
 * @Description TODO
 * @Date 2020/4/28 15:41
 */
public class JOLBiasLock {

    static A a;

    public static void main(String[] args) throws InterruptedException {


        // jvm确定同步块中大部分代码都不是偏向锁，所以在启动的时候延迟。
        Thread.sleep(5000);

        a = new A();
        System.out.println("before lock");
        System.out.println(ClassLayout.parseInstance(a).toPrintable());
        synchronized (a) {
            System.out.println("lock ing");
            System.out.println(ClassLayout.parseInstance(a).toPrintable());
        }
        System.out.println("after lock");
        System.out.println(ClassLayout.parseInstance(a).toPrintable());
    }
}
