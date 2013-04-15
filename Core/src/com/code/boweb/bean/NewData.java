
package com.code.boweb.bean;

import java.util.ArrayList;

public class NewData {

	
	/**
	 * <NDField object=""  literal =""></NDField>
     * <!--Can be multiple-->
	 */
	
	public ArrayList<String> ndDataObjects;
	
	public ArrayList<String> ndDataLiterals;
	
	public ArrayList<String> ndDataValues;

	
	/**
	 * @return the ndDataObjects
	 */
	public ArrayList<String> getndDataObjects() {
		return ndDataObjects;
	}

	/**
	 * @param ndDataObjects the ndDataObjects to set
	 */
	public void setndDataObjects(ArrayList<String> ndDataObjects) {
		this.ndDataObjects = ndDataObjects;
	}

	/**
	 * @return the ndDataLiterals
	 */
	public ArrayList<String> getndDataLiterals() {
		return ndDataLiterals;
	}

	/**
	 * @param ndDataLiterals the ndDataLiterals to set
	 */
	public void setndDataLiterals(ArrayList<String> ndDataLiterals) {
		this.ndDataLiterals = ndDataLiterals;
	}

	/**
	 * @return the ndDataValues
	 */
	public ArrayList<String> getndDataValues() {
		return ndDataValues;
	}

	/**
	 * @param ndDataValues the ndDataValues to set
	 */
	public void setndDataValues(ArrayList<String> ndDataValues) {
		this.ndDataValues = ndDataValues;
	}	
	
}