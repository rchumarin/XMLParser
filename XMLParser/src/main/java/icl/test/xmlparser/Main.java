
package icl.test.xmlparser;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Main {

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException{
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = factory.newDocumentBuilder();
        Document doc = documentBuilder.parse(new File("src/myXmlConfig.xml"));
        
//        Element el = doc.getDocumentElement(); //возвращает класс описывающий элемент
//        String titleE1 = el.getNodeName(); //возвращает имя элемента
//        System.out.println("titleE1 = " + titleE1);
          
        String el = doc.getDocumentElement().getNodeName();
        System.out.println("titleE1 = " + el);
        
        //Node работает с одним элементом
        //NodeList содержит множество элементов
        //все что находится в элементе product
        NodeList nodeList = doc.getElementsByTagName("product"); 
        String title ="";
        int price = 0, amount = 0;
        
        String department = null;
        
        System.out.println("departments\ttitle\t\tprice\tamount");
        for(int i=0; i<nodeList.getLength(); i++) {
            Element element = (Element)nodeList.item(i);
            // самый первый title
            title = element.getElementsByTagName("title").item(0).getChildNodes().item(0).getNodeValue(); 
            price = Integer.parseInt(element.getElementsByTagName("price").item(0).getChildNodes().item(0).getNodeValue()); 
            amount = Integer.parseInt(element.getElementsByTagName("amount").item(0).getChildNodes().item(0).getNodeValue()); 

//            department = Integer.parseInt(element.getParentNode().getAttributes().getNamedItem("id").getNodeValue());
            department = element.getParentNode().getAttributes().getNamedItem("id").getNodeValue();
            System.out.println(department + "\t" + title + "\t" + price + "\t" + amount);
        }
        
    }
    
}
