package com.amazon;

import java.util.Arrays;

public class Partition_266 {

	public static void main(String[] args) {
		Partition_266 pt = new Partition_266();
		
		int[] input = {10, 80, 30, 90, 40, 50, 70};
		
		input = pt.partition(input,0,input.length-1);
		
		System.out.println(Arrays.toString(input));
	}

	private int[] partition(int[] input, int l, int h) {
		
		int pivot = input[h];
		
		int i = 0;
		
		for(int j=l;j<=h;j++){
			
			if(input[j] <= pivot){
				switchEle(input,i,j);
				i++;
			}
			
		}
		
		return input;
	}

	private void switchEle(int[] input, int i, int j) {
		int temp = input[i];
		input[i] = input[j];
		input[j]=temp;
	}

}
