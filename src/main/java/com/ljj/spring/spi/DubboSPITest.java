package com.ljj.spring.spi;

import org.apache.dubbo.common.extension.ExtensionLoader;

/**
 * @Author liujj
 * @Description TODO
 * @Date 2020/1/20 9:28
 */
public class DubboSPITest {

    public static void main(String[] args) {

        ExtensionLoader<Robot> extensionLoader = ExtensionLoader.getExtensionLoader(Robot.class);

//        Robot robot = ExtensionLoader.getExtensionLoader(Robot.class).getAdaptiveExtension();
//
//        robot.sayHello();

        Robot robot = extensionLoader.getAdaptiveExtension();
        robot.sayHello();


//        Robot optimusPrime = extensionLoader.getExtension("optimusPrime");
//
//        optimusPrime.sayHello();
//
//        Robot bumblebee = extensionLoader.getExtension("bumblebee");
//
//        bumblebee.sayHello();


    }
}
