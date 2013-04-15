/* ----------------------------------------------------------------
 * Nombre de la Clase:  BalancedSmileys.java
 * Version: 1.0
 * Fecha:Jan 30, 2013
 * Empresa: 
 * Proyecto: OPM
 * Desarrollado por: Panel Sistemas Informaticos, S.L.
 * ----------------------------------------------------------------
 */
package com.ravi.fb;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**********************************************************************
 * 
 *<br><b>Nombre Fichero:</b> BalancedSmileys.java
 *<br>
 *<br><b>Descripcion:</b>
 *<pre>
 *</pre> 
 *<br><b>Fecha de creacion:</b>Jan 30, 2013
 *<br>
 *<br><b>@author </b>DelogicoUser
 *<br>
 *<br><b>Languaje:</b> java
 *<br>
 ********************************************************************** */
public class BalancedSmileys {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int lineNo = 0;
		
		try {
			
			String inputFileName = "input_balancedSmileys.txt";
			BufferedReader br = new BufferedReader(new FileReader(inputFileName));
			
			String outputFileName = "output.txt";
			FileWriter fstream = new FileWriter(outputFileName);
	        BufferedWriter out = new BufferedWriter(fstream);
	        
			String line;
			
			while ((line = br.readLine()) != null) {
				
				if(lineNo > 0){
					
					/*System.out.println(line);
					boolean valid = checkString(line.toLowerCase());

					if(lineNo == 1)
						//out.write("Case #"+lineNo+": "+beauty);
						System.out.println("Case #"+lineNo+": "+valid+"\n");
					else{
						//out.newLine();
						//out.write("Case #"+lineNo+": "+beauty);
						System.out.println("Case #"+lineNo+": "+valid+"\n");
					}*/
					
					/************************ ANOTHER METHOD *******************************/
					
					System.out.println("------------------------------------------");
					
					System.out.println(line);
					boolean valid2 = checkString2(line.toLowerCase());

					if(lineNo == 1)
						//out.write("Case #"+lineNo+": "+beauty);
						System.out.println("Case #"+lineNo+": "+valid2);
					else{
						//out.newLine();
						//out.write("Case #"+lineNo+": "+beauty);
						System.out.println("Case #"+lineNo+": "+valid2);
					}
					
				}
				lineNo+=1;
				
			}
			br.close();
			out.close();
			System.out.println("********************************************");
			System.out.println("Opearation completed successfully, please check out \"output.txt\" file");
			
		} catch (FileNotFoundException e) {
			System.out.println("File with the given file name not found...!!!\n");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error reading lineNo : "+lineNo+"\n");
			e.printStackTrace();
		}
		
		
	}	// main() ends...

	
	
	private static boolean checkString2(String line) {
		// TODO Auto-generated method stub
		
		int smileys = 0;
		int frownies = 0;
		int counter = 0;
		
		while(line.contains(":)")){
			line = line.replaceFirst(":\\)", "");
			smileys++;
			System.out.println(line+", smileys: "+smileys);
		}
		while(line.contains(":(")){
			line = line.replaceFirst(":\\(", "");
			frownies++;
			System.out.println(line+", frownies: "+frownies);
		}
		
		if(line.equals("") || line.equals(":") || line.equals(" ") || 
				line.equals("()"))
			return true;
		

		for(int i = 0; i < line.length(); i++){
			
			if("(".equals(line.charAt(i)+"")){
				counter++;
			}else if(")".equals(line.charAt(i)+"")){
				if(counter > 0 || frownies > 0)
					counter--;
				else
					return false;
			 }
		}
		
		if(counter == 0)
			return true;
		else if(counter > 0){
			if(smileys >= counter){
				if(counter-smileys >= 0)
					return true;
			}else 
				return false;
		}else if(counter < 0){
			if(counter + frownies >= 0)
				return true;
			else 
				return false;
		}
		
		return false;
	
	
	}  // checkString2() ends... 


	private static boolean checkString(String line) {
		
		if(line.equals("") || line.equals(":(") || line.equals(":") || line.equals(":)") || line.equals(" "))
			return true;
		
		
		int min = 0;
		int max = 0;
		
		for(int i = 0; i < line.length(); i++){
			if("(".equals(line.charAt(i)+"")){
				 min++; max++;
			}else if(")".equals(line.charAt(i)+"")){
				 min--; max--;
			}else if(":".equals(line.charAt(i)+"") && i < line.length()-1 && ")".equals(line.charAt(i+1)+"")){
					 min--;
					 i++;
			}else if(":".equals(line.charAt(i)+"") && i < line.length()-1 && "(".equals(line.charAt(i+1)+"")){
					 max++;
					 i++;
			}
		}
		
		if(max < 0)
			return false;
		
		return (min <= 0 && max >= 0);
		
	}  // checkString() ends...
	

}

