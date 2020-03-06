package com.ljj.spring.spi.activate;

import org.apache.dubbo.common.extension.SPI;

/**
 * @Author liujj
 * @Description TODO
 * @Date 2020/2/28 10:05
 */
@SPI
public interface ActivateExt {
    String echo(String msg);
}
