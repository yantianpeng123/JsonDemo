package com.itmayiedu.day04;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;

/**
 * NIO编程服务端
 */
public class NIOServer {

    public static void main(String[] args) throws Exception{
        test01();
    }
    public static void test01()throws Exception{
        System.out.println("服务器端已经启动");
        //创建服务端通道
        ServerSocketChannel channel = ServerSocketChannel.open();
        //设置为异步读取
        channel.configureBlocking(false);//jdk1.7以上
        //绑定连接
        channel.bind(new InetSocketAddress(8990));
        //获取选择器
        Selector selector = Selector.open();
        //将通道注册到选择器当中，并且监听已经接受的事件
        channel.register(selector, SelectionKey.OP_ACCEPT);
        while (selector.select()>0){
            //获取当前注册器有注册已经监听到事件，
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()){
                //获取准备就绪的事件。
                SelectionKey next = iterator.next();
                //判断事件是否准备就绪
                if(next.isAcceptable()){
                    //准备接受 获取客户端连接
                    SocketChannel accept = channel.accept();
                    //设置为阻塞事件
                    accept.configureBlocking(false);//异步非阻塞IO
                    //将该通道组册到服务器上。
                    accept.register(selector,SelectionKey.OP_READ);
                }else if(next.isReadable()){//判断当前的选择就绪的状态的通道。
                    SocketChannel channel1 = (SocketChannel)next.channel();//强制转为Socket通道
                    //读取数据
                    int len  = 0;
                    ByteBuffer allocate = ByteBuffer.allocate(1024);
                    while ((len  = channel1.read(allocate))>0){
                        allocate.flip();//开启读取模式
                        System.out.println(new String(allocate.array(),0,len));
                        allocate.clear();
                    }
                }
                iterator.remove();
            }
        }
    }
}
