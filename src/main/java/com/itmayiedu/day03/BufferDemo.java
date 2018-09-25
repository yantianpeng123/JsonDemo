package com.itmayiedu.day03;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.nio.channels.FileChannel.MapMode;

/**
 * 缓冲区的概念：
 *    private int mark = -1;
 *     private int position = 0;缓冲区正在操作的位置
 *     private int limit;缓存区可用大小。
 *     private int capacity;  缓冲区最大容量。
 *
 *     核心方法：
 *      put（）：存放数据到到缓存区。
 *      get（）：获取缓存区的数据。
 */
public class BufferDemo {


    private ByteBuffer allocate;

    @Test
    public void test01(){
        //初始化buffer容量。
        allocate = ByteBuffer.allocate(1024);
        System.out.println("=======>>>>>>缓存区可用大小："+ allocate.limit());
        System.out.println("==========>>>>缓冲区正在操作的位置："+ allocate.position());
        System.out.println("==========>>>>>缓存区最大的容量："+ allocate.capacity());
        System.out.println("==========>>>>缓冲区存放数据：");
        allocate.put("1234567".getBytes());
        System.out.println("=======>>>>>>缓存区可用大小："+ allocate.limit());
        System.out.println("==========>>>>缓冲区正在操作的位置："+ allocate.position());
        System.out.println("==========>>>>>缓存区最大的容量："+ allocate.capacity());
        allocate.flip();//开启读取模式

        byte [] bytes = new byte[allocate.limit()];
        allocate.get(bytes);
        System.out.println("==========>>>>>>读取的数据是："+new String(bytes,0,bytes.length));
        System.out.println("==========>>>>>>>重复读取");
        allocate.rewind();//开启重复读取模式
        byte [] bytes1 = new byte[allocate.limit()];
        allocate.get(bytes1);
        System.out.println("==========>>>>>>读取的数据是："+new String(bytes1,0,bytes1.length));
        System.out.println("清空缓冲区："+allocate.clear());
        System.out.println("=======>>>>>>缓存区可用大小："+ allocate.limit());
        System.out.println("==========>>>>缓冲区正在操作的位置："+ allocate.position());
        System.out.println("==========>>>>>缓存区最大的容量："+ allocate.capacity());
        System.out.println((char)allocate.get());
    }

    @Test
    public void  test02(){
        ByteBuffer byteBuffer =ByteBuffer.allocate(10);//初始化，Byte的容量设置为10，
        byteBuffer.put("abcdefg".getBytes());
        byteBuffer.flip();//开启读写模式
        byte [] bytes = new byte[byteBuffer.limit()];
        byteBuffer.get(bytes,0,2);
        byteBuffer.mark();//做一个标记
        System.out.println(new String (bytes,0,2));
        System.out.println(byteBuffer.position());
        System.out.println("===============>>>>>>>>>");
        byteBuffer.get(bytes,2,2);
        System.out.println(new String(bytes,0,2));
        byteBuffer.reset();//恢复到mark位置标记
        System.out.println(byteBuffer.position());
    }
    //非直接缓存区读写操作
    @Test
    public void test03()throws Exception{
        //读入流
        FileInputStream fileInputStream = new FileInputStream("/Users/yantianpeng/Desktop/11.png");
        //写入流
        FileOutputStream fileOutputStream = new FileOutputStream("/Users/yantianpeng/Desktop/2.png");
        //创建读入通道
        FileChannel channel = fileInputStream.getChannel();
        //创建写入通道
        FileChannel channel1 = fileOutputStream.getChannel();//非缓存区读取操作
        //分配指定大小缓存区
        ByteBuffer allocate = ByteBuffer.allocate(1024);
        while (channel.read(allocate)!=-1){
            //开启读写模式
            allocate.flip();
            channel1.write(allocate);
            allocate.clear();//buffer必须clear
        }
        channel1.close();
        channel.close();
        fileOutputStream.close();
        fileOutputStream.close();
    }

    //直接缓存区读写操作
    @Test
    public void test04() throws Exception{
        //创建读的管道
        FileChannel open = FileChannel.open(Paths.get("/Users/yantianpeng/Desktop/11.png"), StandardOpenOption.READ);
        //创建写的管道
        FileChannel open1 = FileChannel.open(Paths.get("/Users/yantianpeng/Desktop/2.png"), StandardOpenOption.READ,StandardOpenOption.WRITE, StandardOpenOption.CREATE);
        //定义映射文件直接操作缓存区
        MappedByteBuffer inmappedByteBuffer = open.map(MapMode.READ_ONLY, 0, open.size());
        MappedByteBuffer outmappedByteBuffer1 = open1.map(MapMode.READ_WRITE, 0, open1.size());
        //直接缓存去操作；
        byte[] bytes = new byte[inmappedByteBuffer.limit()];
        inmappedByteBuffer.get(bytes);
        outmappedByteBuffer1.put(bytes);
        open.close();
        open1.close();


    }
}
