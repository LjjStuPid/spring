package com.ljj.ioc.chapter2.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author liujj
 * @Description TODO
 * @Date 2019/9/26 11:10
 */
public class MyMethodInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object sub, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("=======插入前置通知==========");
        Object object = methodProxy.invokeSuper(sub, objects);
        System.out.println("=======插入后者通知========");
        return object;
    }
}
