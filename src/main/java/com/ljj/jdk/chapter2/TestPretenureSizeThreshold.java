package com.ljj.jdk.chapter2;

public class TestPretenureSizeThreshold {

    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) {
          testPretenureSizeThreshold();
    }

    public static void testPretenureSizeThreshold() {
        byte[] allocation;
        allocation = new byte[8 * _1MB];
    }

}
