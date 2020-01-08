package com.ljj.test;

import java.util.concurrent.TimeUnit;

public class HookTest {

    public void start() {
        Runtime.getRuntime().addShutdownHook(new Thread((() -> {
            System.out.println("Execute Hook.........");
            while (true) {
                System.out.println("www");
            }
        })));
    }

    public static void main(String[] args) throws InterruptedException {
        new HookTest().start();
        System.out.println("The Application is doing something");
        TimeUnit.MILLISECONDS.sleep(5000);
    }
}
