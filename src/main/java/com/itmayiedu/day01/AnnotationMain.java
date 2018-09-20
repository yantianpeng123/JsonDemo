package com.itmayiedu.day01;


import java.lang.reflect.Field;

/**
 *  利用java的反射机制生成sql的拼接
 *  select student_id ,student_name,student_age from student;
 */
public class AnnotationMain {
    public static void main(String[] args) throws  Exception{
        StringBuffer  sb = new StringBuffer();//拼接的参数
        Class<?> forName = Class.forName("com.itmayiedu.day01.StudentsEntity");
        //获取类上边的注解
        Table table = forName.getDeclaredAnnotation(Table.class);
        sb.append("select");
        System.out.println(table.value());
        //获取属性上面的注解 先获取所有的属性。
        Field[] declaredFields = forName.getDeclaredFields();
        for (Field field:declaredFields) {
            Perporty perporty = field.getDeclaredAnnotation(Perporty.class);
            System.out.println(perporty.name());
           sb.append(" "+perporty.name()+", ");

        }
        sb.append(" from " +table.value());
        sb.replace(sb.lastIndexOf(","),sb.lastIndexOf(",")+1," ");
        System.out.println(sb.toString());
    }
}
