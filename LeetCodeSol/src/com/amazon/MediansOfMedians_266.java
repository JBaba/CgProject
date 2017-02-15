package com.amazon;

public class MediansOfMedians_266 {

	
	
	public static void main(String[] args) {
		
		MediansOfMedians_266 mom = new MediansOfMedians_266();
		int[] ary = {5, 2, 17, 13, 14, 17, 19, 14, 18, 2, 4, 8, 2, 5, 0, 6, 13, 4, 12, 18, 10};
		
		int median = mom.medianOfUnsortedArray(ary);
		System.out.println("M:"+median);
	}

	private int medianOfUnsortedArray(int[] ary) {
		int[] sizeOfMedians = new int[(ary.length/5)+1];
		
		for(int i=0;i<=ary.length/5;i++){
			
			int low = i*5;
			int high = ((i+1)*5)-1;
			int kthMed = (5*i)+2;
			
			if(high > ary.length){
				high = ary.length - 1 ;
				kthMed = low+((high-low+1)/2);
			}
			
			int median = findMedianUsingQuickSort(ary,low,high,kthMed);
			System.out.println("M-"+i+":"+median);
			sizeOfMedians[i] = median;
		}
		
		int medionsOfMedion = findMedianUsingQuickSort(sizeOfMedians,0,sizeOfMedians.length-1,(sizeOfMedians.length/2));
		
		return ary[partition(ary, 0, ary.length-1, medionsOfMedion)];
	}

	private int findMedianUsingQuickSort(int[] ary, int low, int high, int k) {

		if(low < high){
			
			int pivotIndex = partition(ary,low,high);
			
			findMedianUsingQuickSort(ary, low, pivotIndex-1, k);
			findMedianUsingQuickSort(ary, pivotIndex+1, high, k);
		}
		
		return ary[k];
	}
	
	private int partition(int[] ary, int low, int high,int pivot) {

		int i = low-1;
		
		for(int j=low; j <= high ; j++){
			if(ary[j] <= pivot){
				i++;
				swap(ary,i,j);
			}
		}
		
		return i;
	}

	private int partition(int[] ary, int low, int high) {

		int pivot = ary[high];
		
		int i = low-1;
		
		for(int j=low; j <= high ; j++){
			if(ary[j] <= pivot){
				i++;
				swap(ary,i,j);
			}
		}
		
		return i;
	}

	private void swap(int[] ary, int i, int j) {

		int temp = ary[i];
		ary[i] = ary[j];
		ary[j] = temp;
		
	}
	
}
