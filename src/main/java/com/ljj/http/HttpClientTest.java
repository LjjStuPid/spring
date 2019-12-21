package com.ljj.http;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;

public class HttpClientTest {

    public static void main(String[] args) {
        PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager();
        connectionManager.setMaxTotal(200);
        connectionManager.setDefaultMaxPerRoute(20);

        // 从连接池中获取client对象
        CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(connectionManager)
                .build();

        String url = "http://wwww.baidu.com/s/word=java";
        long start = System.currentTimeMillis();

        for (int i = 0; i < 100; i++) {

        }

    }

    public static void doGet(HttpClientConnectionManager connectionManager, String url) {
        // 从连接池中获取client对象
        CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(connectionManager)
                .build();

        RequestConfig config = RequestConfig.custom().setConnectTimeout(1000)
                .setConnectionRequestTimeout(500).build();
        HttpGet httpGet = new HttpGet(url);
    }
}
