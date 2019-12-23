package com.ljj.test;

import java.io.Serializable;

/**
 * @Author liujj
 * @Description TODO
 * @Date 2019/12/5 18:08
 */
public class D implements Serializable {

    private static final long serialVersionUID = -3925934565657541314L;

    private String username;

    public D() {
        System.out.println("D");
    }


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    @Override
    public String toString() {
        return "D{" +
                "username='" + username + '\'' +
                '}';
    }
}
