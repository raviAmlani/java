package com.ravi.fb;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileInput {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) {
		
		BufferedReader br;
		int lineNo = 1;
		try {
			
			br = new BufferedReader(new FileReader("Input.txt"));
			
			String line;
			while ((line = br.readLine()) != null) {
				if(lineNo == 1){
					// do something...
				}
				System.out.println(line);	
			}
			br.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("File with the given file name not found...!!!");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error reading lineNo : "+lineNo);
			e.printStackTrace();
		}
		

	}

}
