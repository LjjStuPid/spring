package com.ljj.test;

/**
 * @Author liujj
 * @Description TODO
 * @Date 2020/2/10 16:23
 */
public class TestPretenureSizeThreshold {

    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) {
        byte[] allocation = new byte[5 * _1MB];
    }
}
