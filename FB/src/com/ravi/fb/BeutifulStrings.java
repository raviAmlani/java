package com.ravi.fb;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class BeutifulStrings {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int lineNo = 0;
		
		try {
			
			String inputFileName = "input.txt";
			BufferedReader br = new BufferedReader(new FileReader(inputFileName));
			
			String outputFileName = "output.txt";
			FileWriter fstream = new FileWriter(outputFileName);
	        BufferedWriter out = new BufferedWriter(fstream);
	        
	        // Lets clear the file if it already exists
	        /*PrintWriter writer = new PrintWriter(outputFileName);
	        writer.print("");
	        writer.close();*/
			
			String line;
			
			while ((line = br.readLine()) != null) {
				//System.out.println(line);
				if(lineNo > 0){
					int beauty = BeautyOperation(line);
					//System.out.println(line);
					//System.out.println("Case #"+lineNo+": "+beauty);
					//System.out.println();
					if(lineNo == 1)
						out.write("Case #"+lineNo+": "+beauty);
					else{
						out.newLine();
						out.write("Case #"+lineNo+": "+beauty);
					}
				}
				lineNo+=1;
			}
			br.close();
			out.close();
			System.out.println("Opearation completed successfully, please check out \"output.txt\" file");
			
		} catch (FileNotFoundException e) {
			System.out.println("File with the given file name not found...!!!\n");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error reading lineNo : "+lineNo+"\n");
			e.printStackTrace();
		}
		
		
	}	// main() ends...
	


	private static int BeautyOperation(String line) {
		
		String s = line.toLowerCase();
		Map mapAlpha = new HashMap();
		//System.out.println(s);
		//System.out.println("-----------------------------");
		
		fillUpMap(mapAlpha, s);
		mapAlpha = sortMap(mapAlpha);
		
		//printMap(mapAlpha);
		//System.out.println("-----------------------------");
		
		Map mapBeauty = assignBeauty(mapAlpha);
		//printMap(mapBeauty);
		//System.out.println("-----------------------------");
		
		// NOW CALCULATE THE BEAUTY
		int beauty = calculateBeauty(mapBeauty, s);
		return beauty;
		
	}



	private static Map fillUpMap(Map mapAlpha, String s){
		
		for(int i = 0; i < s.length(); i++){
			
			char charMain = s.charAt(i);
//			System.out.println(charMain+ ":" +Character.getNumericValue(charMain));
			//System.out.println(charMain + " : " + Character.isLetter(charMain));
			int charVal = Character.getNumericValue(charMain);
			
			// not storing if a char is not a letter. It will cause a problem while assigning its ranking.
			
			if(Character.isLetter(charMain)){
				if(mapAlpha.get(charMain) != null){
					int currVal = Integer.parseInt(mapAlpha.get(charMain).toString());
					mapAlpha.put(charMain, currVal+1);
				}else{
					mapAlpha.put(charMain, 1);
				}	
			}
			
			
		} // for loop ends...
		
		return mapAlpha;
		
	}	// fillUpMap() ends...
	
	
	private static Map sortMap(Map mapAlpha) {

		List list = new LinkedList(mapAlpha.entrySet());
		 
		// sort list based on comparator
		Collections.sort(list, new Comparator() {
			public int compare(Object o1, Object o2) {
				return ((Comparable) ((Map.Entry) (o2)).getValue())
                                       .compareTo(((Map.Entry) (o1)).getValue());
			}
		});
 
		// put sorted list into map again
                //LinkedHashMap make sure order in which keys were inserted
		mapAlpha.clear();
		mapAlpha = new LinkedHashMap();
		for (Iterator it = list.iterator(); it.hasNext();) {
			Map.Entry entry = (Map.Entry) it.next();
			mapAlpha.put(entry.getKey(), entry.getValue());
		}
		return mapAlpha;
		
	}	// sortMap() ends...
	
	
	private static void printMap(Map mapAlpha) {
	
		Iterator it = mapAlpha.entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry pairs = (Map.Entry)it.next();
	        System.out.println(pairs.getKey() + " = " + pairs.getValue());
	    }
		
	}	// printMap() ends...	

	
	 private static Map assignBeauty(Map mapAlpha) {
	 
		 Map mapBeauty = new LinkedHashMap();
		 Iterator it = mapAlpha.entrySet().iterator();
		 int beauty = 26;
		 while (it.hasNext()) {
			 Map.Entry entry = (Map.Entry)it.next();
			 mapBeauty.put(entry.getKey(), beauty--);
		 }

		return mapBeauty;
		 
	 }	// assignBeauty() ends.. 


	 private static int calculateBeauty(Map mapBeauty, String s) {
		 
		 int beauty = 0;
		 
		 for(int i = 0; i < s.length(); i++){
			 
			 char c = s.charAt(i);
			 if(mapBeauty.get(c) != null){
				 beauty = beauty + Integer.parseInt(mapBeauty.get(c).toString());
				 //System.out.println("char:"+c+"-"+mapBeauty.get(c));
				 //System.out.println("currBeauty:"+beauty);
				 
			 }
			 
		 }
		 
		 //System.out.println("String : "+s);
		 //System.out.println("-----------------------------");
		 //Case #1: 152
		 //System.out.println("Case #"+caseNo+": "+beauty);
		 return beauty;
		 
	 }	// calculateBeauty() ends...
	 

}
