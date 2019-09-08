package com.ljj.aop.chapter9;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.core.io.Resource;

import java.lang.reflect.Method;

public class ResourceSetupBeforeAdvice implements MethodBeforeAdvice {

    private Resource resource;

    public ResourceSetupBeforeAdvice(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        if(!resource.exists()){
            System.out.println("创建资源");
        }
    }
}
