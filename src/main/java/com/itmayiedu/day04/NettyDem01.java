package com.itmayiedu.day04;



import org.jboss.netty.bootstrap.ServerBootstrap;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.socket.nio.NioClientSocketChannelFactory;
import org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;
import org.jboss.netty.handler.codec.string.StringDecoder;
import org.jboss.netty.handler.codec.string.StringEncoder;

import java.net.InetSocketAddress;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * Netty服务器端
 */
public class NettyDem01 {
    public static void main(String[] args) {
        test01();
    }
    public static void test01(){
    //创建服务对象
       ServerBootstrap serverBootstrap =  new ServerBootstrap();
        //创建两个线程池 一个监听端口号 一个监听NIO
        ExecutorService boos = Executors.newCachedThreadPool();
        ExecutorService work = Executors.newCachedThreadPool();
        //线程池放入到工程组中
        serverBootstrap.setFactory(new NioServerSocketChannelFactory(boos,work));
        //谁管道工程
        serverBootstrap.setPipelineFactory(new ChannelPipelineFactory() {
            //设置管道
            @Override
            public ChannelPipeline getPipeline() throws Exception {
                ChannelPipeline pipeline = Channels.pipeline();
                pipeline.addLast("decoder",new StringDecoder());
                pipeline.addLast("encoder",new StringEncoder());
                pipeline.addLast("serverHandler",new ServerHandler());
                return pipeline;
            }
        });
        //绑定端口号
        serverBootstrap.bind(new InetSocketAddress(8990));
        System.out.println("Netty服务端启动");

        while (true){
            try{
                Thread.sleep(1000);
                System.out.println("每隔1秒打印一次");
            }catch (Exception ex){

            }
        }
    }
}
