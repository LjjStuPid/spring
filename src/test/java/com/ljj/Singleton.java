package com.ljj;

/**
 * @Author liujj
 * @Description TODO
 * @Date 2019/9/24 9:59
 */
public class Singleton {
    private static final Singleton sing = new Singleton();

    private Singleton() {
    }

    public static Singleton getInstance() {
        return Nes.singleton;
    }

    private static class Nes {

        private static Singleton singleton = new Singleton();

    }




}
