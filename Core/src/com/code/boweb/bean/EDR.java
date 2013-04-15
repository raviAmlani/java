package com.code.boweb.bean;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "EDR")
@XmlType(propOrder = {"actionCode", "operationType", "transactionSequenceNumber", "description", "interpreter", "xmlObjects", "affectedData", "originalData" })
@XmlSeeAlso( { XMLObjects.class, AffectedData.class, OriginalData.class })

public class EDR
{
	private String ActionCode;
	private String OperationType;
	private String transactionSequenceNumber;
	private String Description;
	private String Interpreter;		

	private XMLObjects xmlObjects;
	private AffectedData affectedData;
	private OriginalData originalData;
	
	private NewData newData;
	
	/*private OriginalMultipleData originalMultipleData = new OriginalMultipleData();
	
	private NewMultipleData newMultipleData; */
	
	@XmlElement(name = "ActionCode")
	public String getActionCode() 
	{
		return ActionCode;
	}	
	public void setActionCode(String actionCode) 
	{
		this.ActionCode = actionCode;
	}
	
	@XmlElement(name = "OperationType")
	public String getOperationType() 
	{
		return OperationType;
	}
	public void setOperationType(String operationType) 
	{
		this.OperationType = operationType;
	}
	
	@XmlElement(name = "transactionSequenceNumber")
	public String getTransactionSequenceNumber() 
	{
		return transactionSequenceNumber;
	}
	public void setTransactionSequenceNumber(String transactionSequenceNumber) 
	{
		this.transactionSequenceNumber = transactionSequenceNumber;
	}
	
	@XmlElement(name = "Description")
	public String getDescription() 
	{
		return Description;
	}
	public void setDescription(String description) 
	{
		this.Description = description;
	}
	
	@XmlElement(name = "Interpreter")
	public String getInterpreter() 
	{
		return Interpreter;
	}
	public void setInterpreter(String interpreter) 
	{
		this.Interpreter = interpreter;
	}
	
//	@XmlElementWrapper(name = "XMLObjects")
//	@XmlSeeAlso(XMLObjects.class)
	@XmlElement(name = "XMLObjects")
	public XMLObjects getXmlObjects() 
	{
		return xmlObjects;
	}
	public void setXmlObjects(XMLObjects xmlObjects) 
	{
		this.xmlObjects = xmlObjects;
	}

	
	
	@XmlElement(name = "AffectedData")
	public AffectedData getAffectedData() {
		return affectedData;
	}

	public void setAffectedData(AffectedData affectedData) {
		this.affectedData = affectedData;
	}
	/**
	 * @return the originalData
	 */
	
	@XmlElement(name = "OriginalData")
	public OriginalData getOriginalData() {
		return originalData;
	}
	/**
	 * @param originalData the originalData to set
	 */
	public void setOriginalData(OriginalData originalData) {
		this.originalData = originalData;
	}
	
	public NewData getNewData() {
		return newData;
	}
	public void setNewData(NewData newData) {
		this.newData = newData;
	}
	
	/*public OriginalMultipleData getOriginalMultipleData() {
		return originalMultipleData;
	}
	public void setOriginalMultipleData(OriginalMultipleData originalMultipleData) {
		originalMultipleData = originalMultipleData;
	}
	public NewMultipleData getNewMultipleData() {
		return newMultipleData;
	}
	public void setNewMultipleData(NewMultipleData newMultipleData) {
		this.newMultipleData = newMultipleData;
	}*/
	
	
	

} // Edr.java ends...
