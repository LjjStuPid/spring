package com.ljj.spring.spi;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @Author liujj
 * @Description TODO
 * @Date 2020/1/20 9:08
 */
public class JavaSPITest {

    public static void main(String[] args) {
        ServiceLoader<Robot> serviceLoader = ServiceLoader.load(Robot.class);
        Iterator<Robot> iterator = serviceLoader.iterator();
        while (iterator.hasNext()) {
            Robot robot = iterator.next();
            robot.sayHello();
        }
    }
}
