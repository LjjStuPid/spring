package com.ljj.db.chapter19;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Test {

    public static void main(String[] args) {
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setUrl("jdbc:mysql://127.0.0.1:3306/quick4j?serverTimezone=Asia/Shanghai");
        basicDataSource.setUsername("root");
        basicDataSource.setPassword("123456");
        basicDataSource.setDefaultAutoCommit(false);

        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(basicDataSource);
        DefaultTransactionDefinition defaultTransactionDefinition = new DefaultTransactionDefinition();
        defaultTransactionDefinition.setPropagationBehavior(TransactionDefinition.PROPAGATION_NOT_SUPPORTED);

        JdbcTemplate jdbcTemplate = new JdbcTemplate(basicDataSource);
        TransactionTemplate transactionTemplate = new TransactionTemplate(dataSourceTransactionManager, defaultTransactionDefinition);
        transactionTemplate.execute(new TransactionCallback<Object>() {
            @Override
            public Object doInTransaction(TransactionStatus status) {
                jdbcTemplate.update("update user t set t.password=? where t.id=?", ps -> {
                    ps.setString(1, "trwr");
                    ps.setString(2, "8");
                });
                jdbcTemplate.query("select t.password from user t where t.id=?", new Object[]{"8"}, new RowCallbackHandler() {
                    @Override
                    public void processRow(ResultSet rs) throws SQLException {
                        System.out.println(rs.getString(1));
                    }
                });
                return null;
            }

        });


    }
}
