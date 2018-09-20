package com.itmayiedu.day02;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 使用线程池解决http多个请求问题
 */
public class ExecutoTcpServer extends Thread{

    public static void main(String[] args) throws  Exception{
        System.out.println("================>>>>>>>TCP服务客户端启动");
        ExecutorService executorService = Executors.newCachedThreadPool();//创建可缓存线程池
        ServerSocket serverSocket = new ServerSocket(8996);

        try{
                Socket accept = serverSocket.accept();
                executorService.execute(new Runnable() {
                    @Override
                    public void run() {
                    try{
                        InputStream inputStream = accept.getInputStream();
                        byte [] bytes =new byte[1024];
                        int len = inputStream.read(bytes);
                        String result = new String (bytes,0,len);
                        System.out.println("服务端接受客户端请求："+result);
                        OutputStream outputStream = accept.getOutputStream();
                        outputStream.write("itmayiedu".getBytes());
                    }catch (Exception ex){
                    }
                    }
                });
        } catch (Exception ex){

        }
    }
}
