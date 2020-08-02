package com.ljj.concurrency.threadlocal;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: liujinjian
 * @Date: 2020/8/1 18:09
 */
public class ThreadLocalWeakReferenceGCDemo {

    private static final int THREAD_LOOP_SIZE = 20;

    public static void main(String[] args) {

        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < THREAD_LOOP_SIZE; i++) {
            ThreadLocal<Map<Integer, String>> threadLocal = new ThreadLocal<>();
            Map<Integer, String> map = new HashMap<>();

            map.put(i, "我是第" + i + "个ThreadLocal数据！");
            threadLocal.set(map);
            threadLocal.get();

            System.out.println("第" + i + "次获取ThreadLocal中的数据");

            try{
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
