package com.ljj.spring.spi.activate;

import org.apache.dubbo.common.extension.Activate;

/**
 * @Author liujj
 * @Description TODO
 * @Date 2020/2/28 10:11
 */
@Activate(order = 2,group = {"order"})
public class OrderActivateExtImpl1 implements ActivateExt {
    @Override
    public String echo(String msg) {
        return msg;
    }
}
