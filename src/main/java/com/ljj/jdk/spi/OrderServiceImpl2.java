package com.ljj.jdk.spi;

public class OrderServiceImpl2 implements OrderService {
    @Override
    public void saveOrder() {
        System.out.println("保存订单2");
    }
}
