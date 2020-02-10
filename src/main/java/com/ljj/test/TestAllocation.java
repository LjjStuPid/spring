package com.ljj.test;

/**
 * @Author liujj
 * @Description TODO
 * @Date 2020/2/10 16:11
 */
public class TestAllocation {

    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) {
        byte[] allocation1, allocation2, allocation3, allocation4;

        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];

        allocation3 = new byte[10 * _1MB];
        allocation4 = new byte[3 * _1MB];

    }
}
