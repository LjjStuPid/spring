package com.ljj.jvm;

import java.util.concurrent.CountDownLatch;

/**
 * @Author liujj
 * @Description TODO
 * @Date 2020/4/1 11:20
 */
public class HeavyLock {
    static CountDownLatch countDownLatch = new CountDownLatch(1000000000);

    public static void main(String[] args) throws InterruptedException {

        final C test = new C();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                while (countDownLatch.getCount() > 0) {
                    test.parse();
                }
            }).start();
        }
        countDownLatch.await();
        long end = System.currentTimeMillis();
        System.out.println(String.format("%sms", end - start));

    }

    private static class C {
        int i;

        public synchronized void parse() {
            i++;
            HeavyLock.countDownLatch.countDown();
        }
    }
}
