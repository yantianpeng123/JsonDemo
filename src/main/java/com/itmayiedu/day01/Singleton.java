package com.itmayiedu.day01;

/**
 * 创建一个单例
 * 单例模式：  就是保证在JVM中只出现一次。
 *
 * 使用私有化构造起保证对象不能通过new的方式创建
 */
public class Singleton {

    private  static   Singleton singleton;
    //使用私有化构造表示当前的对象不能被实例化
    private Singleton(){

    }
    //懒汉式线程是不安全的可以使用 synchronized 保证线程安全但是此方法的效率很低的

    public static synchronized Singleton getInstance(){
        if(singleton==null){
            singleton = new Singleton();
        }
        return singleton;
    }
//使用双重锁机制保证线程的安全性同时不影响起效率
    public static Singleton getSingleton(){
        if(singleton==null){//第一层检验锁
            synchronized (Singleton.class){
                if(singleton ==null){//第二层上锁
                    singleton = new Singleton();
                }
            }
        }
        //当对象不是空的话就不考虑线程安全的问题了

        return singleton;
    }
}
