/* ----------------------------------------------------------------
 * Nombre de la Clase:  ReplaceQuotes.java
 * Version: 1.0
 * Fecha:Sep 6, 2012
 * Empresa: 
 * Proyecto: OPM
 * Desarrollado por: Panel Sistemas Informaticos, S.L.
 * ----------------------------------------------------------------
 */
package com.code.others;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

/**********************************************************************
 * 
 *<br><b>Nombre Fichero:</b> ReplaceQuotes.java
 *<br>
 *<br><b>Descripcion:</b>
 *<pre>
 *</pre> 
 *<br><b>Fecha de creacion:</b>Sep 6, 2012
 *<br>
 *<br><b>@author </b>DelogicoUser
 *<br>
 *<br><b>Languaje:</b> java
 *<br>
 ********************************************************************** */
public class ReplaceQuotes {

	public static void main(String [] args) {
		
		/*String withQuotes = "Hello \"world\"...\"how are you\"";
		System.out.println(withQuotes);
		System.out.println(withQuotes.replaceAll("\"", "'"));*/
		
		BufferedReader br;
		BufferedWriter bw = null;
		InputStreamReader isr = null;
		try {
			File xmlFile = new File("D:\\GeoPC_ES.sql");
			FileInputStream fis = new FileInputStream(xmlFile);
			isr = new InputStreamReader(fis, Charset.forName("UTF-8"));  // ISO-8859-1
			bw = new BufferedWriter(new FileWriter(new File("D:\\new.sql"), true));
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		
		try {
//			br = new BufferedReader(new FileReader(new File("D:\\GeoPC_ES.sql")));
			br = new BufferedReader(isr);
			String line;
	        int lineNo = 1; 
	        while((line = br.readLine()) != null) {
	             
//	        	System.out.println(line.replaceAll("\"", "'"));
	            line = line.replaceAll("\"", "'");
	            System.out.println(lineNo+" --> "+line);
	            bw.write(line);
                bw.newLine();

	            lineNo++;
	             
	        }
	        
	        br.close();
	        bw.close();
	        System.out.println("-- DONE --");
	        
	        
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		
	}
	
}

