package com.ljj.concurrency.threadlocal;

import java.util.*;

/**
 * @Author: liujinjian
 * @Date: 2020/8/1 13:25
 */
public class SimpleThreadLocal<T> {
    public Map<Thread, T> valueMap = Collections.synchronizedMap(new HashMap<>());

    public void set(T value) {
        valueMap.put(Thread.currentThread(), value);
    }

    public T get() {
        Thread currenctThread = Thread.currentThread();

        T t = valueMap.get(currenctThread);
        if (t == null && !valueMap.containsKey(currenctThread)) {
            t = initialValue();
            valueMap.put(currenctThread, t);
        }
        return t;
    }

    public void remove() {
        valueMap.remove(Thread.currentThread());
    }

    public T initialValue() {
        return null;
    }

    public static void main(String[] args) {
        SimpleThreadLocal<List<String>> threadLocal = new SimpleThreadLocal<>();

        new Thread(() -> {
            List<String> params = new ArrayList<>(3);
            params.add("张三");
            params.add("李四");
            params.add("王五");
            threadLocal.set(params);
            System.out.println(Thread.currentThread().getName());
            threadLocal.get().forEach(param -> System.out.println(param));
        }).start();

        new Thread(() -> {
            try {
                Thread.sleep(1000);
                List<String> params = new ArrayList<>(2);
                params.add("Chinese");
                params.add("English");
                threadLocal.set(params);
                System.out.println(Thread.currentThread().getName());
                threadLocal.get().forEach(param -> System.out.println(param));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
