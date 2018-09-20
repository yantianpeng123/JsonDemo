package com.itmayiedu.day01;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

    /**
     * 表示该类是一个自定义注解类
     */
    @Target({ElementType.METHOD,ElementType.TYPE})//表示该主机的使用范围，methof表示只能在方法上面使用。
    @Retention(RetentionPolicy.RUNTIME)//表示该注解的生命周期。
    public @interface AutoDemo02 {
        int beaId () default 0;//加上默认值表示可以不传参数
        String ClassName () default "";
        String [] array();//没加上default 表示该参数必填。
    }
