package com.ljj.spring.aop.chapter8;

import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author liujj
 * @Description TODO
 * @Date 2020/1/14 14:45
 */
public class RequestCtrlCallback implements MethodInterceptor {

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {

        if (method.getName().equals("request")) {
            System.out.println("dfafdasfdasf");
        }
        return proxy.invokeSuper(obj, args);
    }

    public static void main(String[] args) {

        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "E:\\idea-ljj\\spring\\com");
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Requestable.class);
        enhancer.setCallback(new RequestCtrlCallback());


        Requestable proxy = (Requestable) enhancer.create();
        proxy.request();
    }
}
