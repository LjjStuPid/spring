package com.ljj.spring.spi;

import org.apache.dubbo.common.URL;

/**
 * @Author liujj
 * @Description TODO
 * @Date 2020/1/20 15:00
 */
public class AppleWater implements PlantsWater {
    @Override
    public Fruit grant() {
        return new Apple();
    }

    @Override
    public String watering(URL url) {
        System.out.println("watering apple");
        return "watering finished";
    }
}
