package com.ljj.sync;

/**
 * @Author liujj
 * @Description 偏向锁和轻量级锁对比
 * @Date 2020/4/28 15:51
 */
public class BiasAndLightPerformance {
    public static void main(String[] args) throws InterruptedException {
        // 开启偏向锁
//        Thread.sleep(5000L);
        A a = new A();
        long start = System.currentTimeMillis();
        for (long i = 0; i < 1000000000L; i++) {
            a.parse();
        }
        long end = System.currentTimeMillis();
        System.out.println(String.format("%sms", end - start));
    }


    private static class A {
        int i = 0;

        public synchronized void parse() {
            i++;
        }
    }
}
