package com.ljj.test;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Test1 {

    public static final ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(1);

    public static void main(String[] args) {

        threadPoolExecutor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("www");
            }
        });
        test();
    }

    public static void test() {

    }
}
