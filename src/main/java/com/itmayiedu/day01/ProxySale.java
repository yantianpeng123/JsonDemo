package com.itmayiedu.day01;

public class ProxySale implements Host {
    private ManSaleHost manSaleHost;
    public ProxySale(ManSaleHost manSaleHost){
     this.manSaleHost = manSaleHost;
    }
    @Override
    public  void sale() {
        System.out.println("我是中介，你买房的任务交给我了。。。");
        manSaleHost.sale();
        System.out.println("我是中介，，你的房子买好了");
    }
}
