package config;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;

public class XMLConfigurationProvider {

    public static String getValue(String keyName, String fileName) throws IOException {
        ClassLoader classLoader = XMLConfigurationProvider.class.getClassLoader();
        String value = null;
        try (InputStream inputStream = classLoader.getResourceAsStream(fileName)) {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document xmlDoc = builder.parse(inputStream);
//            System.out.println(xmlDoc.getDocumentElement().getElementsByTagName("key").item(0).getTextContent());
            Node key = xmlDoc.getElementsByTagName(keyName).item(0);
            Element eKey = (Element) key;
            value = eKey.getAttribute("value");
//            System.out.println(eKey.getAttribute("value"));
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
        return value;
    }

}

