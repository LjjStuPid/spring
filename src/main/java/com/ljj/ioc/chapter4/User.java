package com.ljj.ioc.chapter4;

import java.util.Date;

/**
 * @Author liujj
 * @Description TODO
 * @Date 2019/9/4 16:44
 */
public class User {

    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "User{" +
                "date=" + date +
                '}';
    }
}
