package com.ravi.fb;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.Collections;
 
 
public class CardGame {

	static long MODULO_BASE = 1000000007;
		
	public static void main(String[] args) {
		/*5
		4 3
		3 6 2 8 
		5 2
		10 20 30 40 50 
		6 4
		0 1 2 3 5 8 
		2 2
		1069 1122 
		10 5
		10386 10257 10432 10087 10381 10035 10167 10206 10347 10088*/
		
		try {
			//input_cardGame.txt
			BufferedReader reader = new BufferedReader(new FileReader("card_game.txt"));
			String line = null;
			int cases = Integer.parseInt(reader.readLine());
			int i = 1;
			while(i <= cases){
				
				String n_k[] = reader.readLine().split(" ");
				int n = Integer.parseInt(n_k[0]);
				int k = Integer.parseInt(n_k[1]);
				String vals[] = reader.readLine().split(" ");
				ArrayList<Integer> input = new ArrayList<Integer>();
				for(String val : vals){
					input.add(Integer.parseInt(val));
				}
				
				//System.out.println("\nCase:"+i+"\nn:"+n+"  k:"+k);
				//System.out.println(input);
				long sum = getSum(n, k, input);
				System.out.println("Case #"+i+": "+sum);
				i++;
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public static long getSum(int n, int k, ArrayList<Integer> input){
		Collections.sort(input);

		long totalNumberOfSets = (long) combination(n, k);
		long firstHeighestNumberOfSets = k*totalNumberOfSets/n;

		long sum = 0;
		long currentSetsCount = 0;
		int count = 0;
		int newN = n;
		int newK = k;
		for(int i = input.size() -1; i >=0; i--){
			count++;
			long num = input.get(i);
			long tempSetCount = 0;
			if(count == 1)     
			{
				tempSetCount = firstHeighestNumberOfSets;//(long) combination(n - count, k-1);
				newN = n-1;
				newK = k-1;
			}else{
				if(newN == 0 || newN -newK ==0){
					tempSetCount = (long) combination(n - count, k-1);
				}else{
					tempSetCount = firstHeighestNumberOfSets * (newN - newK)/newN;
					firstHeighestNumberOfSets = tempSetCount;
					newN--;
				}
			}

			if(currentSetsCount + tempSetCount > totalNumberOfSets){
				tempSetCount = totalNumberOfSets - currentSetsCount;
			}
			num = (num%MODULO_BASE);
			tempSetCount = (tempSetCount%MODULO_BASE);
			sum = sum + num*(tempSetCount);
			if(sum > MODULO_BASE){
				sum = sum - MODULO_BASE;
			}
			currentSetsCount += tempSetCount;

			if(currentSetsCount == totalNumberOfSets){
				break;
			}
		}

		return sum;
	}

	public static double combination(int n, int k){
		if(k > n-k){
			return combination(n , n-k);
		}
		double result = 1;

		for(int i =0; i < k; i++){
			result = result*(n - i);
			result = result/(k -i);
		}
		return result;
	}
}