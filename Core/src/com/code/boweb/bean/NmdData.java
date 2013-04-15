package com.code.boweb.bean;

import java.util.ArrayList;

public class NmdData {

	public ArrayList<String> NmdNameObjects;
	public ArrayList<String> NmdNameDataLiterals;	
	public ArrayList<String> NmdNameDataValues;
	
	public ArrayList<String> NmdNumberObjects;	
	public ArrayList<String> NmdNumberDataLiterals;	
	public ArrayList<String> NmdNumberDataValues;
	
	NmdRecord nmdRecord = new NmdRecord();
	
	/**
	 * @return the nmdNameObjects
	 */
	public ArrayList<String> getNmdNameObjects() {
		return NmdNameObjects;
	}
	/**
	 * @param nmdNameObjects the nmdNameObjects to set
	 */
	public void setNmdNameObjects(ArrayList<String> nmdNameObjects) {
		NmdNameObjects = nmdNameObjects;
	}
	/**
	 * @return the nmdNameDataLiterals
	 */
	public ArrayList<String> getNmdNameDataLiterals() {
		return NmdNameDataLiterals;
	}
	/**
	 * @param nmdNameDataLiterals the nmdNameDataLiterals to set
	 */
	public void setNmdNameDataLiterals(ArrayList<String> nmdNameDataLiterals) {
		NmdNameDataLiterals = nmdNameDataLiterals;
	}
	/**
	 * @return the nmdNameDataValues
	 */
	public ArrayList<String> getNmdNameDataValues() {
		return NmdNameDataValues;
	}
	/**
	 * @param nmdNameDataValues the nmdNameDataValues to set
	 */
	public void setNmdNameDataValues(ArrayList<String> nmdNameDataValues) {
		NmdNameDataValues = nmdNameDataValues;
	}
	/**
	 * @return the nmdNumberObjects
	 */
	public ArrayList<String> getNmdNumberObjects() {
		return NmdNumberObjects;
	}
	/**
	 * @param nmdNumberObjects the nmdNumberObjects to set
	 */
	public void setNmdNumberObjects(ArrayList<String> nmdNumberObjects) {
		NmdNumberObjects = nmdNumberObjects;
	}
	/**
	 * @return the nmdNumberDataLiterals
	 */
	public ArrayList<String> getNmdNumberDataLiterals() {
		return NmdNumberDataLiterals;
	}
	/**
	 * @param nmdNumberDataLiterals the nmdNumberDataLiterals to set
	 */
	public void setNmdNumberDataLiterals(ArrayList<String> nmdNumberDataLiterals) {
		NmdNumberDataLiterals = nmdNumberDataLiterals;
	}
	/**
	 * @return the nmdNumberDataValues
	 */
	public ArrayList<String> getNmdNumberDataValues() {
		return NmdNumberDataValues;
	}
	/**
	 * @param nmdNumberDataValues the nmdNumberDataValues to set
	 */
	public void setNmdNumberDataValues(ArrayList<String> nmdNumberDataValues) {
		NmdNumberDataValues = nmdNumberDataValues;
	}
	/**
	 * @return the nmdRecord
	 */
	public NmdRecord getNmdRecord() {
		return nmdRecord;
	}
	/**
	 * @param nmdRecord the nmdRecord to set
	 */
	public void setNmdRecord(NmdRecord nmdRecord) {
		this.nmdRecord = nmdRecord;
	}
}
