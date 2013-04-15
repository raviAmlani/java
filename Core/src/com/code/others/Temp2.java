/* ----------------------------------------------------------------
 * Nombre de la Clase:  Temp2.java
 * Version: 1.0
 * Fecha:Oct 9, 2012
 * Empresa: 
 * Proyecto: OPM
 * Desarrollado por: Panel Sistemas Informaticos, S.L.
 * ----------------------------------------------------------------
 */
package com.code.others;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

import org.apache.commons.codec.binary.Base64;

public class Temp2 {


	public static void main(String[] args){
		
		System.out.println("***********************************************************");
		System.out.println("File avail ? : "+new File("d:\\David_CERT.cer").isFile());
		
		File f = new File("d:\\David_CERT.cer");
		BufferedReader br = null;
		FileInputStream fis = null;
		InputStreamReader isr = null;
		StringBuffer buffer = new StringBuffer();
		try {
			
			// 1. CER TO STRING
			fis = new FileInputStream(f);
			isr = new InputStreamReader(fis, Charset.forName("UTF8"));  // ISO-8859-1
			br = new BufferedReader(isr);
			
			String line = null;
	        while((line = br.readLine()) != null) {
	        	buffer.append(line);
	        }
	        
	        br.close();
	        isr.close();
	        
	        String cer = buffer.toString();
	        System.out.println(cer);
	        System.out.println("\n***********************************************************\n");
	        
	        
			// DECODING 
			byte[] decoded_bytes_cer = Base64.decodeBase64(cer);
			String cert_direct = new String(decoded_bytes_cer);
			String cert_direct_utf8 = new String(decoded_bytes_cer, Charset.forName("UTF-8"));
			//System.out.println("----> Decoded : \n"+cert_direct_utf8);
			
			// ENCODING - byte[] as Direct input - WORKED...
			byte[] encoded_byte_cer = Base64.encodeBase64(decoded_bytes_cer);
			String cer_b64 = new String(encoded_byte_cer);
			System.out.println("----> Encoded Output Byte, Input Byte : "+ cer_b64.equals(cer) +"\n"+cer_b64);
			
			// ENCODING - String using UTF-8 - not working.
			
			/*cer_b64 = Base64.encodeBase64String(cert_direct.getBytes());
			System.out.println("----> Encoded 1.1 : \n"+cer_b64);
			cer_b64 = Base64.encodeBase64String(cert_direct.getBytes(Charset.forName("UTF-8")));
			System.out.println("----> Encoded 1.2 : \n"+cer_b64);
			cer_b64 = Base64.encodeBase64String(cert_direct_utf8.getBytes());
			System.out.println("----> Encoded 2.1 : \n"+cer_b64);
			cer_b64 = Base64.encodeBase64String(cert_direct_utf8.getBytes(Charset.forName("UTF-8")));
			System.out.println("----> Encoded 2.2 : \n"+cer_b64);*/
		
			
			// CONVERSION FROM BYTES TO INPUT STREAM AND VICE VERSA...
			
			/*InputStream inputStream_decoded_bytes_cer = new ByteArrayInputStream(decoded_bytes_cer);
	        byte[] inputStream_decoded_bytes_cer_function = bytesDesdeInputStream(inputStream_decoded_bytes_cer,inputStream_decoded_bytes_cer.available());
	        inputStream_decoded_bytes_cer.close();*/
			
			System.out.println("\n**************************************************************\n");
	        
			
			
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
		
	}  // main() method...
	
	public static byte[] bytesDesdeInputStream(java.io.InputStream in, int length)
	{
		java.io.DataInputStream din = new java.io.DataInputStream(in);
		byte[] bytecodes = new byte[length];
		try {
			din.readFully(bytecodes);
			if (din != null) din.close();
		}catch (IOException ex){
			ex.getMessage();
			ex.printStackTrace();
		}
		return bytecodes;

	}
	
}

