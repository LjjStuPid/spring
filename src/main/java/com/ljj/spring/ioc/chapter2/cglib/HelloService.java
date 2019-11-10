package com.ljj.spring.ioc.chapter2.cglib;

/**
 * @Author liujj
 * @Description TODO
 * @Date 2019/9/26 11:08
 */
public  class HelloService {

    public HelloService() {
        System.out.println("HelloService构造");
    }

    static String sayOthers(String name) {
        System.out.println("HelloService:sayOthers>>" + name);
        return null;
    }

    void sayHello() {
        System.out.println("HelloService:sayHello");
    }
}
