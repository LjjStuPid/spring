package com.ljj.jvm;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.info.GraphLayout;

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
        String object =  "刘雪梅";

        print(ClassLayout.parseInstance(object).toPrintable());

        print(GraphLayout.parseInstance(object).toPrintable());

        print("size :  " + GraphLayout.parseInstance(object).totalSize());
    }
}
