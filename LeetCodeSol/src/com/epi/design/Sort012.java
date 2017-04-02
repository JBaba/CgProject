package com.epi.design;

public class Sort012 {

	// Sort the input array, the array is assumed to
    // have values in {0, 1, 2}
    static void sort012(int a[], int arr_size)
    {
    	int lo = 0;
    	int mid = 0;
    	int hi = arr_size - 1;
    	
    	while (mid <= hi) {
			switch (a[mid]) {
			case 0:
				swap(a,mid,lo);
				lo++;
				mid++;
				break;

			case 1:
				mid++;
				break;

			case 2:
				swap(a,mid,hi);
				hi--;
				break;
	
				
			default:
				break;
			}
		}
    }
 
    private static void swap(int[] a, int mid, int hi) {
    	int tmp = a[mid];
    	a[mid] = a[hi];
    	a[hi] = tmp;
	}

	/* Utility function to print array arr[] */
    static void printArray(int arr[], int arr_size)
    {
        int i;
        for (i = 0; i < arr_size; i++)
            System.out.print(arr[i]+" ");
        System.out.println("");
    }
 
    /*Driver function to check for above functions*/
    public static void main (String[] args)
    {
        int arr[] = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
        int arr_size = arr.length;
        sort012(arr, arr_size);
        System.out.println("Array after seggregation ");
        printArray(arr, arr_size);
    }

}
