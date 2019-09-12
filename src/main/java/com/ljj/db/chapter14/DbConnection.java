package com.ljj.db.chapter14;


import oracle.jdbc.pool.OracleDataSource;
import org.springframework.jdbc.datasource.DataSourceUtils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @Author liujj
 * @Description TODO
 * @Date 2019/9/11 17:06
 */
public class DbConnection {

    public static void main(String[] args) throws SQLException {
        Long start = System.currentTimeMillis();
        try {
            DataSource dataSource = new OracleDataSource();
            ((OracleDataSource) dataSource).setURL("jdbc:oracle:thin:@192.168.70.11:1521:interpay");
            ((OracleDataSource) dataSource).setUser("interdb");
            ((OracleDataSource) dataSource).setPassword("interdb");
            Connection connection = DataSourceUtils.getConnection(dataSource);
            System.out.println(connection);
        } finally {
            Long end = System.currentTimeMillis();
            System.out.println("耗时:" + (end - start));
        }

    }
}
