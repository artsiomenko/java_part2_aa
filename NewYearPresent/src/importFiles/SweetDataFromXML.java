package importFiles;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.util.ArrayList;

import candies.Sweet;

public class SweetDataFromXML {
	private static final String file_name = "sweets.xml";
	
	public static ArrayList<Sweet> getSweetFromXML() {
		ArrayList<Sweet> sweets = new ArrayList<Sweet>();
		try {

			File fXmlFile = new File(file_name);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			
			doc.getDocumentElement().normalize();

			NodeList nList = doc.getElementsByTagName("sweet");

			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					sweets.add(new Sweet(eElement.getElementsByTagName("name").item(0).getTextContent(),
										 Integer.parseInt(eElement.getElementsByTagName("weight").item(0).getTextContent())));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sweets;
	}
}
