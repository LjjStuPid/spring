package com.ljj.concurrency.threadlocal;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: liujinjian
 * @Date: 2020/8/1 13:00
 */
public class ThreadLocalDemo {

    public static ThreadLocal<List<String>> threadLocal = new ThreadLocal<>();

    public void setThreadLocal(List<String> values) {
        threadLocal.set(values);
    }

    public void getThreadLocal() {
        System.out.println(Thread.currentThread().getName());
        threadLocal.get().forEach(name -> System.out.println(name));
    }

    public static void main(String[] args) {
        final ThreadLocalDemo threadLocal = new ThreadLocalDemo();

        new Thread(() -> {
            try {
                Thread.sleep(20000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            List<String> params = new ArrayList<>(3);
            params.add("张三");
            params.add("李四");
            params.add("王五");
            threadLocal.setThreadLocal(params);
            threadLocal.getThreadLocal();
        }).start();

        new Thread(() -> {
            try {
                Thread.sleep(20000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            List<String> params = new ArrayList<>(3);
            params.add("Chinese");
            params.add("English");
            threadLocal.setThreadLocal(params);
            threadLocal.getThreadLocal();
        }).start();


    }
}
