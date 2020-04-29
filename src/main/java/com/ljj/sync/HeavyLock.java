package com.ljj.sync;

import java.util.concurrent.CountDownLatch;

/**
 * @Author liujj
 * @Description TODO
 * @Date 2020/4/28 15:55
 */
public class HeavyLock {

    static CountDownLatch countDownLatch = new CountDownLatch(1000000000);

    public static void main(String[] args) throws InterruptedException {
        final A a = new A();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                while (countDownLatch.getCount() > 0) {
                    a.parse();
                }
            }).start();
        }
        countDownLatch.await();
        long end = System.currentTimeMillis();
        System.out.println(String.format("%sms", end - start));
    }

    private static class A {
        int i = 0;

        public synchronized void parse() {
            i++;
            countDownLatch.countDown();
        }
    }
}
