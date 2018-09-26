package com.itmayiedu.day04;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * IO(BIO)与NIO的区别：其本质区别就是阻塞和非阻塞的区别。
 * 阻塞的概念： 应用程序在获取网络数据的时候，如果网络传输数据很慢，就会一直等待，一直到传输完毕为止。
 * 非阻塞的概念：应用程序可以直接获取已经准备好的数据，无需等待。
 * IO为同步阻塞形式，NIO为同步非阻塞形式
 */
public class NIOAndIO {

    public static void main(String[] args) {

    }
    public void test01() throws Exception{
        System.out.println("============>>>>>>>>>>>Scoket服务端启动");
        ServerSocket serverSocket = new ServerSocket(8090);
        //使用多线程解决异步问题。
        ExecutorService executorService = Executors.newCachedThreadPool();//创建可缓存的线程池。
        while(true){
            Socket accept = serverSocket.accept();
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try{
                        InputStream inputStream = accept.getInputStream();
                        byte[] buf = new byte[1024];
                        int len = inputStream.read(buf);
                        System.out.println("服务端接受客户端内容："+new String(buf,0,len));
                    }catch (Exception ex){

                    }
                }
            });
        }
    }
}
