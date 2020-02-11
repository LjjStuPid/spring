package com.ljj.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author liujj
 * @Description TODO
 * @Date 2020/2/11 8:32
 */
public class OOMObject {

    public byte[] placeholder = new byte[64 * 1024];


    public static void fillHeap(int num) throws InterruptedException {
        List<OOMObject> list = new ArrayList<OOMObject>();
        for (int i = 0; i < num; i++) {
            Thread.sleep(50);
            list.add(new OOMObject());
        }

        System.gc();
    }

    public static void main(String[] args) throws InterruptedException {
        fillHeap(10000);
    }

}
