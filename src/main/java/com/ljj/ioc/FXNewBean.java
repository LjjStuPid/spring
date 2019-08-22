package com.ljj.ioc;

/**
 * @Author liujj
 * @Description TODO
 * @Date 2019/8/22 11:19
 */

public class FXNewBean {

    private String name;

    public FXNewBean(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "FXNewBean{" +
                "name='" + name + '\'' +
                '}';
    }
}
