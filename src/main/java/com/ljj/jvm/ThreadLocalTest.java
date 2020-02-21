package com.ljj.jvm;

/**
 * @Author liujj
 * @Description TODO
 * @Date 2020/2/14 10:41
 */
public class ThreadLocalTest {

    private static InheritableThreadLocal<String> stringInheritableThreadLocal = new InheritableThreadLocal<>();


    public static void main(String[] args) {

        stringInheritableThreadLocal.set("fdsafdasf");

        new Thread(() -> {
            new Thread(() -> {
                System.out.println(stringInheritableThreadLocal.get());
            }).start();
        }).start();
    }
}
