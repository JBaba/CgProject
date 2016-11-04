package leetcode.sol.sorting;

import java.util.Arrays;

public class MergeSortOddEven {

	int[] sArry = null;
	
	public MergeSortOddEven() {
		int[] arry = {1,2,3,4,5,6,7,8,9,10,11,12,13};
		sArry = new int[arry.length];
		System.out.println(Arrays.toString(arry));
		System.out.println("-------------------------");
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
         int l = middle + 1;
         int k = low;
         // Copy the smallest values from either the left or the right side back
         // to the original array
         while (i <= middle && j <= high) {
                 if (sArry[i]%2 == 1) {
                     numbers[k] = sArry[i];
                     i++;
                     k++;
                 }else{
                	 numbers[l] = sArry[i];
                     i++;
                     l++;
                 }
                 
                 if (sArry[j]%2 == 1) {
                     numbers[k] = sArry[j];
                     j++;
                     k++;
                 }else{
                	 numbers[l] = sArry[j];
                     j++;
                     l++;
                 }
                 
         }
         // Copy the rest of the left side of the array into the target array
         while (j <= high) {
                 numbers[k] = sArry[j];
                 k++;
                 j++;
         }
         while (i <= middle) {
             numbers[k] = sArry[i];
             k++;
             i++;
     }

 }
	
	public static void main(String[] args) {
		MergeSortOddEven m = new MergeSortOddEven();
		System.out.println("Done...");
	}

}
