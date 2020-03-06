package com.ljj.spring.spi.activate;

import org.apache.dubbo.common.extension.Activate;

/**
 * @Author liujj
 * @Description TODO
 * @Date 2020/2/28 10:44
 */
@Activate(order = 1,group = {"order"})
public class OrderActivateExtImpl2 implements ActivateExt {
    @Override
    public String echo(String msg) {
        return msg;
    }
}
