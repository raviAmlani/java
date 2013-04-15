package com.code.boweb.bean;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlSeeAlso(AffectedData.class)
@XmlRootElement(name = "AffectedData")
public class AffectedData {

	
	/**
	 * <AData object=""  literal ="codMoneda">moneda</AData>
     * <!--Can be multiple-->
	 */
	
	@XmlAttribute(name = "object")
	public ArrayList<String> aDataObjects;
	
	@XmlAttribute(name = "literal")
	private ArrayList<String> aDataLiterals;
	
	@XmlElement(name = "AData")
	private ArrayList<String> aDataValues;

	
	/**
	 * @return the aDataObjects
	 */
	public ArrayList<String> getaDatasObjects() {
		return aDataObjects;
	}

	/**
	 * @param aDataObjects the aDataObjects to set
	 */
	public void setaDataObjects(ArrayList<String> aDataObjects) {
		this.aDataObjects = aDataObjects;
	}

	/**
	 * @return the aDataLiterals
	 */
	public ArrayList<String> getaDatasLiterals() {
		return aDataLiterals;
	}

	/**
	 * @param aDataLiterals the aDataLiterals to set
	 */
	public void setaDataLiterals(ArrayList<String> aDataLiterals) {
		this.aDataLiterals = aDataLiterals;
	}

	/**
	 * @return the aDataValues
	 */
	public ArrayList<String> getaDatasValues() {
		return aDataValues;
	}

	/**
	 * @param aDataValues the aDataValues to set
	 */
	public void setaDataValues(ArrayList<String> aDataValues) {
		this.aDataValues = aDataValues;
	}	
	
}