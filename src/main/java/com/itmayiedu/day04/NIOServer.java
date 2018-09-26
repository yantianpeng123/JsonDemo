package com.itmayiedu.day04;

import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

/**
 * NIO编程服务端
 */
public class NIOServer {

    public static void test01()throws Exception{
        System.out.println("服务器端已经启动");
        //创建服务端通道
        SocketChannel channel = SocketChannel.open();
        //设置为异步读取
        channel.configureBlocking(false);//jdk1.7以上
        //绑定连接
        channel.bind(new InetSocketAddress(8990));
        //获取选择器
        Selector selector = Selector.open();
        //将通道注册到选择器当中，并且
        channel.register(selector, SelectionKey.OP_ACCEPT);


    }
}
