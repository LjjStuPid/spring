package com.ljj.spring.test;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ThreadLocalTest {

    public static Executor executor = Executors.newSingleThreadExecutor();

    public static void main(String[] args) throws InterruptedException {
        executor.execute(() -> {
            while (true) {
                c();
            }
        });
    }

    public static void c() {
        ThreadLocal threadLocal = new ThreadLocal();
        threadLocal.set(new byte[1024 * 1024]);
        threadLocal.remove();
    }
}
