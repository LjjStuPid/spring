package com.ljj.spring.aop.chapter10;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;

import java.util.Arrays;

/**
 * @Author liujj
 * @Description TODO
 * @Date 2019/9/10 15:28
 */
@Aspect
public class TaskExecutionCompletionAspect {

    @AfterReturning(value = "execution(String com.ljj.spring.aop.chapter10.TaskExecutionCompletion.execute(String,..))",returning = "ss")
    public void taskExecutionComplete(JoinPoint joinPoint,String ss) {
        System.out.println(Arrays.toString(joinPoint.getArgs()));
        System.out.println(ss);
    }

    public static void main(String[] args) {
        AspectJProxyFactory weaver = new AspectJProxyFactory();
        weaver.setProxyTargetClass(true);
        weaver.setTarget(new TaskExecutionCompletion());
        weaver.addAspect(TaskExecutionCompletionAspect.class);
        Object proxy = weaver.getProxy();
        ((TaskExecutionCompletion) proxy).execute("fdasfddafadfaa");
    }

}
