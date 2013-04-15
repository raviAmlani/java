/* ----------------------------------------------------------------
 * Nombre de la Clase:  WinInstaller.java
 * Version: 1.0
 * Fecha:May 7, 2012
 * Empresa: 
 * Proyecto: OPM
 * Desarrollado por: Panel Sistemas Informaticos, S.L.
 * ----------------------------------------------------------------
 */
package com.code.panel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.io.IOUtils;

/**********************************************************************
 * 
 *<br><b>Nombre Fichero:</b> WinInstaller.java
 *<br>
 *<br><b>Descripcion:</b>
 *<pre>
 *</pre> 
 *<br><b>Fecha de creacion:</b>May 7, 2012
 *<br>
 *<br><b>@author </b> Ravi Amlani
 *<br>
 *<br><b>Languaje:</b> java
 *<br>
 ********************************************************************** */
public class WinInstaller {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String source= "lib/itext-1.1.4.jar";         
		String dest = "D:"+System.getProperty("file.separator")+"1234567890"+System.getProperty("file.separator");
		String file = "1.jar";
		
		if(new File(source).isFile()){
			System.out.println("yes");
			copyFile(source, dest, file);
		}else{
			System.out.println("NO");
		}
		
		
	}
	
	private static void copyFile(String source, String dest, String file){
		
		InputStream in = null;
		OutputStream out = null;
		try {     

			in = new FileInputStream(new File(source));
			File outputFile = new File(dest, file);
			if (!outputFile.getParentFile().exists()) {
	             outputFile.getParentFile().mkdirs();
	         }
			out = new FileOutputStream(outputFile);
			IOUtils.copy(in, out);
			//Log.i(ContentManagerActivity.TAG, "COPY PASTE DONE...");
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			IOUtils.closeQuietly(in);
		    IOUtils.closeQuietly(out);
		}
	}					

}

