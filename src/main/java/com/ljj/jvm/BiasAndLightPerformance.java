package com.ljj.jvm;

/**
 * @Author liujj
 * @Description TODO
 * @Date 2020/4/1 11:14
 */
public class BiasAndLightPerformance {

    public static void main(String[] args) throws InterruptedException {
        // jvm启动的时候认为锁存在竞争的可能性很大，所以偏向锁需要延迟5s初始化
//        Thread.sleep(5000);
        B b = new B();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000000000L; i++) {
            b.parse();
        }
        long end = System.currentTimeMillis();
        System.out.println(String.format("%sms", end - start));
    }
}
