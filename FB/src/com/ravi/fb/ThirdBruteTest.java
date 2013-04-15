package com.ravi.fb;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;


public class ThirdBruteTest {


	public static long get(int n,int k,long a,long b,long c,long r){
		
		System.out.println("n:"+n+"\nk:"+k+"\nArr length will be:"+(k+(n-k)%(k+1)));
		long arr[]=new long[k+(n-k)%(k+1)];
		//long arr[]=new long[n];
		//long arr[]=new long[(int) r];
		arr[0]=a;
		for(int i=1;i<k;i++)
			arr[i]=(arr[i-1]*b+c)%r;
		int occ[]=new int[k+1];
		for(int j=k;j<arr.length;j++ )
		{
			Arrays.fill(occ, -1);
			for(int i=j-1;i>j-1-k;i--)
				if(arr[i]<=k)
					occ[(int) arr[i]]=i;
			for(int i=0;i<k;i++)
				if(occ[i]==-1){
					arr[j]=i;
					break;
				}
		}
		return arr[arr.length-1];
		
	}
	public static void main(String[] args) throws IOException {
		
		
		
		int lineNo = 0;
		
		try {
			
			String inputFileName = "input.txt";
			BufferedReader br = new BufferedReader(new FileReader(inputFileName));
			
			String outputFileName = "output.txt";
			FileWriter fstream = new FileWriter(outputFileName);
	        BufferedWriter out = new BufferedWriter(fstream);
	        
			int testCases = Integer.parseInt(br.readLine());
			//System.out.println("Total test cases :"+testCases+"\n");
			
			for(int i = 1; i <= testCases; i++){
				
				String n_k = br.readLine();
				String[] vals1 = n_k.split(" ");
				int n = new Integer(vals1[0]);
				int k = new Integer(vals1[1]);

				String a_b_c_r = br.readLine();
				String[] vals2 = a_b_c_r.split(" ");
				long a = new Long(vals2[0]);
				long b = new Long(vals2[1]);
				long c = new Long(vals2[2]);
				long r = new Long(vals2[3]);
				
				long min = get(n, k, a, b, c, r);
				System.out.println("Case #"+i+": "+ min);
				System.out.println("-------------------------------------------");
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
	}

}
