package com.ravi.fb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class FinaTheMin {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
	    /*m[0] = a
   	    m[i] = (b * m[i - 1] + c) % r, 0 < i < k
		
		int n = 97;
		int k = 39;  // known values
*/		//34 37 656 97
		
		/*BigInteger a = BigInteger.valueOf(34);
		BigInteger b = BigInteger.valueOf(37);
		BigInteger c = BigInteger.valueOf(656);
		BigInteger r = BigInteger.valueOf(97);*/
		
		
		/*BigInteger m[] = new BigInteger[n];
		m[0] = a;
		
		for(int i = 1; i < k; i++){
			System.out.println("i="+i);
			BigInteger temp = (b.multiply(m[i - 1]).add(c)).mod(r);
			m[i] = temp;
			
		}
		System.out.println("---------------------------------");
		System.out.println(m.length);
		System.out.println("---------------------------------");
		Arrays.sort(m, 0, k);
		for(int i = 0; i < k; i++){
			System.out.println("m["+i+"]:"+m[i]);
		}*/
		

		int n = 97;
		int k = 39;

		long a = 34;
		long b = 37;
		long c = 656;
		long r = 97;
		
		long m[] = new long[n];
		m[0] = a;
		
		// fill up array upto k values.
		for(int i = 1; i < k; i++){
			long temp = (b * m[i-1] + c) % r;
			m[i] = temp;
			//System.out.println(m[i]);
		}
		
		System.out.println("---------------------------------");
		
		//Arrays.sort(m, 0, k);
		for(int i = 0; i < k; i++){
			System.out.println("m["+i+"]:"+m[i]);
		}
		System.out.println("---------------------------------");
		
		
		int start = 0;
		for(int i = k; i < n; i++){
			
			System.out.println("--->index="+i);
			System.out.println("Start:"+start);
			System.out.println("End:"+(i-1));
			int end = i-1;
			
			Arrays.sort(m);
			
			long tempM[] = new long[k];
			int indexTempM = 0;
			for(int tempI = start; tempI <= end; tempI++){
				tempM[indexTempM] = m[tempI];
				indexTempM++;
			}
			Arrays.sort(tempM);
			for(int l = 0; l < k; l++){
				System.out.println("tempM["+l+"]:"+tempM[l]);
			}
			
			long min = tempM[0];
			//long min = 0;
			long max = tempM[tempM.length-1];
			
			ArrayList<Long> notContainedList = new ArrayList<Long>();
			
			for(long curr = min; curr <= max; curr++){
				
				//System.out.println("curr="+curr+","+Arrays.asList(tempM).contains(curr));
				/*if(!Arrays.asList(tempM).contains(curr)){
					notContainedList.add(curr);
				}*/
				boolean isContain = false;
				for(indexTempM = 0; indexTempM < k; indexTempM++){
					if(curr == tempM[indexTempM]){
						isContain = true;
						break;
					}
				}
				if(!isContain)
					notContainedList.add(curr);
				System.out.println("curr="+curr+","+isContain);
				
			}
			Collections.sort(notContainedList);
			
			System.out.println("Size of list:"+notContainedList.size()+"Lowest:"+notContainedList.get(0));
			m[i] = (Long) notContainedList.get(0);
			
			start+=1;
			
			
			
			/*for(int l = 0; l < k; l++){
				System.out.println("tempM["+l+"]:"+tempM[l]);
			}
			for(int l = 0; l < notContainedList.size(); l++){
				System.out.println("notContainedList["+l+"]:"+notContainedList.get(l));
			}
			System.out.println("============================================================================");
			break;*/
		}
		
		System.out.println("-------- FINAL OUTPUT --------");
		
		for(int i = 0; i < n; i++){
			System.out.println("m["+i+"]:"+m[i]);
		}

	}

}
