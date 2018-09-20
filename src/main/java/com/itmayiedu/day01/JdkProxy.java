package com.itmayiedu.day01;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class JdkProxy implements InvocationHandler {
    private Object target;
    public JdkProxy(Object target){
        this.target =target;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
       System.out.println("我是中介，开始监听你买房了");
        Object invoke = method.invoke(target, args);
        System.out.println("我是中介，结束监听你买房了");
        return invoke;
    }
}
