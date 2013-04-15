/* ----------------------------------------------------------------
 * Nombre de la Clase:  EDR.java
 * Version: 1.0
 * Fecha:Apr 2, 2012
 * Empresa: 
 * Proyecto: OPM
 * Desarrollado por: Panel Sistemas Informaticos, S.L.
 * ----------------------------------------------------------------
 */
package com.code.others;

/**********************************************************************
 * 
 *<br><b>Nombre Fichero:</b> EDR.java
 *<br>
 *<br><b>Descripcion:</b>
 *<pre>
 *</pre> 
 *<br><b>Fecha de creacion:</b>Apr 2, 2012
 *<br>
 *<br><b>@author </b>DelogicoUser
 *<br>
 *<br><b>Languaje:</b> java
 *<br>
 ********************************************************************** */
public class EDR {

	private String actionCode;
	
	private XMLObjects xmlObjects;
	
	private AffectedData affectedData = new AffectedData();

	
	
	/**
	 * @return the actionCode
	 */
	public String getActionCode() {
		return actionCode;
	}

	/**
	 * @param actionCode the actionCode to set
	 */
	public void setActionCode(String actionCode) {
		this.actionCode = actionCode;
	}

	/**
	 * @return the xmlObjects
	 */
	public XMLObjects getXmlObjects() {
		return xmlObjects;
	}

	/**
	 * @param xmlObjects the xmlObjects to set
	 */
	public void setXmlObjects(XMLObjects xmlObjects) {
		this.xmlObjects = xmlObjects;
	}

	/**
	 * @return the affectedData
	 */
	public AffectedData getAffectedData() {
		return affectedData;
	}

	/**
	 * @param affectedData the affectedData to set
	 */
	public void setAffectedData(AffectedData affectedData) {
		this.affectedData = affectedData;
	}
	
}

