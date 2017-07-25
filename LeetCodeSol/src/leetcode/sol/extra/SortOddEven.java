package leetcode.sol.extra;

import java.util.Arrays;

public class SortOddEven {

	public static void main(String[] args) {

		int[] ary = {2,3,4,5,6,7,8,9,10,11};
		
		ary = sortArryintoOddEvenPosition(ary);
		
		System.out.println(Arrays.toString(ary));
		
	}

	private static int[] sortArryintoOddEvenPosition(int[] ary) {

		// pointers
		int p1 = 0, p2 = 0;
		
		while(p1 != ary.length && p2 != ary.length){
			
			// both at same position then move forward second pointer
			if(p1 == p2){ 
				p2++;
			}
			
			// front is odd then move
			if(isOdd(ary[p1])){
				p1++;
			}
			
			// compare both position
			
			// if value at second pointer is odd
			if(isOdd(ary[p2])){
				swapPosition(ary,p1,p2);
				// after swap move first pointer as odd value sorted 
				p1++;
			}
			
			// at both position value is even then
			// compare and swap from small to big
			if(isEven(ary[p1]) && isEven(ary[p2])){
				if(ary[p2] < ary[p1]){
					swapInternalEvenArray(ary,p1,p2);
				}else{
					// 
					p2++;
				}
			}
		}
		
		return ary;
	}

	private static void swapInternalEvenArray(int[] ary, int p1, int p2) {

		while(p1 != p2){
			if(ary[p1] > ary[p2]){
				swapPosition(ary, p1, p2);
				p1++;
			}
		}
		
	}

	private static boolean isEven(int i) {
		return (i%2 == 0) ? true : false;
	}

	private static boolean isOdd(int i) {
		return (i%2 == 1) ? true : false;
	}

	private static void swapPosition(int[] ary, int p1, int p2) {
		int temp = ary[p1];
		ary[p1] = ary[p2];
		ary[p2] = temp;
	}

}
