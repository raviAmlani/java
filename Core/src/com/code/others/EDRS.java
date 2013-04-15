/* ----------------------------------------------------------------
 * Nombre de la Clase:  EDRS.java
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
 *<br><b>Nombre Fichero:</b> EDRS.java
 *<br>
 *<br><b>Descripcion:</b>
 *<pre>
 *</pre> 
 *<br><b>Fecha de creacion:</b>Apr 2, 2012
 *<br>
 *<br><b>@author </b> Ravi Amlani
 *<br>
 *<br><b>Languaje:</b> java
 *<br>
 ********************************************************************** */
public class EDRS {

//	First TAG inside DOCUMENT NODE. This can be multiple.
	private ArrayList<EDR> listEDR;

	/**
	 * @return the listEDR
	 */
	public ArrayList<EDR> getListOfEDR() {
		return listEDR;
	}

	/**
	 * @param listEDR the listEDR to set
	 */
	public void setListOfEDR(ArrayList<EDR> listEDR) {
		this.listEDR = listEDR;
	}

	
	
}

