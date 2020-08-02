package com.ljj.test;

/**
 * @Author: liujinjian
 * @Date: 2020/8/1 11:54
 */
public class ThreadLocalTest {

    public static void main(String[] args) {


        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    testThreadLocal();
                }
            }

            public void testThreadLocal() {
                ThreadLocal threadLocal = new ThreadLocal();
                threadLocal.set(new byte[1024 * 1024]);
            }

        }).start();
    }


}
