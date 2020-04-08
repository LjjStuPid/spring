package com.ljj.jvm;

import org.openjdk.jol.info.ClassLayout;

/**
 * @Author liujj
 * @Description TODO
 * @Date 2020/4/1 11:00
 */
public class JOLExample {

    static A a;

    public static void main(String[] args) throws InterruptedException {
        // 对象内存布局
//        System.out.println(VM.current().details());
//        System.out.println(ClassLayout.parseInstance(a).toPrintable());

        // 有没有计算hashCode区别
//        A a = new A();
//        System.out.println("before hash");
//        System.out.println(ClassLayout.parseInstance(a).toPrintable());
//        System.out.println("jvm--------------Ox" + Integer.toHexString(a.hashCode()));
//        System.out.println("after hash");
//        System.out.println(ClassLayout.parseInstance(a).toPrintable());

        // 偏向锁
        // JVM延迟偏向锁是因为：如果不延迟，一上来就是偏向锁，假设程序后续还有线程调用，他会升级，JVM确定同步块中
        // 大部分都不是偏向锁，所在在启动的时候延迟
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
