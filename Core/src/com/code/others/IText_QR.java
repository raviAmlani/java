/* ----------------------------------------------------------------
 * Nombre de la Clase:  IText_QR.java
 * Version: 1.0
 * Fecha:Feb 27, 2012
 * Empresa: 
 * Proyecto: OPM
 * Desarrollado por: Panel Sistemas Informaticos, S.L.
 * ----------------------------------------------------------------
 */
package com.code.others;

import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BarcodeQRCode;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;



/**********************************************************************
 * 
 *<br><b>Nombre Fichero:</b> IText_QR.java
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
public class IText_QR {

	public static void main(String []args){
		// step 2
		
		try{
			Document document = new Document(new Rectangle(340, 842));
		    // step 2
		    PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("D:\\todo.pdf"));
		    // step 3
		    document.open();
		    // step 4
		    PdfContentByte cb = writer.getDirectContent();
		    
		    document.add(new Paragraph("Barcode QRCode"));
	        BarcodeQRCode qrcode = new BarcodeQRCode("http://www.google.co.in/", 1, 1, null);
	        Image img = qrcode.getImage();
	        document.add(img);

	        // step 5
	        document.close();	
	        
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
}

