package com.deloitte.elements.eng;

public class E_1_CounBits {

	
	
	public static void main(String[] args) {

		E_1_CounBits e1 = new E_1_CounBits();
		int ans = e1.countOneBits(5);
		System.out.println(ans);
		System.out.println("----------------------->");
		int a = -2;
		System.out.println("a:"+Integer.toBinaryString(a));
		
		int c = a >> 15;
		
		//System.out.println(Integer.toBinaryString(a));
		System.out.println(Integer.toBinaryString(c));
		
		int d = a >>> 1;
		
		//System.out.println(Integer.toBinaryString(a));
		System.out.println(Integer.toBinaryString(d));
		
	}

	private int countOneBits(int i) {
		
		short count = 0;
		short total = 0;
		System.out.println(Integer.toBinaryString(i));
		
		while (i != 0) {
			total++;
			count += (i & 1);
			i >>>= 1;
		}
		
		System.out.println("zero:"+(total-count));
		
		return count;
	}

}
