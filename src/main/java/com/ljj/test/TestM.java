package com.ljj.test;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @Author liujj
 * @Description TODO
 * @Date 2019/12/23 17:35
 */
public class TestM {

    public static void main(String[] args) throws IOException {
        int i = 0;
        while (i++ < 100) {
            // 要连接的服务端IP地址和端口
            String host = "192.168.70.174";
            int port = 20800;
            // 与服务端建立连接
            Socket socket = new Socket(host, port);
            // 建立连接后获得输出流
            OutputStream outputStream = socket.getOutputStream();
            String message = "你好  yiwangzhibujian";
            socket.getOutputStream().write(message.getBytes("UTF-8"));
            outputStream.close();
        }

        while (true);

//        socket.close();
    }
}
