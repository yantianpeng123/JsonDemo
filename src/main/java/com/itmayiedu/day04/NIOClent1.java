package com.itmayiedu.day04;


import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * NIO编程客户端
 */
public class NIOClent1 {
    public static void main(String[] args) throws Exception{
        test01();
    }
    public static void test01()throws Exception {
        System.out.println("==================>>>>>>>>>+客户端已经启动");
        //2创建 Socket通道
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 8990));
        //3。切换异步非阻塞
        socketChannel.configureBlocking(false);//jdk1.7以上的版本
        ByteBuffer allocate = ByteBuffer.allocate(1024);
        allocate.put(new Date().toString().getBytes());//存放数据
        //切换到读取模式
        allocate.flip();
        socketChannel.write(allocate);
        allocate.clear();//清理allocate;
        socketChannel.close();//关闭通道

    }

}
