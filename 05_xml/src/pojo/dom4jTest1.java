package pojo;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.util.List;

public class dom4jTest1 {
    @Test
    public void Test1() throws DocumentException {
        //创建一个SAXReader输入流,来读取xml文件配置,生成document对象;
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read("src/books.xml");
        System.out.println(document);
    }

    /**
     * 读取books.xml文件,通过document获取根元素,通过根元素获取book标签对象,遍历处理每个book标签转换为book类;
     */
    @Test
    public void Test2() throws DocumentException{
        SAXReader reader = new SAXReader();
        Document read = reader.read("src/books.xml");
        Element rootElement = read.getRootElement();
//        System.out.println(rootElement);
        //element()和elements都是通过标签名查找子元素 带s用于多个子元素查找
        List<Element> book = rootElement.elements("book");
        for (Element element : book) {
            //asXML是把标签对象转化为标签字符串
//            System.out.println(element.asXML());
            Element name = element.element("name");
            Element price = element.element("price");
            Element author = element.element("author");

//            System.out.println(name.asXML());
            //getText()方法可以获取标签重的文本内容

            //System.out.println(name.getText().trim()+"\t\t\t"+price.getText().trim()+"\t\t\t"+author.getText().trim());

            //直接获取标签里的文本内容
            String name1 = element.elementText("name");
            String price1 = element.elementText("price");
            String author1 = element.elementText("author");
            String sn = element.attributeValue("sn");

            //把获取到的内容写进book类中
            System.out.println(new book(sn, name1, Double.parseDouble(price1), author1));
        }
    }
}
