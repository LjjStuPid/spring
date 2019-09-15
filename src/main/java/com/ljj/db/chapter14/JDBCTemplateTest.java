package com.ljj.db.chapter14;

import com.ljj.db.chapter14.domain.User;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JDBCTemplateTest {

    public static void main(String[] args) {
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setUrl("jdbc:mysql://127.0.0.1:3306/quick4j?serverTimezone=Asia/Shanghai&useCursorFetch=true");
        basicDataSource.setUsername("root");
        basicDataSource.setPassword("123456");
        JdbcTemplate jdbcTemplate = new JdbcTemplate(basicDataSource);

        // 查询数据
//        List customerList = resultSetExtractor(jdbcTemplate);
//        List customerList = rowMapperTest(jdbcTemplate);
//        List customerList = rowCallbackHandlerTest(jdbcTemplate);

        // 更新数据
        int updateRecord = update(jdbcTemplate);
        System.out.println(updateRecord);

    }


    public static int update(JdbcTemplate jdbcTemplate) {
        int update = jdbcTemplate.update("update user t set t.password=? where t.id=?", new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setString(1, "575425435");
                ps.setString(2,"90");
            }
        });
        return update;
    }

    public static List rowCallbackHandlerTest(JdbcTemplate jdbcTemplate) {
        List list = new ArrayList();
        jdbcTemplate.query("select * from user", new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet rs) throws SQLException {
                User user = new User();
                user.setId(rs.getInt(1));
                user.setUsername(rs.getString(2));
                user.setPassword(rs.getString(3));
                user.setState(rs.getString(4));
                user.setCreate_time(rs.getDate(5));
                user.setRealname(rs.getString(6));
                user.setEmail(rs.getString(7));
                user.setAddress(rs.getString(8));
                user.setCountry(rs.getString(9));
                user.setCity(rs.getString(10));
                list.add(user);
            }
        });
        return list;
    }

    public static List rowMapperTest(JdbcTemplate jdbcTemplate) {
        List customers = jdbcTemplate.query("select * from user", new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User user = new User();
                user.setId(rs.getInt(1));
                user.setUsername(rs.getString(2));
                user.setPassword(rs.getString(3));
                user.setState(rs.getString(4));
                user.setCreate_time(rs.getDate(5));
                user.setRealname(rs.getString(6));
                user.setEmail(rs.getString(7));
                user.setAddress(rs.getString(8));
                user.setCountry(rs.getString(9));
                user.setCity(rs.getString(10));
                return user;
            }
        });
        return customers;
    }

    public static List resultSetExtractor(JdbcTemplate jdbcTemplate) {
        jdbcTemplate.setFetchSize(1);
        List customerList = jdbcTemplate.query("select * from user", new ResultSetExtractor<List>() {
            @Override
            public List extractData(ResultSet rs) throws SQLException, DataAccessException {
                List customers = new ArrayList();
                while (rs.next()) {
                    User user = new User();
                    user.setId(rs.getInt(1));
                    user.setUsername(rs.getString(2));
                    user.setPassword(rs.getString(3));
                    user.setState(rs.getString(4));
                    user.setCreate_time(rs.getDate(5));
                    user.setRealname(rs.getString(6));
                    user.setEmail(rs.getString(7));
                    user.setAddress(rs.getString(8));
                    user.setCountry(rs.getString(9));
                    user.setCity(rs.getString(10));
                    customers.add(user);
                }
                return customers;
            }
        });
        return customerList;
    }
}
