package com.itmayiedu.day05;

import java.util.ArrayList;
import java.util.List;
//
///**
// * 新生代和老生代的区别
// * -Xmn新生代的大小一般设置为整个堆的三分之一到四分之一之间。
// * -XX：SurvivorRatio 设置新生代eden区和from/to空间的之间的比例关系N/1。
// * 设置新生代和老年代比例是一比三或者一比四
// */
public class Demo03 {

    private static int count = 0;
    //栈溢出ava.lang.StackOverflowError
    //栈溢出是方法递归调用不是循环调用。
    public static void getCount(){
       try{
           count++;
           getCount();
       }catch (Throwable throwable){
           System.out.println("最大的count："+count);
           throwable.printStackTrace();
       }
    }
    static class OOMObject{

    }
    public static void main(String[] args) {
        getCount();
        //test02();
    }
    //栈溢出
    public static void test04(){

    }

    public static void test01(){
        byte [] b = null;
        for (int i = 0; i <10 ; i++) {
            System.out.println("i:"+i);
            b = new byte[1*1024*1024];
        }
    }

//    /**
//     * 堆溢出的方式以及解决方案
//     * 在运行的时设置堆初始值为10M堆最大值为10M，就会出现堆内存溢出（ava heap space）
//     */
    public static void test02(){
        List<Object> list = new ArrayList();
        for (int i = 0; i <10 ; i++) {
            System.out.println("i:"+i);
            list.add(new byte[1*1024*1024]);
        }
        System.out.println("创建完毕。。");
    }
    //死循环会产生堆内存溢出Java heap space
    public static void test03(){
        ArrayList<Object> objects = new ArrayList<>();
        while (true){
            objects.add(new OOMObject());
        }
    }
}
