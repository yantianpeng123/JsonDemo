package com.itmayiedu.day01;


/**
 *单例模式 饿汉式写法
 */
public class Singleton3 {
    //在类加载的时候实例化对象 不考虑线程的安全问题
    private static Singleton3 singleton3 =new Singleton3();
    //私有化构造器
    private Singleton3(){

    }
    //获取对象的实例化
    public static Singleton3 getInstance(){
        return singleton3;
    }
}
