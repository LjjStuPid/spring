package com.ljj.test;

/**
 * @Author liujj
 * @Description TODO
 * @Date 2020/2/27 16:38
 */
public class BB {
    public static void main(String[] args) {

    }

    private static void sayHello(String to){
        System.out.println(String.format("Hello,%s",to));
    }

    private static void sayHello(Object to){
        System.out.println(String.format("Hello,%s",to));
    }




}
