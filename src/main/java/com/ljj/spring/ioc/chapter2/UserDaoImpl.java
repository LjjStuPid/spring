package com.ljj.spring.ioc.chapter2;

import org.springframework.stereotype.Repository;

/**
 * @Author liujj
 * @Description TODO
 * @Date 2019/9/25 15:13
 */
@Repository
public class UserDaoImpl implements UserDao {
    @Override
    public void save(User user) {
        System.out.println("保存用户:" + user);
    }
}
