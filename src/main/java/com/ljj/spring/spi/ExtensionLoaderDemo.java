package com.ljj.spring.spi;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.ExtensionLoader;

/**
 * @Author liujj
 * @Description TODO
 * @Date 2020/1/20 15:04
 */
public class ExtensionLoaderDemo {
    public static void main(String[] args) {
        URL url = URL.valueOf("dubbo://192.168.0.101:20880?plants.water=banana");

        ExtensionLoader<PlantsWater> extensionLoader = ExtensionLoader.getExtensionLoader(PlantsWater.class);
        PlantsWater plantsWater = extensionLoader.getAdaptiveExtension();

        String result = plantsWater.watering(url);
        System.out.println(result);
    }
}
