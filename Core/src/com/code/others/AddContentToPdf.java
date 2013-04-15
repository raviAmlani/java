/* ----------------------------------------------------------------
 * Nombre de la Clase:  AddContentToPdf.java
 * Version: 1.0
 * Fecha:Feb 27, 2012
 * Empresa: 
 * Proyecto: OPM
 * Desarrollado por: Panel Sistemas Informaticos, S.L.
 * ----------------------------------------------------------------
 */
package com.code.others;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;

import javax.imageio.ImageIO;

import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.BarcodeQRCode;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.qrcode.QRCodeWriter;

/**********************************************************************
 * 
 *<br><b>Nombre Fichero:</b> AddContentToPdf.java
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
public class AddContentToPdf {
	
	public static void main(String []args){
		
	    generateAndPasteQR("D:\\PDF_Testing\\forms.pdf", "http://www.google.co.in/");
	    System.out.println("Done...");
	} // main() ends...

	private static void generateAndPasteQR(String path, String content) {

		PdfStamper stamper = null;
	    
	    try {
	        // Convert a string to UTF-8 bytes in a ByteBuffer
	    	Charset charset = Charset.forName("UTF-8");
		    CharsetEncoder encoder = charset.newEncoder();
		    byte[] b = null;
	        ByteBuffer bbuf = encoder.encode(CharBuffer.wrap(content));
	        b = bbuf.array();
	        String data;
	        data = new String(b, "UTF-8");
		
	        //Hashtable<EncodeHintType, String> hints = new Hashtable<EncodeHintType, String>(2);
            //hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
	        
	        //path = "D:\\forms.pdf";
	        String newPath = "D:\\PDF_Testing\\forms_1.pdf";
	        
	        
	        File f = new File(path);
	        System.out.println("PATH : "+path+" - File Avail : "+f.exists());
	        System.out.println("File Name  : "+f.getName()+"\n");
	        
	        File f2 = new File(newPath);
	        System.out.println("PATH : "+newPath+" - File Avail : "+f.exists());
	        System.out.println("File Name  : "+f2.getName()+"\n");
	        
	        
	        FileOutputStream nfos = new FileOutputStream(newPath);
	        PdfReader reader = new PdfReader(path); // input PDF
	        stamper = new PdfStamper(reader, nfos); // output PDF
	        //BaseFont bf = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1252, BaseFont.NOT_EMBEDDED); // set font
		
			/**
	         * Add content to PDF
	         */
	        //loop on pages
	        for (int i=1; i<=reader.getNumberOfPages(); i++){

	        	System.out.println("Current page --> "+i);
	            
	        	// get object for writing over the existing content;
	            // you can also use getUnderContent for writing in the bottom layer
	            PdfContentByte over = stamper.getOverContent(i);
	            
	            if(i == 1){
	            	
	            	System.out.println("Putting a QR...");
		            // write text
		            //over.beginText();
		            //over.setFontAndSize(bf, 10);    // set font and size
		            //over.setTextMatrix(107, 740);   // set x,y position (0,0 is at the bottom left)
		            //over.setTextMatrix(0, 0);
		            //over.showText("I can write at page " + i);  // set text
		            BarcodeQRCode qrcode = new BarcodeQRCode(data, 100, 100, null);
		            
		  //---------------------------------------------------------------------------------
		            
		            
		            com.itextpdf.text.Image img = qrcode.getImage();
			        img.setBorder(0);
			        img.setBorderWidth(0.0f);
			        //img.scaleAbsolute(img.getHeight()*0.48f, img.getWidth()*0.48f);
			        //img.scalePercent(50, 50);
			        img.scaleToFit(70, 70);

			        
			        img.setAbsolutePosition(7, 15);
			        img.setAlignment(Image.TEXTWRAP);
		            over.addImage(img);
		            over.closePath();
		            
		            System.out.println(img.getBorderWidth());
		            System.out.println(img.getBorderWidthLeft());
		            //System.out.println(img.type());
		            System.out.println(img.getHeight());
		            System.out.println(img.getPlainHeight());
		            System.out.println(img.getScaledHeight());
	
		 //---------------------------------------------------------------------------------
		            /*java.awt.Image rawImage = qrcode.createAwtImage(Color.BLACK, Color.WHITE);
		            BufferedImage outImage = new BufferedImage(rawImage.getWidth(null), rawImage.getHeight(null), BufferedImage.TYPE_INT_RGB);
		            outImage.getGraphics().drawImage(rawImage, 0, 0, null);
		            ByteArrayOutputStream bytesOut = new ByteArrayOutputStream();
		            ImageIO.write(outImage, "png", bytesOut);
		            bytesOut.flush();
		            byte[] pngImageData = bytesOut.toByteArray();
		            
		            Image img = Image.getInstance(pngImageData);
		            img.setAbsolutePosition(7, 15);
		            over.addImage(img);

		            System.out.println(img.getBorderWidth());
		            System.out.println(img.getBorderWidthLeft());
		            System.out.println(img.type());
		            System.out.println(img.getHeight());
		            System.out.println(img.getPlainHeight());
		            System.out.println(img.getScaledHeight());*/
			       
		            
	            }
	            
	            //ADD IT AS AN FOOTER WITH PdfContentByte-OVER
	            /*com.itextpdf.text.pdf.PdfTemplate template = over.createTemplate(100, 100);
	            template.addImage(img);
		        over.addTemplate(template, 0, 715);

		        Phrase phrase1 = new Phrase(over + "", FontFactory.getFont(FontFactory.TIMES_ROMAN, 7, Font.NORMAL));
		        HeaderFooter footer = new HeaderFooter(phrase1, true);*/
		        

	        }

	        stamper.close();
	        nfos.close();
	        //boolean rename = f2.renameTo(new File("D:\\new.pdf"));
	        //System.out.println("rename ? : "+rename);
	        
	        //stamper.close();
	        
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			/*try {
				stamper.close();
			} catch (DocumentException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}*/
		}
	} // generateAndPasteQR() ends...

}

