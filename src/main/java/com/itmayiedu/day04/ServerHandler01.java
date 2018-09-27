package com.itmayiedu.day04;
import  io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

public class ServerHandler01 extends ChannelHandlerAdapter{
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("服务端收到客户端的数据："+(String)msg);
        //回复客户端数据
        ctx.write("11111");
        ctx.write("11111");
        ctx.flush();
    }
}
