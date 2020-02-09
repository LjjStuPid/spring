package com.ljj.jdk.spi;

import java.util.Iterator;
import java.util.ServiceLoader;

public class SPITest {


    public static final String ww = "1231";

    public static void main(String[] args) {
        ServiceLoader<OrderService> services = ServiceLoader.load(OrderService.class);
        Iterator<OrderService> iterator = services.iterator();
        while (iterator.hasNext()) {
            OrderService orderService = iterator.next();
            orderService.saveOrder();
        }
    }

    private class m{

    }
}
