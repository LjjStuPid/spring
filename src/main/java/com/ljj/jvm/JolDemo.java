package com.ljj.jvm;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.info.GraphLayout;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author liujj
 * @Description TODO
 * @Date 2020/2/12 10:04
 */
public class JolDemo {


    static Object generate() {
        Map<String, Object> map = new HashMap<>();
        map.put("a", new Integer(1));
        map.put("b", "b");
        map.put("c", new Date());
        for (int i = 0; i < 10; i++) {
            map.put(String.valueOf(i), String.valueOf(i));
        }
        return map;
    }

    static void print(String messgae) {
        System.out.println(messgae);
        System.out.println("-----------------");
    }

    public static void main(String[] args) {


//        QuickPayTransaction quickPayTransaction = new QuickPayTransaction();

        ArrayList arrayList = new ArrayList();

        print(ClassLayout.parseInstance(arrayList).toPrintable());

        print(GraphLayout.parseInstance(arrayList).toPrintable());

        print("size :  " + GraphLayout.parseInstance(arrayList).totalSize());
    }
}
