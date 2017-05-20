package com.facebook.set1;

/**
 * 
 * Input : arr[] = {-4, -2, 1, -3} 
            k = 2
	Output : -1
	The sub array is {-2, 1}
	
	Input : arr[] = {1, 1, 1, 1, 1, 1} 
	            k = 2
	Output : 6 
	The sub array is {1, 1, 1, 1, 1, 1}
 * 
 * 
 * @author nviradia
 *
 */
public class AtLeastKMaxSumSubArray {

	public static void main(String[] args) {
		
		int[] ary1 = {-4, -2, 1, -3};
		int sum = findMaxSumForLeastKElement(2,ary1);
		System.out.println(sum);
		
		int[] ary2 = {1, 1, 1, 1, 1, 1};
		sum = findMaxSumForLeastKElement(2,ary2);
		System.out.println(sum);
		
		int[] ary3 = {1, 2, 3, -10, -3};
		sum = findMaxSumForLeastKElement(4,ary3);
		System.out.println(sum);
		
	}

	private static int findMaxSumForLeastKElement(int k, int[] ary1) {
		int maxSum = Integer.MIN_VALUE,max_so_far = 0;
		int countK = 0,jumpBack=0;
		boolean sFlag = false;
		for(int i=0;i<ary1.length;i++){
			max_so_far += ary1[i];
			countK++;
			
			if(max_so_far > maxSum && countK >= k)
				maxSum = max_so_far;
			
			if(max_so_far < 0 && !sFlag){
				jumpBack = i;
				sFlag = true;
			}
			
			if(max_so_far < 0 && countK >= k){
				max_so_far = 0;
				countK = 0;
				
				if(countK < k)
					i=jumpBack;
				
				sFlag = false;
			}
			
		}
		
		return maxSum;
	}

}
