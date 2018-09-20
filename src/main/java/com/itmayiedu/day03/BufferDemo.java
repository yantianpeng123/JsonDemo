package com.itmayiedu.day03;

import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
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
        byteBuffer.reset();//恢复到mark位置标记
        byteBuffer.get(bytes,0,2);
        System.out.println(new String(bytes,0,2));
        System.out.println(byteBuffer.position());
    }
}
