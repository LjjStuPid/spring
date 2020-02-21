package com.ljj.jvm;

import java.util.concurrent.TimeUnit;

/**
 * @Author liujj
 * @Description TODO
 * @Date 2020/2/13 9:18
 */
public class VolatileTest {

    public static volatile int race = 0;

    public static void increase() {
        race++;
    }

    private static final int THREADS_COUNT = 20;

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[THREADS_COUNT];

        for (int i = 0; i < THREADS_COUNT; i++) {
            threads[i] = new Thread(() -> {
                for (int i1 = 0; i1 < 100; i1++) {
                    increase();
                }
            });
            threads[i].start();
        }

//        while (Thread.activeCount() > 0) {
//            Thread.yield();
//        }

        TimeUnit.SECONDS.sleep(10);

        System.out.println(race);
    }
}
