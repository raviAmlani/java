package com.code.boweb.bean;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlSeeAlso(XMLObjects.class)
@XmlRootElement(name = "XMLObjects")
public class XMLObjects  
{
	@XmlElement(name = "XMLObject")
	public ArrayList<String> xmlObjectValues;
	
	public ArrayList<String> getXmlObjectsValues() 
	{
		return xmlObjectValues;
	}

	public void setXmlObjectValues(ArrayList<String> xmlObjectValues) 
	{
		this.xmlObjectValues = xmlObjectValues;
	}	
}
