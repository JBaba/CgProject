package com.facebook.set1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RearrangeStringAndSum {

	public static void main(String[] args) {
		String ans = rearrange("AC2BEW3");
		System.out.println(ans);
	}

	private static String rearrange(String string) {
		List<Character> chars = new ArrayList<>();
		List<Character> nums = new ArrayList<>();
		
		String ans = "";
		
		int sum = 0;
		
		for(char c:string.toCharArray()){
			if(c >= 'A' && c <= 'Z'){
				chars.add(c);
			}else{
				sum += c - '0';
			}
		}
		
		Collections.sort(chars);
		
		for(char c : chars){
			ans += c;
		}
		
		return ans+sum;
	}

}
