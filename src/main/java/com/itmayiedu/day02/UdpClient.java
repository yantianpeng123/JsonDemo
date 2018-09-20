package com.itmayiedu.day02;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/**
 * 使用UDP协议完成客户端和服务器端的通信
 */
public class UdpClient {
    public static void main(String[] args)throws Exception {
        test02();
    }

    public static void test02()throws Exception{
        System.out.println("===============>>>>>>UDP客户端启动");
        DatagramSocket datagramSocket = new DatagramSocket();//创建端口号
        Scanner scanner= new Scanner(System.in);
        String string = scanner.nextLine();
        byte[] bytes = string.getBytes();
        DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length, InetAddress.getByName("127.0.0.1"), 8998);
        datagramSocket.send(datagramPacket);
        System.out.println("===============>>>>>>>客户端请求结束");
        datagramSocket.close();

    }
}
