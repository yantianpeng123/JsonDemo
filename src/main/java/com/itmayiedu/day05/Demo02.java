package com.itmayiedu.day05;

import java.text.DecimalFormat;

public class Demo02 {
    public static void main(String[] args) throws Exception{
        byte [] byte01 = new byte[1*1024*1024];
        System.out.println("分配了1M内存");
        JvmInfo();
        Thread.sleep(5000);
        byte [] byte02 = new byte[4*1024*1024];
        System.out.println("分配了4M内存");
        JvmInfo();
    }

    /**
     * 转换成M
     * @param maxMemory
     * @return
     */
    private static String toM(Long maxMemory){
        Float num = (float)maxMemory/(1024*1024);
        DecimalFormat decimalFormat  = new DecimalFormat("0.00");
        return decimalFormat.format(num);
    }

    public static void JvmInfo(){
        long maxMemory = Runtime.getRuntime().maxMemory();//最大内存配置信息。
        System.out.println("最大内存配置信息: "+maxMemory+","+toM(maxMemory)+"M");
        //空闲空间
        long freeMemory = Runtime.getRuntime().freeMemory();
        System.out.println("空闲内存大小："+freeMemory+","+toM(freeMemory)+" M");
        long totalMemory = Runtime.getRuntime().totalMemory();//已经使用的内存空间大小
        System.out.println("已使用内存空间大小："+totalMemory+"，"+toM(totalMemory)+" M");

    }
}
