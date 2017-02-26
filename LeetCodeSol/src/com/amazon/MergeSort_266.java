package com.amazon;

import java.util.Arrays;

public class MergeSort_266 {

	public static void main(String[] args) {
		MergeSort_266 mom = new MergeSort_266();
		int[] ary = {5, 2, 17, 13, 14, 17, 19, 14, 18, 2, 4, 8, 2, 5, 0, 6, 13, 4, 12, 18, 10};
		System.out.println(Arrays.toString(ary));
		mom.mergeSort(ary,0,ary.length-1);
		System.out.println(Arrays.toString(ary));
		
	}

	private int[] mergeSort(int[] ary, int l, int h) {

		if(l<h){
			
			int mid = l + (h-l)/2;
			
			mergeSort(ary, l, mid);
			mergeSort(ary, mid+1, h);
			sort(ary,l,mid,h);
			
		}
		
		return ary;
	}

	private void sort(int[] ary, int l, int mid, int h) {
		int first = l;
		int second = mid+1;
		int end = h;
		
		int[] extraSpace = new int[end-first+1];
		
		int index = 0;
		
		while(first <= mid && second <= h){
			
			if(ary[first] >= ary[second]){
				extraSpace[index] = ary[second];
				index++;
				second++;
			}else{
				extraSpace[index] = ary[first];
				index++;
				first++;
			}
			
		}
		
		while(first <= mid){
			extraSpace[index] = ary[first];
			index++;
			first++;
		}
		
		while(second <= h){
			extraSpace[index] = ary[second];
			index++;
			second++;
		}
		
		index = l;
		
		for(int i=0;i<extraSpace.length ; i++){
			ary[index] = extraSpace[i];
			index++;
		}
		
	}

}
