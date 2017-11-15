//package insy;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class reader {

	public static void main(String[] args) {
		Document doc = null;
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			doc = builder.parse (new File("bookstore.xml"));
	        
			System.out.println(doc.getDocumentElement().getNodeName());
			NodeList list = doc.getElementsByTagName("book");
			for(int i = 0; i < list.getLength(); i++) {
				Node node = list.item(i);
				Element element = (Element)node;
				Element title = (Element) element.getElementsByTagName("title").item(0);
				Element year = (Element) element.getElementsByTagName("year").item(0);
				Element author = (Element) element.getElementsByTagName("author").item(0);
				System.out.println(title.getFirstChild().getTextContent() + " (" + element.getAttribute("category") + "), " + year + ", from " + author);
			}
		} catch (SAXParseException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
