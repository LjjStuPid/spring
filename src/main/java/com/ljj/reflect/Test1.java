package com.ljj.reflect;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author liujj
 * @Description TODO
 * @Date 2019/12/2 10:08
 */
public class Test1 {

    public static final AtomicInteger a = new AtomicInteger();

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(1);
        new Thread(() -> {
            while (true) {
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + ":" + a.getAndIncrement());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }
            }
        }).start();

        new Thread(() -> {
            while (true) {
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + ":" + a.getAndIncrement());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }
            }
        }).start();
    }
}
