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
 *<br><b>@author </b> Ravi amlani
 *<br>
 *<br><b>Languaje:</b> java
 *<br>
 ********************************************************************** */

import java.io.File;
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

public class DOM_Writer_1 {

	public static void main(String argv[]) {
		 
		  try {
	 
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
	 
			// root elements
			Document doc = docBuilder.newDocument();
			Element rootElement = doc.createElement("company");
			doc.appendChild(rootElement);
	 
			// staff elements
			Element staff = doc.createElement("Staff");
			rootElement.appendChild(staff);
	 
			// set attribute to staff element
			Attr attr = doc.createAttribute("id");
			attr.setValue("1");
			staff.setAttributeNode(attr);
	 
			// shorten way
			// staff.setAttribute("id", "1");
	 
			// firstname elements
			Element firstname = doc.createElement("firstname");
			firstname.appendChild(doc.createTextNode("yong"));
			staff.appendChild(firstname);
	 
			 //create a comment and put it in the root element
            Comment comment = doc.createComment("Comment");
            staff.appendChild(comment);
			
			// lastname elements
			Element lastname = doc.createElement("lastname");
			lastname.appendChild(doc.createTextNode("mook kim"));
			staff.appendChild(lastname);
	 
			// nickname elements
			Element nickname = doc.createElement("nickname");
			nickname.appendChild(doc.createTextNode("mkyong"));
			
			staff.appendChild(nickname);
	 
			// salary elements
			Element salary = doc.createElement("salary");
			salary.appendChild(doc.createTextNode("10"));
			staff.appendChild(salary);
	 
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
		}
}

