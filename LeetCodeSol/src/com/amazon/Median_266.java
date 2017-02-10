package com.amazon;

public class Median_266 {

	public static void main(String[] args) {

		Median_266 md = new Median_266();
		int[] ary = {1,2,3,4,5,6};
		printMedian(ary);
	}

	private static void printMedian(int[] ary) {

		int median;
		int mid = ary.length / 2;
		
		if(ary.length % 2 == 0){
			median = ( ary[mid-1] + ary[mid] ) / 2;
		}else{
			median = ( ary[mid] );
		}

		System.out.println("Median: "+median);
	}

}
