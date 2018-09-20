package com.itmayiedu.day01;

/**
 * 手写实现Spring框架IOC的原理
 */
public class IOCDemo01 {
    public static void main(String[] args) {
        String string ="java.lang.String";
        System.out.println(string.substring(string.lastIndexOf(".")+1));
    }
}
