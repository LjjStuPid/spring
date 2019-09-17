package com.ljj.db.chapter19;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.transaction.*;
import org.springframework.transaction.support.DefaultTransactionStatus;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @Author liujj
 * @Description TODO
 * @Date 2019/9/17 14:19
 */
public class JdbcPlatformTransactionManager implements PlatformTransactionManager {

    private Log log = LogFactory.getLog(JdbcPlatformTransactionManager.class);

    private DataSource dataSource;

    public JdbcPlatformTransactionManager(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public TransactionStatus getTransaction(TransactionDefinition definition) throws TransactionException {
        Connection connection;
        try {
            connection = dataSource.getConnection();
            TransactionResourceManager.bindResource(connection);
            return new DefaultTransactionStatus(connection, true, true, false, true, null);
        } catch (SQLException e) {
            throw new CannotCreateTransactionException("can't get connection for tx", e);
        }
    }

    @Override
    public void commit(TransactionStatus status) throws TransactionException {
        Connection connection = (Connection) TransactionResourceManager.unbindResource();
        try {
            connection.commit();
        } catch (SQLException e) {
            throw new TransactionSystemException("commit failed with SQLExcetpion", e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                log.error("连接关闭异常");
            }
        }
    }

    @Override
    public void rollback(TransactionStatus status) throws TransactionException {
        Connection connection = (Connection) TransactionResourceManager.unbindResource();
        try {
            connection.rollback();
        } catch (SQLException e) {
            throw new UnexpectedRollbackException("can't failed with SQLException", e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                log.error("连接关闭异常");
            }
        }
    }
}
