package com.ljj.jvm;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CountDownLatch;

/**
 * @Author liujj
 * @Description TODO
 * @Date 2020/2/13 9:45
 */
public class Singleton {

    private static Singleton singleton = null;


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

    public static void main(String[] args) throws InterruptedException {

        final Set<String> stringSet = new HashSet<>();

        CountDownLatch countDownLatch = new CountDownLatch(1000);
        for (int i = 0; i < 1000; i++) {
            new Thread(() -> {
                String instance = getInstance().toString();
                stringSet.add(instance);
                countDownLatch.countDown();

            }).start();
        }

        countDownLatch.await();
        System.out.println(stringSet);
    }
}
