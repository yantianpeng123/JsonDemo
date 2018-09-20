package com.itmayiedu.day01;

import net.sf.cglib.proxy.MethodInterceptor;

import java.lang.reflect.Method;

public class Cglibproxyn implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, net.sf.cglib.proxy.MethodProxy methodProxy) throws Throwable {
        System.out.println("我是中介，开始监听你买房了");
        Object invoke = methodProxy.invokeSuper(o, objects);
        System.out.println("我是中介，结束监听你买房了");
        return invoke;
    }
}
