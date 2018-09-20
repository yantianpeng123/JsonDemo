package com.itmayiedu.day01;

public class SingletonMain {

    public static void main(String[] args) {
       test01();
       test02();
    }

    public static void test02(){
        Singleton3 instance1 = Singleton3.getInstance();
        Singleton3 instance2 = Singleton3.getInstance();
        System.out.println(instance1==instance2);
    }

    public static void test01(){
        Singleton instance1 = Singleton.getInstance();
        Singleton instance2=  Singleton.getInstance();
        System.out.println(instance1==instance2);//返回true表示当前对象返回的是同一个对象。
    }
}
