package com.itmayiedu.day02;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpService {
    public static void main(String[] args) throws Exception{
        System.out.println("============>>>>>>Tcp服务器启动。。");
        //创建tcp服务连接
        ServerSocket serverSocket =new ServerSocket(9899);

        Socket accept = serverSocket.accept();
        InputStream inputStream = accept.getInputStream();
        byte [] bytes = new byte[1024];
        int len = inputStream.read();
        String result = new String (bytes,0,len);
        System.out.println("=============>>>>>>服务器端接受客户端端内容是："+result);


    }
}
