/* ----------------------------------------------------------------
 * Nombre de la Clase:  IPObtain.java
 * Version: 1.0
 * Fecha:Apr 3, 2013
 * Empresa: 
 * Proyecto: OPM
 * Desarrollado por: Panel Sistemas Informaticos, S.L.
 * ----------------------------------------------------------------
 */
package com.code.others;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

/**********************************************************************
 * 
 *<br><b>Nombre Fichero:</b> IPObtain.java
 *<br>
 *<br><b>Descripcion:</b>
 *<pre>
 *</pre> 
 *<br><b>Fecha de creacion:</b>Apr 3, 2013
 *<br>
 *<br><b>@author </b>DelogicoUser
 *<br>
 *<br><b>Languaje:</b> java
 *<br>
 ********************************************************************** */
public class IPObtain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String ip = "";
		InetAddress address;
		try {
			address = InetAddress.getByName(InetAddress.getLocalHost().getHostAddress());
			ip = address.getHostAddress();
			System.out.println(ip);
			
			InetAddress add[] = InetAddress.getAllByName(InetAddress.getLocalHost().getHostName());
			System.out.println(InetAddress.getLocalHost().getHostName());
			System.out.println(Arrays.toString(add));
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//address = InetAddress.getByName(request.getRemoteHost());
		//ip = address.getHostAddress();
		

	}

}

