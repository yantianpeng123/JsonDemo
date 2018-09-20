package com.itmayiedu.day01;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.lang.reflect.Field;
import java.util.List;

public class ClassPathXmlApplicationContext {
        private static String path;
        private static String ID;
        private static String CLASS;
        private static String NAME;
        private static String VALUE;
        private void init(){
            ID="id";
            CLASS ="class";
            NAME ="name";
            VALUE  ="value";
        }
        //通过构造函数读取文件xml
    public ClassPathXmlApplicationContext(String path) {
            init();
        this.path =path;
    }
    //通解析xml获取xml里面的值
    public static Object getBean(String beanId)throws Exception{
            //判断beanId是否是空
       if(isEmpty(beanId)){
          throw new Exception("beanId不能为空");
       }
       //读取xml文件
        SAXReader saxReader = new SAXReader();
        Document read = saxReader.read(path);
        Element rootElement = read.getRootElement();
        List<Element> elements = rootElement.elements();//获取根节点
        for (Element element:elements) {
            String id = element.attributeValue(ID);
            if(!id.equals(beanId)){
                //结束本次循环
                continue;
            }
            //从配置文件中获到bena
            String attClass = element.attributeValue(CLASS);
            //使用Java反射机制获取初始化类
           Class<?> forName = Class.forName(attClass);
            User user = (User)forName.newInstance();
            List<Element> Sonelement = element.elements();//获取二级节点
            for (Element Sonel: Sonelement) {
                String attrFiled = Sonel.attributeValue(NAME);
                String attributeValue = Sonel.attributeValue(VALUE);//给属性赋值
                Field declaredField = forName.getDeclaredField(attrFiled);
                declaredField.setAccessible(true);
                String type = declaredField.getType().getSimpleName();
                if("Integer".equals(type)){
                    declaredField.set(user,Integer.parseInt(attributeValue));
                }
                if("String".equals(type)){
                    declaredField.set(user,(attributeValue));
                }

            }
            return user;

        }
        return null;
    }

    /**
     * 判断是否为空
     * @param string
     * @return
     */
    public static boolean isEmpty(String string){
        if("".equals(string)||null ==string||string.trim().length()==0){
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext applicationContext =new
                ClassPathXmlApplicationContext("/Users/yantianpeng/Desktop/xmltext.txt");
        User user1 = (User)getBean("      ");
        System.out.println(user1.getId());
        System.out.println(user1.getName());
    }
}
