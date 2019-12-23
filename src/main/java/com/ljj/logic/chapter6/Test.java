package com.ljj.logic.chapter6;

import java.nio.charset.Charset;

public class Test {
    public static void main(String[] args) {
        test();
        Float f = new Float(1.31);
        System.out.println(Float.toHexString(f));

        System.out.println(Charset.defaultCharset().name());
//        char x = 0X10FFFF;
    }

    public static int test() {
        int ret = 0;
        try {
            int a = 5 / 0;
            return ret;
        } finally {
            return 2;
        }
    }
}
