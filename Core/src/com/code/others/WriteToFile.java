/* ----------------------------------------------------------------
 * Nombre de la Clase:  WriteToFile.java
 * Version: 1.0
 * Fecha:Dec 14, 2011
 * Empresa: 
 * Proyecto: OPM
 * Desarrollado por: Panel Sistemas Informaticos, S.L.
 * ----------------------------------------------------------------
 */
package com.code.others;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**********************************************************************
 * 
 *<br><b>Nombre Fichero:</b> WriteToFile.java
 *<br>
 *<br><b>Descripcion:</b>
 *<pre>
 *</pre> 
 *<br><b>Fecha de creacion:</b>Dec 14, 2011
 *<br>
 *<br><b>@author </b>DelogicoUser
 *<br>
 *<br><b>Languaje:</b> java
 *<br>
 ********************************************************************** */
public class WriteToFile {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		//writeToFile();
		
		/** Below function is not related to first function */
		//createFile();
		
		/** Substring operation */
		//subString();
		
		/** To open any file in windows default program */
		//executeAnyFile();
		
		
	}
	

	private static void subString() {

		String testSub = "/user1/user2/ravi.pfx";
		String fileName = "";
		if(testSub.startsWith("/")){
			testSub = testSub.substring(1, testSub.length());
			System.out.println(testSub);
		}
		
		if(testSub.contains(".pfx")){
			
			// find the last slash
			int indexOfLastSlash = testSub.lastIndexOf("/");
			fileName = testSub.substring(indexOfLastSlash+1, testSub.length());
			testSub = testSub.substring(0, indexOfLastSlash);
			System.out.println("New path = "+testSub);
			System.out.println("file Name = "+fileName);
		}
	}

	private static void writeToFile(){
		
		BufferedWriter out;
		try {
			//out = new BufferedWriter(new FileWriter("\\\\pc_21\\Software\\test.txt"));
			//out = new BufferedWriter(new FileWriter("D:\\ravi\\test.txt"));
			//out = new BufferedWriter(new FileWriter("lib/iText/test111.txt"));
			out = new BufferedWriter(new FileWriter("/WorkSpace_Helios_2/test111.txt"));
			out.write("Hello world");
			out.newLine();
			out.write("hi...");
			out.close();
			System.out.println("File has been written...");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
	}
	
	private static void createFile(){
		
		
//		Case 0: "";
//		Case 1:	"userDir/";
//		Case 2:	"/userDir/";

//		String relPath = "";
//		String relPath = "userDir/";
		String relPath = "/userDir1/userDir2/";
		String absPath = "Cert/";
		String fileName = "test.txt";
		
		String nombreDB = "";
		
		File f = null;
		
		if(relPath == null || relPath.equals("")){
		
			System.out.println("--------------- CASE 0 - rel path Blank ------------------");
			absPath = absPath + "gener/";
			nombreDB = "gener/" + fileName;
			
			f = new File(absPath + fileName);
			File dir = new File(absPath);
			
			
			System.out.println("Dir exist ? : "+dir.isDirectory());
			if(!dir.isDirectory()){
				dir.mkdirs();
				System.out.println("Dir exist ? : "+dir.isDirectory());
			}

			System.out.println("File exist ? : "+f.exists());
			
		}else if(!relPath.startsWith("/")){
			
			System.out.println("--------------- CASE 1 - rel path without slash ------------------");
			
			absPath = absPath + relPath;
			nombreDB = relPath + fileName;
			
			f = new File(absPath + fileName);
			File dir = new File(absPath);
			
			
			System.out.println("Dir exist ? : "+dir.isDirectory());
			if(!dir.isDirectory()){
				dir.mkdirs();
				System.out.println("Dir exist ? : "+dir.isDirectory());
			}

			System.out.println("File exist ? : "+f.exists());
			
		}else if(relPath.startsWith("/")){
			
			System.out.println("--------------- CASE 2 - rel path with slash ------------------");
			
			absPath = relPath;
			nombreDB = relPath + fileName;
			
			f = new File(absPath + fileName);
			File dir = new File(absPath);
			
			
			System.out.println("Dir exist ? : "+dir.isDirectory());
			if(!dir.isDirectory()){
				dir.mkdirs();
				System.out.println("Dir exist ? : "+dir.isDirectory());
			}

			System.out.println("File exist ? : "+f.exists());
			
		}
		
		try{
			BufferedWriter out;
			out = new BufferedWriter(new FileWriter(f));
			out.write("Hello world");
			out.newLine();
			out.write("hi...");
			out.close();
			System.out.println("File has been written...");
			System.out.println("File exist ? : "+f.exists());
			
			System.out.println("Check from db path : "+new File(nombreDB).exists());
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	private static void executeAnyFile(){
		
		Process p;
		try {
			p = Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler D:\\test.txt");
			p.waitFor();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}

