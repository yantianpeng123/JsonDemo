package com.itmayiedu.day01;

public class CarFactory  {
    public static Car createCar(String name){
        Car car =null;
        switch (name){
            case "奥迪":
                car = new AutoCar();
            break;
            case "奔驰":
                car = new BenciCar();
                break;
                default:
                    break;
        }
        return car;
    }
}
