package com.ljj.spring.spi.activate;

import org.apache.dubbo.common.extension.Activate;

/**
 * @Author liujj
 * @Description TODO
 * @Date 2020/2/28 10:09
 */
@Activate(group = {"group1","group2"})
public class GroupActivateExtImpl implements ActivateExt {
    @Override
    public String echo(String msg) {
        return msg;
    }
}
