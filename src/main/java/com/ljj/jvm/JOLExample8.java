package com.ljj.jvm;

import org.openjdk.jol.info.ClassLayout;

/**
 * @Author liujj
 * @Description TODO
 * @Date 2020/4/1 12:28
 */
public class JOLExample8 {
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
        private int i;

        public synchronized void parse() {
            i++;
        }
    }
}
