package com.ljj.test;

import java.util.concurrent.TimeUnit;

public class Testy {
    private static final int COUNT_BITS = Integer.SIZE - 3;

    public static void main(String[] args) {

        Object a = new Object();
        Object b = new Object();

        Thread threadA = new Thread(() -> {
            synchronized (a){
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (b){
                    System.out.println("HelloA");
                }
            }
        });

        Thread threadB = new Thread(() -> {
            synchronized (b){
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (a){
                    System.out.println("HelloB");
                }
            }
        });

        threadA.start();
        threadB.start();



    }
}
