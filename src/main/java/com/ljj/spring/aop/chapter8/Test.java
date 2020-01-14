package com.ljj.spring.aop.chapter8;

import org.springframework.aop.framework.ProxyFactory;

/**
 * @Author liujj
 * @Description TODO
 * @Date 2020/1/14 15:42
 */
public class Test {

    public static void main(String[] args) {

        ProxyFactory proxyFactory = new ProxyFactory(Requestable.class);
        Object object = proxyFactory.getProxy();
        System.out.println(object.toString());
    }
}
