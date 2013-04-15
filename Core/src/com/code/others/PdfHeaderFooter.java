/* ----------------------------------------------------------------
 * Nombre de la Clase:  PdfHeaderFooter.java
 * Version: 1.0
 * Fecha:Feb 27, 2012
 * Empresa: 
 * Proyecto: OPM
 * Desarrollado por: Panel Sistemas Informaticos, S.L.
 * ----------------------------------------------------------------
 */
package com.code.others;

import java.io.FileOutputStream;

import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.HeaderFooter;
import com.lowagie.text.Image;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfTemplate;
import com.lowagie.text.pdf.PdfWriter;

/**********************************************************************
 * 
 *<br><b>Nombre Fichero:</b> PdfHeaderFooter.java
 *<br>
 *<br><b>Descripcion:</b>
 *<pre>
 *</pre> 
 *<br><b>Fecha de creacion:</b>Feb 27, 2012
 *<br>
 *<br><b>@author </b>DelogicoUser
 *<br>
 *<br><b>Languaje:</b> java
 *<br>
 ********************************************************************** */
public class PdfHeaderFooter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		/**
         * Header Footer 
         */

		try{
			/**
			 * WORKING FINE TO PUT ANY EXTERNAL IMAGE AND MAKE A NEW PDF...
			 */
			
			Document document=new Document();
	        FileOutputStream fos=new FileOutputStream("D:\\todo.pdf");
	        PdfWriter writer = PdfWriter.getInstance(document, fos);
	        document.open();
	        Image image1 = Image.getInstance("D:\\QR_Code.JPG");

	        image1.setAbsolutePosition(0, 0);

	        com.lowagie.text.pdf.PdfContentByte byte1 = writer.getDirectContent();
	        PdfTemplate tp1 = byte1.createTemplate(100, 100);
	        tp1.addImage(image1);
	        
	        byte1.addTemplate(tp1, 0, 715);

	        Phrase phrase1 = new Phrase(byte1 + "", FontFactory.getFont(FontFactory.TIMES_ROMAN, 7, Font.NORMAL));

	        HeaderFooter footer = new HeaderFooter(phrase1, true);
	        document.setFooter(footer);
	        document.close();
	        System.out.println("File is created successfully showing header and footer.");
	        
		}catch (Exception e) {
			e.printStackTrace();
		}
        
	}

}

