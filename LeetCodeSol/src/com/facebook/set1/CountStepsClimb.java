package com.facebook.set1;

import java.util.Arrays;

public class CountStepsClimb {

	public static void main(String[] args) {

		int ans = countNumberOfWaysToClimbSteps(3,0);
		
		System.out.println(ans);
		
		perm("abcd");
		
	}

	private static void perm(String string) {

		perm(string.toCharArray(),string.length()-1);
		
	}

	private static void perm(char[] ary, int n) {

		if(n==0)
			System.out.println(new String(ary));
		
		for(int i=0;i<=n;i++){
			swap(ary,i,n);
			perm(ary,n-1);
			swap(ary,i,n);
		}
		
	}
	
	private static void swap(char[] ary, int left, int right) {
		char temp = ary[left];
		ary[left] = ary[right];
		ary[right] = temp;
	}

	private static int countNumberOfWaysToClimbSteps(int no,int start) {
		
		if(no == start)
			return 1;
		
		if(no < start)
			return 0;
		
		return countNumberOfWaysToClimbSteps(no, start+1)
			+ countNumberOfWaysToClimbSteps(no, start+2)
			+ countNumberOfWaysToClimbSteps(no, start+3);
	}

}
