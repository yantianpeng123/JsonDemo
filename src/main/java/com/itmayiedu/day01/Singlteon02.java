package com.itmayiedu.day01;

/**
 * 懒汉式单例模式
 * 通过私有化构造起的方式实现单例模式 保证JVM中只存在一个
 */
public class Singlteon02 {
    private static Singlteon02 singlteon02;//创建一个对象 赋值为空
    //私有化构造器
    private Singlteon02 (){

    }
    //通过该方式实例化对象 双重锁保证线程的安全性
    public static Singlteon02 getInstance(){
        if(singlteon02==null){
            synchronized (Singlteon02.class){
                if(singlteon02==null){
                    singlteon02 = new Singlteon02();
                }
            }
        }
        return  singlteon02;
    }

    //简单的单例模式线程不安全的
    public static Singlteon02 getSinglteon02(){
        if(singlteon02==null){
            singlteon02 = new Singlteon02();
        }
        return singlteon02;
    }
}
