package com.ljj.db.chapter14;

import com.ljj.ioc.chapter4.DataSource;
import oracle.jdbc.pool.OracleDataSource;
import org.springframework.jdbc.datasource.DelegatingDataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @Author liujj
 * @Description TODO
 * @Date 2019/9/11 17:06
 */
public class DbConnection {

    public static void main(String[] args) throws SQLException {
        javax.sql.DataSource  dataSource = new OracleDataSource();
        Long start = System.currentTimeMillis();
        try {
            DriverManager.setLoginTimeout(1);
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@193.168.70.11:1521:interpay", "interdb", "interdb");
            System.out.println(connection);
        } finally {
            Long end = System.currentTimeMillis();
            System.out.println("耗时:" + (end - start));
        }

    }
}
