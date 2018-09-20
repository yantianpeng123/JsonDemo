package com.itmayiedu.day01;

import java.util.List;

public class User {
    private Integer id;
    private String name;
    private AdressEntity Adress;
    private List<HobbyEntity> Hobby;

    public User() {
        System.out.println("使用JAVA反射机制获取无参的构造函数");
    }

    public User(Integer id, String name) {
        System.out.println("使用javaf反射机制获取有参数的构造函数");
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public AdressEntity getAdress() {
        return Adress;
    }

    public List<HobbyEntity> getHobby() {
        return Hobby;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAdress(AdressEntity adress) {
        Adress = adress;
    }

    public void setHobby(List<HobbyEntity> hobby) {
        Hobby = hobby;
    }
}
