package com.itmayiedu.day01;

public class CarMain {
    public static void main(String[] args) {
      test02();
    }

    public static void test01(){
        Car car = CarFactory.createCar("奥迪");
        car.run();
    }
//创建奥迪特有的工厂。
    public static void test02(){
        Car car = AutoCarFactory.create();
        car.run();
    }
}
