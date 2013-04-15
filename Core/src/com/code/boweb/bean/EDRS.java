
package com.code.boweb.bean;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "EDRs")
@XmlSeeAlso( { XMLObjects.class })
public class EDRS {

//	First TAG inside DOCUMENT NODE. This can be multiple.
	
	@XmlElement(name = "EDR")
	private ArrayList<EDR> listOfEDR;

	/**
	 * @return the listOfEDR
	 */
	public ArrayList<EDR> getListsOfEDR() {
		return listOfEDR;
	}

	/**
	 * @param listOfEDR the listOfEDR to set
	 */
	public void setListOfEDR(ArrayList<EDR> listOfEDR) {
		this.listOfEDR = listOfEDR;
	}

		
}