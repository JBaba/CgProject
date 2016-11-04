package leetcode.sol.sorting;

import java.util.Arrays;

public class MergeSort {

	int[] sArry = null;
	
	public MergeSort() {
		int[] arry = {23,12,45,44,2,3,7,5,6,4,15,28,19,30};
		sArry = new int[arry.length];
		mergeSort(arry,0,arry.length-1);
		System.out.println(Arrays.toString(arry));
		System.out.println("-------------------------");
		System.out.println(Arrays.toString(sArry));
	}
	
	private void mergeSort(int[] arry, int i, int length) {
		
		// sort if less then or equal 2 element
		if(i<length)
		{	
			int mid = i + (length-i)/2;
			
			mergeSort(arry, i, mid);
			mergeSort(arry, mid+1, length);
			
			merge(arry, i, mid, length);
		}
	}


	 private void merge(int[] numbers,int low, int middle, int high) {

         // Copy both parts into the helper array
         for (int i = low; i <= high; i++) {
                 sArry[i] = numbers[i];
         }

         int i = low;
         int j = middle + 1;
         int k = low;
         // Copy the smallest values from either the left or the right side back
         // to the original array
         while (i <= middle && j <= high) {
                 if (sArry[i] <= sArry[j]) {
                         numbers[k] = sArry[i];
                         i++;
                 } else {
                         numbers[k] = sArry[j];
                         j++;
                 }
                 k++;
         }
         // Copy the rest of the left side of the array into the target array
         while (i <= middle) {
                 numbers[k] = sArry[i];
                 k++;
                 i++;
         }

 }
	
	private void swap(int[] arry, int front, int second) {
		int temp = arry[front];
		arry[front] = arry[second];
		arry[second] = temp;
	}

	public static void main(String[] args) {
		MergeSort m = new MergeSort();
	}

}
