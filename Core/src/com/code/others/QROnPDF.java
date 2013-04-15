/* ----------------------------------------------------------------
 * Nombre de la Clase:  QROnPDF.java
 * Version: 1.0
 * Fecha:Feb 27, 2012
 * Empresa: 
 * Proyecto: OPM
 * Desarrollado por: Panel Sistemas Informaticos, S.L.
 * ----------------------------------------------------------------
 */
package com.code.others;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;

import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;

import com.keepautomation.barcode.BarCode;
import com.keepautomation.barcode.IBarCode;
import com.lowagie.text.pdf.PdfReader;

/**********************************************************************
 * 
 *<br><b>Nombre Fichero:</b> QROnPDF.java
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
public class QROnPDF {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		try {
			PdfReader reader = new PdfReader("D:\\todo.pdf");
			
			Charset charset = Charset.forName("UTF-8");
		    CharsetEncoder encoder = charset.newEncoder();
		    byte[] b = null;
		    ByteBuffer bbuf = encoder.encode(CharBuffer.wrap("http://www.google.co.in/"));
	        b = bbuf.array();
	        String data = new String(b, "UTF-8");

			/**************************************************** 
			* 
			* 1.
			* QRGen.jar 
			* Config can not be set - excpet its size
			* */
			ByteArrayOutputStream out = QRCode.from(data).to(ImageType.JPG).withSize(150, 150).stream();
			FileOutputStream fout = new FileOutputStream(new File("D:\\QR_Code_23042012.JPG"));
			fout.write(out.toByteArray());
			fout.flush();
			fout.close(); 
			System.out.println("D:\\QR_Code_23042012.JPG ---> Done...");
			/**************************************************** 
			 
			 * 2.
			 * Barcode.jar 
			 * names of the methods which are called by the class are not meaningful.
			 * */
			//Create BarCode object in Java
		    BarCode barcode = new BarCode(); 
		    
		    //Set barcode symbology type to QR-Code
		    barcode.setType(IBarCode.QRCODE); 
		    
		    //Set QR-Code encoding code value
		    barcode.setData(data); 
		    
		    
		    //Set QRCode image size
		    //barcode.setUOM(IBarCode.UOM_PIXEL);        // QR-Code unit of measure
		    //barcode.setBarcodeHeight((float) 0.2f);
		    //barcode.setBarcodeWidth((float) 0.2f);
		    barcode.setResolution(72);                 // QR-Code image resolution in dpi
		    //barcode.setX(3);                           // QR-Code bar module width (X dimension)
		    barcode.setLeftMargin(0);		       // QR-Code image left margin size
		    barcode.setRightMargin(0);		       // QR-Code image right margin size
		    barcode.setTopMargin(0);		       // QR-Code image top margin size
		    barcode.setBottomMargin(0);		       // QR-Code image bottom margin size
		    barcode.setRotate(IBarCode.ROTATE_0);      // QR-Code rotation
		    
		    
		    //Generate QR-Code barcodes in image GIF format
		    //barcode.draw("D:\\barcode-qrcode-java.gif");

		    //Create QR-Code barcodes in OutputStream object
		    FileOutputStream fout2 = new FileOutputStream(new File("D:\\QR_Code_2.JPG"));
		    barcode.draw(fout2);
		    
		    //Draw & Print QR-Code barcodes to Graphics2D object within specified region
		    //barcode.draw("java.awt.Graphics2D", "java.awt.geom.Rectangle2D");
		    
		    //Generate QR-Code barcodes & write to byte[] 
		    //byte[] barcodeInBytes = barcode.drawOutputAsBytes();
		    
		    //Generate QR-Code barcodes & encode to System.Drawing.Bitmap object 
		    //BufferedImage barcodeImage = barcode.draw();
		    System.out.println(barcode.getGeneratedBarcodeImageHeight() + " X " +barcode.getGeneratedBarcodeImageWidth());
		    
		    
		    /**************************************************** 
			 
			 * 3.
			 * ZXing
			 * */
		    
		    /**************************************************** 
			 
			 * 4.
			 * iText
			 * */
		    
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

