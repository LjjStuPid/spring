package com.ljj.spring.ioc.chapter4.impl;

import com.ljj.spring.ioc.chapter4.FXNewBean;
import com.ljj.spring.ioc.chapter4.IFXNewsListener;
import com.ljj.spring.ioc.chapter4.PasswordDecodable;
import org.springframework.stereotype.Component;

/**
 * @Author liujj
 * @Description 测试
 * @Date 2019/8/22 11:13
 */
@Component
public class DowJonesNewsListener implements IFXNewsListener, PasswordDecodable {

    private String password;

    public DowJonesNewsListener() {
        System.out.println("构造器");
    }

    @Override
    public FXNewBean getNewsByPK(String newsId) {
        System.out.println("获取DowJonesNews:" + newsId);
        return new FXNewBean("DowJonesNews");
    }

    @Override
    public String getEncodedPassword() {
        return "dfashfhasjfklhdasflhasdfj";
    }

    @Override
    public void setDecodedPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "DowJonesNewsListener{" +
                "password='" + password + '\'' +
                '}';
    }
}
