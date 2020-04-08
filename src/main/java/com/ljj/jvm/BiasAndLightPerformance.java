package com.ljj.jvm;

/**
 * @Author liujj
 * @Description TODO
 * @Date 2020/4/1 11:14
 */
public class BiasAndLightPerformance {

    public static void main(String[] args) throws InterruptedException {

        Thread.sleep(5000);
        B b = new B();
        long start = System.currentTimeMillis();

        for (int i = 0; i < 1000000000L; i++) {
            b.parse();
        }
        long end = System.currentTimeMillis();
        System.out.println(String.format("%sms", end - start));
    }
}
