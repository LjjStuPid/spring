package com.ljj.ioc.impl;

import com.ljj.ioc.FXNewBean;
import com.ljj.ioc.IFXNewsListener;
import org.springframework.stereotype.Component;

/**
 * @Author liujj
 * @Description 测试
 * @Date 2019/8/22 11:13
 */
@Component
public class DowJonesNewsListener implements IFXNewsListener {

    public FXNewBean getNewsByPK(String newsId) {
        System.out.println("获取DowJonesNews:" + newsId);
        return new FXNewBean("DowJonesNews");
    }
}
