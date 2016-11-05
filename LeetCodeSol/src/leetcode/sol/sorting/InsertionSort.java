package leetcode.sol.sorting;

import java.util.Arrays;

public class InsertionSort {
    public InsertionSort() {
    	int[] ary = {9,1,5,4,7,6,3};
    	sort(ary);
    	System.out.println(Arrays.toString(ary));
    	int[] ary1 = {9,1,5,4,7,6,3};
    	sort2(ary1);
    	System.out.println(Arrays.toString(ary));
    }
    
	private void sort2(int[] ary) {
		for(int i=0;i<ary.length;i++){
			int j=i;
			while(j>0){
				if(ary[j-1]>ary[j])
					swap(ary, j-1, j);
				j--;
			}
		}
	}

	private void sort(int[] ary) {
		for(int i=0;i<ary.length;i++){
			for(int j=i+1;j>0;j--){
				try{
					if(ary[j-1]>ary[j])
						swap(ary, j-1, j);
				}catch (Exception e) {
				}
			}
		}
	}

	private void swap(int[] ary, int i, int j) {
		int temp = ary[i];
		ary[i]=ary[j];
		ary[j]=temp;
	}

	public static void main(String[] args) {
		InsertionSort bs = new InsertionSort();
	}

}
