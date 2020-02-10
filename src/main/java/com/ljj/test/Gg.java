package com.ljj.test;

/**
 * @Author liujj
 * @Description TODO
 * @Date 2020/2/10 10:52
 */
public class Gg {

    public static Gg gg = new Gg();

    public Gg() {
        System.out.println("构造函数");
    }

    {
        System.out.println("Heloo");
    }

    public static void main(String[] args) {
        Gg gg = new Gg();

    }
}
