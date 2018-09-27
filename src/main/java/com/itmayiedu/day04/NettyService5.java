package com.itmayiedu.day04;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

/**
 * Netty5.0服务端
 */
public class NettyService5 {
    public static void main(String[] args) throws Exception {
        System.out.println("===================>>>>>>>>>服务端已经启动");
        //1.创建两个线程池，一个负责接受客户端，一个负责进行传输
        NioEventLoopGroup pgroup = new NioEventLoopGroup();
       NioEventLoopGroup cgroup  = new NioEventLoopGroup();
       //创建辅助类
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap.group(pgroup,cgroup).channel(NioServerSocketChannel.class).option(ChannelOption.SO_BACKLOG,1024)
                .option(ChannelOption.SO_SNDBUF,32*1024).option(ChannelOption.SO_RCVBUF,32*1024)
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        socketChannel.pipeline().addLast(new StringDecoder());
                        socketChannel.pipeline().addLast(new ServerHandler01());
                    }
                });

        ChannelFuture channelFuture = serverBootstrap.bind(9090).sync();
        channelFuture.channel().close().sync();
        pgroup.shutdownGracefully();
        cgroup.shutdownGracefully();

    }
}
