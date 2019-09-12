package com.ljj.db.chapter14;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.sql.SQLException;
import java.util.Map;

/**
 * @Author liujj
 * @Description TODO
 * @Date 2019/9/12 10:19
 */
public class DBCPTest {

    public static void main(String[] args) throws SQLException {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:oracle:thin:@192.168.70.87:1521:ipayment");
        dataSource.setUsername("ipayment2018");
        dataSource.setPassword("ipayment@2018");
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        TransactionSynchronizationManager.initSynchronization();
        Map<String, Object> objectMap = jdbcTemplate.queryForMap("select * from T_MCHT_REFUND_ORDER t where t.mcht_id = '903310112340001' and t.mcht_refund_order_no = '122585267'");
        System.out.println(objectMap);
    }
}
