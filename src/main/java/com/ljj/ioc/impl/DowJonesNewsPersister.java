package com.ljj.ioc.impl;

import com.ljj.ioc.FXNewBean;
import com.ljj.ioc.IFXNewsPersister;
import org.springframework.stereotype.Component;

/**
 * @Author liujj
 * @Description TODO
 * @Date 2019/8/22 11:15
 */
@Component
public class DowJonesNewsPersister implements IFXNewsPersister {

    public void persistNews(FXNewBean fxNewBean) {
        System.out.println("保存DowJonesNews" + fxNewBean);
    }
}
