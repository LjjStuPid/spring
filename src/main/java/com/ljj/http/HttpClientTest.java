package com.ljj.http;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class HttpClientTest {

    public static void main(String[] args) {
        String url = "http://wwww.baidu.com/s/word=java";
        HttpGet httpGet = new HttpGet(url);
        CloseableHttpResponse httpResponse = null;
        try {
            httpResponse = (CloseableHttpResponse) HttpClientConnectionPool.getInstance().execute(httpGet);
//            String response = EntityUtils.toString(httpResponse.getEntity());
//            System.out.println(response);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (httpResponse != null) {
                try {
                    httpResponse.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
