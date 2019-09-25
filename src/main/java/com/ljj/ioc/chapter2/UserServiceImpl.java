package com.ljj.ioc.chapter2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author liujj
 * @Description TODO
 * @Date 2019/9/25 15:15
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private final UserDao userDao = null;


    @Override
    public void add() {
        User user = new User("liujinjian", "1231321");
        userDao.save(user);
    }

    @Override
    public String toString() {
        return "UserServiceImpl{" +
                "userDao=" + userDao +
                '}';
    }
}
