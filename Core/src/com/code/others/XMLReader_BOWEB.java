
package com.code.others;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
 
public class XMLReader_BOWEB {
 
	public static void main(String argv[]) {
 
	  parseBOWEB_XML();
	}
 
	public static void parseBOWEB_XML() {

		try 
		  {
//			String path = FileSearch.xmlFilePath;   
	 		File fXmlFile = new File("PP_CONSULTA_HAPPY1.xml");
	 		System.out.println("File exists  : "+fXmlFile.exists());
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			
			Node node = doc.getDocumentElement();
	 
			System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
			
			NodeList nList = doc.getElementsByTagName("EDR");
			System.out.println("EDR Size -----------------------> "+nList.getLength());
			parseEDR(nList.item(0));
			parseEDR(nList.item(1));
			parseEDR(nList.item(2));
	 
			
		  } catch (Exception e) {
			e.printStackTrace();
		  }
	  
	}

	private static void parseXMLObjects(Node nodeImageGallery){
		
		System.out.println("\nInside parseXMLObjects(), NodeName : "+nodeImageGallery.getNodeName());
		if(nodeImageGallery.hasChildNodes()){
			
			NodeList childList = nodeImageGallery.getChildNodes(); //User List
			System.out.println("Children of XMLObjects : "+childList.getLength());
			
			for(int childNum=0; childNum < childList.getLength(); childNum++){
				
				if(childList.item(childNum).getNodeName().equalsIgnoreCase("XMLObject")){
					
					Node temp = childList.item(childNum);
					if(!(temp.getNodeName().equalsIgnoreCase("#text"))){
						
						Element el = (Element)temp;
						if(el.hasChildNodes()){
							String imageName = el.getFirstChild().getNodeValue();
							System.out.println("XMLObject --> "+childNum+" : "+imageName);	
						}else{
							System.out.println("XMLObject --> --- ");
						}
						
													
					}
				}
			}
		}	
	} // parseXMLObjects() ends...
	
	
	private static void parseEDR(Node node){
		
		System.out.println("\nInside parseEDR(), NodeName : "+node.getNodeName());
		NodeList nodes = node.getChildNodes();
		
		if(nodes != null)
		{
			System.out.println("nodes.getLength() : "+nodes.getLength());
			
			for (int i = 0; i < nodes.getLength(); i++)
			{
				if(!nodes.item(i).getNodeName().equalsIgnoreCase("#text")){
					if(nodes.item(i).getNodeName().equalsIgnoreCase("XMLObjects")){
						parseXMLObjects(nodes.item(i));
					} 
				} 
			} 
		}
	}
	
	private static String getTagValue(String sTag, Element eElement) 
	{
		NodeList nlList = eElement.getElementsByTagName(sTag).item(0).getChildNodes();
		Node nValue = (Node) nlList.item(0);
		return nValue.getNodeValue();
	}
}