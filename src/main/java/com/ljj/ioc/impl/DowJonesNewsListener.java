package com.ljj.ioc.impl;

import com.ljj.ioc.FXNewBean;
import com.ljj.ioc.IFXNewsListener;

/**
 * @Author liujj
 * @Description TODO
 * @Date 2019/8/22 11:13
 */
public class DowJonesNewsListener implements IFXNewsListener {

    public FXNewBean getNewsByPK(String newsId) {
        System.out.println("获取DowJonesNews:" + newsId);
        return new FXNewBean("DowJonesNews");
    }
}
