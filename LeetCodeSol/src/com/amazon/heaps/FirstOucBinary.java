package com.amazon.heaps;

public class FirstOucBinary {

	public static void main(String[] args) {
		int[] ary = {-14,1,2,108,108,243};
		
		int ix = findFirst(ary,108);
		System.out.println(ix);
		
		ix = findLast(ary,108);
		System.out.println(ix);
	}

	private static int findLast(int[] ary, int i) {
		int results = -1;
		int lo = 0, hi = ary.length-1;
		int mid;
		
		while(hi>=lo){
			mid = lo + (hi-lo)/2;
			if(ary[mid]>i){
				hi=mid-1;
			}else if(ary[mid]==i){
				results=mid;
				lo=mid+1;
			}else{
				lo=mid+1;
			}
		}
		
		return results;
	}

	private static int findFirst(int[] ary, int i) {
		int results = -1;
		int lo = 0, hi = ary.length-1;
		int mid;
		
		while(hi>=lo){
			mid = lo + (hi-lo)/2;
			if(ary[mid]>i){
				hi=mid-1;
			}else if(ary[mid]==i){
				results=mid;
				hi=mid-1;
			}else{
				lo=mid+1;
			}
		}
		
		return results;
	}

}
