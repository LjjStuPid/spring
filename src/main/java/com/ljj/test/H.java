package com.ljj.test;

import java.util.Map;

/**
 * @Author liujj
 * @Description TODO
 * @Date 2020/2/11 9:07
 */
public class H {

    private static final Object lock = new Object();

    private static int m = 1;

    public static class ThreadA extends Thread {
        @Override
        public void run() {
            while (true) {
                synchronized (lock) {
                    while (m != 1) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("A");
                    m = 2;
                    lock.notifyAll();
                }
            }
        }
    }

    public static class ThreadB extends Thread {
        @Override
        public void run() {
            while (true) {
                synchronized (lock) {
                    while (m != 2) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("B");
                    m = 3;
                    lock.notifyAll();
                }
            }
        }
    }

    public static class ThreadC extends Thread {
        @Override
        public void run() {
            while (true) {
                synchronized (lock) {
                    while (m != 3) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("C");
                    m = 1;
                    lock.notifyAll();
                }
            }
        }
    }

    public static void main(String[] args) {
//        ThreadA threadA = new ThreadA();
//        ThreadB threadB = new ThreadB();
//        ThreadC threadC = new ThreadC();
//        threadA.start();
//        threadB.start();
//        threadC.start();


        Map<Thread, StackTraceElement[]> map = Thread.getAllStackTraces();
        for (Map.Entry<Thread, StackTraceElement[]> threadEntry : map.entrySet()) {
            for (StackTraceElement stackTraceElement : threadEntry.getValue()) {
                System.out.println(stackTraceElement.getMethodName());
            }
        }
    }
}
