package leetcode.sol.sorting;

import java.util.Arrays;

public class QuickSort {
	int[] ary = {23,12,8,22,5,15,74,29,18,9};
	public QuickSort() {
		System.out.println(Arrays.toString(ary));
		quickSort(0,ary.length-1);
		System.out.println(Arrays.toString(ary));
	}
	
	private void quickSort(int low, int high) {
		if(ary==null || ary.length == 0)
			return;
		
		if(low>=high)
			return;
		
		// pick pivot
		int mid = low + (high-low)/2;
		int pivot = ary[mid];
		
		int i=low, j=high;
		
		while(i<=j){
			while(ary[i]<pivot){
				i++;
			}
			while(pivot<ary[j]){
				j--;
			}
			if (i <= j) {
				int temp = ary[i];
				ary[i] = ary[j];
				ary[j] = temp;
				i++;
				j--;
			}
		}
		
		if(low<j)
			quickSort(low, j);
		
		if(high>i)
			quickSort(i, high);
	}
	
	public static void main(String[] args) {
		QuickSort qs = new QuickSort();
	}

}
