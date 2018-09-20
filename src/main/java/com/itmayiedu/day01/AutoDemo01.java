package com.itmayiedu.day01;

/**
 * 内置注解的功能
 */

public class AutoDemo01 {

    public static void main(String[] args) {

    }

    @Deprecated
    @AutoDemo02(array = {"111","222"})//表示引用该注解
    public static void test01(){

    }
}
