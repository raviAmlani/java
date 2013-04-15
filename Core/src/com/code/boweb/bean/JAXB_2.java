/* ----------------------------------------------------------------
 * Nombre de la Clase:  JAXB_1.java
 * Version: 1.0
 * Fecha:Apr 10, 2012
 * Empresa: 
 * Proyecto: OPM
 * Desarrollado por: Panel Sistemas Informaticos, S.L.
 * ----------------------------------------------------------------
 */
package com.code.boweb.bean;

import java.io.Console;
import java.io.File;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**********************************************************************
 * 
 *<br><b>Nombre Fichero:</b> JAXB_1.java
 *<br>
 *<br><b>Descripcion:</b>
 *<pre>
 *</pre> 
 *<br><b>Fecha de creacion:</b>Apr 10, 2012
 *<br>
 *<br><b>@author </b> Ravi Amlani
 *<br>
 *<br><b>Languaje:</b> java
 *<br>
 ********************************************************************** */
public class JAXB_2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		
		// create bookstore, assigning book
		XMLReader xmlReader = new XMLReader("PP_CONSULTA_HAPPY1.xml", "SEARCH");
		EDR edr = xmlReader.getEdr();
		ArrayList<EDR> listOfEDR = new ArrayList<EDR>();
		listOfEDR.clear();
		listOfEDR.add(edr);
		
		EDRS edrs = new EDRS();
		edrs.setListOfEDR(listOfEDR);
		
		System.err.println("\n *************************************** \n");
		
		// create JAXB context and instantiate marshaller
		JAXBContext context;
		try {
			context = JAXBContext.newInstance(EDRS.class);
			Marshaller m = context.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			m.marshal(edrs, System.out);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	} // main() ends...

}

