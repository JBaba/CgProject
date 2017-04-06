package com.epi.design;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumMultiplyInList {

	public static void main(String[] args) {
		List<Integer> num1 = new ArrayList<Integer>();
		num1.add(4);
		num1.add(4);
		
		System.out.println(num1);
		
		List<Integer> num2 = new ArrayList<Integer>();
		num2.add(5);
		num2.add(5);
		
		System.out.println(num2);
		
		List<Integer> num3 = numMultiplyInList(num1,num2);
		
		System.out.println(num3);
	}

	private static List<Integer> numMultiplyInList(List<Integer> num1,
			List<Integer> num2) {

		boolean isNegative = (num1.get(0) > 0 ? num2.get(0) > 0 ? false : true : num2.get(0) > 0 ? true : false);
		
		num1.set(0, Math.abs(num1.get(0)));
		num2.set(0, Math.abs(num2.get(0)));
		
		List<Integer> bigNo = (num1.size() >= num2.size()) ? num1 : num2;
		List<Integer> smallNo = (num1.size() >= num2.size()) ? num2 : num1;
		
		List<Integer> result = new ArrayList<Integer>(Collections.nCopies(num1.size()+num2.size(), 0));
		
		System.out.println(result);
		
		for(int i=smallNo.size()-1;i>=0;i--){
			for(int j=bigNo.size()-1;j>=0;j--){
				result.set(i+j+1, result.get(i+j+1)+smallNo.get(i)*bigNo.get(j));
				result.set(i+j, result.get(i+j)+result.get(i+j+1)/10);
				result.set(i+j+1, result.get(i+j+1)%10);
			}
		}
		
		return result;
	}

}
