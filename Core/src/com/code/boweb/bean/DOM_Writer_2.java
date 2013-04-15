/* ----------------------------------------------------------------
 * Nombre de la Clase:  DOM_Writer_1.java
 * Version: 1.0
 * Fecha:Apr 11, 2012
 * Empresa: 
 * Proyecto: OPM
 * Desarrollado por: Panel Sistemas Informaticos, S.L.
 * ----------------------------------------------------------------
 */
package com.code.boweb.bean;

/**********************************************************************
 * 
 *<br><b>Nombre Fichero:</b> DOM_Writer_1.java
 *<br>
 *<br><b>Descripcion:</b>
 *<pre>
 *</pre> 
 *<br><b>Fecha de creacion:</b>Apr 11, 2012
 *<br>
 *<br><b>@author </b> Ravi Amlani
 *<br>
 *<br><b>Languaje:</b> java
 *<br>
 ********************************************************************** */

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
 
import org.w3c.dom.Attr;
import org.w3c.dom.Comment;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.itextpdf.text.log.SysoLogger;

public class DOM_Writer_2 {

	/**
	 * Code Convention :
	 * * Name of the Elements - same as xml node name
	 * * Name of Objects - same as xml node name followed by underscore. 
	 */
	
	EDRS edrs_obj = null;
	
	public static void main(String argv[]) {
		 
		DOM_Writer_2 domWriter = new DOM_Writer_2();
		
		domWriter.readXML();
		domWriter.writeXML();
		
	} // main() ends...

	private void readXML() {
		
		XMLReader xmlReader = new XMLReader("PP_CONSULTA_HAPPY1.xml", "SEARCH");
		EDR edr_obj = xmlReader.getEdr();
		ArrayList<EDR> listOfEDR = new ArrayList<EDR>();
		listOfEDR.clear();
		EDR edr2_obj = edr_obj;
		listOfEDR.add(edr_obj);
		listOfEDR.add(edr2_obj);
		
		edrs_obj = new EDRS();
		edrs_obj.setListOfEDR(listOfEDR);
		
		System.out.println("*********** READING ENDS ******************************************");
		
	} // readXML() ends...

	private void writeXML() {

		try {
			  
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
	 
			// root elements
			Document doc = docBuilder.newDocument();
			Element edrs = doc.createElement(Constant.EDRS);
			doc.appendChild(edrs);
	 
			ArrayList<EDR> edr_list_obj = edrs_obj.getListsOfEDR();
			System.out.println(edrs_obj.getListsOfEDR().size());
			
			
			for(int i=0; i < edrs_obj.getListsOfEDR().size(); i++){
				
				
				EDR edr_obj = edr_list_obj.get(i);
				
				// EDR elements
				Element edr = doc.createElement(Constant.EDR);
				edrs.appendChild(edr);
				
				Element actionCode = doc.createElement(Constant.ACTION_CODE);
				actionCode.appendChild(doc.createTextNode(edr_obj.getActionCode()));
				edr.appendChild(actionCode);
				
				Element opType = doc.createElement(Constant.OPERATION_TYPE);
				opType.appendChild(doc.createTextNode(edr_obj.getOperationType()));
				edr.appendChild(opType);
				
				Element transNo = doc.createElement(Constant.TRANSACTION_SEQ_NUMBER);
				transNo.appendChild(doc.createTextNode(edr_obj.getTransactionSequenceNumber()==null?"":edr_obj.getTransactionSequenceNumber()));
				edr.appendChild(transNo);
				
				Element desc = doc.createElement(Constant.DESCRIPTION);
				desc.appendChild(doc.createTextNode(edr_obj.getDescription()==null?"":edr_obj.getDescription()));
				edr.appendChild(desc);
				
				Element interpreter = doc.createElement(Constant.INTERPRETER);
				interpreter.appendChild(doc.createTextNode(edr_obj.getInterpreter()));
				edr.appendChild(interpreter);
				
				 //create a comment and put it in the root element
	            Comment comment = doc.createComment("Comment");
	            edr.appendChild(comment);
	            
	            Element xmlObjs = doc.createElement(Constant.XML_OBJECTS);
	            for(String str : edr_obj.getXmlObjects().getXmlObjectsValues()){
	            	
	            	Element xmlObj = doc.createElement(Constant.XML_OBJECT);
	            	xmlObj.appendChild(doc.createTextNode(str==null?"":str));
	            	xmlObjs.appendChild(xmlObj);
	            }
	            edr.appendChild(xmlObjs);
	            
	            Element affectedData = doc.createElement(Constant.AFFECTED_DATA);
	            int index = 0;
	            for(String str : edr_obj.getAffectedData().getaDatasValues()){
	            	
	            	
	            	Element aData = doc.createElement(Constant.A_DATA);
	            	aData.appendChild(doc.createTextNode(str==null?"":str));
	            	affectedData.appendChild(aData);
	            	
	            	// Setting attribs to AData
	    			Attr attr = doc.createAttribute(Constant.OBJECT);
	    			attr.setValue(edr_obj.getAffectedData().getaDatasObjects().get(index));
	    			aData.setAttributeNode(attr);
	    			
	    			attr = doc.createAttribute(Constant.LITERAL);
	    			attr.setValue(edr_obj.getAffectedData().getaDatasLiterals().get(index));
	    			aData.setAttributeNode(attr);
	            	
	    			index += 1;
	            }
	            edr.appendChild(affectedData);
	            
	            Element originalData = doc.createElement(Constant.ORIGINAL_DATA);
	            index = 0;
	            for(String str : edr_obj.getOriginalData().getOdDatasValues()){
	            	
	            	
	            	Element odField = doc.createElement(Constant.OD_FIELD);
	            	odField.appendChild(doc.createTextNode(str==null?"":str));
	            	originalData.appendChild(odField);
	            	
	            	// Setting attribs to odField
	    			Attr attr = doc.createAttribute(Constant.OBJECT);
	    			attr.setValue(edr_obj.getOriginalData().getOdDatasObjects().get(index));
	    			odField.setAttributeNode(attr);
	    			
	    			attr = doc.createAttribute(Constant.LITERAL);
	    			attr.setValue(edr_obj.getOriginalData().getOdDatasLiterals().get(index));
	    			odField.setAttributeNode(attr);
	            	
	    			index += 1;
	            }
	            edr.appendChild(originalData);
	            
	            Element newData = doc.createElement(Constant.NEW_DATA);
	            index = 0;
	            for(String str : edr_obj.getNewData().getndDataValues()){
	            	
	            	
	            	Element ndField = doc.createElement(Constant.ND_FIELD);
	            	ndField.appendChild(doc.createTextNode(str==null?"":str));
	            	newData.appendChild(ndField);
	            	
	            	// Setting attribs to ndField
	    			Attr attr = doc.createAttribute(Constant.OBJECT);
	    			attr.setValue(edr_obj.getNewData().getndDataObjects().get(index));
	    			ndField.setAttributeNode(attr);
	    			
	    			attr = doc.createAttribute(Constant.LITERAL);
	    			attr.setValue(edr_obj.getNewData().getndDataLiterals().get(index));
	    			ndField.setAttributeNode(attr);
	            	
	    			index += 1;
	            }
	            edr.appendChild(newData);
				
			}
			
	 
			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			
			StreamResult result = new StreamResult(new File("D:\\DOM_file.xml"));
			transformer.transform(source, result);
			System.out.println("File saved!");
			
			result =  new StreamResult(System.out);
			transformer.transform(source, result);
	 
	 
		  } catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		  } catch (TransformerException tfe) {
			tfe.printStackTrace();
		  }
	
	} // writeXML() ends...
}

