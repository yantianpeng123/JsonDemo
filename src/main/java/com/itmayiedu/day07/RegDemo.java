package com.itmayiedu.day07;

public class RegDemo {
        public static void main(String[] args) {
            String str="广州市 荔 湾 区芳村花地大道坑口工业区A座二层（3L07D30PAU00858）更换机（深圳客服）";
            str=str.replaceAll("\\(.*?\\)|\\{.*?}|\\[.*?]|（.*?）", "").trim();
            System.out.println(str);
        }
}
