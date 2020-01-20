package com.ljj.spring.spi;

import org.apache.dubbo.common.URL;

/**
 * @Author liujj
 * @Description TODO
 * @Date 2020/1/20 15:01
 */
public class BananaWater implements PlantsWater {
    @Override
    public Fruit grant() {
        return new Banana();
    }

    @Override
    public String watering(URL url) {
        System.out.println("watering banana");
        return "Watering success";
    }
}
