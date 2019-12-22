package com.ljj.http;

import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class HttpClientTest {

    public static void main(String[] args) {
        PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager();
        connectionManager.setMaxTotal(200);
        connectionManager.setDefaultMaxPerRoute(20);
        String url = "http://wwww.baidu.com/s/word=java";

        for (int i = 0; i < 100; i++) {
            doGet(connectionManager, url);
        }

        while (true) {

        }

    }

    public static void doGet(HttpClientConnectionManager connectionManager, String url) {
        // 从连接池中获取client对象
        CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(connectionManager)
                .build();

        RequestConfig config = RequestConfig.custom().setConnectTimeout(1000)
                .setConnectionRequestTimeout(500).build();
        HttpGet httpGet = new HttpGet(url);

        try {
            CloseableHttpResponse closeableHttpResponse = httpClient.execute(httpGet);
            HttpEntity httpEntity = closeableHttpResponse.getEntity();
            String response = EntityUtils.toString(httpEntity, "UTF-8");
            System.out.println(response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
