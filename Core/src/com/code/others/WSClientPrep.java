/* ----------------------------------------------------------------
 * Nombre de la Clase:  WSClientPrep.java
 * Version: 1.0
 * Fecha:Jan 18, 2012
 * Empresa: 
 * Proyecto: OPM
 * Desarrollado por: Panel Sistemas Informaticos, S.L.
 * ----------------------------------------------------------------
 */
package com.code.others;

import java.net.URLEncoder;

import org.apache.commons.codec.binary.Base64;

/**********************************************************************
 * 
 *<br><b>Nombre Fichero:</b> WSClientPrep.java
 *<br>
 *<br><b>Descripcion:</b>
 *<pre>
 *</pre> 
 *<br><b>Fecha de creacion:</b>Jan 18, 2012
 *<br>
 *<br><b>@author </b>DelogicoUser
 *<br>
 *<br><b>Languaje:</b> java
 *<br>
 ********************************************************************** */
public class WSClientPrep {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String str = "<Car><CarRegistrationNo>1</CarRegistrationNo><ModelType>Test</ModelType><ModelSubType>Xing XL</ModelSubType><ModelYear>2006</ModelYear><ChasisNumber>21546</ChasisNumber><EngineNumber>582138172168273</EngineNumber><RTONumber>12342000</RTONumber></Car>";
		int i = 0;
		byte[] b = str.getBytes();
		StringBuffer buffer = new StringBuffer();
		while(i < b.length){
			buffer.append(b[i]);
			//System.out.println(b[i]);
			i++;
		}
		System.out.println(buffer.toString());
		
		byte[] c = Base64.encodeBase64(b);
		System.out.println("-------------------------------");
		i=0;
		while(i<c.length){
			buffer.append(c[i]);
			//System.out.println(c[i]);
			i++;
		}
		System.out.println(buffer.toString());
		System.out.println(URLEncoder.encode("<car>"));
	}

}

