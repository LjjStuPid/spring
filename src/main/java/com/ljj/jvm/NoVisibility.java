package com.ljj.jvm;

import java.util.concurrent.TimeUnit;

/**
 * @Author liujj
 * @Description TODO
 * @Date 2020/2/14 13:06
 */
public class NoVisibility {

    private static boolean ready;

    private static int nummber;

    private static class ReaderThread extends Thread {
        @Override
        public void run() {
            while (!ready) {
                Thread.yield();
            }
            System.out.println(nummber);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new ReaderThread().start();
        nummber = 42;
        ready = true;
    }
}
