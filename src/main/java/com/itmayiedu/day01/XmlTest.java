    package com.itmayiedu.day01;

    import org.dom4j.Attribute;
    import org.dom4j.Document;
    import org.dom4j.Element;
    import org.dom4j.io.SAXReader;

    import java.util.Iterator;
    import java.util.List;

    /**
     * 解析xml
     */
    public class XmlTest {

        public static void main(String[] args) throws Exception{
            test01();
        }
        public static void test01() throws Exception{
                ///Users/yantianpeng/Desktop/xmltest.txt;
            //h获取都读取对象。
            SAXReader saxReader = new SAXReader();
            Document document = saxReader.read("/Users/yantianpeng/Desktop/xmltext.txt");
            Element rootElement = document.getRootElement();
            getNodes(rootElement);

        }
        //      获取节点并判断是否存在下一个节点
        public static void getNodes(Element rootElement){
            List<Attribute> attributes = rootElement.attributes();
            for (Attribute attribute:attributes) {
                System.out.println("属性的名字是："+attribute.getName()+"属性的值是："+attribute.getValue());
            }
            String textTrim = rootElement.getTextTrim();
            if(!"".equals(textTrim)){
                System.out.println("节点名称："+rootElement.getName()+" 节点Value："+textTrim);
            }
            Iterator<Element> elementIterator = rootElement.elementIterator();
            while (elementIterator.hasNext()){
                Element next = elementIterator.next();
                getNodes(next);//递归算法获取下一个节点。
            }
        }
    }
