package com.itmayiedu.day01;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * 自定义json字符串
 */
public class StringJson {
    public static void main(String[] args) {
       // test01();
        test02();
    }


    /**
     * 使用实体类封装json对象。或者json字符串
     */
    public static void test02(){
        TrackEntity track = new TrackEntity();
        List<detailEntity> detai = new ArrayList<detailEntity>();
        detailEntity detailEntity = new detailEntity();
        detailEntity.setMemo("Have not be sent Shenzhen HX logistics（深圳）");
        detailEntity.setLocation("Shenzhen HX logistics（深圳）");
        detailEntity.setTime("2017-01-06 21:05:13");
        detailEntity.setScantype("收件");
        detai.add(detailEntity);
        track.setBillcode("9660034086");
        track.setDetail(detai);
        System.out.println(new JSONObject().toJSONString(track));
    }
    /**
     * 自定义字符串
     */
    public static void test01(){
        JSONObject root = new JSONObject();//最外层
        JSONArray jsonArray = new JSONArray();//数据
        JSONObject object = new JSONObject();//
        object.put("billcode","9660034086");
        JSONArray detail =new JSONArray();
        JSONObject  object1 =  new JSONObject();
        object1.put("time","2017-01-06 21:05:13");
        object1.put("scantype","收件");
        object1.put("memo","Have not be sent Shenzhen HX logistics（深圳）");
        object1.put("location","Shenzhen HX logistics（深圳）");
        JSONObject  object2 =  new JSONObject();
        object2.put("time","2017-01-06 21:05:13");
        object2.put("scantype","收件");
        object2.put("memo","Have not be sent Shenzhen HX logistics（深圳）");
        object2.put("location","Shenzhen HX logistics（深圳）");
        detail.add(object1);
        detail.add(object2);
        object.put("detail",detail);
        root.put("track",object);
        System.out.println(root.toJSONString());
    }
}
