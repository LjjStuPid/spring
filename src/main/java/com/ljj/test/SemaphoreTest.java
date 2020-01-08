package com.ljj.test;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreTest {


    public static void main(String[] args) throws InterruptedException {

        Semaphore semaphore = new Semaphore(1);

        semaphore.acquire();

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            semaphore.release();
    }).start();

        System.out.println("hello");
        semaphore.acquire();

    }
}
