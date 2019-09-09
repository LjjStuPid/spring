package com.ljj.aop.chapter10;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class JDKProxy implements InvocationHandler {

    private Object target;

    public JDKProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(method.getParameterCount()
        y);
        method.getParameterAnnotations();
        System.out.println(Arrays.toString(args));
        Object o = method.invoke(target, args);
        return o;
    }

    public static void main(String[] args) {

        ITest test = new Test();
        ITest iTest = (ITest) Proxy.newProxyInstance(test.getClass().getClassLoader(), new Class[]{ITest.class}, new JDKProxy(test));
        iTest.test("dfahfh");
    }
}
