/* ----------------------------------------------------------------
 * Nombre de la Clase:  XMLObjects.java
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
 *<br><b>Nombre Fichero:</b> XMLObjects.java
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
public class XMLObjects {

	/**
	 * <XMLObject>bw_pp_ch_OperacionGestionConsultaHappy</XMLObject>
	 * <!--Can be multiple-->
	 */ 
	private ArrayList<String> xmlObjectValues;

	
	/**
	 * @return the xmlObjectValue
	 */
	public ArrayList<String> getXmlObjectValues() {
		return xmlObjectValues;
	}

	/**
	 * @param xmlObjectValue the xmlObjectValue to set
	 */
	public void setXmlObjectValues(ArrayList<String> xmlObjectValue) {
		this.xmlObjectValues = xmlObjectValues;
	}
	
	
}

