package com.ljj.spring.spi;

import org.apache.dubbo.common.extension.Adaptive;

/**
 * @Author liujj
 * @Description TODO
 * @Date 2020/1/20 9:04
 */
//@Adaptive
public class Bumblebee implements Robot {
    @Override
    public void sayHello() {
        System.out.println("Hello, I am Bumblebee");
    }
}
