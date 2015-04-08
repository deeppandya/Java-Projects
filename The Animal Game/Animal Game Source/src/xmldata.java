import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class xmldata {
	ArrayList<points> list=new ArrayList<points>();
	public ArrayList<points> fromxml(){
		try {

			File stocks = new File("data.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

			Document doc = dBuilder.parse(stocks);

			doc.getDocumentElement().normalize();

			
			NodeList nodes = doc.getElementsByTagName("question");
			System.out.println("Game Start");
			//System.out.println(nodes.getLength());
			for (int i = 0; i < nodes.getLength(); i++) {
			Node node = nodes.item(i);

			if (node.getNodeType() == Node.ELEMENT_NODE) {
				
				Element element = (Element) node;
				list.add(new points(getValue("q"+(i+1), element), Integer.parseInt(getValue("yes", element)), Integer.parseInt(getValue("no", element))));
				}
			}
			

			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	private static String getValue(String tag, Element element) {
		NodeList nodes = element.getElementsByTagName(tag).item(0).getChildNodes();
		Node node = (Node) nodes.item(0);
			return node.getNodeValue();
		}
}
