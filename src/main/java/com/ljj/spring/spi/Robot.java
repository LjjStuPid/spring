package com.ljj.spring.spi;

import org.apache.dubbo.common.extension.SPI;

/**
 * @Author liujj
 * @Description TODO
 * @Date 2020/1/20 9:03
 */
@SPI
public interface Robot {

    void sayHello();
}
