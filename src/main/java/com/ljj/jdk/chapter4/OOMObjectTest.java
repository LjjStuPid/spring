package com.ljj.jdk.chapter4;

import java.util.ArrayList;
import java.util.List;

public class OOMObjectTest {

    static class OOMObject {
        public byte[] placeholder = new byte[1024 * 1024];


    }

    public static void fillheap(int num) throws InterruptedException {
        List<OOMObject> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            Thread.sleep(50);
            list.add(new OOMObject());
        }
        System.gc();
    }

    public static void main(String[] args) throws InterruptedException {
        fillheap(10000);
    }
}
