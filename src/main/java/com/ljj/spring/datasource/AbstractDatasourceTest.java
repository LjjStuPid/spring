package com.ljj.spring.datasource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author liujj
 * @Description TODO
 * @Date 2020/3/6 8:57
 */
public class AbstractDatasourceTest {

    public static void main(String[] args) throws SQLException {

        BasicDataSource ipaymentDataSource = new BasicDataSource();
        ipaymentDataSource.setUrl("jdbc:oracle:thin:@192.168.70.87:1521:ipayment");
        ipaymentDataSource.setUsername("ipayment2018");
        ipaymentDataSource.setPassword("ipayment@2018");
        BasicDataSource opcDataSource = new BasicDataSource();
        opcDataSource.setUrl("jdbc:oracle:thin:@192.168.70.191:1521:OPCPAY");
        opcDataSource.setUsername("opcpay");
        opcDataSource.setPassword("opcpay191014");

        AbstractRoutingDataSource abstractRoutingDataSource = new AbstractRoutingDataSource() {
            private Map<String, String> keyMap = new HashMap<>();
            {
                keyMap.put("ipaymentDataSource", "ipaymentDataSource");
                keyMap.put("opcDataSource", "opcDataSource");
            }
            @Override
            protected Object determineCurrentLookupKey() {
                return "ipaymentDataSource";
            }
        };
        abstractRoutingDataSource.setDefaultTargetDataSource(opcDataSource);
        Map<Object, Object> map = new HashMap<>(2);
        map.put("ipaymentDataSource", ipaymentDataSource);
        map.put("opcDataSource", opcDataSource);
        abstractRoutingDataSource.setTargetDataSources(map);
        abstractRoutingDataSource.afterPropertiesSet();

        System.out.println(abstractRoutingDataSource.getConnection());


    }
}
