package com.code.boweb.bean;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlSeeAlso(OriginalData.class)
@XmlRootElement(name = "OriginalData")
public class OriginalData {

	
	/**
	 * <ODField object=""  literal =""></ODField>
     * <!--Can be multiple-->
	 */
	
	@XmlElement(name = "OBJODField")
	public ArrayList<String> odDataObjects;
	
	@XmlElement(name = "LITODField")
	private ArrayList<String> odDataLiterals;
	
	@XmlElement(name = "ODField")
	private ArrayList<String> odDataValues;

	/**
	 * @return the odDataObjects
	 */
	public ArrayList<String> getOdDatasObjects() {
		return odDataObjects;
	}

	/**
	 * @param odDataObjects the odDataObjects to set
	 */
	public void setOdDataObjects(ArrayList<String> odDataObjects) {
		this.odDataObjects = odDataObjects;
	}

	/**
	 * @return the odDataLiterals
	 */
	public ArrayList<String> getOdDatasLiterals() {
		return odDataLiterals;
	}

	/**
	 * @param odDataLiterals the odDataLiterals to set
	 */
	public void setOdDataLiterals(ArrayList<String> odDataLiterals) {
		this.odDataLiterals = odDataLiterals;
	}

	/**
	 * @return the odDataValues
	 */
	public ArrayList<String> getOdDatasValues() {
		return odDataValues;
	}

	/**
	 * @param odDataValues the odDataValues to set
	 */
	public void setOdDataValues(ArrayList<String> odDataValues) {
		this.odDataValues = odDataValues;
	}

	
		
}