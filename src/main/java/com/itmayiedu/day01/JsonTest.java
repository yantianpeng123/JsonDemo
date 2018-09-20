package com.itmayiedu.day01;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * json解析
 */
public class JsonTest {
    public static void main(String[] args) {
            //test02();
        //test03();
        test04();
    }

    /**
     * json转对象2
     */
    public static void test04(){
        String json ="{\"track\":[{\"billcode\":\"9660034086\",\"detail\":[{\"time\":\"2017-01-06 21:05:13\",\"scantype\":\"收件\",\"memo\":\"Have not be sent Shenzhen HX logistics（深圳）\",\"location\":\"Shenzhen HX logistics（深圳）\"},{\"time\":\"2017-01-06 21:11:37\",\"scantype\":\"已录包裹信息\",\"memo\":\"托运资讯发送给FedEx\",\"location\":\"\"},{\"time\":\"2017-01-07 10:13:11\",\"scantype\":\"到件\",\"memo\":\"Arrived AT Shenzhen Operation Centre(深圳分拨中心）\",\"location\":\"Shenzhen Operation Centre(深圳分拨中心）\"},{\"time\":\"2017-01-07 11:50:59\",\"scantype\":\"出货\",\"memo\":\"Shipemtns were sent Shenzhen Operation Centre(深圳分拨中心）\",\"location\":\"Shenzhen Operation Centre(深圳分拨中心）\"},{\"time\":\"2017-01-09 14:57:00\",\"scantype\":\"代理已取件\",\"memo\":\"已取件\",\"location\":\"KWUN TONG HK\"},{\"time\":\"2017-01-09 20:20:00\",\"scantype\":\"代理状态\",\"memo\":\"已离开发件地FedEx站点\",\"location\":\"KWUN TONG HK\"},{\"time\":\"2017-01-10 01:16:00\",\"scantype\":\"代理状态\",\"memo\":\"正在运输\",\"location\":\"LANTAU ISLAND HK\"},{\"time\":\"2017-01-10 18:45:00\",\"scantype\":\"代理状态\",\"memo\":\"正在运输\",\"location\":\"CHICAGO, IL\"},{\"time\":\"2017-01-11 04:11:00\",\"scantype\":\"代理已取件\",\"memo\":\"到达联邦快递工作地点\",\"location\":\"MEMPHIS, TN\"},{\"time\":\"2017-01-11 10:01:00\",\"scantype\":\"代理状态\",\"memo\":\"国际货物放行 - 进口\",\"location\":\"MEMPHIS, TN\"},{\"time\":\"2017-01-11 15:23:00\",\"scantype\":\"代理状态\",\"memo\":\"离开联邦快递工作地点\",\"location\":\"MEMPHIS, TN\"},{\"time\":\"2017-01-11 18:06:00\",\"scantype\":\"代理状态\",\"memo\":\"位于目的地分拣中心\",\"location\":\"BALTIMORE, MD\"},{\"time\":\"2017-01-12 08:02:00\",\"scantype\":\"代理状态\",\"memo\":\"位于当地的FedEx工作地点\",\"location\":\"LINTHICUM HEIGHTS, MD\"},{\"time\":\"2017-01-12 08:07:00\",\"scantype\":\"代理状态\",\"memo\":\"货件已装车，派送途中\",\"location\":\"LINTHICUM HEIGHTS, MD\"},{\"time\":\"2017-01-12 09:48:00\",\"scantype\":\"签收\",\"memo\":\"已送达\",\"location\":\"JESSUP, MD\"}]}]}";
        RootEntity rootEntity = JSONObject.parseObject(json, RootEntity.class);
        List<TrackEntity> track = rootEntity.getTrack();
        for (int i = 0; i <track.size() ; i++) {
               System.out.println("billcode:"+ track.get(i).getBillcode());
               System.out.println();
            List<detailEntity> detail = track.get(i).getDetail();
            for (detailEntity detailEntity:detail) {
                System.out.println(detailEntity.getLocation());
                System.out.println(detailEntity.getMemo());
                System.out.println(detailEntity.getScantype());
                System.out.println(detailEntity.getTime());
                System.out.println();
            }
        }

    }

    /**
     * json 转对象1
     */
    public static void test03(){
        String json ="{\"id\":1,\"name\":\"闫天蓬\",\"Adress\":{\"provice\":\"河南省\",\"city\":\"鹿邑县\",\"area\":\"王皮六镇\"},\"Hobby\":[{\"Category\":\"篮球\",\"Name\":\"运动\"},{\"Category\":\"听歌\",\"Name\":\"音乐\"}]}";
        User user = JSONObject.parseObject(json, User.class);
        Integer id = user.getId();
        System.out.println("id: "+id);
        System.out.println("Name:"+user.getName());
        AdressEntity adress = user.getAdress();
        System.out.println("provice: "+adress.getProvice());
        System.out.println("city:"+adress.getCity());
        System.out.println("area"+adress.getArea());
        List<HobbyEntity> hobbys = user.getHobby();
        for (HobbyEntity hobbyEntity:hobbys) {
            System.out.println("Name:"+hobbyEntity.getName());
            System.out.println("category"+hobbyEntity.getCategory());
        }
    }


    /**
     * json数据解析2
     */
    public static void test02(){
        String json ="{\"track\":[{\"billcode\":\"9660034086\",\"detail\":[{\"time\":\"2017-01-0621:05:13\",\"scantype\":\"收件\",\"memo\":\"HavenotbesentShenzhenHXlogistics（深圳）\",\"location\":\"ShenzhenHXlogistics（深圳）\"},{\"time\":\"2017-01-0621:11:37\",\"scantype\":\"已录包裹信息\",\"memo\":\"托运资讯发送给FedEx\",\"location\":\"\"},{\"time\":\"2017-01-0710:13:11\",\"scantype\":\"到件\",\"memo\":\"ArrivedATShenzhenOperationCentre(深圳分拨中心）\",\"location\":\"ShenzhenOperationCentre(深圳分拨中心）\"},{\"time\":\"2017-01-0711:50:59\",\"scantype\":\"出货\",\"memo\":\"ShipemtnsweresentShenzhenOperationCentre(深圳分拨中心）\",\"location\":\"ShenzhenOperationCentre(深圳分拨中心）\"},{\"time\":\"2017-01-0914:57:00\",\"scantype\":\"代理已取件\",\"memo\":\"已取件\",\"location\":\"KWUNTONGHK\"},{\"time\":\"2017-01-0920:20:00\",\"scantype\":\"代理状态\",\"memo\":\"已离开发件地FedEx站点\",\"location\":\"KWUNTONGHK\"},{\"time\":\"2017-01-1001:16:00\",\"scantype\":\"代理状态\",\"memo\":\"正在运输\",\"location\":\"LANTAUISLANDHK\"},{\"time\":\"2017-01-1018:45:00\",\"scantype\":\"代理状态\",\"memo\":\"正在运输\",\"location\":\"CHICAGO,IL\"},{\"time\":\"2017-01-1104:11:00\",\"scantype\":\"代理已取件\",\"memo\":\"到达联邦快递工作地点\",\"location\":\"MEMPHIS,TN\"},{\"time\":\"2017-01-1110:01:00\",\"scantype\":\"代理状态\",\"memo\":\"国际货物放行-进口\",\"location\":\"MEMPHIS,TN\"},{\"time\":\"2017-01-1115:23:00\",\"scantype\":\"代理状态\",\"memo\":\"离开联邦快递工作地点\",\"location\":\"MEMPHIS,TN\"},{\"time\":\"2017-01-1118:06:00\",\"scantype\":\"代理状态\",\"memo\":\"位于目的地分拣中心\",\"location\":\"BALTIMORE,MD\"},{\"time\":\"2017-01-1208:02:00\",\"scantype\":\"代理状态\",\"memo\":\"位于当地的FedEx工作地点\",\"location\":\"LINTHICUMHEIGHTS,MD\"},{\"time\":\"2017-01-1208:07:00\",\"scantype\":\"代理状态\",\"memo\":\"货件已装车，派送途中\",\"location\":\"LINTHICUMHEIGHTS,MD\"},{\"time\":\"2017-01-1209:48:00\",\"scantype\":\"签收\",\"memo\":\"已送达\",\"location\":\"JESSUP,MD\"}]}]}";
        JSONObject jsonObject = JSONObject.parseObject(json);
        JSONArray track = jsonObject.getJSONArray("track");
        for (int i = 0; i <track.size() ; i++) {
            JSONObject jsonObject1 = track.getJSONObject(i);
            String billcode = jsonObject1.getString("billcode");
            System.out.println("billcode:"+billcode);
            System.out.println();
            JSONArray detail = jsonObject1.getJSONArray("detail");
            for (int j = 0; j <detail.size() ; j++) {
                JSONObject detailJSONObject = detail.getJSONObject(i);
                String memo = detailJSONObject.getString("memo");
                System.out.println("memo:"+memo);
                String location = detailJSONObject.getString("location");
                System.out.println("location:"+location);
                String time = detailJSONObject.getString("time");
                System.out.println("time:"+time);
                String scantype = detailJSONObject.getString("scantype");
                System.out.println("scantype:"+scantype);
                System.out.println();
            }

        }
    }

    /**
     * json解析1
     */
    public static void test01(){
        String json ="{\"id\":1,\"name\":\"闫天蓬\",\"Adress\":{\"provice\":\"河南省\",\"city\":\"鹿邑县\",\"area\":\"王皮六镇\"},\"Hobby\":[{\"Category\":\"篮球\",\"Name\":\"运动\"},{\"Category\":\"听歌\",\"Name\":\"音乐\"}]}";
        JSONObject jsonObject = JSONObject.parseObject(json);
        Integer id= (Integer)jsonObject.get("id");
        System.out.println("id:"+id);
        String name = (String )jsonObject.get("name");
        System.out.println("name:"+name);
        JSONObject adress =(JSONObject) jsonObject.get("Adress");
        String provice = adress.getString("provice");
        System.out.println("provice:"+provice);
        String city = adress.getString("city");
        System.out.println("city:"+city);
        String area = adress.getString("area");
        System.out.println("area:"+area);
        JSONArray hobby = jsonObject.getJSONArray("Hobby");
        for (int i = 0; i <hobby.size() ; i++) {
            String category = hobby.getJSONObject(i).getString("Category");
            System.out.println("Category:"+category);
            String name1 = hobby.getJSONObject(i).getString("Name");
            System.out.println("Name:"+name1);
        }
        System.out.println(jsonObject);
    }
}



