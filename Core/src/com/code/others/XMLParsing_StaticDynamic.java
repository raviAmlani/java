
/**
 * @author Ravi Amlani
 * @date 15Dec2011
 */

package com.code.others;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.CharacterData;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;


public class XMLParsing_StaticDynamic {

	public static void main(String[] args) {
		parseXML();
	}

	public static void parseXML() {

		ArrayList<User> users = new ArrayList<User>();
		User user;

		try {
//			URL url = new URL("http://192.168.1.32/autowebservice/autoservice.asmx/GetXML_FromMobile?Mobilestr=9033322126");
			URL url = new URL("http://delogico.com/AutoService.asmx/GetXML_FromMobile?Mobilestr=9033322126");
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(new InputSource(url.openStream()));
			
			
			NodeList nodes = doc.getElementsByTagName("Cars");
			System.out.println("-----> "+nodes.getLength());
			nodes = doc.getElementsByTagName("Users");
			System.out.println("-----> "+nodes.getLength());
			nodes = doc.getElementsByTagName("User");
			System.out.println("-----> "+nodes.getLength());
			nodes = doc.getElementsByTagName("Car");
			System.out.println("-----> "+nodes.getLength());
			
			
			for(int i=0;i<nodes.getLength();i++) { 
				Element element = (Element)nodes.item(i); 
				/*System.out.println("Title: " + getElementValue(element,"title")); 
				System.out.println("Link: " + getElementValue(element,"link")); 
				System.out.println("Publish Date: " + getElementValue(element,"pubDate")); 
				System.out.println("Author: " + getElementValue(element,"dc:creator")); 
				System.out.println("Description: " + getElementValue(element,"description")); 
				*/
				
				System.out.println(getElementValue(element,"ModalType"));
				
				
			}//for 
			
			System.out.println("/////////////////////////////////////////////////////////////////");
			
			Node node = doc.getDocumentElement();
			//NodeList nodes = doc.getElementsByTagName("User");
			if(node.getNodeType()==Node.DOCUMENT_NODE){
				System.out.println("doc node");
			}
			System.out.println("node type = "+node.getNodeType()+"-->"+node.getNodeName());
			parseNode(node);
			
			//System.out.println("nodes.getLength() --> "+nodes.getLength());
			
			/*for (int i = 0; i < nodes.getLength(); i++) {
				
				Element element = (Element) (nodes).item(i);
				user = new User();
				user.setFname(getElementValue(element, "fname"));
				user.setMname(getElementValue(element, "mname"));
				user.setLname(getElementValue(element, "lname"));
				users.add(user);
				System.out.println(user.getFname()+user.getMname()+user.getLname()); */
		} catch (Exception e) {
				System.out.println("XML Pasing Excpetion = " + e);
			}
		
			
	}

	private static String parseNode(Node node)throws IOException
    {
		
		NodeList nodes = null;
        if(node.getNodeType() == Node.DOCUMENT_NODE)
        {
            System.out.println("DOC NODE :( ");
       
        	nodes = node.getChildNodes();
        	if(nodes != null)
        	{
            for (int i = 0; i < nodes.getLength(); i++)
            {
                parseNode(nodes.item(i));
            	//system.out.println(" --> "+nodes.getLength()+"  "+nodes.item(i).getNodeName());
            }
        	}
        }
        else if(node.getNodeType() == Node.ELEMENT_NODE)
        {
            nodes = node.getChildNodes();
            if(nodes != null)
            {
                for (int i = 0; i < nodes.getLength(); i++)
                {
                	System.out.println("nodes.getLength() "+nodes.getLength());
                    //parseNode(nodes.item(i));
                	//System.out.println(" --> "+node.getNodeType()+"  "+nodes.getLength()+"  "+nodes.item(i).getNodeName());
                	if(!nodes.item(i).getNodeName().equalsIgnoreCase("#text")){
                		System.out.println("#text detected");
                		
                		if(nodes.item(i).getNodeName().equalsIgnoreCase("Users")){
                			System.out.println("1");
                			// Do nothing	
                			parseUsers(nodes.item(i));
                			//parseUsers_2(nodes.item(i));
                			
                		}else if(nodes.item(i).getNodeName().equalsIgnoreCase("User")){
                			System.out.println("2");
                			//parseIcons(nodes.item(i));
                		}else if(nodes.item(i).getNodeName().equalsIgnoreCase("Cars")){
                			System.out.println("3");
                			//parseInitialScreen(nodes.item(i));
                			parseCars(nodes.item(i));
                		}else if(nodes.item(i).getNodeName().equalsIgnoreCase("Car")){
                			System.out.println("4");
                			//parseMainMenu(nodes.item(i));
                		}
                		
                	} // Inner most IF ends...
                } // FOR LOOP ends...
            } // 2ND IF ends...
        } // 1ST IF ends...
        else if(node.getNodeType() == Node.TEXT_NODE)
        {
            if(node.getNodeValue().length()>0)
            {
                System.out.println(" # "+node.getNodeValue());
            }
        }
       
        return null;
    }
	
	private static void parseUsers_2(Node node){
		
	}
	
	private static void parseUsers(Node nodeImageGallery){
		
		System.out.println("\nINSIDE parseUsers()");
		if(nodeImageGallery.hasChildNodes()){
			NodeList childList = nodeImageGallery.getChildNodes(); //User List
			
			for(int childNum=0; childNum < childList.getLength(); childNum++){
				if(childList.item(childNum).getNodeName().equalsIgnoreCase("User")){
					//system.out.println(childList.item(childNum).getNodeName());//+" -> "+el.getFirstChild().getNodeValue());
					Node temp = childList.item(childNum);
					if(temp.hasChildNodes()){ // User
						NodeList tempChild = temp.getChildNodes();  // User's properties
						for(int j = 0; j < tempChild.getLength(); j++){ 
							if(!(tempChild.item(j).getNodeName().equalsIgnoreCase("#text"))){
								Element el = (Element)tempChild.item(j);
								//system.out.println(el.getNodeName()+" -> "+el.getFirstChild().getNodeValue());	
								
								// Now we'll build a query
								String imageName = el.getFirstChild().getNodeValue();
								System.out.println("--------------> "+imageName);
//								System.out.println("--- "+tempChild.item(j).getNodeName());
//								System.out.println("  - "+tempChild.item(j).getNodeValue());
															
							}
						}
					}
				}
			}
		}	
	} // parseVideoGallery() ends...
	
	private static void parseCars(Node nodeImageGallery){
		
		System.out.println("\nINSIDE parseCars()");
		if(nodeImageGallery.hasChildNodes()){
			NodeList childList = nodeImageGallery.getChildNodes(); //User List
			
			for(int childNum=0; childNum < childList.getLength(); childNum++){
				if(childList.item(childNum).getNodeName().equalsIgnoreCase("Car")){
					//system.out.println(childList.item(childNum).getNodeName());//+" -> "+el.getFirstChild().getNodeValue());
					Node temp = childList.item(childNum);
					if(temp.hasChildNodes()){ // Car
						NodeList tempChild = temp.getChildNodes();  // Car's properties
						for(int j = 0; j < tempChild.getLength(); j++){ 
							if(!(tempChild.item(j).getNodeName().equalsIgnoreCase("#text"))){
								Element el = (Element)tempChild.item(j);
								//system.out.println(el.getNodeName()+" -> "+el.getFirstChild().getNodeValue());	
								
								// Now we'll build a query
								String imageName = el.getFirstChild().getNodeValue();
								System.out.println("--------------> "+imageName);
															
							}
						}
					}
				}
			}
		}	
	} // parseVideoGallery() ends...
	
	private static String getCharacterDataFromElement(Element e) {
		try {
			Node child = e.getFirstChild();
			if (child instanceof CharacterData) {
				CharacterData cd = (CharacterData) child;
				return cd.getData();
			}
		} catch (Exception ex) {
		}
		return "";
	}

	protected float getFloat(String value) {
		if (value != null && !value.equals(""))
			return Float.parseFloat(value);
		else
			return 0;
	}

	protected static String getElementValue(Element parent, String label) {
		return getCharacterDataFromElement((Element) parent.getElementsByTagName(label).item(0));
	}
}


/*<Document>
<Users>
<User>
<FirstName>ronak</FirstName>
<MiddleName></MiddleName>
<SurName>shah</SurName>
<Address1>360</Address1>
<Address2>dungarpur</Address2>
<Address3></Address3>
<City>dungarpur</City>
<State>rajasthan</State>
<PostalCode>314001</PostalCode>
<EmailId>ron@gm.com</EmailId>
<PrimaryContact>123456</PrimaryContact>
<SecondryContact></SecondryContact>
</User>
</Users>
<Cars>
<Car>
<CarRegistrationNo>123</CarRegistrationNo>
<ModalType>bmwi8</ModalType>
<ModalSubType>8102</ModalSubType>
<ModalYear>2011</ModalYear>
<ChasisNumber>420</ChasisNumber>
<EngineNumber>582138172168273</EngineNumber>
<RTONumber>8912379127398173789739817937</RTONumber>
</Car>
<Car>
<CarRegistrationNo>789</CarRegistrationNo>
<ModalType>mercedes320d</ModalType>
<ModalSubType>378</ModalSubType>
<ModalYear>2010</ModalYear>
<ChasisNumber>42523</ChasisNumber>
<EngineNumber>1231212</EngineNumber>
<RTONumber>1231232323123</RTONumber>
</Car>
<Car>
<CarRegistrationNo>123</CarRegistrationNo>
<ModalType>bmwi8</ModalType>
<ModalSubType>8102</ModalSubType>
<ModalYear>2011</ModalYear>
<ChasisNumber>420</ChasisNumber>
<EngineNumber>582138172168273</EngineNumber>
<RTONumber>8912379127398173789739817937</RTONumber>
</Car>
</Cars>
</Document>*/