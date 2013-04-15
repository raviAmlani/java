package com.ravi.fb;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class FinaTheMin1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		//5
		/*97 39
		34 37 656 97*/
		/*186 75
		68 16 539 186*/
		/*137 49
		48 17 461 137*/
		/*98 59
		6 30 524 98*/
		/*46 18
		7 11 9 46*/
		
		int lineNo = 0;
		
		try {
			
			String inputFileName = "input1.txt";
			BufferedReader br = new BufferedReader(new FileReader(inputFileName));
			
			String outputFileName = "output.txt";
			FileWriter fstream = new FileWriter(outputFileName);
	        BufferedWriter out = new BufferedWriter(fstream);
	        
			int testCases = Integer.parseInt(br.readLine());
			//System.out.println("Total test cases :"+testCases+"\n");
			
			for(int i = 1; i <= testCases; i++){
				
				String n_k = br.readLine();
				String[] vals1 = n_k.split(" ");
				long n = new Long(vals1[0]);
				long k = new Long(vals1[1]);

				String a_b_c_r = br.readLine();
				String[] vals2 = a_b_c_r.split(" ");
				long a = new Long(vals2[0]);
				long b = new Long(vals2[1]);
				long c = new Long(vals2[2]);
				long r = new Long(vals2[3]);
				
				long min = findTheMin(n, k, a, b, c, r);
				System.out.println("Case #"+i+": "+ min);
				if(i == 1)
					out.write("Case #"+i+": "+ min);
				else{
					out.newLine();
					out.write("Case #"+i+": "+ min);
				}
				
			}
			
			br.close();
			out.close();
			//System.out.println("Opearation completed successfully, please check out \"outputFindMin.txt\" file");
			
		} catch (FileNotFoundException e) {
			System.out.println("File with the given file name not found...!!!\n");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error reading lineNo : "+lineNo+"\n");
			e.printStackTrace();
		}
		
		
	}	// main() ends...

	private static long findTheMin(long n, long k, long a, long b, long c, long r) {

		//long m[] = new long[(int) (k+(n-k)%(k+1))];
		//System.out.println("Might repeat from here:"+(k+(n-k)%(k+1)));
		long m[] = new long[(int) n];
		m[0] = a;
		
		// fill up array upto k values.
		for(int i = 1; i < k; i++){
			m[i] = (b * m[i-1] + c) % r;
			//System.out.println("m["+i+"]:"+m[i]);
		}
		
		//System.out.println("---------------------------------");
		
		long start = 0;
		Long limit = new Long("1000000000");
		//for(long i = k; i < n; i++){
		for(long i = k; i < m.length; i++){
			
			long end = i-1;
			//System.out.println("--->index="+i);
			//System.out.println("Range Start:"+start+" ,End:"+end);
			
			long tempM[] = new long[(int) k];
			int indexTempM = 0;
			
			for(long tempI = start; tempI <= end; tempI++){
				tempM[indexTempM] = m[(int) tempI];
				indexTempM++;
			}
			
			
			for(long curr = 0; curr <= limit; curr++){
				
				boolean isContain = false;
				for(indexTempM = 0; indexTempM < tempM.length; indexTempM++){
					if(curr == tempM[indexTempM]){
						isContain = true;
						break;
					}
				}
				if(!isContain){
					m[(int) i] = curr;
					//System.out.println("m["+i+"]:"+m[(int) i]);
					break;
				}
				
			}
			
			start+=1;
			
		}
		
		//System.out.println("-------- FINAL OUTPUT --------");
		
		/*for(int i = 0; i < n; i++){
			System.out.println("m["+i+"]:"+m[i]);
		}*/
		
		return m[m.length-1];
	}

}	// class ends...
