package com.itmayiedu.day02;

import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class TcpClient {
    public static void main(String[] args) throws Exception{
            test01();
    }

    public static void test01()throws Exception{
        System.out.println("===================>>>>>>>TCP协议客户端启动");
        Socket socket = new Socket("127.0.0.1", 9899);
        OutputStream outputStream = socket.getOutputStream();
        Scanner scanner = new Scanner(System.in);
        String string = "接受客户端请求：";
        outputStream.write(string.getBytes());
        socket.close();

    }
}
