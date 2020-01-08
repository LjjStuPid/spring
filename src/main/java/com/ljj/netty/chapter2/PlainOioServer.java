package com.ljj.netty.chapter2;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;

public class PlainOioServer {

    public void serve(int port) throws IOException {
        final ServerSocket socket = new ServerSocket(port);
        for (; ; ) {
            final Socket clientSocket = socket.accept();
            System.out.println("Accepted connection from " + clientSocket);
            new Thread(() -> {
                OutputStream out;
                try {
                    out = clientSocket.getOutputStream();
                    out.write("Hi!\r\n".getBytes(Charset.forName("UTF-8")));
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        clientSocket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }

    public static void main(String[] args) throws IOException {

        new Thread(() -> {
            PlainOioServer plainOioServer = new PlainOioServer();

            try {
                plainOioServer.serve(9090);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();


        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                Socket socket = new Socket();
                try {
                    socket.connect(new InetSocketAddress(9090));
                    PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
                    printWriter.write("Hello World");
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                    String response = bufferedReader.readLine();
                    System.out.println(response);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        }

    }
}
