/* ----------------------------------------------------------------
 * Nombre de la Clase:  Testing.java
 * Version: 1.0
 * Fecha:Dec 3, 2011
 * Empresa: 
 * Proyecto: OPM
 * Desarrollado por: Panel Sistemas Informaticos, S.L.
 * ----------------------------------------------------------------
 */
package com.code.others;

import java.text.NumberFormat;
import java.text.ParseException;

/**********************************************************************
 * 
 *<br><b>Nombre Fichero:</b> Testing.java
 *<br>
 *<br><b>Descripcion:</b>
 *<pre>
 *</pre> 
 *<br><b>Fecha de creacion:</b>Dec 3, 2011
 *<br>
 *<br><b>@author </b>DelogicoUser
 *<br>
 *<br><b>Languaje:</b> java
 *<br>
 ********************************************************************** */
public class FormatNumbers {

	static float f = 123456789;
	static double d = 123456789.456789;
	static java.text.DecimalFormat df = new java.text.DecimalFormat("#########.###########");

	
	public static void main(String[] args) throws Exception {

		System.out.println("f = "+f);
		System.out.println("d = "+d);
		System.out.println("formatted = "+df.parse(df.format(d)).doubleValue());
		System.out.println("formatted = "+df.format(d));
		System.out.println(NumberFormat.getInstance().format(f));
	}

}

