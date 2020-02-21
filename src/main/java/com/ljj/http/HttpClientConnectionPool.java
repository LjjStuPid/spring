package com.ljj.http;

import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;

/**
 * @Author liujj
 * @Description TODO
 * @Date 2020/2/21 11:41
 */
public class HttpClientConnectionPool {

    private static volatile CloseableHttpClient instance;

    static {
        PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
        cm.setMaxTotal(200);
        cm.setDefaultMaxPerRoute(20);
        RequestConfig requestConfig = RequestConfig.custom().setConnectionRequestTimeout(1000)
                .setSocketTimeout(1000).setConnectionRequestTimeout(1000).build();
        instance = HttpClients.custom().setConnectionManager(cm).setDefaultRequestConfig(requestConfig).build();
    }


    public static HttpClient getInstance() {
        return instance;
    }
}
