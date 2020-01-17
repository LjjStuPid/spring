package com.ljj.spring.aop.chapter9;

import org.springframework.stereotype.Service;

/**
 * @Author liujj
 * @Description TODO
 * @Date 2020/1/17 10:54
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Override
    public boolean updateOrder() {
        System.out.println("更新了订单");
        return false;
    }

}
