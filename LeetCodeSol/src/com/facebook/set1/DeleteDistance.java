package com.facebook.set1;

public class DeleteDistance {

	public static void main(String[] args) {

		int ans = deleteDistance("ot","got");
		System.out.println(ans);
		
	}

	private static int deleteDistance(String string, String string2) {
		int[] chars = new int[256];
		
		for(int i=0;i<string.length();i++)
			chars[string.charAt(i)]++;
		
		for(int i=0;i<string2.length();i++)
			chars[string2.charAt(i)]--;
		
		int sum = 0;
		
		for(int i=0;i<256;i++)
			sum += i * Math.abs(chars[i]);
		
		return sum;
	}

}
