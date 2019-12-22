package com.ljj.concurrency.chapter3;

import java.util.concurrent.CountDownLatch;

public class Singleton {

    private static Singleton singleton;

    public static Singleton getInstance() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        for (int i = 0; i < 40; i++) {
            new Thread(() -> {
                try {
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Singleton.getInstance());
            }).start();
        }
        countDownLatch.countDown();
    }
}
