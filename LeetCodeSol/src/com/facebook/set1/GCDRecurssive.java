package com.facebook.set1;

/**
 * 
 * 	Input  : arr[] = {1, 2, 3}
	Output : 1
		
	Input  : arr[] = {2, 4, 6, 8}
	Output : 2
 * 
 * 
 * @author nviradia
 *
 */
public class GCDRecurssive {

	public static void main(String[] args) {
		int[] ary1 = {1,2,3};
		int ans = findGCD(ary1);
		System.out.println(ans);
		
		int[] ary2 = {2,4,6,8};
		ans = findGCD(ary2);
		System.out.println(ans);

	}

	private static int findGCD(int[] ary1) {
		if(ary1 == null || ary1.length < 1)
			return 0;
		if(ary1.length == 1)
			return ary1[0];
		
		int first = ary1[0];
		
		for(int i=1;i<ary1.length;i++){
			first = GCD(first,ary1[i]);
		}
		
		return first;
	}

	private static int GCD(int first, int sec) {
		if(first==0)
			return sec;
		return GCD(sec%first,first);
	}

}
