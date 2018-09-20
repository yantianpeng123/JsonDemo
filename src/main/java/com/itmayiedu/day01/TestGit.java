package com.itmayiedu.day01;

public class TestGit {
    public static void main(String[] args) {
        System.out.println("测试git数据的");
    }

    public static boolean isEmpty(String string){
        if(string.length()==0||"".equals(string)||null==string){
            return  true;
        }
        return false;
    }
}
