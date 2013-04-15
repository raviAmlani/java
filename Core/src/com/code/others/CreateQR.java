/* ----------------------------------------------------------------
 * Nombre de la Clase:  CreateQR.java
 * Version: 1.0
 * Fecha:Feb 27, 2012
 * Empresa: 
 * Proyecto: OPM
 * Desarrollado por: Panel Sistemas Informaticos, S.L.
 * ----------------------------------------------------------------
 */
package com.code.others;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.Hashtable;

import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.encoder.ByteMatrix;

/**********************************************************************
 * 
 *<br><b>Nombre Fichero:</b> CreateQR.java
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
public class CreateQR {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Charset charset = Charset.forName("UTF-8");
	    CharsetEncoder encoder = charset.newEncoder();
	    byte[] b = null;
	    try {
	        // Convert a string to UTF-8 bytes in a ByteBuffer
	        ByteBuffer bbuf = encoder.encode(CharBuffer.wrap("http://www.google.co.in/"));
	        b = bbuf.array();
	    } catch (CharacterCodingException e) {
	        System.out.println(e.getMessage());
	    }

	    String data;
	    try {
	        data = new String(b, "UTF-8");
	        // get a byte matrix for the data
	        BitMatrix matrix = null;
	        ByteMatrix byteMatrix = null;
	        int h = 100;
	        int w = 100;
	        com.google.zxing.Writer writer = new MultiFormatWriter();
	        try {
	            Hashtable<EncodeHintType, String> hints = new Hashtable<EncodeHintType, String>(2);
	            hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
	            matrix = writer.encode(data, com.google.zxing.BarcodeFormat.QR_CODE, w, h, hints);
	        } catch (com.google.zxing.WriterException e) {
	            System.out.println(e.getMessage());
	        }

	        // change this path to match yours (this is my mac home folder, you can use: c:\\qr_png.png if you are on windows)
	        String filePath = "D:\\CreateQR.JPG";
	        File file = new File(filePath);
	        try {
	            MatrixToImageWriter.writeToFile(matrix, "JPG", file);
	            System.out.println("printing to " + file.getAbsolutePath());
	        } catch (IOException e) {
	            System.out.println(e.getMessage());
	        }
	    } catch (UnsupportedEncodingException e) {
	        System.out.println(e.getMessage());
	    }
	}

}

