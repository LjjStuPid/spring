package com.ljj.spring.aop.chapter9;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.NameMatchMethodPointcutAdvisor;

public class MockTask implements ITask {
    @Override
    public void execute(TaskExecutionContext ctx) {
        System.out.println("fdasf");
        System.out.println("task executed.");
    }


    public static void main(String[] args) {
        MockTask task = new MockTask();
        ProxyFactory weaver = new ProxyFactory();
        weaver.setTarget(task);
//        weaver.setInterfaces(new Class[]{ITask.class});
        NameMatchMethodPointcutAdvisor advisor = new NameMatchMethodPointcutAdvisor();
        advisor.setMappedName("execute");
        advisor.setAdvice(new PerformanceMethodInterctptor());
        weaver.addAdvisor(advisor);
        ITask proxyObject = (ITask) weaver.getProxy();
        System.out.println(proxyObject.getClass());
        proxyObject.execute(null);
    }
}
