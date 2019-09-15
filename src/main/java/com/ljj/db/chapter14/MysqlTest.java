package com.ljj.db.chapter14;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.SQLException;
import java.util.Map;

public class MysqlTest {

    public static void main(String[] args) {
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setUrl("jdbc:mysql://127.0.0.1:3306/quick4j?serverTimezone=Asia/Shanghai");
        basicDataSource.setUsername("root");
        basicDataSource.setPassword("123456");
        JdbcTemplate jdbcTemplate = new JdbcTemplate(basicDataSource);
        try {
            Map map = jdbcTemplate.queryForMap("select * from user t where t.username1 = 'ljj'");
        }catch (Exception e){

            System.out.println(((SQLException)e.getCause()).getErrorCode());
        }

//        System.out.println(map);
    }
}
