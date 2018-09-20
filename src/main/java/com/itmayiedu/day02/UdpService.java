package com.itmayiedu.day02;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * UDP协议服务端
 */
public class UdpService {

    public static void main(String[] args) throws Exception{
       // test02();
        test01();
    }

    public static void test01()throws Exception{
        System.out.println("==============>>>>>>UDP服务器启动");
        DatagramSocket datagramSocket = new DatagramSocket(8998);//创建端口号
        byte[]  bytes =new byte[1024];//接受字节数
        DatagramPacket datagramPacket = new DatagramPacket(bytes,bytes.length);//定义数据包
        datagramSocket.receive(datagramPacket);//接受客户端请求，将数据封装给数据包，如果客户端不往服务端发送请求，该方法就一直阻塞。
        System.out.println("来源IP："+datagramSocket.getInetAddress()+" 来源端口号："+datagramSocket.getPort());
        String result = new String(datagramPacket.getData(),0,datagramPacket.getLength());
        System.out.println(result);
        datagramSocket.close();
    }


}
