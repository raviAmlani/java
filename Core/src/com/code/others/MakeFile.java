/* ----------------------------------------------------------------
 * Nombre de la Clase:  MakeFile.java
 * Version: 1.0
 * Fecha:Nov 22, 2011
 * Empresa: 
 * Proyecto: OPM
 * Desarrollado por: Panel Sistemas Informaticos, S.L.
 * ----------------------------------------------------------------
 */
package com.code.others;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**********************************************************************
 * 
 *<br><b>Nombre Fichero:</b> MakeFile.java
 *<br>
 *<br><b>Descripcion:</b>
 *<pre>
 *</pre> 
 *<br><b>Fecha de creacion:</b>Nov 22, 2011
 *<br>
 *<br><b>@author </b>DelogicoUser
 *<br>
 *<br><b>Languaje:</b> java
 *<br>
 ********************************************************************** */
public class MakeFile {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MakeFile makeFile = new MakeFile();
		makeFile.makePDF();
	}

	private void makePDF(){
		
		System.out.println("Inside makePDF() ---------------- ");
		byte[] byteSource = null;
		
		try {
			byteSource = pdfToByte();
			//byteSource = pdfToByte().getBytes();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		System.out.println("Now decoding ---------------- ");
		//String strByte = "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OR3VPFrVROxPMF2dGOdneNF5uaVM4il5S+oz+faedMz1z6LeSnX/x8YgnHPi0cfffG6YpwLTUjQQlgOowsKqZVJtpLbBctJER5i4yvRYeqiV14MfeJgv1t1yNetw261fy6p73uJmVwjXZU74WD4ruxnZKhvxVsUQqNVoyInEbBzFuxFXIyt9MKfN+3GvoPMBs4EXpXaAs/6TnFvjpuzt3cJ4hdQOjFWQsQHh2oBfAQYAxWJu0goNCmVuZHN0cmVhbQ1lbmRvYmoNOTQgMCBvYmo8PC9TdWJ0eXBlL1RydWVUeXBlL0ZvbnREZXNjcmlwdG9yIDk1IDAgUi9MYXN0Q2hhciA4Ni9XaWR0aHNbMjc4IDAgMCAwIDAgMCAwIDAgMCAwIDAgMCAwIDAgMjc4IDAgMCAwIDAgMCAwIDAgMCAwIDAgMCAwIDAgMCAwIDAgMCAwIDAgMCA3MjIgNzIyIDY2NyAwIDc3OCAwIDI3OCAwIDAgNjExIDAgNzIyIDc3OCA2NjcgMCAwIDY2NyA2MTEgNzIyIDY2N10vQmFzZUZvbnQvQXJpYWwtQm9sZE1UL0ZpcnN0Q2hhciAzMi9FbmNvZGluZy9XaW5BbnNpRW5jb2RpbmcvVHlwZS9Gb250Pj4NZW5kb2JqDTk1IDAgb2JqPDwvU3RlbVYgMTM4L0ZvbnROYW1lL0FyaWFsLUJvbGRNVC9Gb250U3RyZXRjaC9Ob3JtYWwvRm9udFdlaWdodCA3MDAvRmxhZ3MgMzIvRGVzY2VudCAtMjExL0ZvbnRCQm94Wy02MjggLTM3NiAyMDAwIDEwMTBdL0FzY2VudCA5MDUvRm9udEZhbWlseShBcmlhbCkvQ2FwSGVpZ2h0IDcxOC9YSGVpZ2h0IDUxNS9UeXBlL0ZvbnREZXNjcmlwdG9yL0l0YWxpY0FuZ2xlIDA+Pg1lbmRvYmoNOTYgMCBvYmo8PC9TdWJ0eXBlL1RydWVUeXBlL0ZvbnREZXNjcmlwdG9yIDk3IDAgUi9MYXN0Q2hhciAxMTEvV2lkdGhzWzI3OCAwIDAgMCAwIDAgMCAwIDAgMCAwIDAgMCAwIDAgMCAwIDU1NiA1NTYgNTU2IDU1NiA1NTYgNTU2IDU1NiA1NTYgNTU2IDAgMCAwIDAgMCAwIDAgMCAwIDAgMCAwIDAgMCAwIDAgMCAwIDAgMCAwIDAgNjY3IDAgMCAwIDAgMCAwIDAgMCAwIDAgMCAwIDAgMCAwIDAgNTU2IDAgMCAwIDU1NiAyNzggNTU2IDAgMCAwIDAgMCAwIDAgNTU2XS9CYXNlRm9udC9BcmlhbE1UL0ZpcnN0Q2hhciAzMi9FbmNvZGluZy9XaW5BbnNpRW5jb2RpbmcvVHlwZS9Gb250Pj4NZW5kb2JqDTk3IDAgb2JqPDwvU3RlbVYgODgvRm9udE5hbWUvQXJpYWxNVC9Gb250U3RyZXRjaC9Ob3JtYWwvRm9udFdlaWdodCA0MDAvRmxhZ3MgMzIvRGVzY2VudCAtMjExL0ZvbnRCQm94Wy02NjUgLTMyNSAyMDAwIDEwMDZdL0FzY2VudCA5MDUvRm9udEZhbWlseShBcmlhbCkvQ2FwSGVpZ2h0IDcxOC9YSGVpZ2h0IDUxNS9UeXBlL0ZvbnREZXNjcm";
		//byte[] bytes = strByte.getBytes();
		byte[] bytes = byteSource;
    	OutputStream out;
		try {
			File file = new File("D:\\data.pdf");
			out = new FileOutputStream(file);
			out.write(bytes);
			out.close();
			
			/*if(file.exists())
				file.delete();*/
			
			if(file.exists()){
				System.out.println("File is present...");
				Process p = Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler D:\\data.pdf");
				p.waitFor();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private byte[] pdfToByte() throws IOException {
		
		InputStream inputStream = new FileInputStream("d:\\todo.pdf");
		
		byte[] buffer = new byte[8192];
	    ByteArrayOutputStream baos = new ByteArrayOutputStream();
	    int bytesRead;
	    while ((bytesRead = inputStream.read(buffer)) != -1)
	    {
	        baos.write(buffer, 0, bytesRead);
	    }
	    return baos.toByteArray();
	    //return baos.toByteArray().toString();
	}
}

