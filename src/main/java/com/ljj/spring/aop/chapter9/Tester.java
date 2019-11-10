package com.ljj.spring.aop.chapter9;

public class Tester implements ITester {

    private  boolean busyAsTester;

    public void setBusyAsTester(boolean busyAsTester) {
        this.busyAsTester = busyAsTester;
    }

    @Override
    public boolean isBusyAsTester() {
        return false;
    }

    @Override
    public void testSoftware() {
        System.out.println("I will ensure the quality");
    }
}
