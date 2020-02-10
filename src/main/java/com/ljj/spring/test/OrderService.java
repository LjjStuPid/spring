package com.ljj.spring.test;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author liujj
 * @Description TODO
 * @Date 2020/1/9 14:33
 */
@Service
public class OrderService {

    @Autowired
    private UserService userService;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

}
