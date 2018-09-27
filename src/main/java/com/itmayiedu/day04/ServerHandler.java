package com.itmayiedu.day04;

        import org.jboss.netty.channel.*;

public class ServerHandler extends SimpleChannelHandler {
    //接受客户端数据
    @Override
    public void messageReceived(ChannelHandlerContext ctx, MessageEvent e) throws Exception {
        super.messageReceived(ctx, e);
        System.out.println("================>>>>>>>>>+messageReceived");
        System.out.println("================>>>>>>>>服务端的数据："+e.getMessage());
    }
    //接受出现的异常
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, ExceptionEvent e) throws Exception {
        super.exceptionCaught(ctx, e);
    }
    //必须建立连接，关闭通道是才会触发
    @Override
    public void channelDisconnected(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception {
        super.channelDisconnected(ctx, e);
    }
    //通道别关闭的时候触发
    @Override
    public void channelClosed(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception {
        super.channelClosed(ctx, e);
    }
}

