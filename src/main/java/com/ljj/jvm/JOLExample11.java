package com.ljj.jvm;

import org.openjdk.jol.info.ClassLayout;

/**
 * @Author liujj
 * @Description TODO
 * @Date 2020/4/1 11:52
 */
public class JOLExample11 {

    private static A a;

    public static void main(String[] args) throws InterruptedException {
        a = new A();
        System.out.println("before lock");
        System.out.println(ClassLayout.parseInstance(a).toPrintable());
        Thread thread = new Thread(() -> {
            synchronized (a) {
                System.out.println("before wait");
                System.out.println(ClassLayout.parseInstance(a).toPrintable());
                try {
                    a.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("after wait");
                System.out.println(ClassLayout.parseInstance(a).toPrintable());

            }
        });
        thread.start();
        Thread.sleep(7000);
        synchronized (a) {
            a.notifyAll();
        }
    }


    private static class A {
        private int i;

        public synchronized void parse() {
            i++;
        }
    }
}
