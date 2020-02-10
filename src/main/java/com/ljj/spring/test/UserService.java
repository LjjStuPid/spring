package com.ljj.spring.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author liujj
 * @Description TODO
 * @Date 2020/1/9 14:33
 */
@Service
public class UserService {

    @Autowired
    private OrderService orderService;

    public OrderService getOrderService() {
        return orderService;
    }

    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    //    @Autowired
//    private UserService(OrderService orderService) {
//        this.orderService = orderService;
//    }

}
