package com.ljj.spring.spi;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.Adaptive;
import org.apache.dubbo.common.extension.SPI;

/**
 * @Author liujj
 * @Description TODO
 * @Date 2020/1/20 14:44
 */
@SPI("banana")
public interface PlantsWater {

    Fruit grant();

    @Adaptive
    String watering(URL url);
}
