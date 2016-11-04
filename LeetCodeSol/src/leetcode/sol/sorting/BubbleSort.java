package leetcode.sol.sorting;

import java.util.Arrays;

public class BubbleSort {
    public BubbleSort() {
    	int[] ary = {9,1,5,4,7,6,3};
    	sort(ary);
    	System.out.println(Arrays.toString(ary));
    }
    
	private void sort(int[] ary) {
		for(int i=0;i<ary.length;i++){
			for(int j=1;j<ary.length-i;j++){
				if(ary[j-1]>ary[j])
					swap(ary,j-1,j);
			}
		}
	}

	private void swap(int[] ary, int i, int j) {
		int temp = ary[i];
		ary[i]=ary[j];
		ary[j]=temp;
	}

	public static void main(String[] args) {
		BubbleSort bs = new BubbleSort();
	}

}
