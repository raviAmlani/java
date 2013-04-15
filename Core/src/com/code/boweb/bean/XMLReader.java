
package com.code.boweb.bean;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.util.ArrayList;

 
public class XMLReader 
{
	String xmlFilePath;
	String operationType;
	public XMLReader(String filePath,String Types)
	 {
		 xmlFilePath = filePath;
		 operationType = Types;		 
	 } 
	public EDR getEdr()
	{
		EDR edr = null;
		XMLObjects xmlObject = new XMLObjects();
		ArrayList<EDR> list_Of_EDR = new ArrayList<EDR>();
		
 	  try 
	  {
		File fXmlFile = new File(xmlFilePath);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		//ArrayList<Edrs> edr = new ArrayList<Edrs>();
		
		
		Document doc = dBuilder.parse(fXmlFile);
		doc.getDocumentElement().normalize();
 
		Node nodeMain = doc.getDocumentElement();
		System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
		NodeList nList = doc.getElementsByTagName("EDR");
		System.out.println("-----------------------");
	
		System.out.println(nList.getLength());						
		
		for (int temp = 0; temp < nList.getLength(); temp++) 
		{
						
			Node nNode = nList.item(temp);   
		   if (nNode.getNodeType() == Node.ELEMENT_NODE) {
 
		      Element eElement = (Element) nNode;
		      if(getTagValue("OperationType", eElement).toUpperCase().matches(operationType.toUpperCase()))		     
		     	{		     	  			     			      
			      System.out.println("Error.....................");
		    	  /*edrs.setActionCode(getTagValue("ActionCode", eElement));
			      edrs.setOperationType(getTagValue("OperationType", eElement));
			      edrs.setDescription(getTagValue("Description", eElement));
			      edrs.setInterpreter(getTagValue("Interpreter", eElement));*/
			      
			      edr = parseEDR(nNode);	
			      
//			      System.out.println("+++++++++++++++"+ edr.getOriginalMultipleData().getOmdDataList().size());
			      
			      /**
			       * CTRL+Z UPTO HERE
			       */
			      
			     /* System.out.println("+++++++++++++++"+ edr.getNewMultipleData().getNmdList().size());
			      
			      System.out.println(edr.getNewMultipleData().getNmdList());
			      System.out.println("\n");
			      System.out.println(edr.getNewMultipleData().getNmdList().get(0).getNmdNameObjects());
			      
			      System.out.println(edr.getNewMultipleData().getNmdList().get(0).getNmdNameDataLiterals());
			      System.out.println(edr.getNewMultipleData().getNmdList().get(0).getNmdNameDataValues());
			      System.out.println("\n");
			      System.out.println(edr.getNewMultipleData().getNmdList().get(0).getNmdNumberObjects());
			      System.out.println(edr.getNewMultipleData().getNmdList().get(0).getNmdNumberDataLiterals());
			      System.out.println(edr.getNewMultipleData().getNmdList().get(0).getNmdNumberDataValues());			      
			      System.out.println("\n");
			      System.out.println(edr.getNewMultipleData().getNmdList().get(0).getNmdRecord().getNmdRecordDataObjects());
			      System.out.println(edr.getNewMultipleData().getNmdList().get(0).getNmdRecord().getNmdRecordDataLiterals());
			      System.out.println(edr.getNewMultipleData().getNmdList().get(0).getNmdRecord().getNmdRecordDataValues());*/
			      
			      list_Of_EDR.add(edr);
		      	}
		   }
		   
		}
	  } catch (Exception e) {
		e.printStackTrace();
	  }
 	  return edr;
  }
 
private static EDR parseEDR(Node node){
		
		System.out.println("\nInside parseEDR(), NodeName : "+node.getNodeName());
		NodeList nodes = node.getChildNodes();
		Element eElement = (Element) node;
		ArrayList<String> xmlObjectsValue = new ArrayList<String>();
		EDR edr = new EDR();
		
		if(nodes != null)
		{
			System.out.println("nodes.getLength() : "+nodes.getLength());
			//System.out.println("nodes :::: "+nodes.i);
			
			for (int i = 0; i < nodes.getLength(); i++)
			{
				
//				System.out.println(" i is ::-->> " +i + " Node is ::-->> " + nodes.item(i).getNodeName());
				
				if(!nodes.item(i).getNodeName().equalsIgnoreCase("#text"))
				{					 
					if(nodes.item(i).getNodeName().equalsIgnoreCase("ActionCode"))
					{				 						
						edr.setActionCode(getTagValue("ActionCode", eElement));
					}
					else if(nodes.item(i).getNodeName().equalsIgnoreCase("OperationType"))
					{						 						
						edr.setOperationType(getTagValue("OperationType", eElement));
					}
					else if(nodes.item(i).getNodeName().equalsIgnoreCase("Description"))
					{																	
						edr.setDescription(getTagValue("Description", eElement));						
					}
					else if(nodes.item(i).getNodeName().equalsIgnoreCase("Interpreter"))
					{											
						edr.setInterpreter(getTagValue("Interpreter", eElement));
					}
					else if(nodes.item(i).getNodeName().equalsIgnoreCase("XMLObjects"))
					{						
						edr=parseXMLObjects(nodes.item(i), edr);
					}
					else if(nodes.item(i).getNodeName().equalsIgnoreCase("AffectedData"))
					{						
						edr=parseAffectedData(nodes.item(i), edr);
					}
					else if(nodes.item(i).getNodeName().equalsIgnoreCase("OriginalData"))
					{						
						edr=parseOriginalData(nodes.item(i), edr);
					}
					/*else if(nodes.item(i).getNodeName().equalsIgnoreCase("OriginalMultipleData"))
					{						
						edr=parseOMDData(nodes.item(i), edr);
//						parseOMDData(nodes.item(i), edr);
					}*/
					else if(nodes.item(i).getNodeName().equalsIgnoreCase("NewData"))
					{						
						edr=parseNewData(nodes.item(i), edr);
					}
					/*else if(nodes.item(i).getNodeName().equalsIgnoreCase("NewMultipleData"))
					{						
						edr=parseNMDData(nodes.item(i), edr);
					}*/
				} 
			} 
		}
		return edr;
	}





private static EDR parseNMDData(Node NewMultipleDatanode, EDR edr)
{

	System.out.println("\nInside NewMultipleDatanode(), NodeName : "+NewMultipleDatanode.getNodeName());
	
	NewMultipleData newMultipleData = new NewMultipleData();
	NmdData nmdData = new NmdData();
	NmdRecord nmdRecord = new NmdRecord();
	
	ArrayList<NmdData> nmdDataList = new ArrayList<NmdData>();					
			
	ArrayList<String> nmdNameObjectsList = new ArrayList<String>();					
	ArrayList<String> nmdNameDataLiteralsList = new ArrayList<String>();		
	ArrayList<String> nmdNameDataValuesList = new ArrayList<String>();
	
	ArrayList<String> nmdNumberObjectsList = new ArrayList<String>();					
	ArrayList<String> nmdNumberDataLiteralsList = new ArrayList<String>();		
	ArrayList<String> nmdNumberDataValuesList = new ArrayList<String>();
	
	ArrayList<String> nmdRecordDataObjectsList = new ArrayList<String>();					
	ArrayList<String> nmdRecordDataLiteralsList = new ArrayList<String>();		
	ArrayList<String> nmdRecordDataValuesList = new ArrayList<String>();
	
	if(NewMultipleDatanode.hasChildNodes())
	{
		
		NodeList childList = NewMultipleDatanode.getChildNodes(); // newMultipleDatanode Child List
	
		for(int childNum=0;childNum<childList.getLength();childNum++)
		{
			if(!(childList.item(childNum).getNodeName().equalsIgnoreCase("#text")) && !(childList.item(childNum).getNodeName().equalsIgnoreCase("#comment")) && (childList.item(childNum).getNodeName().equalsIgnoreCase("NMD")))
			{
				NodeList innerchildList1 = childList.item(childNum).getChildNodes();
				
				System.out.println(innerchildList1);
				System.out.println(innerchildList1.getLength());
				
				for (int innerChildNum=0;innerChildNum<innerchildList1.getLength();innerChildNum++)
				{
					if(!(innerchildList1.item(innerChildNum).getNodeName().equalsIgnoreCase("#text")) && !(innerchildList1.item(innerChildNum).getNodeName().equalsIgnoreCase("#comment")))
					{
						Element e = (Element) innerchildList1.item(innerChildNum);
						
						if ((innerchildList1.item(innerChildNum).getNodeName().equalsIgnoreCase("NMDName")))
						{
							System.out.println(e.getAttribute("object"));	
							nmdNameObjectsList.add(e.getAttribute("object"));
							System.out.println(e.getAttribute("literal"));
							nmdNameDataLiteralsList.add(e.getAttribute("literal"));
							if (e.hasChildNodes())
							{
								System.out.println(e.getFirstChild().getNodeValue());
								nmdNameDataValuesList.add(e.getFirstChild().getNodeValue());
							}
							else
							{
								
							}														
						}					
						else if ((innerchildList1.item(innerChildNum).getNodeName().equalsIgnoreCase("NMDnumber")))
						{
							System.out.println(e.getAttribute("object"));			
							nmdNumberObjectsList.add(e.getAttribute("object"));
							System.out.println(e.getAttribute("literal"));
							nmdNumberDataLiteralsList.add(e.getAttribute("literal"));
							if (e.hasChildNodes())
							{
								System.out.println(e.getFirstChild().getNodeValue());
								nmdNumberDataValuesList.add(e.getFirstChild().getNodeValue());
							}
							else
							{
								
							}									
						}
						else if ((innerchildList1.item(innerChildNum).getNodeName().equalsIgnoreCase("NMDRecord")))
						{
							
							NodeList innerchildList2 = innerchildList1.item(innerChildNum).getChildNodes();
							
							System.out.println(innerchildList2);
							System.out.println(innerchildList2.getLength());
							
							for (int innerChildNum1=0;innerChildNum1<innerchildList2.getLength();innerChildNum1++)
							{
								if(!(innerchildList2.item(innerChildNum1).getNodeName().equalsIgnoreCase("#text")) && !(innerchildList2.item(innerChildNum1).getNodeName().equalsIgnoreCase("#comment")))
								{
									Element e1 = (Element) innerchildList2.item(innerChildNum1);
									
									if ((innerchildList2.item(innerChildNum1).getNodeName().equalsIgnoreCase("NMDField")))
									{
										System.out.println(e1.getAttribute("object"));		
										nmdRecordDataObjectsList.add(e1.getAttribute("object"));
										System.out.println(e1.getAttribute("literal"));
										nmdRecordDataLiteralsList.add(e1.getAttribute("literal"));
										if (e1.hasChildNodes())
										{
											System.out.println(e1.getFirstChild().getNodeValue());
											nmdRecordDataValuesList.add(e1.getFirstChild().getNodeValue());
										}
										else
										{
											
										}														
									}
								}
							}
																					
						}
						
					}				
				}
				nmdRecord.setNmdRecordDataObjects(nmdRecordDataObjectsList);
				nmdRecord.setNmdRecordDataLiterals(nmdRecordDataLiteralsList);
				nmdRecord.setNmdRecordDataValues(nmdRecordDataValuesList);
				
				nmdData.setNmdRecord(nmdRecord);
				
				nmdData.setNmdNameObjects(nmdNameObjectsList);
				nmdData.setNmdNameDataLiterals(nmdNameDataLiteralsList);
				nmdData.setNmdNameDataValues(nmdNameDataValuesList);
				
				nmdData.setNmdNumberObjects(nmdNumberObjectsList);
				nmdData.setNmdNumberDataLiterals(nmdNumberDataLiteralsList);
				nmdData.setNmdNumberDataValues(nmdNumberDataValuesList);
				
				nmdDataList.add(nmdData);				
		}	
	}
  }
	newMultipleData.setNmdList(nmdDataList);
//	edr.setNewMultipleData(newMultipleData);
	return edr;
}




private static EDR parseOMDData(Node OriginalMultipleDatanode, EDR edr)
{

	System.out.println("\nInside AffectedDatanode(), NodeName : "+OriginalMultipleDatanode.getNodeName());
	
	OriginalMultipleData originalMultipleData = new OriginalMultipleData();
	OmdData omdData = null;
	OmdRecord omdRecord = null;
	
	ArrayList<OmdData> omdDataList = new ArrayList<OmdData>();					
			
	String OmdNameObjects = null;					
	String OmdNameDataLiterals= null;		
	String OmdNameDataValues = null;
	
	String OmdNumberObjects = null;					
	String OmdNumberDataLiterals = null;		
	String OmdNumberDataValues = null;
	
	ArrayList<String> omdRecordDataObjectsList = new ArrayList<String>();					
	ArrayList<String> omdRecordDataLiteralsList = new ArrayList<String>();		
	ArrayList<String> omdRecordDataValuesList = new ArrayList<String>();
	
	if(OriginalMultipleDatanode.hasChildNodes())
	{
		
		NodeList childList = OriginalMultipleDatanode.getChildNodes(); // originalMultipleData Child List
	
		for(int childNum=0;childNum<childList.getLength();childNum++)
		{
			if(!(childList.item(childNum).getNodeName().equalsIgnoreCase("#text")) && !(childList.item(childNum).getNodeName().equalsIgnoreCase("#comment")) && (childList.item(childNum).getNodeName().equalsIgnoreCase("OMD")))
			{
				NodeList innerchildList1 = childList.item(childNum).getChildNodes();
				
				omdData = new OmdData();
				
				System.out.println(innerchildList1);
				System.out.println(innerchildList1.getLength());
				
				for (int innerChildNum=0;innerChildNum<innerchildList1.getLength();innerChildNum++)
				{
					if(!(innerchildList1.item(innerChildNum).getNodeName().equalsIgnoreCase("#text")) && !(innerchildList1.item(innerChildNum).getNodeName().equalsIgnoreCase("#comment")))
					{
						Element e = (Element) innerchildList1.item(innerChildNum);
						
						if ((innerchildList1.item(innerChildNum).getNodeName().equalsIgnoreCase("OMDName")))
						{
							System.out.println(e.getAttribute("object"));					
							OmdNameObjects = (e.getAttribute("object"));
							System.out.println(e.getAttribute("literal"));
							OmdNameDataLiterals = (e.getAttribute("literal"));
							if (e.hasChildNodes())
							{
								System.out.println(e.getFirstChild().getNodeValue());
								OmdNameDataValues = (e.getFirstChild().getNodeValue());
							}
							else
							{
								
							}														
						}					
						else if ((innerchildList1.item(innerChildNum).getNodeName().equalsIgnoreCase("Number")))
						{
							System.out.println(e.getAttribute("object"));	
							OmdNumberObjects = (e.getAttribute("object"));
							System.out.println(e.getAttribute("literal"));
							OmdNumberDataLiterals = (e.getAttribute("literal"));
							if (e.hasChildNodes())
							{
								System.out.println(e.getFirstChild().getNodeValue());
								OmdNumberDataValues = (e.getFirstChild().getNodeValue());
							}
							else
							{
								
							}									
						}
						else if ((innerchildList1.item(innerChildNum).getNodeName().equalsIgnoreCase("Record")))
						{
							
							NodeList innerchildList2 = innerchildList1.item(innerChildNum).getChildNodes();
							
							omdRecord = new OmdRecord();
							
							System.out.println(innerchildList2);
							System.out.println(innerchildList2.getLength());
							
							for (int innerChildNum1=0;innerChildNum1<innerchildList2.getLength();innerChildNum1++)
							{
								if(!(innerchildList2.item(innerChildNum1).getNodeName().equalsIgnoreCase("#text")) && !(innerchildList2.item(innerChildNum1).getNodeName().equalsIgnoreCase("#comment")))
								{
									Element e1 = (Element) innerchildList2.item(innerChildNum1);
									
									if ((innerchildList2.item(innerChildNum1).getNodeName().equalsIgnoreCase("OMDField")))
									{
										System.out.println(e1.getAttribute("object"));		
										omdRecordDataObjectsList.add(e1.getAttribute("object"));
										System.out.println(e1.getAttribute("literal"));
										omdRecordDataLiteralsList.add(e1.getAttribute("literal"));
										if (e1.hasChildNodes())
										{
											System.out.println(e1.getFirstChild().getNodeValue());
											omdRecordDataValuesList.add(e1.getFirstChild().getNodeValue());
										}
										else
										{
											
										}														
									}
								}
							}
						}
					}				
				}
				//
				omdRecord.setOmdRecordDataObjects(omdRecordDataObjectsList);
				omdRecord.setOmdRecordDataLiterals(omdRecordDataLiteralsList);
				omdRecord.setOmdRecordDataValues(omdRecordDataValuesList);
				
				omdData.setOmdRecord(omdRecord);
				
				omdData.setOmdNameObjects(OmdNameObjects);
				omdData.setOmdNameDataLiterals(OmdNameDataLiterals);
				omdData.setOmdNameDataValues(OmdNameDataValues);
				
				omdData.setOmdNumberObjects(OmdNumberObjects);
				omdData.setOmdNumberDataLiterals(OmdNumberDataLiterals);
				omdData.setOmdNumberDataValues(OmdNumberDataValues);
				
				omdDataList.add(omdData);
				System.out.println("+++++++++++++++"+ omdDataList.size());
		}	
	}
  }
	originalMultipleData.setOmdDataList(omdDataList);
	System.out.println("+++++++++++++++"+ originalMultipleData.getOmdDataList().size());
//	edr.setOriginalMultipleData(originalMultipleData);
	System.out.println("+++++++++++++++"+ originalMultipleData.getOmdDataList().size());
//	System.out.println("&&&&&&&&&&&&&&&&&"+edr.getOriginalMultipleData());
	
	return edr;
}



private static EDR parseNewData(Node NewDatanode, EDR edr)
{

	System.out.println("\nInside AffectedDatanode(), NodeName : "+NewDatanode.getNodeName());
	
	NewData newData = new NewData();
	
	ArrayList<String> ndDataObjects = new ArrayList<String>();					
	ArrayList<String> ndDataLiterals = new ArrayList<String>();		
	ArrayList<String> ndDataValues = new ArrayList<String>();
			
	
	if(NewDatanode.hasChildNodes())
	{
	
		NodeList childList = NewDatanode.getChildNodes(); // XMLObjects Child List
		System.out.println("Children of XMLObjects : "+childList.getLength());
		
		for(int childNum=0;childNum<childList.getLength();childNum++)
		{
			if(!(childList.item(childNum).getNodeName().equalsIgnoreCase("#text")) && !(childList.item(childNum).getNodeName().equalsIgnoreCase("#comment"))){
			
				System.out.println(childList.item(childNum).getNodeName());
				Element e = (Element) childList.item(childNum);
				System.out.println(e.getAttribute("object"));
				ndDataObjects.add(e.getAttribute("object"));
				System.out.println(e.getAttribute("literal"));
				ndDataLiterals.add(e.getAttribute("literal"));				
				if (e.hasChildNodes())
				{
					ndDataValues.add(e.getFirstChild().getNodeValue());
				}
				else
				{
					ndDataValues.add("");
				}
				
			}				
		}	
	}
	
	newData.setndDataLiterals(ndDataLiterals);
	newData.setndDataObjects(ndDataObjects);
	newData.setndDataValues(ndDataValues);
			
	edr.setNewData(newData);
	
	return edr;
}





	private static EDR parseOriginalData(Node OriginalDatanode, EDR edr)
	{

		System.out.println("\nInside AffectedDatanode(), NodeName : "+OriginalDatanode.getNodeName());
		
		OriginalData originalData = new OriginalData();
		
		ArrayList<String> odDataObjects = new ArrayList<String>();					
		ArrayList<String> odDataLiterals = new ArrayList<String>();		
		ArrayList<String> odDataValues = new ArrayList<String>();
				
		
		if(OriginalDatanode.hasChildNodes())
		{
		
			NodeList childList = OriginalDatanode.getChildNodes(); // XMLObjects Child List
			System.out.println("Children of XMLObjects : "+childList.getLength());
			
			for(int childNum=0;childNum<childList.getLength();childNum++)
			{
				if(!(childList.item(childNum).getNodeName().equalsIgnoreCase("#text")) && !(childList.item(childNum).getNodeName().equalsIgnoreCase("#comment"))){
				
					System.out.println(childList.item(childNum).getNodeName());
					Element e = (Element) childList.item(childNum);
					System.out.println(e.getAttribute("object"));
					odDataObjects.add(e.getAttribute("object"));
					System.out.println(e.getAttribute("literal"));
					odDataLiterals.add(e.getAttribute("literal"));
//					System.out.println(e.getFirstChild().getNodeValue());
					if (e.hasChildNodes())
					{
						odDataValues.add(e.getFirstChild().getNodeValue());
					}
					else
					{
						odDataValues.add("");
					}
				}				
			}	
		}
		
		originalData.setOdDataObjects(odDataObjects);
		originalData.setOdDataLiterals(odDataLiterals);
		originalData.setOdDataValues(odDataValues);
				
		edr.setOriginalData(originalData);
		
		return edr;
}		

	
	
	private static EDR parseAffectedData(Node AffectedDatanode, EDR edr)
	{

		System.out.println("\nInside AffectedDatanode(), NodeName : "+AffectedDatanode.getNodeName());
		
		AffectedData affectedData = new AffectedData();
		
		ArrayList<String> aDataObjects = new ArrayList<String>();					
		ArrayList<String> aDataLiterals = new ArrayList<String>();		
		ArrayList<String> aDataValues = new ArrayList<String>();
		
		if(AffectedDatanode.hasChildNodes())
		{
		
			NodeList childList = AffectedDatanode.getChildNodes(); // XMLObjects Child List
			System.out.println("Children of XMLObjects : "+childList.getLength());
			
			for(int childNum=0;childNum<childList.getLength();childNum++)
			{
				if(!(childList.item(childNum).getNodeName().equalsIgnoreCase("#text")) && !(childList.item(childNum).getNodeName().equalsIgnoreCase("#comment"))){
				
					System.out.println(childList.item(childNum).getNodeName());
					Element e = (Element) childList.item(childNum);
					aDataObjects.add(e.getAttribute("object"));
					aDataLiterals.add(e.getAttribute("literal"));
					if (e.hasChildNodes())
					{
						aDataValues.add(e.getFirstChild().getNodeValue());
					}
					else
					{
						aDataValues.add("");
					}
				}				
			}
			
		}
		
		affectedData.setaDataObjects(aDataObjects);
		affectedData.setaDataLiterals(aDataLiterals);
		affectedData.setaDataValues(aDataValues);
				
		edr.setAffectedData(affectedData);
		
		return edr;
	}		


	private static EDR parseXMLObjects(Node XMLObjectsnode, EDR edr)
	{
	
		System.out.println("\nInside parseXMLObjects(), NodeName : "+XMLObjectsnode.getNodeName());
		XMLObjects xmlObjects = new XMLObjects();		
		ArrayList<String> xmlObjectsValue = new ArrayList<String>();
		int i=0;
		if(XMLObjectsnode.hasChildNodes()){
		
		NodeList childList = XMLObjectsnode.getChildNodes(); // XMLObjects Child List
		System.out.println("Children of XMLObjects : "+childList.getLength());
		
		for(int childNum=0; childNum < childList.getLength(); childNum++)
		{			
			if(childList.item(childNum).getNodeName().equalsIgnoreCase("XMLObject"))
			{				
				Node temp = childList.item(childNum);
				if(!(temp.getNodeName().equalsIgnoreCase("#text")) && !(temp.getNodeName().equalsIgnoreCase("#comment")))
				{					
					Element e = (Element)temp;									
					if (e.hasChildNodes())
					{
						xmlObjectsValue.add(e.getFirstChild().getNodeValue());
					}
					else
					{
						xmlObjectsValue.add("");
					}
				}
			}
		}		
	}
		for(String str : xmlObjectsValue){
			System.out.println(" -- "+str);
		}
		xmlObjects.setXmlObjectValues(xmlObjectsValue);
		edr.setXmlObjects(xmlObjects);
//		System.out.println(xmlObjects.getXmlObjectValues().size());
		return edr;
}

  private static String getTagValue(String sTag, Element eElement) 
  {
 	NodeList nlList = eElement.getElementsByTagName(sTag).item(0).getChildNodes();
    Node nValue = (Node) nlList.item(0);
 	return nValue.getNodeValue();
  }
}