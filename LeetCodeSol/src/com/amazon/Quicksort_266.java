package com.amazon;

import java.util.Arrays;

public class Quicksort_266 {

	public static void main(String[] args) {
		
		Quicksort_266 qc = new Quicksort_266();
		
		int[] input = {90, 80, 70, 60, 50, 40, 30};
		input = qc.quicksort(input,0,input.length-1);
		System.out.println(Arrays.toString(input));
		
		int[] input2 = {10, 80, 30, 90, 40, 50, 70};
		input2 = qc.quicksort(input2,0,input2.length-1);
		System.out.println(Arrays.toString(input2));
		
	}

	private int[] quicksort(int[] input, int l, int h) {
		if(l<h){
			int partitionIndex = partition(input,l,h);
			
			quicksort(input, l, partitionIndex-1);
			quicksort(input, partitionIndex+1, h);
		}
		return input;
	}

	private int partition(int[] input, int l, int h) {
		int pivot = input[h];
		
		// start with low
		int i=(l-1);
		
		for (int j = l; j <= h; j++) {
			if(input[j] <= pivot){
				i++;
				switchEle(input,i,j);
			}
		}
		return i;
	}
	
	private void switchEle(int[] input, int i, int j) {
		int temp = input[i];
		input[i] = input[j];
		input[j]=temp;
	}

}
