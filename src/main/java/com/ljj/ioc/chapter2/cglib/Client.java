package com.ljj.ioc.chapter2.cglib;

import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;

/**
 * @Author liujj
 * @Description TODO
 * @Date 2019/9/26 11:12
 */
public class Client {
    public static void main(String[] args) {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "E:\\idea-ljj\\spring\\src\\main\\java\\com\\ljj\\ioc\\chapter2\\cglib");
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(HelloService.class);
        enhancer.setCallback(new MyMethodInterceptor());
        HelloService proxy = (HelloService) enhancer.create();
        System.out.println(proxy.getClass().getPackage());
        System.out.println(proxy.getClass().getName());
        proxy.sayOthers("fdafdsa");
        proxy.sayHello();
    }
}
