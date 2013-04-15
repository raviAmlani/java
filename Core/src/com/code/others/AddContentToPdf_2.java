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

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream.GetField;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.Hashtable;

import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.encoder.ByteMatrix;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.BarcodeQRCode;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.keepautomation.barcode.BarCode;
import com.keepautomation.barcode.IBarCode;
import com.lowagie.text.DocListener;
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
public class AddContentToPdf_2 {
	
	public static void main(String []args){
		
	    PdfStamper stamper = null;
	    
	    try {
	        // Convert a string to UTF-8 bytes in a ByteBuffer
	    	Charset charset = Charset.forName("UTF-8");
		    CharsetEncoder encoder = charset.newEncoder();
		    byte[] b = null;
	        ByteBuffer bbuf = encoder.encode(CharBuffer.wrap("http://www.google.co.in/"));
	        b = bbuf.array();
	        String data;
	        data = new String(b, "UTF-8");
		
	        //Hashtable<EncodeHintType, String> hints = new Hashtable<EncodeHintType, String>(2);
            //hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
	        
	        String path = "D:\\PDF_Testing\\forms.pdf";
	        String newPath = "D:\\PDF_Testing\\forms_2.pdf";
	        
	        
	        File f = new File(path);
	        System.out.println("File Avail : "+f.exists());
	        System.out.println("File Name  : "+f.getName());
	        
	        File f2 = new File(newPath);
	        System.out.println(f2.getName());
	        
	        
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
	            
	            // write text
	            //over.beginText();
	            //over.setFontAndSize(bf, 10);    // set font and size
	            //over.setTextMatrix(107, 740);   // set x,y position (0,0 is at the bottom left)
	            //over.setTextMatrix(0, 0);
	            //over.showText("I can write at page " + i);  // set text
	            
	            // BarcodeQRCode qrcode = new BarcodeQRCode(data, 70, 70, null);
		        //com.itextpdf.text.Image img = qrcode.getImage();
	            
	            if(i == 1){
	            	
	            	byte[] imageInBytes = getQRImage(data);
			        com.itextpdf.text.Image img2 = com.itextpdf.text.Image.getInstance(imageInBytes);   
			        
			        img2.setAbsolutePosition(16, 16);
			        img2.setAlignment(Image.TEXTWRAP);
		            over.addImage(img2);
		            //over.endText();
		            over.closePath();	
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
	}
	
	private static byte[] getQRImage(String data){
		
		byte[] barcodeInBytes = null;
		try{
			/**************************************************** 
			 * Barcode.jar */
			//Create BarCode object in Java
		    BarCode barcode = new BarCode(); 
		    
		    //Set barcode symbology type to QR-Code
		    barcode.setType(IBarCode.QRCODE); 
		    
		    //Set QR-Code encoding code value
		    barcode.setData(data); 
		    
		    
		    //Set QRCode image size
		    barcode.setUOM(IBarCode.UOM_PIXEL);        // QR-Code unit of measure
		    
		    barcode.setX(2f);
		    barcode.setY(40f);
		    //barcode.setBarcodeHeight((float) 0.1f);
		    //barcode.setBarcodeWidth((float) 0.2f);
		    barcode.setResolution(72);                 // QR-Code image resolution in dpi

		    barcode.setLeftMargin(0);		       // QR-Code image left margin size
		    barcode.setRightMargin(0);		       // QR-Code image right margin size
		    barcode.setTopMargin(0);		       // QR-Code image top margin size
		    barcode.setBottomMargin(0);		       // QR-Code image bottom margin size
		    
		    barcode.setRotate(IBarCode.ROTATE_0);      // QR-Code rotation
		    
		    
		    
		    //Generate QR-Code barcodes in image GIF format
		    //barcode.draw("D:\\barcode-qrcode-java.gif");

		    //Create QR-Code barcodes in OutputStream object
		    //FileOutputStream fout2 = new FileOutputStream(new File("D:\\QR_Code_2.JPG"));
		    //barcode.draw(fout2);
		    
		    //Draw & Print QR-Code barcodes to Graphics2D object within specified region
		    //barcode.draw("java.awt.Graphics2D", "java.awt.geom.Rectangle2D");
		    
		    //Generate QR-Code barcodes & write to byte[] 
		    barcodeInBytes = barcode.drawOutputAsBytes();
		    
		    //Generate QR-Code barcodes & encode to System.Drawing.Bitmap object 
		    //BufferedImage barcodeImage = barcode.draw();
		    System.out.println(barcode.getGeneratedBarcodeImageHeight() + " X " +barcode.getGeneratedBarcodeImageWidth());
		    System.out.println("Bytes are ready...");
	
		}catch(Exception e){
			e.printStackTrace();
		}
		return barcodeInBytes;
				
	} //getImage() ends...
	
	/*private static byte[] getQRImageZXing(String data){
		
		BitMatrix matrix = null;
        ByteMatrix byteMatrix = null;
        int h = 100;
        int w = 100;
        com.google.zxing.Writer writer = new QRCodeWriter();
        try {
            Hashtable<EncodeHintType, String> hints = new Hashtable<EncodeHintType, String>(2);
            hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        } catch (com.google.zxing.WriterException e) {
            System.out.println(e.getMessage());
        }
		byteMatrix = writer.encode(data, com.google.zxing.BarcodeFormat.QR_CODE, w, h);
		
		//byte[][] array = matrix.getArray(); 	
	
	}*/

}

