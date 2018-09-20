package com.itmayiedu.day01;

@Table("student")//" "引号里面表示数据库的表的名字
public class StudentsEntity {
    @Perporty(name="student_id",length = 10)//name的值表示数据库的字段
    private String studentName;
    @Perporty(name = "student_name")//name的值表示数据库的字段
    private String studentId;
    @Perporty(name="student_age")//name的值表示数据库的字段
    private String studentAge;
    @Perporty(name = "student_weigth")
    private String studetWeigth;
}
