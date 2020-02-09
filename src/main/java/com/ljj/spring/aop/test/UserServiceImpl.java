package com.ljj.spring.aop.test;

import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {
    @Override
    public void work() {
        System.out.println("开始干活.......coding....");
    }
}
