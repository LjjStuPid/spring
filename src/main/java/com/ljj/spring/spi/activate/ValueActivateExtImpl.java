package com.ljj.spring.spi.activate;

import org.apache.dubbo.common.extension.Activate;

/**
 * @Author liujj
 * @Description TODO
 * @Date 2020/2/28 10:45
 */
@Activate(value = {"value"},group = {"group"})
public class ValueActivateExtImpl implements ActivateExt {
    @Override
    public String echo(String msg) {
        return msg;
    }
}
