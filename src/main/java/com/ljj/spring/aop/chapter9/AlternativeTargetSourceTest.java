package com.ljj.spring.aop.chapter9;

import org.springframework.aop.TargetSource;
import org.springframework.aop.framework.ProxyFactory;

/**
 * @Author liujj
 * @Description TODO
 * @Date 2020/1/16 16:34
 */
public class AlternativeTargetSourceTest {

    public static void main(String[] args) {

        ITask task1 = ctx -> System.out.println("execute in Task1.");
        ITask task2 = ctx -> System.out.println("execute in Task2");
        ProxyFactory pf = new ProxyFactory();
        TargetSource targetSource = new AlternativeTargetSource(task1, task2);
        pf.setTargetSource(targetSource);
        ITask proxy = (ITask) pf.getProxy();
        System.out.println(proxy);
        proxy.execute(null);
        proxy.execute(null);
        proxy.execute(null);
        proxy.execute(null);

    }
}
