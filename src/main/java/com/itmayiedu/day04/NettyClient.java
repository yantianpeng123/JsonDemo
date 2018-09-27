package com.itmayiedu.day04;

import org.jboss.netty.bootstrap.ClientBootstrap;
import org.jboss.netty.channel.*;
import org.jboss.netty.channel.socket.nio.NioClientSocketChannelFactory;
import org.jboss.netty.handler.codec.string.StringDecoder;
import org.jboss.netty.handler.codec.string.StringEncoder;

import java.net.InetSocketAddress;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Netty 客户端
 */
public class NettyClient {


    public static void main(String[] args) {
        ClientBootstrap clientBootstrap= new ClientBootstrap();
        ExecutorService book = Executors.newCachedThreadPool();
        ExecutorService wook = Executors.newCachedThreadPool();
        clientBootstrap.setFactory(new NioClientSocketChannelFactory(book,wook));
        clientBootstrap.setPipelineFactory(new ChannelPipelineFactory() {
            @Override
            public ChannelPipeline getPipeline() throws Exception {
                ChannelPipeline pipeline = Channels.pipeline();
                pipeline.addLast("decoder",new StringDecoder());
                pipeline.addLast("encoder",new StringEncoder());
                pipeline.addLast("clientHandler",new ClientHandler());
                return pipeline;
            }
        });
        //绑定端口号
        ChannelFuture connect = clientBootstrap.connect(new InetSocketAddress("127.0.0.1", 8990));
        System.out.println("====================>>>>>>>>>>客户端已经启动。。");
        Channel channel = connect.getChannel();
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("===============>>>>>>>>>>>>>>请输入内容");
            channel.write(scanner.next());

        }
    }
}
