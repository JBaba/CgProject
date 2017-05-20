package com.facebook.set1;

public class LongestSubArraySum {

	public static void main(String[] args) {

		int[] ary1 = {-2,-3,4,-1,-2,1,5,-3,8};
		int sum = logestSubArraySum(ary1);
		System.out.println(sum);
	}

	private static int logestSubArraySum(int[] ary1) {
		
		int maxSum = Integer.MIN_VALUE;
		int max_ends  = 0;
		
		for(int i=0;i<ary1.length;i++){
			int item = ary1[i];
			max_ends = max_ends + item;
			
			if(max_ends > maxSum)
				maxSum = max_ends;
			
			if(max_ends < 0)
				max_ends = 0;
			
		}
		
		maxSum = Math.max(maxSum, max_ends);
		
		return maxSum;
	}

}
