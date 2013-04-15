/* ----------------------------------------------------------------
 * Nombre de la Clase:  AffectedData.java
 * Version: 1.0
 * Fecha:Apr 2, 2012
 * Empresa: 
 * Proyecto: OPM
 * Desarrollado por: Panel Sistemas Informaticos, S.L.
 * ----------------------------------------------------------------
 */
package com.code.others;

import java.util.ArrayList;

/**********************************************************************
 * 
 *<br><b>Nombre Fichero:</b> AffectedData.java
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
public class AffectedData {

	
	/**
	 * <AData object=""  literal ="codMoneda">moneda</AData>
     * <!--Can be multiple-->
	 */
	
	public ArrayList<String> aDataObjects;
	
	private ArrayList<String> aDataLiterals;
	
	private ArrayList<String> aDataValues;

	
	/**
	 * @return the aDataObjects
	 */
	public ArrayList<String> getaDataObjects() {
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
	public ArrayList<String> getaDataLiterals() {
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
	public ArrayList<String> getaDataValues() {
		return aDataValues;
	}

	/**
	 * @param aDataValues the aDataValues to set
	 */
	public void setaDataValues(ArrayList<String> aDataValues) {
		this.aDataValues = aDataValues;
	}
	
	
	
}

