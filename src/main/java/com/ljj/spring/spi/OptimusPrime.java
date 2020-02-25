package com.ljj.spring.spi;

import org.apache.dubbo.common.extension.Adaptive;

/**
 * @Author liujj
 * @Description TODO
 * @Date 2020/1/20 9:03
 */
@Adaptive
public class OptimusPrime implements Robot {
    @Override
    public void sayHello() {
        System.out.println("Hello,I am Optimus Prime");
    }
}
