package com.hibernateTest.tests;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

/**
 * Created by suay on 8/23/16.
 */
public class ReandAndWriteXMLTests {

    final static String TEST_XML = "src/test/resources/test.xml" ;


    @Test
    public void testReadXML(){

        try {
            File file = new File(TEST_XML);
            DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = dBuilder.parse(file);

            //optional, but recommended
            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("staff");

            for (int i = 0; i < nList.getLength(); i++){

                Node item = nList.item(i);

                if(item.getNodeType() == Node.ELEMENT_NODE){
                    Element element = (Element) item;
                    System.out.println("Staff id: "+ element.getAttribute("id"));
                    NodeList firstname = element.getElementsByTagName("firstname");
                    System.out.println("first name: " + firstname.item(0).getTextContent());
                }
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }

}
