package com.ravi.fb;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;


public class Beauty {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br=new BufferedReader(new FileReader("input_BeautifulString.txt"));
		BufferedWriter bw=new BufferedWriter(new FileWriter("output.txt"));
		int t=Integer.parseInt(br.readLine());
		for(int test=1;test<=t;test++)
		{
			int count[]=new int[26];
			String input=br.readLine().toLowerCase();
			for(int i=0;i<input.length();i++)
			{
				if(input.charAt(i)>='a' && input.charAt(i)<='z')
					count[input.charAt(i)-'a']++;
			}
			Arrays.sort(count);
			int res=0;
			for(int i=26;i>0;i--)
			{
				res+=count[i-1]*i;
			}
			bw.write("Case #"+test+": "+res+"\n");
			//System.out.println("Case #"+test+": "+res);
			
		}
		bw.flush();
		bw.close();
		br.close();

	}

}