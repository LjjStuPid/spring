package com.ljj.spring.reflect;

public class Test {

    public static void main(String[] args) {

        new Thread(() -> {
            while (true) {

            }
        }).start();

        System.out.println("hello");

//        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
//        executorService.execute(()->{
//            System.out.println("wer");
//        });
    }
}
