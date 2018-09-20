package com.itmayiedu.day01;



import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 *
 * Java的反射机制
 */
public class InvokeJava {

    public static void main(String[] args) throws Exception{
             //test01();
            // test02();
             test03();
       // test04();
    }
//使用Java的无参数的构造获取类的实例对象。
    public static void test01()throws Exception{
        Class<?> forName = Class.forName("com.itmayiedu.day01.User");//这里必须写类的全路径。
        User user = (User)forName.newInstance();//调用的是类的无参的构造函数，要是仅用Java的反射机制的时候只需要吧无参数的构造函数修饰符改成private；
        user.setId(1);
        user.setName("name");
    }
    //使用java的有参数的构造函数获取类的实力化
    public static void test02()throws Exception {
        Class<?> forName = Class.forName("com.itmayiedu.day01.User");
        //使用有参数的构造函数
        Constructor<?> constructor = forName.getConstructor(Integer.class, String.class);
        User user1 = (User) constructor.newInstance(1, "12233");
        System.out.println(user1.getName());
        System.out.println(user1.getId());
    }
    //获取当前类的所有的属性和方法
    public static void test03()throws Exception {
        Class<?> forName = Class.forName("com.itmayiedu.day01.User");
        Field[] declaredFields = forName.getDeclaredFields();//获取当前累的的所有的属性
        for (Field field:declaredFields) {
            System.out.println(Modifier.toString(field.getModifiers())+" "+field.getType().getSimpleName()+" "+field.getName());
        }
        System.out.println();
        Method[] declaredMethods = forName.getDeclaredMethods();//获取当前类的所有的方法
        for (Method method:declaredMethods) {
           System.out.println(Modifier.toString(method.getModifiers())+" "+method.getReturnType().getSimpleName()+" "+" "+method.getName()
           +"("+")");
        }
    }

    public static void test04() throws Exception{
        Class<?> forName = Class.forName("com.itmayiedu.day01.User");
        User newInstance = (User)forName.newInstance();
        Field[] declaredFields = forName.getDeclaredFields();
        for (Field field:declaredFields) {
            Field declaredField = forName.getDeclaredField(field.getName());
            declaredField.setAccessible(true);//私有属性必须设置此属性是true
            Class<?> type = declaredField.getType();
            if("Integer".equals(type.getSimpleName())){
                declaredField.set(newInstance,1);
            }
            if("String".equals(type.getSimpleName())){
                declaredField.set(newInstance,"ioioi");
            }
        }
        System.out.println(newInstance.getName());
        System.out.println(newInstance.getId());
    }

}
