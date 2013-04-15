package com.code.others;

import java.util.Arrays;

/**
 * @author Ravi
 *
 */
public class CorporateGroupMedian {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int[] input1 = {-2,-7,-9,-12,-15,-17,-19,-23,-25,-27,-30};
		int[] input2 = {-2,-5,-8,-10,-14,-18,-19,-20,-21,-25,-30};
		//int[] input1 = {1,2,3,4};
		//int[] input2 = {5,6,7,8};
				
		System.out.println("\n-------->"+median(input1, input2));
		
	}

	 public static int median(int[] input1,int[] input2){
		
		 int[] arr = Arrays.copyOf(input1, input1.length + input2.length);
		 System.arraycopy(input2, 0, arr, input1.length, input2.length);
		 System.out.println(Arrays.toString(arr));
		 Arrays.sort(arr);
		 System.out.println(Arrays.toString(arr));
		 
		 int n = arr.length;
		 System.out.println(n);
		 int pointer = 0;
		 int median = 0;
		 if(n > 0 && n%2 != 0){
			 pointer = ((n+1)/2)-1;
			 median = arr[pointer];
		 }else if(n > 0 && n%2 == 0){
			 /*int temp1 = arr[(arr.length-1)/2];
			 int temp2 = arr[(arr.length-1)/2+1];*/
			 int temp1 = arr[((arr.length)/2)-1];
			 int temp2 = arr[((arr.length)/2+1)-1];
			 
			 Double d1 = Double.valueOf(temp1+"");
			 Double d2 = Double.valueOf(temp2+"");
			 Double d = (d1 + d2)/2;
			 System.out.println();
			 System.out.println(d);
			 System.out.println(Math.round(-17.6));
			 System.out.println(Math.round(17.6));
			 System.out.println(Math.round(-17.5));
			 System.out.println(Math.round(17.5));
			 System.out.println(Math.round(-17.4));
			 System.out.println(Math.round(17.4));
			 median = Integer.valueOf(Math.round(d)+"");
			 System.out.println(median);
			 
			 String s = d+"";
			 Double d_ = Double.valueOf("0." + s.substring(s.indexOf(".")+1));
			 d = Double.valueOf(s.substring(0, s.indexOf(".")));
			 System.out.println("\n"+d+" - "+d_);
			 if(d_ >= 0.5){
				 d = d+1;
				 System.out.println(d);
			 }
			 else{
				 System.out.println(d);
			 }
			 s = d+"";
			 median = Integer.valueOf(s.substring(0, s.indexOf(".")));
			 
			 
		 }else{
			 return 0;
		 }
		 
		 return median;
	        
	 }
	
}
