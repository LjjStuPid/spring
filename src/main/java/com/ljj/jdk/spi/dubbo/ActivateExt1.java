package com.ljj.jdk.spi.dubbo;

import org.apache.dubbo.common.extension.SPI;

@SPI
public interface ActivateExt1 {

    String echo(String msg);
}
