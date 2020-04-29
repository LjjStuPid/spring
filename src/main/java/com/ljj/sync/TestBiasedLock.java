package com.ljj.sync;

import java.util.List;
import java.util.Vector;

/**
 * @Author liujj
 * @Description TODO
 * @Date 2020/4/29 10:05
 */
public class TestBiasedLock {


    private static List<Integer> list = new Vector<Integer>();

    public static void main(String[] args) {
        long tsStart = System.currentTimeMillis();
        new TestBiasedLock().testConcurrentThreadDif();
//        new TestBiasedLock().testSingleThreadDif();
        System.out.println(Thread.activeCount());
        while (Thread.activeCount()>2){

        }
        System.out.println("一共消耗："+(System.currentTimeMillis()-tsStart)+" ms"+",集合中元素的数量："+list.size());
    }

    void testSingleThreadDif() {
        for (int i = 0; i < 10000000; i++) {
            list.add(i);
        }
    }

    /*
     * 开启偏向锁：一共耗费：911 ms
     * 关闭偏向锁：一共耗费：844 ms
     * */
    void testConcurrentThreadDif() {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000000; j++) {
                    list.add(j);
                }
            }, "thread-" + String.valueOf(i)).start();
        }
    }
}
