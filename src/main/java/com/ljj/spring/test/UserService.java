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

    private OrderService orderService;

    @Autowired
    private UserService(OrderService orderService) {
        this.orderService = orderService;
    }

}
