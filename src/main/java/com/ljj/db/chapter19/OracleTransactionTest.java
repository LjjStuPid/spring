package com.ljj.db.chapter19;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.util.Date;

/**
 * @Author liujj
 * @Description TODO
 * @Date 2019/9/19 14:36
 */
public class OracleTransactionTest {

    public static void main(String[] args) {

        String insertSql = "insert into T_MCHT_REFUND_ORDER(ID,MCHT_ID,MCHT_ORDER_NO,MCHT_REFUND_ORDER_NO,REFUND_ORDER_ID,Amount,CREATE_TIME) values(?,?,?,?,?,?,?)";

        String querySql = "select t.MCHT_ORDER_NO from T_MCHT_REFUND_ORDER t where t.id=?";

        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setUrl("jdbc:oracle:thin:@192.168.70.87:1521:ipayment");
        basicDataSource.setUsername("ipayment2018");
        basicDataSource.setPassword("ipayment@2018");
        basicDataSource.setDefaultAutoCommit(false);



        DefaultTransactionDefinition defaultTransactionDefinition = new DefaultTransactionDefinition();
        defaultTransactionDefinition.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);

        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(basicDataSource);

//        TransactionSynchronizationManager.initSynchronization();

        JdbcTemplate jdbcTemplate = new JdbcTemplate(basicDataSource);
        Long id = System.currentTimeMillis();

        TransactionStatus transactionStatus = dataSourceTransactionManager.getTransaction(defaultTransactionDefinition);
        jdbcTemplate.update(insertSql, new Object[]{id, id, id, id, id, id, new Date()});

        dataSourceTransactionManager.commit(transactionStatus);

    }

}
