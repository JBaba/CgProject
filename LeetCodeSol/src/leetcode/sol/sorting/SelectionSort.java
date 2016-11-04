package leetcode.sol.sorting;

import java.util.Arrays;

public class SelectionSort {
    public SelectionSort() {
    	int[] ary = {9,1,5,4,7,6,3};
    	sort(ary);
    	System.out.println(Arrays.toString(ary));
    }
    
	private void sort(int[] ary) {
		for(int i=0;i<ary.length;i++){
			int min = i;
			for(int j=i+1;j<ary.length;j++){
				if(ary[min]>ary[j])
					min = j;
			}
			swap(ary, i, min);
		}
	}

	private void swap(int[] ary, int i, int j) {
		int temp = ary[i];
		ary[i]=ary[j];
		ary[j]=temp;
	}

	public static void main(String[] args) {
		SelectionSort bs = new SelectionSort();
	}

}
