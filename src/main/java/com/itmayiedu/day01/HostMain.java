package com.itmayiedu.day01;

import net.sf.cglib.proxy.Enhancer;

import java.lang.reflect.Proxy;

public class HostMain {
    public static void main(String[] args) {
           // test02();
        test03();
    }

    /**
     * 静态代理对象
     */
    public static void test01(){
        new ProxySale(new ManSaleHost()).sale();
    }

    /**
     * 动态代理对象
     */
    public static void test02(){
        ManSaleHost manSaleHost = new ManSaleHost();
        JdkProxy jdkProxy = new JdkProxy(manSaleHost);
        Host o = (Host) Proxy.newProxyInstance(manSaleHost.getClass().getClassLoader(),
                manSaleHost.getClass().getInterfaces(), jdkProxy);
        o.sale();
    }
    /**
     * CGLIB动态代理
     */
    public static void test03(){
        Cglibproxyn cglibproxyn = new Cglibproxyn();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(ManSaleHost.class);
        enhancer.setCallback(cglibproxyn);
       ManSaleHost host = (ManSaleHost) enhancer.create();
       host.sale();

    }
}
