package com.facebook.set1;

import java.util.Arrays;

public class ArrengeEvenOddAtIndex {

	public static void main(String[] args) {

		int[] ary = {1,3,5,7,2,4,6,8};
		
		System.out.println(Arrays.toString(ary));
		
		ary = arrengeEvenOdd(ary);
		
		System.out.println(Arrays.toString(ary));
		
	}

	private static int[] arrengeEvenOdd(int[] ary) {

		int left = 0, right = ary.length - 1;
		
		while(left < right){
			
			while(left % 2 == ary[left] % 2 && left < right){
				left++;
			}
			
			while(right % 2 == ary[right] % 2 && left < right){
				right--;
			}
			
			if(left < right){
				swap(ary,left,right);
				left++;
				right--;
			}
		}
		
		return ary;
	}

	private static void swap(int[] ary, int left, int right) {
		int temp = ary[left];
		ary[left] = ary[right];
		ary[right] = temp;
	}

}
