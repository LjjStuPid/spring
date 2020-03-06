package com.ljj.spring.spi.activate;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.ExtensionLoader;

import java.util.List;

/**
 * @Author liujj
 * @Description TODO
 * @Date 2020/2/28 10:55
 */
public class Test {

    public static void main(String[] args) {
        ExtensionLoader<ActivateExt> loader = ExtensionLoader.getExtensionLoader(ActivateExt.class);
        URL url = URL.valueOf("test://localhost/test");
        url = url.addParameter("value","test");
        List<ActivateExt> list = loader.getActivateExtension(url, new String[]{"order1","default"}, "group");
        System.out.println(list.size());
        list.forEach(item -> {
            System.out.println(item.getClass());
        });
    }
}
